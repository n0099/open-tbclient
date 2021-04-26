package com.baidu.swan.games.network.websocket;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.h0.a.k;
import d.a.h0.g.w.i.e;
import d.a.h0.g.w.i.f;
import d.a.h0.g.w.i.h;
import d.a.h0.g.w.i.i;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WebSocketEventTarget extends EventTargetImpl implements IWebSocketListener {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f12429f = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public SocketTaskState f12430e;

    /* loaded from: classes3.dex */
    public enum SocketTaskState {
        IDLE,
        OPEN,
        CLOSE
    }

    public WebSocketEventTarget(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.f12430e = SocketTaskState.IDLE;
    }

    public final void A(String str, Object obj) {
        if (f12429f) {
            Log.i("WebSocket", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        this.f12430e = SocketTaskState.CLOSE;
        A(IntentConfig.CLOSE, new e(jSONObject != null ? jSONObject.optInt("code", 0) : 0, jSONObject == null ? "" : jSONObject.optString("reason")));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        if (this.f12430e == SocketTaskState.IDLE) {
            A("error", new f(th.getMessage()));
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(String str) {
        A("message", new h(str));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onOpen(Map<String, String> map) {
        this.f12430e = SocketTaskState.OPEN;
        A("open", new i(new JSONObject(map)));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr);
        A("message", new h(new JsArrayBuffer(bArr, remaining)));
    }
}
