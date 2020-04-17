package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Base64;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
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
    private InterfaceC0272a bJP;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private int mState = 1;
    private WebSocketFrame.OpCode bJQ = null;
    private final List<WebSocketFrame> bJR = new LinkedList();

    /* renamed from: com.baidu.swan.apps.console.v8inspector.websocket.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0272a {
        void a(WebSocketFrame webSocketFrame);

        void onClose();

        void onException(IOException iOException);

        void onOpen();
    }

    public static boolean m(Map<String, String> map) {
        String str = map.get("Upgrade".toLowerCase());
        String str2 = map.get(HTTP.CONN_DIRECTIVE.toLowerCase());
        return "websocket".equalsIgnoreCase(str) && (str2 != null && str2.toLowerCase().contains("Upgrade".toLowerCase()));
    }

    public static String hV(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update((str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes());
        return Base64.encodeToString(messageDigest.digest(), 2);
    }

    public void a(InterfaceC0272a interfaceC0272a) {
        this.bJP = interfaceC0272a;
    }

    public void d(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
        this.mState = 2;
        if (this.bJP != null) {
            this.bJP.onOpen();
        }
        Uc();
    }

    private void Uc() {
        while (this.mState == 2) {
            try {
                b(WebSocketFrame.j(this.mInputStream));
            } catch (IOException e) {
                if (this.bJP != null) {
                    this.bJP.onException(e);
                }
                c.e("V8WebSocket", "parse web socket frame fail", e);
                return;
            } finally {
                Ud();
            }
        }
    }

    private void b(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.Ue() == WebSocketFrame.OpCode.Close) {
            d(webSocketFrame);
        } else if (webSocketFrame.Ue() == WebSocketFrame.OpCode.Ping) {
            e(new WebSocketFrame(WebSocketFrame.OpCode.Pong, true, webSocketFrame.Ug()));
        } else if (webSocketFrame.Ue() == WebSocketFrame.OpCode.Pong) {
            if (DEBUG) {
                Log.i("V8WebSocket", "A pong request has received.");
            }
        } else if (!webSocketFrame.Uf() || webSocketFrame.Ue() == WebSocketFrame.OpCode.Continuation) {
            c(webSocketFrame);
        } else if (this.bJQ != null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
        } else {
            if (webSocketFrame.Ue() == WebSocketFrame.OpCode.Text || webSocketFrame.Ue() == WebSocketFrame.OpCode.Binary) {
                this.bJP.a(webSocketFrame);
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
        }
    }

    private void c(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.Ue() != WebSocketFrame.OpCode.Continuation) {
            if (this.bJQ != null && DEBUG) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
            }
            this.bJQ = webSocketFrame.Ue();
            this.bJR.clear();
            this.bJR.add(webSocketFrame);
        } else if (webSocketFrame.Uf()) {
            if (this.bJQ == null) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
            }
            this.bJR.add(webSocketFrame);
            this.bJP.a(new WebSocketFrame(this.bJQ, this.bJR));
            this.bJQ = null;
            this.bJR.clear();
        } else if (this.bJQ == null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        } else {
            this.bJR.add(webSocketFrame);
        }
    }

    private void d(WebSocketFrame webSocketFrame) throws IOException {
        WebSocketFrame.CloseCode closeCode = WebSocketFrame.CloseCode.NormalClosure;
        String str = "";
        if (webSocketFrame instanceof WebSocketFrame.a) {
            closeCode = ((WebSocketFrame.a) webSocketFrame).Uk();
            str = ((WebSocketFrame.a) webSocketFrame).getCloseReason();
        }
        if (this.mState == 3) {
            Ud();
        } else {
            a(closeCode, str);
        }
    }

    public synchronized void e(WebSocketFrame webSocketFrame) throws IOException {
        webSocketFrame.write(this.mOutputStream);
    }

    private void Ud() {
        if (this.mState != 4) {
            com.baidu.swan.d.c.closeSafely(this.mInputStream);
            com.baidu.swan.d.c.closeSafely(this.mOutputStream);
            this.mState = 4;
            this.bJP.onClose();
        }
    }

    public void a(WebSocketFrame.CloseCode closeCode, String str) throws IOException {
        int i = this.mState;
        this.mState = 3;
        if (i == 2) {
            e(new WebSocketFrame.a(closeCode, str));
        } else {
            Ud();
        }
    }
}
