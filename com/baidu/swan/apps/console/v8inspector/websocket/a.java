package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Base64;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.swan.c.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private InterfaceC0417a cGX;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private int mState = 1;
    private WebSocketFrame.OpCode cGY = null;
    private final List<WebSocketFrame> cGZ = new LinkedList();

    /* renamed from: com.baidu.swan.apps.console.v8inspector.websocket.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0417a {
        void a(WebSocketFrame webSocketFrame);

        void onClose();

        void onException(IOException iOException);

        void onOpen();
    }

    public static boolean y(Map<String, String> map) {
        String str = map.get("Upgrade".toLowerCase());
        String str2 = map.get(HTTP.CONN_DIRECTIVE.toLowerCase());
        return "websocket".equalsIgnoreCase(str) && (str2 != null && str2.toLowerCase().contains("Upgrade".toLowerCase()));
    }

    public static String mC(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update((str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes());
        return Base64.encodeToString(messageDigest.digest(), 2);
    }

    public void a(InterfaceC0417a interfaceC0417a) {
        this.cGX = interfaceC0417a;
    }

    public void d(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
        this.mState = 2;
        if (this.cGX != null) {
            this.cGX.onOpen();
        }
        amo();
    }

    private void amo() {
        while (this.mState == 2) {
            try {
                b(WebSocketFrame.l(this.mInputStream));
            } catch (IOException e) {
                if (this.cGX != null) {
                    this.cGX.onException(e);
                }
                c.e("V8WebSocket", "parse web socket frame fail", e);
                return;
            } finally {
                amp();
            }
        }
    }

    private void b(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.amq() == WebSocketFrame.OpCode.Close) {
            d(webSocketFrame);
        } else if (webSocketFrame.amq() == WebSocketFrame.OpCode.Ping) {
            e(new WebSocketFrame(WebSocketFrame.OpCode.Pong, true, webSocketFrame.ams()));
        } else if (webSocketFrame.amq() == WebSocketFrame.OpCode.Pong) {
            if (DEBUG) {
                Log.i("V8WebSocket", "A pong request has received.");
            }
        } else if (!webSocketFrame.amr() || webSocketFrame.amq() == WebSocketFrame.OpCode.Continuation) {
            c(webSocketFrame);
        } else if (this.cGY != null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
        } else {
            if (webSocketFrame.amq() == WebSocketFrame.OpCode.Text || webSocketFrame.amq() == WebSocketFrame.OpCode.Binary) {
                this.cGX.a(webSocketFrame);
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
        }
    }

    private void c(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.amq() != WebSocketFrame.OpCode.Continuation) {
            if (this.cGY != null && DEBUG) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
            }
            this.cGY = webSocketFrame.amq();
            this.cGZ.clear();
            this.cGZ.add(webSocketFrame);
        } else if (webSocketFrame.amr()) {
            if (this.cGY == null) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
            }
            this.cGZ.add(webSocketFrame);
            this.cGX.a(new WebSocketFrame(this.cGY, this.cGZ));
            this.cGY = null;
            this.cGZ.clear();
        } else if (this.cGY == null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        } else {
            this.cGZ.add(webSocketFrame);
        }
    }

    private void d(WebSocketFrame webSocketFrame) throws IOException {
        WebSocketFrame.CloseCode closeCode = WebSocketFrame.CloseCode.NormalClosure;
        String str = "";
        if (webSocketFrame instanceof WebSocketFrame.a) {
            closeCode = ((WebSocketFrame.a) webSocketFrame).amw();
            str = ((WebSocketFrame.a) webSocketFrame).getCloseReason();
        }
        if (this.mState == 3) {
            amp();
        } else {
            a(closeCode, str);
        }
    }

    public synchronized void e(WebSocketFrame webSocketFrame) throws IOException {
        webSocketFrame.write(this.mOutputStream);
    }

    private void amp() {
        if (this.mState != 4) {
            d.closeSafely(this.mInputStream);
            d.closeSafely(this.mOutputStream);
            this.mState = 4;
            this.cGX.onClose();
        }
    }

    public void a(WebSocketFrame.CloseCode closeCode, String str) throws IOException {
        int i = this.mState;
        this.mState = 3;
        if (i == 2) {
            e(new WebSocketFrame.a(closeCode, str));
        } else {
            amp();
        }
    }
}
