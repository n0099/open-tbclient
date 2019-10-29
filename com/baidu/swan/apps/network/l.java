package com.baidu.swan.apps.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import com.baidu.swan.apps.scheme.actions.z;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class l extends z {
    public static final a aYW = new a(null);

    public l(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/webSocket");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [74=5] */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, com.baidu.swan.apps.ae.b bVar) {
        boolean b2;
        p.i(unitedSchemeEntity, "entity");
        if (z.DEBUG) {
            Log.d("websocket", "handleSubAction subAction: " + str);
        }
        if (bVar == null) {
            com.baidu.swan.apps.console.c.e("websocket", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
            if (z.DEBUG) {
                Log.d("websocket", "websocket --- illegal swanApp");
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(bVar.id)) {
            com.baidu.swan.apps.console.c.e("websocket", "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none swanApp id");
            if (z.DEBUG) {
                Log.d("websocket", "websocket --- none swanApp id");
                return false;
            }
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                com.baidu.swan.apps.console.c.e("websocket", "no params found");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "no params found");
                if (z.DEBUG) {
                    Log.d("websocket", "websocket --- none params found");
                    return false;
                }
                return false;
            }
            if (str != null) {
                switch (str.hashCode()) {
                    case -1138508621:
                        if (str.equals("/swan/webSocket/connect")) {
                            b2 = c(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, bVar);
                            break;
                        }
                        break;
                    case -346732449:
                        if (str.equals("/swan/webSocket/send")) {
                            b2 = b(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, bVar);
                            break;
                        }
                        break;
                    case 2121629697:
                        if (str.equals("/swan/webSocket/close")) {
                            b2 = a(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, bVar);
                            break;
                        }
                        break;
                }
                return b2;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            b2 = false;
            return b2;
        }
    }

    private final boolean a(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!jSONObject.has("taskID")) {
            com.baidu.swan.apps.console.c.e("websocket", "taskID lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID lose");
            if (z.DEBUG) {
                Log.d("websocket", "close --- taskID lose");
                return false;
            }
            return false;
        }
        String string = jSONObject.getString("taskID");
        int optInt = jSONObject.optInt("code", 1000);
        String optString = jSONObject.optString(TiebaInitialize.LogFields.REASON, "close normally");
        try {
            try {
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                p.h(string, "taskId");
                p.h(optString, TiebaInitialize.LogFields.REASON);
                webSocketManager.close(string, optInt, optString);
                bVar.Rh().gt(string);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            } catch (Exception e) {
                com.baidu.swan.apps.console.c.e("websocket", e.getMessage());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
                if (z.DEBUG) {
                    Log.d("websocket", "close --- " + e.getMessage());
                }
                k Rh = bVar.Rh();
                p.h(string, "taskId");
                Rh.gt(string);
                return false;
            }
        } catch (Throwable th) {
            k Rh2 = bVar.Rh();
            p.h(string, "taskId");
            Rh2.gt(string);
            throw th;
        }
    }

    private final boolean b(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!jSONObject.has("taskID") || !jSONObject.has("data")) {
            com.baidu.swan.apps.console.c.e("websocket", "taskID or data lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID or data lose");
            if (z.DEBUG) {
                Log.d("websocket", "send --- taskID or data lose");
                return false;
            }
            return false;
        }
        String string = jSONObject.getString("taskID");
        String string2 = jSONObject.getString("data");
        try {
            if (jSONObject.optString("dataType", "string").equals("arrayBuffer")) {
                ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(string2, 2));
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                p.h(string, "taskId");
                p.h(wrap, "buffer");
                webSocketManager.send(string, wrap);
            } else {
                WebSocketManager webSocketManager2 = WebSocketManager.INSTANCE;
                p.h(string, "taskId");
                p.h(string2, "data");
                webSocketManager2.send(string, string2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        } catch (Exception e) {
            com.baidu.swan.apps.console.c.e("websocket", e.getMessage());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
            if (z.DEBUG) {
                Log.d("websocket", "send --- " + e.getMessage());
                return false;
            }
            return false;
        }
    }

    private final boolean c(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!jSONObject.has("url") || !jSONObject.has("cb")) {
            com.baidu.swan.apps.console.c.e("websocket", "url or cb lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "url or cb lose");
            if (z.DEBUG) {
                Log.d("websocket", "connect --- url or cb lose");
                return false;
            }
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("cb");
        if (!jSONObject2.has("onOpen") || !jSONObject2.has("onMessage") || !jSONObject2.has("onClose") || !jSONObject2.has("onError")) {
            com.baidu.swan.apps.console.c.e("websocket", "websocket callback lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "websocket callback lose");
            if (z.DEBUG) {
                Log.d("websocket", "connect --- websocket callback lose");
                return false;
            }
            return false;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (!bVar.Rh().MQ()) {
            jSONObject3.put("errno", "1");
        } else if (!com.baidu.swan.apps.af.a.b.aD("socket", jSONObject.getString("url"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal request");
            return false;
        } else {
            WebSocketRequest fromJSON = WebSocketRequest.Companion.fromJSON(jSONObject);
            p.h(jSONObject2, "cb");
            try {
                WebSocketTask connect = WebSocketManager.INSTANCE.connect(fromJSON, a(jSONObject2, callbackHandler));
                jSONObject3.put("errno", "0");
                jSONObject3.put("task", connect.toJSON());
                bVar.Rh().a(connect);
            } catch (Exception e) {
                com.baidu.swan.apps.console.c.e("websocket", e.getMessage());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
                if (z.DEBUG) {
                    Log.d("websocket", "connect --- " + e.getMessage());
                    return false;
                }
                return false;
            }
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0));
        return true;
    }

    private final IWebSocketListener a(JSONObject jSONObject, CallbackHandler callbackHandler) {
        return new b(new WeakReference(callbackHandler), jSONObject.getString("onOpen"), jSONObject.getString("onMessage"), jSONObject.getString("onClose"), jSONObject.getString("onError"));
    }

    /* loaded from: classes2.dex */
    public static final class b implements IWebSocketListener {
        final /* synthetic */ WeakReference aYY;
        final /* synthetic */ String aYZ;
        final /* synthetic */ String aZa;
        final /* synthetic */ String aZb;
        final /* synthetic */ String aZc;

        b(WeakReference weakReference, String str, String str2, String str3, String str4) {
            this.aYY = weakReference;
            this.aYZ = str;
            this.aZa = str2;
            this.aZb = str3;
            this.aZc = str4;
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onOpen(Map<String, String> map) {
            p.i(map, "headers");
            JSONObject jSONObject = new JSONObject(map);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(WebSocketRequest.PARAM_KEY_HEADER, jSONObject);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "websocket open success");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.aYY.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.aYZ, jSONObject3.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(String str) {
            p.i(str, "message");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", str);
            jSONObject.put("dataType", "string");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", "0");
            jSONObject2.put("message", "message received");
            jSONObject2.put("data", jSONObject);
            CallbackHandler callbackHandler = (CallbackHandler) this.aYY.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.aZa, jSONObject2.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onMessage(ByteBuffer byteBuffer) {
            p.i(byteBuffer, "message");
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
            CallbackHandler callbackHandler = (CallbackHandler) this.aYY.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.aZa, jSONObject2.toString());
            }
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onClose(JSONObject jSONObject) {
            com.baidu.swan.apps.ae.b FD;
            k Rh;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", jSONObject != null ? jSONObject.optInt("code") : 0);
            jSONObject2.put(TiebaInitialize.LogFields.REASON, (jSONObject == null || (r0 = jSONObject.optString(TiebaInitialize.LogFields.REASON, "")) == null) ? "" : "");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "websocket closed");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.aYY.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.aZb, jSONObject3.toString());
            }
            String string = jSONObject != null ? jSONObject.getString("taskID") : null;
            if (string == null || (FD = l.this.FD()) == null || (Rh = FD.Rh()) == null) {
                return;
            }
            Rh.gt(string);
        }

        @Override // com.baidu.searchbox.websocket.IWebSocketListener
        public void onError(Throwable th, JSONObject jSONObject) {
            com.baidu.swan.apps.ae.b FD;
            k Rh;
            p.i(th, "t");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("errMsg", th.getMessage());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("status", "0");
            jSONObject3.put("message", "error happen");
            jSONObject3.put("data", jSONObject2);
            CallbackHandler callbackHandler = (CallbackHandler) this.aYY.get();
            if (callbackHandler != null) {
                callbackHandler.handleSchemeDispatchCallback(this.aZc, jSONObject3.toString());
            }
            String string = jSONObject != null ? jSONObject.getString("taskID") : null;
            if (string == null || (FD = l.this.FD()) == null || (Rh = FD.Rh()) == null) {
                return;
            }
            Rh.gt(string);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(o oVar) {
            this();
        }
    }
}
