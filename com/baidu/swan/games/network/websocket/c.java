package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
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
    private b dvn;
    private String taskId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.swan.games.f.b bVar2) {
        super(bVar2);
        this.dvn = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c j(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        this.taskId = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
        int uK = k.uK("url");
        if (uK != 7) {
            a(k, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", com.baidu.swan.games.w.a.d.lh(7), com.baidu.swan.games.w.a.d.lh(uK)));
        } else {
            String optString = k.optString("url");
            String optString2 = k.optString("__plugin__");
            if (!this.dvn.auV()) {
                a(k, "connectSocket", "up to max connect count");
            } else if (!cV(optString, optString2)) {
                a(k, "connectSocket", String.format("invalid url \"%s\"", optString));
            } else {
                WebSocketRequest b = b(optString, k);
                i(jsObject);
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(b, this);
                    this.taskId = connect.getTaskId();
                    this.dvn.a(connect);
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
        String str;
        JsArrayBuffer jsArrayBuffer = null;
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        switch (this.dvq) {
            case IDLE:
                a(k, "SocketTask.send", "SocketTask.readyState is not OPEN");
                return;
            case CLOSE:
                a(k, "SocketTask.send", "SocketTask.readyState is CLOSED");
                return;
            default:
                switch (k.uK("data")) {
                    case 7:
                        str = k.optString("data", null);
                        break;
                    case 8:
                    case 9:
                    default:
                        a(k, "SocketTask.send", "invalid data type");
                        return;
                    case 10:
                        str = null;
                        jsArrayBuffer = k.a("data", (JsArrayBuffer) null);
                        break;
                }
                if (str == null && jsArrayBuffer == null) {
                    a(k, "SocketTask.send", "invalid data type");
                    return;
                }
                try {
                    if (str != null) {
                        WebSocketManager.INSTANCE.send(this.taskId, str);
                    } else if (jsArrayBuffer != null) {
                        WebSocketManager.INSTANCE.send(this.taskId, ByteBuffer.wrap(jsArrayBuffer.buffer()));
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
        if (this.dvq == WebSocketEventTarget.SocketTaskState.CLOSE) {
            a(k, "SocketTask.close", "SocketTask.readyState is CLOSED");
            return;
        }
        int optInt = k.optInt("code", 1000);
        String optString = k.optString(TiebaInitialize.LogFields.REASON);
        try {
        } catch (Exception e) {
            a(k, "SocketTask.close", e.getMessage());
        } finally {
            this.dvn.oM(this.taskId);
        }
        if (!(optInt == 1000 || (optInt >= 3000 && optInt <= 4999))) {
            a(k, "SocketTask.close", d.dvp);
            return;
        }
        WebSocketManager.INSTANCE.close(this.taskId, optInt, optString);
        a(k, "SocketTask.close");
    }

    private boolean cV(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.apps.ad.a.a.axa()) {
            return true;
        }
        return str.startsWith("wss://") && com.baidu.swan.apps.ag.a.b.K("socket", str, str2) == 0;
    }

    private WebSocketRequest b(String str, @NonNull com.baidu.swan.games.binding.model.c cVar) {
        WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
        builder.setUrl(str);
        builder.setMethod(cVar.optString("method"));
        com.baidu.swan.games.binding.model.c uS = cVar.uS(WebSocketRequest.PARAM_KEY_HEADER);
        if (uS != null) {
            for (String str2 : uS.keySet()) {
                if (!TextUtils.isEmpty(str2) && !com.baidu.swan.apps.network.a.bWN.contains(str2.toUpperCase())) {
                    builder.addHeader(str2, uS.toString(str2));
                }
            }
        }
        String[] uN = cVar.uN(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        ArrayList arrayList = new ArrayList();
        if (uN != null && uN.length != 0) {
            arrayList.addAll(Arrays.asList(uN));
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
        if (this.dvn != null && jSONObject != null) {
            this.dvn.oM(jSONObject.optString(Message.TASK_ID));
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        super.onError(th, jSONObject);
        if (this.dvn != null && jSONObject != null) {
            this.dvn.oM(jSONObject.optString(Message.TASK_ID));
        }
    }

    private void i(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }
}
