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
/* loaded from: classes2.dex */
public class c extends WebSocketEventTarget {
    private b bCN;
    private String taskId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, com.baidu.swan.games.e.b bVar2) {
        super(bVar2);
        this.bCN = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c h(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        this.taskId = String.format(Locale.CHINA, "WebSocketTask-%d", Long.valueOf(System.currentTimeMillis()));
        int jy = i.jy("url");
        if (jy != 7) {
            a(i, "connectSocket", String.format("parameter error: parameter.url should be %s instead of %s", com.baidu.swan.games.s.a.d.gb(7), com.baidu.swan.games.s.a.d.gb(jy)));
        } else {
            String optString = i.optString("url");
            if (!this.bCN.MQ()) {
                a(i, "connectSocket", "up to max connect count");
            } else if (!kr(optString)) {
                a(i, "connectSocket", String.format("invalid url \"%s\"", optString));
            } else {
                try {
                    WebSocketTask connect = WebSocketManager.INSTANCE.connect(a(optString, i), this);
                    this.taskId = connect.getTaskId();
                    this.bCN.a(connect);
                    com.baidu.swan.games.utils.a.a(i, true, new e.c(this.taskId, String.format("%s:ok", "connectSocket")));
                } catch (Exception e) {
                    a(i, "connectSocket", e.getMessage());
                }
            }
        }
        return this;
    }

    @JavascriptInterface
    public void send(JsObject jsObject) {
        String str = null;
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        switch (this.bCQ) {
            case IDLE:
                a(i, "SocketTask.send", "SocketTask.readyState is not OPEN");
                return;
            case CLOSE:
                a(i, "SocketTask.send", "SocketTask.readyState is CLOSED");
                return;
            default:
                JsArrayBuffer jsArrayBuffer = null;
                for (int i2 = 0; i2 < jsObject.length(); i2++) {
                    if ("data".equals(jsObject.getPropertyName(i2))) {
                        switch (jsObject.getPropertyType(i2)) {
                            case 7:
                                str = jsObject.toString(i2);
                                continue;
                            case 8:
                            case 9:
                            default:
                                a(i, "SocketTask.send", "invalid data type");
                                return;
                            case 10:
                                jsArrayBuffer = jsObject.toJsArrayBuffer(i2);
                                continue;
                        }
                    }
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
        if (this.bCQ == WebSocketEventTarget.SocketTaskState.CLOSE) {
            a(i, "SocketTask.close", "SocketTask.readyState is CLOSED");
            return;
        }
        int optInt = i.optInt("code", 1000);
        String optString = i.optString(TiebaInitialize.LogFields.REASON);
        try {
        } catch (Exception e) {
            a(i, "SocketTask.close", e.getMessage());
        } finally {
            this.bCN.gt(this.taskId);
        }
        if (!(optInt == 1000 || (optInt >= 3000 && optInt <= 4999))) {
            a(i, "SocketTask.close", d.bCP);
            return;
        }
        WebSocketManager.INSTANCE.close(this.taskId, optInt, optString);
        a(i, "SocketTask.close");
    }

    private boolean kr(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (DEBUG && com.baidu.swan.apps.ac.a.a.Oa()) {
            return true;
        }
        return str.startsWith("wss://") && com.baidu.swan.apps.af.a.b.aD("socket", str);
    }

    private WebSocketRequest a(String str, @NonNull com.baidu.swan.games.binding.model.c cVar) {
        WebSocketRequest.Builder builder = new WebSocketRequest.Builder();
        builder.setUrl(str);
        builder.setMethod(cVar.optString("method"));
        JsObject jE = cVar.jE(WebSocketRequest.PARAM_KEY_HEADER);
        if (jE != null) {
            for (int i = 0; i < jE.length(); i++) {
                int propertyType = jE.getPropertyType(i);
                String propertyName = jE.getPropertyName(i);
                if (!TextUtils.isEmpty(propertyName) && !com.baidu.swan.apps.network.a.aYr.contains(propertyName.toUpperCase()) && propertyType == 7) {
                    builder.addHeader(propertyName, jE.toString(i));
                }
            }
        }
        String[] jA = cVar.jA(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        ArrayList arrayList = new ArrayList();
        if (jA != null && jA.length != 0) {
            arrayList.addAll(Arrays.asList(jA));
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
        if (this.bCN != null && jSONObject != null) {
            this.bCN.gt(jSONObject.optString("taskID"));
        }
    }

    @Override // com.baidu.swan.games.network.websocket.WebSocketEventTarget, com.baidu.searchbox.websocket.IWebSocketListener
    public void onError(Throwable th, JSONObject jSONObject) {
        super.onError(th, jSONObject);
        if (this.bCN != null && jSONObject != null) {
            this.bCN.gt(jSONObject.optString("taskID"));
        }
    }
}
