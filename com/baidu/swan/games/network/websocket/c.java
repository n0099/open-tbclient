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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends WebSocketEventTarget {
    private b cPK;
    private String taskId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.swan.games.e.b bVar2) {
        super(bVar2);
        this.cPK = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c h(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        this.taskId = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
        int pK = i.pK("url");
        if (pK != 7) {
            a(i, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", com.baidu.swan.games.v.a.d.id(7), com.baidu.swan.games.v.a.d.id(pK)));
        } else {
            String optString = i.optString("url");
            String optString2 = i.optString("__plugin__");
            if (!this.cPK.ahj()) {
                a(i, "connectSocket", "up to max connect count");
            } else if (!cb(optString, optString2)) {
                a(i, "connectSocket", String.format("invalid url \"%s\"", optString));
            } else {
                WebSocketRequest b = b(optString, i);
                g(jsObject);
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(b, this);
                    this.taskId = connect.getTaskId();
                    this.cPK.a(connect);
                    com.baidu.swan.games.utils.b.a(i, true, new e.c(this.taskId, String.format("%s:ok", "connectSocket")));
                } catch (Exception e) {
                    a(i, "connectSocket", e.getMessage());
                }
            }
        }
        return this;
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        String str;
        JsArrayBuffer jsArrayBuffer = null;
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        switch (this.cPN) {
            case IDLE:
                a(i, "SocketTask.send", "SocketTask.readyState is not OPEN");
                return;
            case CLOSE:
                a(i, "SocketTask.send", "SocketTask.readyState is CLOSED");
                return;
            default:
                switch (i.pK("data")) {
                    case 7:
                        str = i.optString("data", null);
                        break;
                    case 8:
                    case 9:
                    default:
                        a(i, "SocketTask.send", "invalid data type");
                        return;
                    case 10:
                        str = null;
                        jsArrayBuffer = i.a("data", (JsArrayBuffer) null);
                        break;
                }
                if (str == null && jsArrayBuffer == null) {
                    a(i, "SocketTask.send", "invalid data type");
                    return;
                }
                try {
                    if (str != null) {
                        WebSocketManager.INSTANCE.send(this.taskId, str);
                    } else if (jsArrayBuffer != null) {
                        WebSocketManager.INSTANCE.send(this.taskId, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                    }
                    a(i, "SocketTask.send");
                    return;
                } catch (Exception e) {
                    a(i, "SocketTask.send", e.getMessage());
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
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        if (this.cPN == WebSocketEventTarget.SocketTaskState.CLOSE) {
            a(i, "SocketTask.close", "SocketTask.readyState is CLOSED");
            return;
        }
        int optInt = i.optInt("code", 1000);
        String optString = i.optString(TiebaInitialize.LogFields.REASON);
        try {
        } catch (Exception e) {
            a(i, "SocketTask.close", e.getMessage());
        } finally {
            this.cPK.kT(this.taskId);
        }
        if (!(optInt == 1000 || (optInt >= 3000 && optInt <= 4999))) {
            a(i, "SocketTask.close", d.cPM);
            return;
        }
        WebSocketManager.INSTANCE.close(this.taskId, optInt, optString);
        a(i, "SocketTask.close");
    }

    private boolean cb(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.swan.apps.ah.a.a.aiI()) {
            return true;
        }
        return str.startsWith("wss://") && com.baidu.swan.apps.aj.a.b.D("socket", str, str2) == 0;
    }

    private WebSocketRequest b(String str, @NonNull com.baidu.swan.games.binding.model.c cVar) {
        WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
        builder.setUrl(str);
        builder.setMethod(cVar.optString("method"));
        com.baidu.swan.games.binding.model.c pS = cVar.pS(WebSocketRequest.PARAM_KEY_HEADER);
        if (pS != null) {
            for (String str2 : pS.keySet()) {
                if (!TextUtils.isEmpty(str2) && !com.baidu.swan.apps.network.a.bDh.contains(str2.toUpperCase())) {
                    builder.addHeader(str2, pS.toString(str2));
                }
            }
        }
        String[] pN = cVar.pN(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        ArrayList arrayList = new ArrayList();
        if (pN != null && pN.length != 0) {
            arrayList.addAll(Arrays.asList(pN));
        } else {
            arrayList.add("");
        }
        builder.setProtocols(arrayList);
        builder.setConnectionLostTimeout(0);
        return builder.build();
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c i(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        return c == null ? new com.baidu.swan.games.binding.model.c() : c;
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
        if (this.cPK != null && jSONObject != null) {
            this.cPK.kT(jSONObject.optString("taskID"));
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        super.onError(th, jSONObject);
        if (this.cPK != null && jSONObject != null) {
            this.cPK.kT(jSONObject.optString("taskID"));
        }
    }

    private void g(JsObject jsObject) {
        if (jsObject != null) {
            jsObject.release();
        }
    }
}
