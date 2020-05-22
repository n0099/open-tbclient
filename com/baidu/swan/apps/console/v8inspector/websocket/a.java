package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Base64;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.swan.e.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private InterfaceC0330a bSR;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private int mState = 1;
    private WebSocketFrame.OpCode bSS = null;
    private final List<WebSocketFrame> bST = new LinkedList();

    /* renamed from: com.baidu.swan.apps.console.v8inspector.websocket.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0330a {
        void a(WebSocketFrame webSocketFrame);

        void onClose();

        void onException(IOException iOException);

        void onOpen();
    }

    public static boolean o(Map<String, String> map) {
        String str = map.get("Upgrade".toLowerCase());
        String str2 = map.get(HTTP.CONN_DIRECTIVE.toLowerCase());
        return "websocket".equalsIgnoreCase(str) && (str2 != null && str2.toLowerCase().contains("Upgrade".toLowerCase()));
    }

    public static String iW(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update((str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes());
        return Base64.encodeToString(messageDigest.digest(), 2);
    }

    public void a(InterfaceC0330a interfaceC0330a) {
        this.bSR = interfaceC0330a;
    }

    public void d(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
        this.mState = 2;
        if (this.bSR != null) {
            this.bSR.onOpen();
        }
        WH();
    }

    private void WH() {
        while (this.mState == 2) {
            try {
                b(WebSocketFrame.k(this.mInputStream));
            } catch (IOException e) {
                if (this.bSR != null) {
                    this.bSR.onException(e);
                }
                c.e("V8WebSocket", "parse web socket frame fail", e);
                return;
            } finally {
                WI();
            }
        }
    }

    private void b(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.WJ() == WebSocketFrame.OpCode.Close) {
            d(webSocketFrame);
        } else if (webSocketFrame.WJ() == WebSocketFrame.OpCode.Ping) {
            e(new WebSocketFrame(WebSocketFrame.OpCode.Pong, true, webSocketFrame.WL()));
        } else if (webSocketFrame.WJ() == WebSocketFrame.OpCode.Pong) {
            if (DEBUG) {
                Log.i("V8WebSocket", "A pong request has received.");
            }
        } else if (!webSocketFrame.WK() || webSocketFrame.WJ() == WebSocketFrame.OpCode.Continuation) {
            c(webSocketFrame);
        } else if (this.bSS != null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
        } else {
            if (webSocketFrame.WJ() == WebSocketFrame.OpCode.Text || webSocketFrame.WJ() == WebSocketFrame.OpCode.Binary) {
                this.bSR.a(webSocketFrame);
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
        }
    }

    private void c(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.WJ() != WebSocketFrame.OpCode.Continuation) {
            if (this.bSS != null && DEBUG) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
            }
            this.bSS = webSocketFrame.WJ();
            this.bST.clear();
            this.bST.add(webSocketFrame);
        } else if (webSocketFrame.WK()) {
            if (this.bSS == null) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
            }
            this.bST.add(webSocketFrame);
            this.bSR.a(new WebSocketFrame(this.bSS, this.bST));
            this.bSS = null;
            this.bST.clear();
        } else if (this.bSS == null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        } else {
            this.bST.add(webSocketFrame);
        }
    }

    private void d(WebSocketFrame webSocketFrame) throws IOException {
        WebSocketFrame.CloseCode closeCode = WebSocketFrame.CloseCode.NormalClosure;
        String str = "";
        if (webSocketFrame instanceof WebSocketFrame.a) {
            closeCode = ((WebSocketFrame.a) webSocketFrame).WP();
            str = ((WebSocketFrame.a) webSocketFrame).getCloseReason();
        }
        if (this.mState == 3) {
            WI();
        } else {
            a(closeCode, str);
        }
    }

    public synchronized void e(WebSocketFrame webSocketFrame) throws IOException {
        webSocketFrame.write(this.mOutputStream);
    }

    private void WI() {
        if (this.mState != 4) {
            d.closeSafely(this.mInputStream);
            d.closeSafely(this.mOutputStream);
            this.mState = 4;
            this.bSR.onClose();
        }
    }

    public void a(WebSocketFrame.CloseCode closeCode, String str) throws IOException {
        int i = this.mState;
        this.mState = 3;
        if (i == 2) {
            e(new WebSocketFrame.a(closeCode, str));
        } else {
            WI();
        }
    }
}
