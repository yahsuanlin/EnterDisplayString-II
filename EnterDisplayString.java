import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EnterDisplayString extends JFrame {
  //create a DisplayString instance for display sting on panel
  private DisplayString panel = new  DisplayString();

  public EnterDisplayString() {
    //place the message panel in the frame
	add(panel, BorderLayout.CENTER);
    panel.setFocusable(true);
  }

  class DisplayString extends MessagePanel {
    private String message = "Input anything you want to say then press Enter to show";// Message to display	
    private StringBuffer buffer = new StringBuffer();

    public DisplayString() {
      this.addKeyListener(new Listener()); // Add listener
    }
    
    class Listener extends KeyAdapter {
      public void keyTyped(KeyEvent e) {
        buffer.append(e.getKeyChar());
      }

      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          message = String.valueOf(buffer);
          buffer.setLength(0);
          setMessage(message);
        }
      }
    }

  }
}
