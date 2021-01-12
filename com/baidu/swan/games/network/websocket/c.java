package com.baidu.swan.games.network.websocket;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.games.network.websocket.WebSocketEventTarget;
import com.baidu.swan.games.network.websocket.e;
import com.heytap.mcssdk.mode.Message;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends WebSocketEventTarget {
    private b ehk;
    private String taskId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.swan.games.f.b bVar2) {
        super(bVar2);
        this.ehk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c j(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        this.taskId = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
        int vN = k.vN("url");
        if (vN != 7) {
            a(k, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", com.baidu.swan.games.w.a.d.lg(7), com.baidu.swan.games.w.a.d.lg(vN)));
        } else {
            String optString = k.optString("url");
            String optString2 = k.optString("__plugin__");
            if (!this.ehk.aCL()) {
                a(k, "connectSocket", "up to max connect count");
            } else if (!dl(optString, optString2)) {
                a(k, "connectSocket", String.format("invalid url \"%s\"", optString));
            } else {
                WebSocketRequest b2 = b(optString, k);
                i(jsObject);
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(b2, this);
                    this.taskId = connect.getTaskId();
                    this.ehk.a(connect);
                    com.baidu.swan.games.utils.b.a(k, true, new e.c(this.taskId, String.format("%s:ok", "connectSocket")));
                } catch (Exception e) {
                    a(k, "connectSocket", e.getMessage());
                }
            }
        }
        return this;
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        JsArrayBuffer a2;
        String str;
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        switch (this.ehn) {
            case IDLE:
                a(k, "SocketTask.send", "SocketTask.readyState is not OPEN");
                return;
            case CLOSE:
                a(k, "SocketTask.send", "SocketTask.readyState is CLOSED");
                return;
            default:
                switch (k.vN("data")) {
                    case 7:
                        str = k.optString("data", null);
                        a2 = null;
                        break;
                    case 8:
                    case 9:
                    default:
                        a(k, "SocketTask.send", "invalid data type");
                        return;
                    case 10:
                        a2 = k.a("data", (JsArrayBuffer) null);
                        str = null;
                        break;
                }
                if (str == null && a2 == null) {
                    a(k, "SocketTask.send", "invalid data type");
                    return;
                }
                try {
                    if (str != null) {
                        WebSocketManager.INSTANCE.send(this.taskId, str);
                    } else if (a2 != null) {
                        WebSocketManager.INSTANCE.send(this.taskId, ByteBuffer.wrap(a2.buffer()));
                    }
                    a(k, "SocketTask.send");
                    return;
                } catch (Exception e) {
                    a(k, "SocketTask.send", e.getMessage());
                    return;
                }
        }
    }

    @JavascriptInterface
    public void close() {
        close(null);
    }

    @JavascriptInterface
    public void close(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        if (this.ehn == WebSocketEventTarget.SocketTaskState.CLOSE) {
            a(k, "SocketTask.close", "SocketTask.readyState is CLOSED");
            return;
        }
        int optInt = k.optInt("code", 1000);
        String optString = k.optString(TiebaInitialize.LogFields.REASON);
        try {
        } catch (Exception e) {
            a(k, "SocketTask.close", e.getMessage());
        } finally {
            this.ehk.pJ(this.taskId);
        }
        if (!(optInt == 1000 || (optInt >= 3000 && optInt <= 4999))) {
            a(k, "SocketTask.close", d.ehm);
            return;
        }
        WebSocketManager.INSTANCE.close(this.taskId, optInt, optString);
        a(k, "SocketTask.close");
    }

    private boolean dl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.apps.ad.a.a.aEO()) {
            return true;
        }
        return str.startsWith("wss://") && com.baidu.swan.apps.af.a.b.X("socket", str, str2) == 0;
    }

    private WebSocketRequest b(String str, @NonNull com.baidu.swan.games.binding.model.c cVar) {
        WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
        builder.setUrl(str);
        builder.setMethod(cVar.optString("method"));
        com.baidu.swan.games.binding.model.c vV = cVar.vV(WebSocketRequest.PARAM_KEY_HEADER);
        if (vV != null) {
            for (String str2 : vV.keySet()) {
                if (!TextUtils.isEmpty(str2) && !com.baidu.swan.apps.network.a.cER.contains(str2.toUpperCase())) {
                    builder.addHeader(str2, vV.toString(str2));
                }
            }
        }
        String[] vQ = cVar.vQ(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        ArrayList arrayList = new ArrayList();
        if (vQ != null && vQ.length != 0) {
            arrayList.addAll(Arrays.asList(vQ));
        } else {
            arrayList.add("");
        }
        builder.setProtocols(arrayList);
        builder.setConnectionLostTimeout(0);
        return builder.build();
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c k(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        return e == null ? new com.baidu.swan.games.binding.model.c() : e;
    }

    private void a(com.baidu.swan.games.binding.model.c cVar, String str) {
        String format = String.format("%s:ok", str);
        if (DEBUG) {
            Log.i("WebSocket", format);
        }
        com.baidu.swan.games.utils.b.a(cVar, true, new e.b(format));
    }

    private void a(com.baidu.swan.games.binding.model.c cVar, String str, String str2) {
        String format = String.format("%s:fail %s", str, str2);
        if (DEBUG) {
            Log.i("WebSocket", format);
        }
        com.baidu.swan.games.utils.b.a(cVar, false, new e.b(format));
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        super.onClose(jSONObject);
        if (this.ehk != null && jSONObject != null) {
            this.ehk.pJ(jSONObject.optString(Message.TASK_ID));
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        super.onError(th, jSONObject);
        if (this.ehk != null && jSONObject != null) {
            this.ehk.pJ(jSONObject.optString(Message.TASK_ID));
        }
    }

    private void i(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }
}
