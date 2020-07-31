package com.baidu.swan.apps.console.v8inspector.websocket;

import android.util.Base64;
import android.util.Log;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.console.v8inspector.websocket.WebSocketFrame;
import com.baidu.swan.d.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private InterfaceC0338a bYy;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private int mState = 1;
    private WebSocketFrame.OpCode bYz = null;
    private final List<WebSocketFrame> bYA = new LinkedList();

    /* renamed from: com.baidu.swan.apps.console.v8inspector.websocket.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0338a {
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

    public static String jo(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update((str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes());
        return Base64.encodeToString(messageDigest.digest(), 2);
    }

    public void a(InterfaceC0338a interfaceC0338a) {
        this.bYy = interfaceC0338a;
    }

    public void d(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
        this.mState = 2;
        if (this.bYy != null) {
            this.bYy.onOpen();
        }
        Yt();
    }

    private void Yt() {
        while (this.mState == 2) {
            try {
                b(WebSocketFrame.k(this.mInputStream));
            } catch (IOException e) {
                if (this.bYy != null) {
                    this.bYy.onException(e);
                }
                c.e("V8WebSocket", "parse web socket frame fail", e);
                return;
            } finally {
                Yu();
            }
        }
    }

    private void b(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.Yv() == WebSocketFrame.OpCode.Close) {
            d(webSocketFrame);
        } else if (webSocketFrame.Yv() == WebSocketFrame.OpCode.Ping) {
            e(new WebSocketFrame(WebSocketFrame.OpCode.Pong, true, webSocketFrame.Yx()));
        } else if (webSocketFrame.Yv() == WebSocketFrame.OpCode.Pong) {
            if (DEBUG) {
                Log.i("V8WebSocket", "A pong request has received.");
            }
        } else if (!webSocketFrame.Yw() || webSocketFrame.Yv() == WebSocketFrame.OpCode.Continuation) {
            c(webSocketFrame);
        } else if (this.bYz != null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence not completed.");
        } else {
            if (webSocketFrame.Yv() == WebSocketFrame.OpCode.Text || webSocketFrame.Yv() == WebSocketFrame.OpCode.Binary) {
                this.bYy.a(webSocketFrame);
                return;
            }
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Non control or continuous frame expected.");
        }
    }

    private void c(WebSocketFrame webSocketFrame) throws IOException {
        if (webSocketFrame.Yv() != WebSocketFrame.OpCode.Continuation) {
            if (this.bYz != null && DEBUG) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Previous continuous frame sequence not completed.");
            }
            this.bYz = webSocketFrame.Yv();
            this.bYA.clear();
            this.bYA.add(webSocketFrame);
        } else if (webSocketFrame.Yw()) {
            if (this.bYz == null) {
                throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
            }
            this.bYA.add(webSocketFrame);
            this.bYy.a(new WebSocketFrame(this.bYz, this.bYA));
            this.bYz = null;
            this.bYA.clear();
        } else if (this.bYz == null) {
            throw new WebSocketException(WebSocketFrame.CloseCode.ProtocolError, "Continuous frame sequence was not started.");
        } else {
            this.bYA.add(webSocketFrame);
        }
    }

    private void d(WebSocketFrame webSocketFrame) throws IOException {
        WebSocketFrame.CloseCode closeCode = WebSocketFrame.CloseCode.NormalClosure;
        String str = "";
        if (webSocketFrame instanceof WebSocketFrame.a) {
            closeCode = ((WebSocketFrame.a) webSocketFrame).YB();
            str = ((WebSocketFrame.a) webSocketFrame).getCloseReason();
        }
        if (this.mState == 3) {
            Yu();
        } else {
            a(closeCode, str);
        }
    }

    public synchronized void e(WebSocketFrame webSocketFrame) throws IOException {
        webSocketFrame.write(this.mOutputStream);
    }

    private void Yu() {
        if (this.mState != 4) {
            d.closeSafely(this.mInputStream);
            d.closeSafely(this.mOutputStream);
            this.mState = 4;
            this.bYy.onClose();
        }
    }

    public void a(WebSocketFrame.CloseCode closeCode, String str) throws IOException {
        int i = this.mState;
        this.mState = 3;
        if (i == 2) {
            e(new WebSocketFrame.a(closeCode, str));
        } else {
            Yu();
        }
    }
}
