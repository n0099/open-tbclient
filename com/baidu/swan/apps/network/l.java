package com.baidu.swan.apps.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.scheme.actions.aa;
import com.heytap.mcssdk.mode.Message;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
@kotlin.h
/* loaded from: classes8.dex */
public final class l extends aa {
    public static final a cEX = new a(null);

    public l(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/webSocket");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [76=5] */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.runtime.e eVar) {
        boolean c;
        q.m(unitedSchemeEntity, "entity");
        if (aa.DEBUG) {
            Log.d("websocket", "handleSubAction subAction: " + str);
        }
        if (eVar == null) {
            com.baidu.swan.apps.console.c.e("websocket", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (aa.DEBUG) {
                Log.d("websocket", "websocket --- illegal swanApp");
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(eVar.id)) {
            com.baidu.swan.apps.console.c.e("websocket", "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            if (aa.DEBUG) {
                Log.d("websocket", "websocket --- none swanApp id");
                return false;
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                com.baidu.swan.apps.console.c.e("websocket", "no params found");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "no params found");
                if (aa.DEBUG) {
                    Log.d("websocket", "websocket --- none params found");
                    return false;
                }
                return false;
            }
            if (str != null) {
                switch (str.hashCode()) {
                    case -1597844571:
                        if (str.equals("/swanAPI/webSocket/send")) {
                            c = b(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, eVar);
                            break;
                        }
                        break;
                    case -1293540435:
                        if (str.equals("/swanAPI/webSocket/connect")) {
                            c = c(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, eVar);
                            break;
                        }
                        break;
                    case 1991859579:
                        if (str.equals("/swanAPI/webSocket/close")) {
                            c = a(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, eVar);
                            break;
                        }
                        break;
                }
                return c;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            c = false;
            return c;
        }
    }

    private final boolean a(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (!jSONObject.has(Message.TASK_ID)) {
            com.baidu.swan.apps.console.c.e("websocket", "taskID lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID lose");
            if (aa.DEBUG) {
                Log.d("websocket", "close --- taskID lose");
                return false;
            }
            return false;
        }
        String string = jSONObject.getString(Message.TASK_ID);
        int optInt = jSONObject.optInt("code", 1000);
        String optString = jSONObject.optString(TiebaInitialize.LogFields.REASON, "close normally");
        try {
            try {
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                q.l((Object) string, "taskId");
                q.l((Object) optString, TiebaInitialize.LogFields.REASON);
                webSocketManager.close(string, optInt, optString);
                eVar.azY().oN(string);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            } catch (Exception e) {
                com.baidu.swan.apps.console.c.e("websocket", e.getMessage());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
                if (aa.DEBUG) {
                    Log.d("websocket", "close --- " + e.getMessage());
                }
                k azY = eVar.azY();
                q.l((Object) string, "taskId");
                azY.oN(string);
                return false;
            }
        } catch (Throwable th) {
            k azY2 = eVar.azY();
            q.l((Object) string, "taskId");
            azY2.oN(string);
            throw th;
        }
    }

    private final boolean b(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (!jSONObject.has(Message.TASK_ID) || !jSONObject.has("data")) {
            com.baidu.swan.apps.console.c.e("websocket", "taskID or data lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID or data lose");
            if (aa.DEBUG) {
                Log.d("websocket", "send --- taskID or data lose");
                return false;
            }
            return false;
        }
        String string = jSONObject.getString(Message.TASK_ID);
        String string2 = jSONObject.getString("data");
        try {
            if (jSONObject.optString("dataType", "string").equals("arrayBuffer")) {
                ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(string2, 2));
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                q.l((Object) string, "taskId");
                q.l((Object) wrap, "buffer");
                webSocketManager.send(string, wrap);
            } else {
                WebSocketManager webSocketManager2 = WebSocketManager.INSTANCE;
                q.l((Object) string, "taskId");
                q.l((Object) string2, "data");
                webSocketManager2.send(string, string2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        } catch (Exception e) {
            com.baidu.swan.apps.console.c.e("websocket", e.getMessage());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
            if (aa.DEBUG) {
                Log.d("websocket", "send --- " + e.getMessage());
                return false;
            }
            return false;
        }
    }

    private final boolean c(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (!jSONObject.has("url") || !jSONObject.has("cb")) {
            com.baidu.swan.apps.console.c.e("websocket", "url or cb lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "url or cb lose");
            if (aa.DEBUG) {
                Log.d("websocket", "connect --- url or cb lose");
            }
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("cb");
        if (!jSONObject2.has("onOpen") || !jSONObject2.has("onMessage") || !jSONObject2.has("onClose") || !jSONObject2.has("onError")) {
            com.baidu.swan.apps.console.c.e("websocket", "websocket callback lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "websocket callback lose");
            if (aa.DEBUG) {
                Log.d("websocket", "connect --- websocket callback lose");
            }
            return false;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (!eVar.azY().auV()) {
            jSONObject3.put(BaseJsonData.TAG_ERRNO, "1");
        } else {
            String string = jSONObject.getString("url");
            String optString = jSONObject.optString("__plugin__");
            switch (com.baidu.swan.apps.ag.a.b.K("socket", string, optString)) {
                case 1:
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
                    return false;
                case 2:
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "request url header must be https or wss");
                    return false;
                default:
                    WebSocketRequest fromJSON = WebSocketRequest.Companion.fromJSON(jSONObject);
                    if (!TextUtils.isEmpty(optString)) {
                        com.baidu.swan.pms.model.h pD = com.baidu.swan.apps.ac.g.b.pD(optString);
                        LinkedHashMap headers = fromJSON.getHeaders();
                        if (headers == null) {
                            headers = new LinkedHashMap();
                            fromJSON.setHeaders(headers);
                        }
                        String e = com.baidu.swan.apps.ac.g.a.e(pD);
                        q.l((Object) e, "SwanPluginHostSign.hostSign(pmsPlugin)");
                        headers.put("X-SWAN-HOSTSIGN", e);
                    }
                    q.l((Object) jSONObject2, "cb");
                    try {
                        WebSocketTask connect = WebSocketManager.INSTANCE.connect(fromJSON, a(jSONObject2, callbackHandler));
                        jSONObject3.put(BaseJsonData.TAG_ERRNO, "0");
                        jSONObject3.put("task", connect.toJSON());
                        eVar.azY().a(connect);
                        break;
                    } catch (Exception e2) {
                        com.baidu.swan.apps.console.c.e("websocket", e2.getMessage());
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage());
                        if (aa.DEBUG) {
                            Log.d("websocket", "connect --- " + e2.getMessage());
                        }
                        return false;
                    }
            }
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0));
        return true;
    }

    private final IWebSocketListener a(JSONObject jSONObject, CallbackHandler callbackHandler) {
        return new b(new WeakReference(callbackHandler), jSONObject.getString("onOpen"), jSONObject.getString("onMessage"), jSONObject.getString("onClose"), jSONObject.getString("onError"));
    }

    @kotlin.h
    /* loaded from: classes8.dex */
    public static final class b implements IWebSocketListener {
        final /* synthetic */ WeakReference cEZ;
        final /* synthetic */ String cFa;
        final /* synthetic */ String cFb;
        final /* synthetic */ String cFc;
        final /* synthetic */ String cFd;

        b(WeakReference weakReference, String str, String str2, String str3, String str4) {
            this.cEZ = weakReference;
            this.cFa = str;
            this.cFb = str2;
            this.cFc = str3;
            this.cFd = str4;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map<String, String> map) {
            q.m(map, "headers");
            JSONObject jSONObject = new JSONObject(map);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(WebSocketRequest.PARAM_KEY_HEADER, jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "websocket open success");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.cEZ.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.cFa, jSONObject3.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            q.m(str, "message");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", str);
            jSONObject.put("dataType", "string");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", "0");
            jSONObject2.put("message", "message received");
            jSONObject2.put("data", jSONObject);
            CallbackHandler callbackHandler = (CallbackHandler) this.cEZ.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.cFb, jSONObject2.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            q.m(byteBuffer, "message");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            String encodeToString = Base64.encodeToString(bArr, 2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", encodeToString);
            jSONObject.put("dataType", "arrayBuffer");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", "0");
            jSONObject2.put("message", "message received");
            jSONObject2.put("data", jSONObject);
            CallbackHandler callbackHandler = (CallbackHandler) this.cEZ.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.cFb, jSONObject2.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            com.baidu.swan.apps.runtime.e agn;
            k azY;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", jSONObject != null ? jSONObject.optInt("code") : 0);
            jSONObject2.put(TiebaInitialize.LogFields.REASON, (jSONObject == null || (r0 = jSONObject.optString(TiebaInitialize.LogFields.REASON, "")) == null) ? "" : "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "websocket closed");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.cEZ.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.cFc, jSONObject3.toString());
            }
            String string = jSONObject != null ? jSONObject.getString(Message.TASK_ID) : null;
            if (string == null || (agn = l.this.agn()) == null || (azY = agn.azY()) == null) {
                return;
            }
            azY.oN(string);
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            com.baidu.swan.apps.runtime.e agn;
            k azY;
            q.m(th, "t");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errMsg", th.getMessage());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "error happen");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.cEZ.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.cFd, jSONObject3.toString());
            }
            String string = jSONObject != null ? jSONObject.getString(Message.TASK_ID) : null;
            if (string == null || (agn = l.this.agn()) == null || (azY = agn.azY()) == null) {
                return;
            }
            azY.oN(string);
        }
    }

    @kotlin.h
    /* loaded from: classes8.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
