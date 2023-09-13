package com.baidu.swan.games.network.websocket;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.tieba.ia4;
import com.baidu.tieba.ja4;
import com.baidu.tieba.la4;
import com.baidu.tieba.ma4;
import com.baidu.tieba.rr1;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WebSocketEventTarget extends EventTargetImpl implements IWebSocketListener {
    public static final boolean b = rr1.a;
    public SocketTaskState a;

    /* loaded from: classes4.dex */
    public enum SocketTaskState {
        IDLE,
        OPEN,
        CLOSE
    }

    public WebSocketEventTarget(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.a = SocketTaskState.IDLE;
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        String optString;
        this.a = SocketTaskState.CLOSE;
        int i = 0;
        if (jSONObject != null) {
            i = jSONObject.optInt("code", 0);
        }
        if (jSONObject == null) {
            optString = "";
        } else {
            optString = jSONObject.optString("reason");
        }
        w("close", new ia4(i, optString));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(String str) {
        w("message", new la4(str));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onOpen(Map<String, String> map) {
        this.a = SocketTaskState.OPEN;
        w("open", new ma4(new JSONObject(map)));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        if (this.a == SocketTaskState.IDLE) {
            w("error", new ja4(th.getMessage()));
        }
    }

    public final void w(String str, Object obj) {
        if (b) {
            Log.i("WebSocket", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr);
        w("message", new la4(new JsArrayBuffer(bArr, remaining)));
    }
}
