package com.baidu.swan.games.network.websocket;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
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
/* loaded from: classes2.dex */
public class c extends WebSocketEventTarget {
    private b bes;
    private String taskId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.swan.games.e.b bVar2) {
        super(bVar2);
        this.bes = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c g(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c h = h(jsObject);
        this.taskId = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
        int ie = h.ie("url");
        if (ie != 7) {
            a(h, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", com.baidu.swan.games.q.a.d.eI(7), com.baidu.swan.games.q.a.d.eI(ie)));
        } else {
            String optString = h.optString("url");
            if (!this.bes.Fe()) {
                a(h, "connectSocket", "up to max connect count");
            } else if (TextUtils.isEmpty(optString) || !optString.startsWith("wss://") || !com.baidu.swan.apps.af.a.b.av("socket", optString)) {
                a(h, "connectSocket", String.format("invalid url \"%s\"", optString));
            } else {
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(a(optString, h), this);
                    this.taskId = connect.getTaskId();
                    this.bes.a(connect);
                    com.baidu.swan.games.utils.a.a(h, true, new e.c(this.taskId, String.format("%s:ok", "connectSocket")));
                } catch (Exception e) {
                    a(h, "connectSocket", e.getMessage());
                }
            }
        }
        return this;
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        String str = null;
        com.baidu.swan.games.binding.model.c h = h(jsObject);
        switch (this.bew) {
            case IDLE:
                a(h, "SocketTask.send", "SocketTask.readyState is not OPEN");
                return;
            case CLOSE:
                a(h, "SocketTask.send", "SocketTask.readyState is CLOSED");
                return;
            default:
                JsArrayBuffer jsArrayBuffer = null;
                for (int i = 0; i < jsObject.length(); i++) {
                    if ("data".equals(jsObject.getPropertyName(i))) {
                        switch (jsObject.getPropertyType(i)) {
                            case 7:
                                str = jsObject.toString(i);
                                continue;
                            case 8:
                            case 9:
                            default:
                                a(h, "SocketTask.send", "invalid data type");
                                return;
                            case 10:
                                jsArrayBuffer = jsObject.toJsArrayBuffer(i);
                                continue;
                        }
                    }
                }
                if (str == null && jsArrayBuffer == null) {
                    a(h, "SocketTask.send", "invalid data type");
                    return;
                }
                try {
                    if (str != null) {
                        WebSocketManager.INSTANCE.send(this.taskId, str);
                    } else if (jsArrayBuffer != null) {
                        WebSocketManager.INSTANCE.send(this.taskId, ByteBuffer.wrap(jsArrayBuffer.buffer()));
                    }
                    a(h, "SocketTask.send");
                    return;
                } catch (Exception e) {
                    a(h, "SocketTask.send", e.getMessage());
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
        com.baidu.swan.games.binding.model.c h = h(jsObject);
        if (this.bew == WebSocketEventTarget.SocketTaskState.CLOSE) {
            a(h, "SocketTask.close", "SocketTask.readyState is CLOSED");
            return;
        }
        int optInt = h.optInt("code", 1000);
        String optString = h.optString("reason");
        try {
        } catch (Exception e) {
            a(h, "SocketTask.close", e.getMessage());
        } finally {
            this.bes.ft(this.taskId);
        }
        if (!(optInt == 1000 || (optInt >= 3000 && optInt <= 4999))) {
            a(h, "SocketTask.close", d.bev);
            return;
        }
        WebSocketManager.INSTANCE.close(this.taskId, optInt, optString);
        a(h, "SocketTask.close");
    }

    private WebSocketRequest a(String str, @NonNull com.baidu.swan.games.binding.model.c cVar) {
        WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
        builder.setUrl(str);
        builder.setMethod(cVar.optString("method"));
        JsObject ii = cVar.ii(WebSocketRequest.PARAM_KEY_HEADER);
        if (ii != null) {
            for (int i = 0; i < ii.length(); i++) {
                int propertyType = ii.getPropertyType(i);
                String propertyName = ii.getPropertyName(i);
                if (!TextUtils.isEmpty(propertyName) && !com.baidu.swan.apps.network.a.aCf.contains(propertyName.toUpperCase()) && propertyType == 7) {
                    builder.addHeader(propertyName, ii.toString(i));
                }
            }
        }
        String[] m15if = cVar.m15if(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        ArrayList arrayList = new ArrayList();
        if (m15if != null && m15if.length != 0) {
            arrayList.addAll(Arrays.asList(m15if));
        } else {
            arrayList.add("");
        }
        builder.setProtocols(arrayList);
        builder.setConnectionLostTimeout(0);
        return builder.build();
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c h(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c b = com.baidu.swan.games.binding.model.c.b(jsObject);
        return b == null ? new com.baidu.swan.games.binding.model.c() : b;
    }

    private void a(com.baidu.swan.games.binding.model.c cVar, String str) {
        String format = String.format("%s:ok", str);
        if (DEBUG) {
            Log.i("WebSocket", format);
        }
        com.baidu.swan.games.utils.a.a(cVar, true, new e.b(format));
    }

    private void a(com.baidu.swan.games.binding.model.c cVar, String str, String str2) {
        String format = String.format("%s:fail %s", str, str2);
        if (DEBUG) {
            Log.i("WebSocket", format);
        }
        com.baidu.swan.games.utils.a.a(cVar, false, new e.b(format));
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onClose(JSONObject jSONObject) {
        super.onClose(jSONObject);
        if (this.bes != null && jSONObject != null) {
            this.bes.ft(jSONObject.optString("taskID"));
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        super.onError(th, jSONObject);
        if (this.bes != null && jSONObject != null) {
            this.bes.ft(jSONObject.optString("taskID"));
        }
    }
}
