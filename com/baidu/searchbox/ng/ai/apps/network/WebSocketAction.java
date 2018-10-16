package com.baidu.searchbox.ng.ai.apps.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.websocket.IWebSocketListener;
import com.baidu.searchbox.websocket.WebSocketManager;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.searchbox.websocket.WebSocketTask;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class WebSocketAction extends AiAppAction {
    public static final String ACTION_CLOSE = "/swan/webSocket/close";
    public static final String ACTION_CONNECT = "/swan/webSocket/connect";
    public static final String ACTION_SEND = "/swan/webSocket/send";
    private static final String ACTION_TYPE = "/swan/webSocket";
    public static final Companion Companion = new Companion(null);
    public static final String DATA_TYPE_ARRAY_BUFFER = "arrayBuffer";
    public static final String DATA_TYPE_STRING = "string";
    private static final int DEFAULT_CODE_VALUE = 1000;
    public static final String MODULE_NAME = "/swan/webSocket";
    private static final String MODULE_PATH = "/swan/webSocket/";
    private static final String MODULE_TAG = "websocket";
    public static final String PARAM_KEY_CB = "cb";
    public static final String PARAM_KEY_CODE = "code";
    public static final String PARAM_KEY_DATA = "data";
    public static final String PARAM_KEY_DATA_TYPE = "dataType";
    public static final String PARAM_KEY_ERRMSG = "errMsg";
    private static final String PARAM_KEY_ERRNO = "errno";
    private static final String PARAM_KEY_HEADER = "header";
    private static final String PARAM_KEY_MESSAGE = "message";
    public static final String PARAM_KEY_ONCLOSE = "onClose";
    public static final String PARAM_KEY_ONERROR = "onError";
    public static final String PARAM_KEY_ONMESSAGE = "onMessage";
    public static final String PARAM_KEY_ONOPEN = "onOpen";
    public static final String PARAM_KEY_REASON = "reason";
    public static final String PARAM_KEY_STATUS = "status";
    public static final String PARAM_KEY_TASK = "task";
    public static final String PARAM_KEY_TASKID = "taskID";
    private static final String PARAM_KEY_URL = "url";

    public WebSocketAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, "/swan/webSocket");
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [72=6] */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        boolean handleSend;
        p.i(unitedSchemeEntity, "entity");
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal aiApp");
            return false;
        } else if (TextUtils.isEmpty(aiApp.id)) {
            AiAppsLog.e(MODULE_TAG, "aiapp id is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none aiApp id");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                AiAppsLog.e(MODULE_TAG, "no params found");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "no params found");
                return false;
            }
            if (str != null) {
                switch (str.hashCode()) {
                    case -1138508621:
                        if (str.equals(ACTION_CONNECT)) {
                            handleSend = handleConnect(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, aiApp);
                            break;
                        }
                        break;
                    case -346732449:
                        if (str.equals(ACTION_SEND)) {
                            handleSend = handleSend(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, aiApp);
                            break;
                        }
                        break;
                    case 2121629697:
                        if (str.equals(ACTION_CLOSE)) {
                            handleSend = handleClose(context, optParamsAsJo, unitedSchemeEntity, callbackHandler, aiApp);
                            break;
                        }
                        break;
                }
                return handleSend;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            handleSend = false;
            return handleSend;
        }
    }

    private final boolean handleClose(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (!jSONObject.has(PARAM_KEY_TASKID)) {
            AiAppsLog.e(MODULE_TAG, "taskID lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID lose");
            return false;
        }
        String string = jSONObject.getString(PARAM_KEY_TASKID);
        int optInt = jSONObject.optInt("code", 1000);
        String optString = jSONObject.optString(PARAM_KEY_REASON, "close normally");
        try {
            try {
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                p.h((Object) string, "taskId");
                p.h((Object) optString, PARAM_KEY_REASON);
                webSocketManager.close(string, optInt, optString);
                aiApp.getWebSocket().detachTask(string);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            } catch (Exception e) {
                AiAppsLog.e(MODULE_TAG, e.getMessage());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
                AiAppWebSocket webSocket = aiApp.getWebSocket();
                p.h((Object) string, "taskId");
                webSocket.detachTask(string);
                return false;
            }
        } catch (Throwable th) {
            AiAppWebSocket webSocket2 = aiApp.getWebSocket();
            p.h((Object) string, "taskId");
            webSocket2.detachTask(string);
            throw th;
        }
    }

    private final boolean handleSend(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (!jSONObject.has(PARAM_KEY_TASKID) || !jSONObject.has("data")) {
            AiAppsLog.e(MODULE_TAG, "taskID or data lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "taskID or data lose");
            return false;
        }
        String string = jSONObject.getString(PARAM_KEY_TASKID);
        String string2 = jSONObject.getString("data");
        try {
            if (jSONObject.optString(PARAM_KEY_DATA_TYPE, "string").equals(DATA_TYPE_ARRAY_BUFFER)) {
                ByteBuffer wrap = ByteBuffer.wrap(Base64.decode(string2, 2));
                WebSocketManager webSocketManager = WebSocketManager.INSTANCE;
                p.h((Object) string, "taskId");
                p.h((Object) wrap, "buffer");
                webSocketManager.send(string, wrap);
            } else {
                WebSocketManager webSocketManager2 = WebSocketManager.INSTANCE;
                p.h((Object) string, "taskId");
                p.h((Object) string2, "data");
                webSocketManager2.send(string, string2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        } catch (Exception e) {
            AiAppsLog.e(MODULE_TAG, e.getMessage());
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
            return false;
        }
    }

    private final boolean handleConnect(Context context, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (!jSONObject.has("url") || !jSONObject.has("cb")) {
            AiAppsLog.e(MODULE_TAG, "url or cb lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "url or cb lose");
            return false;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("cb");
        if (!jSONObject2.has(PARAM_KEY_ONOPEN) || !jSONObject2.has(PARAM_KEY_ONMESSAGE) || !jSONObject2.has("onClose") || !jSONObject2.has("onError")) {
            AiAppsLog.e(MODULE_TAG, "websocket callback lose");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "websocket callback lose");
            return false;
        }
        JSONObject jSONObject3 = new JSONObject();
        if (!aiApp.getWebSocket().allowConnectNewSocket()) {
            jSONObject3.put(PARAM_KEY_ERRNO, "1");
        } else {
            WebSocketRequest fromJSON = WebSocketRequest.Companion.fromJSON(jSONObject);
            p.h((Object) jSONObject2, "cb");
            try {
                WebSocketTask connect = WebSocketManager.INSTANCE.connect(fromJSON, createWebSocketListener(jSONObject2, callbackHandler));
                jSONObject3.put(PARAM_KEY_ERRNO, "0");
                jSONObject3.put(PARAM_KEY_TASK, connect.toJSON());
                aiApp.getWebSocket().attachTask(connect);
            } catch (Exception e) {
                AiAppsLog.e(MODULE_TAG, e.getMessage());
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage());
                return false;
            }
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject3, 0));
        return true;
    }

    private final IWebSocketListener createWebSocketListener(JSONObject jSONObject, CallbackHandler callbackHandler) {
        final String string = jSONObject.getString(PARAM_KEY_ONOPEN);
        final String string2 = jSONObject.getString(PARAM_KEY_ONMESSAGE);
        final String string3 = jSONObject.getString("onClose");
        final String string4 = jSONObject.getString("onError");
        final WeakReference weakReference = new WeakReference(callbackHandler);
        return new IWebSocketListener() { // from class: com.baidu.searchbox.ng.ai.apps.network.WebSocketAction$createWebSocketListener$1
            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onOpen(Map<String, String> map) {
                p.i(map, "headers");
                JSONObject jSONObject2 = new JSONObject(map);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("header", jSONObject2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("status", "0");
                jSONObject4.put("message", "websocket open success");
                jSONObject4.put("data", jSONObject3);
                CallbackHandler callbackHandler2 = (CallbackHandler) weakReference.get();
                if (callbackHandler2 != null) {
                    callbackHandler2.handleSchemeDispatchCallback(string, jSONObject4.toString());
                }
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onMessage(String str) {
                p.i(str, "message");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", str);
                jSONObject2.put(WebSocketAction.PARAM_KEY_DATA_TYPE, "string");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", "0");
                jSONObject3.put("message", "message received");
                jSONObject3.put("data", jSONObject2);
                CallbackHandler callbackHandler2 = (CallbackHandler) weakReference.get();
                if (callbackHandler2 != null) {
                    callbackHandler2.handleSchemeDispatchCallback(string2, jSONObject3.toString());
                }
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onMessage(ByteBuffer byteBuffer) {
                p.i(byteBuffer, "message");
                byte[] bArr = new byte[byteBuffer.remaining()];
                byteBuffer.get(bArr);
                String encodeToString = Base64.encodeToString(bArr, 2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("data", encodeToString);
                jSONObject2.put(WebSocketAction.PARAM_KEY_DATA_TYPE, WebSocketAction.DATA_TYPE_ARRAY_BUFFER);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("status", "0");
                jSONObject3.put("message", "message received");
                jSONObject3.put("data", jSONObject2);
                CallbackHandler callbackHandler2 = (CallbackHandler) weakReference.get();
                if (callbackHandler2 != null) {
                    callbackHandler2.handleSchemeDispatchCallback(string2, jSONObject3.toString());
                }
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onClose(JSONObject jSONObject2) {
                AiApp aiApp;
                AiAppWebSocket webSocket;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("code", jSONObject2 != null ? jSONObject2.optInt("code") : 0);
                jSONObject3.put(WebSocketAction.PARAM_KEY_REASON, (jSONObject2 == null || (r0 = jSONObject2.optString(WebSocketAction.PARAM_KEY_REASON, "")) == null) ? "" : "");
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("status", "0");
                jSONObject4.put("message", "websocket closed");
                jSONObject4.put("data", jSONObject3);
                CallbackHandler callbackHandler2 = (CallbackHandler) weakReference.get();
                if (callbackHandler2 != null) {
                    callbackHandler2.handleSchemeDispatchCallback(string3, jSONObject4.toString());
                }
                String string5 = jSONObject2 != null ? jSONObject2.getString(WebSocketAction.PARAM_KEY_TASKID) : null;
                if (string5 == null || (aiApp = WebSocketAction.this.getAiApp()) == null || (webSocket = aiApp.getWebSocket()) == null) {
                    return;
                }
                webSocket.detachTask(string5);
            }

            @Override // com.baidu.searchbox.websocket.IWebSocketListener
            public void onError(Throwable th, JSONObject jSONObject2) {
                AiApp aiApp;
                AiAppWebSocket webSocket;
                p.i(th, "t");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("errMsg", th.getMessage());
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("status", "0");
                jSONObject4.put("message", "error happen");
                jSONObject4.put("data", jSONObject3);
                CallbackHandler callbackHandler2 = (CallbackHandler) weakReference.get();
                if (callbackHandler2 != null) {
                    callbackHandler2.handleSchemeDispatchCallback(string4, jSONObject4.toString());
                }
                String string5 = jSONObject2 != null ? jSONObject2.getString(WebSocketAction.PARAM_KEY_TASKID) : null;
                if (string5 == null || (aiApp = WebSocketAction.this.getAiApp()) == null || (webSocket = aiApp.getWebSocket()) == null) {
                    return;
                }
                webSocket.detachTask(string5);
            }
        };
    }

    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }
}
