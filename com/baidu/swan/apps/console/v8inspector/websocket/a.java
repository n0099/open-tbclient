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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private InterfaceC0402a cMq;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private int mState = 1;
    private WebSocketFrame.OpCode cMr = null;
    private final List<WebSocketFrame> cMs = new LinkedList();

    /* renamed from: com.baidu.swan.apps.console.v8inspector.websocket.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0402a {
        void a(WebSocketFrame webSocketFrame);

        void onClose();

        void onException(IOException iOException);

        void onOpen();
    }

    public static boolean z(Map<String, String> map) {
        String str = map.get("Upgrade".toLowerCase());
        String str2 = map.get(HTTP.CONN_DIRECTIVE.toLowerCase());
        return "websocket".equalsIgnoreCase(str) && (str2 != null && str2.toLowerCase().contains("Upgrade".toLowerCase()));
    }

    public static String lL(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update((str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes());
        return Base64.encodeToString(messageDigest.digest(), 2);
    }

    public void a(InterfaceC0402a interfaceC0402a) {
        this.cMq = interfaceC0402a;
    }

    public void d(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
        this.mState = 2;
        if (this.cMq != null) {
            this.cMq.onOpen();
        }
        amh();
    }

    private void amh() {
        while (this.mState == 2) {
            try {
                b(WebSocketFrame.n(this.mInputStream));
            } catch (IOException e) {
                if (this.cMq != null) {
                    this.cMq.onException(e);
                }
                c.e("V8WebSocket", "parse web socket frame fail", e);
                return;
            } finally {
                ami();
            }
        }
    }

    private void b(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.amj() == WebSocketFrame.OpCode.Close) {
            d(webSocketFrame);
        } else if (webSocketFrame.amj() == WebSocketFrame.OpCode.Ping) {
            e(new WebSocketFrame(WebSocketFrame.OpCode.Pong, true, webSocketFrame.aml()));
        } else if (webSocketFrame.amj() == WebSocketFrame.OpCode.Pong) {
            if (DEBUG) {
                Log.i("V8WebSocket", "A pong request has received.");
            }
        } else if (!webSocketFrame.amk() || webSocketFrame.amj() == WebSocketFrame.OpCode.Continuation) {
            c(webSocketFrame);
        } else if (this.cMr != null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
        } else {
            if (webSocketFrame.amj() == WebSocketFrame.OpCode.Text || webSocketFrame.amj() == WebSocketFrame.OpCode.Binary) {
                this.cMq.a(webSocketFrame);
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
        }
    }

    private void c(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.amj() != WebSocketFrame.OpCode.Continuation) {
            if (this.cMr != null && DEBUG) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
            }
            this.cMr = webSocketFrame.amj();
            this.cMs.clear();
            this.cMs.add(webSocketFrame);
        } else if (webSocketFrame.amk()) {
            if (this.cMr == null) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
            }
            this.cMs.add(webSocketFrame);
            this.cMq.a(new WebSocketFrame(this.cMr, this.cMs));
            this.cMr = null;
            this.cMs.clear();
        } else if (this.cMr == null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        } else {
            this.cMs.add(webSocketFrame);
        }
    }

    private void d(WebSocketFrame webSocketFrame) throws IOException {
        WebSocketFrame.CloseCode closeCode = WebSocketFrame.CloseCode.NormalClosure;
        String str = "";
        if (webSocketFrame instanceof WebSocketFrame.a) {
            closeCode = ((WebSocketFrame.a) webSocketFrame).amp();
            str = ((WebSocketFrame.a) webSocketFrame).getCloseReason();
        }
        if (this.mState == 3) {
            ami();
        } else {
            a(closeCode, str);
        }
    }

    public synchronized void e(WebSocketFrame webSocketFrame) throws IOException {
        webSocketFrame.write(this.mOutputStream);
    }

    private void ami() {
        if (this.mState != 4) {
            d.closeSafely(this.mInputStream);
            d.closeSafely(this.mOutputStream);
            this.mState = 4;
            this.cMq.onClose();
        }
    }

    public void a(WebSocketFrame.CloseCode closeCode, String str) throws IOException {
        int i = this.mState;
        this.mState = 3;
        if (i == 2) {
            e(new WebSocketFrame.a(closeCode, str));
        } else {
            ami();
        }
    }
}
