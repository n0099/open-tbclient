package com.baidu.swan.games.network.websocket;

import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.swan.games.network.websocket.e;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class WebSocketEventTarget extends EventTargetImpl implements IWebSocketListener {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected SocketTaskState cPN;

    /* loaded from: classes11.dex */
    protected enum SocketTaskState {
        IDLE,
        OPEN,
        CLOSE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketEventTarget(JSRuntime jSRuntime) {
        super(jSRuntime);
        this.cPN = SocketTaskState.IDLE;
    }

    private void t(String str, Object obj) {
        if (DEBUG) {
            Log.i("WebSocket", "dispatchEvent:" + str);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onOpen(Map<String, String> map) {
        this.cPN = SocketTaskState.OPEN;
        t("open", new e.C0371e(new JSONObject(map)));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(String str) {
        t("message", new e.d(str));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onMessage(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        t("message", new e.d(new JsArrayBuffer(bArr, bArr.length)));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        this.cPN = SocketTaskState.CLOSE;
        t("close", new e.a(jSONObject == null ? 0 : jSONObject.optInt("code", 0), jSONObject == null ? "" : jSONObject.optString(TiebaInitialize.LogFields.REASON)));
    }

    @Override // com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        if (this.cPN == SocketTaskState.IDLE) {
            t(BdStatsConstant.StatsType.ERROR, new e.b(th.getMessage()));
        }
    }
}
