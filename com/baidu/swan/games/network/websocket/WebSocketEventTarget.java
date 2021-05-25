package com.baidu.swan.games.network.websocket;

import android.util.Log;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.k;
import d.a.l0.h.y.h.e;
import d.a.l0.h.y.h.f;
import d.a.l0.h.y.h.h;
import d.a.l0.h.y.h.i;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class WebSocketEventTarget extends EventTargetImpl implements IWebSocketListener {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f11672f = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public SocketTaskState f11673e;

    /* loaded from: classes3.dex */
    public enum SocketTaskState {
        IDLE,
        OPEN,
        CLOSE
    }

    public WebSocketEventTarget(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.f11673e = SocketTaskState.IDLE;
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        this.f11673e = SocketTaskState.CLOSE;
        z(IntentConfig.CLOSE, new e(jSONObject != null ? jSONObject.optInt("code", 0) : 0, jSONObject == null ? "" : jSONObject.optString("reason")));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        if (this.f11673e == SocketTaskState.IDLE) {
            z("error", new f(th.getMessage()));
        }
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(String str) {
        z("message", new h(str));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onOpen(Map<String, String> map) {
        this.f11673e = SocketTaskState.OPEN;
        z("open", new i(new JSONObject(map)));
    }

    public final void z(String str, Object obj) {
        if (f11672f) {
            Log.i("WebSocket", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.get(bArr);
        z("message", new h(new JsArrayBuffer(bArr, remaining)));
    }
}
