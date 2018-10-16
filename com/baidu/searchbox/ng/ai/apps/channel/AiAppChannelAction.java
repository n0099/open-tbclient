package com.baidu.searchbox.ng.ai.apps.channel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.channel.im.AiAppImClientManager;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppChannelAction extends AiAppAction {
    public static final String ACTION = "action";
    public static final String ACTION_REGISTER = "/swan/dataChannel/registerReceiver";
    public static final String ACTION_SEND_BROADCAST = "/swan/dataChannel/sendBroadcast";
    public static final String ACTION_UNREGISTER = "/swan/dataChannel/unregisterReceiver";
    public static final String MODULE_NAME = "/swan/dataChannel";
    private static final String MODULE_PATH = "/swan/dataChannel/";
    private static final String MODULE_TAG = "AiAppIm";

    /* loaded from: classes2.dex */
    public class ConcreteSubAction {
        public static final String IM_MSG_ACTION = "com.baidu.channel.swan.imsdk";

        public ConcreteSubAction() {
        }
    }

    public AiAppChannelAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        boolean sendBroadcastAction;
        JSONObject paramsJSONObject = getParamsJSONObject(unitedSchemeEntity.getParam("params"));
        if (paramsJSONObject == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e(MODULE_TAG, "params is null");
            return false;
        }
        String optString = paramsJSONObject.optString("action");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e(MODULE_TAG, "can't find concrete sub action, it's null");
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "subAction = " + str + " ; concreteSubAction = " + optString);
        char c = 65535;
        switch (str.hashCode()) {
            case -1011993228:
                if (str.equals(ACTION_SEND_BROADCAST)) {
                    c = 2;
                    break;
                }
                break;
            case -812596272:
                if (str.equals(ACTION_UNREGISTER)) {
                    c = 1;
                    break;
                }
                break;
            case 920298615:
                if (str.equals(ACTION_REGISTER)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                sendBroadcastAction = registerAction(optString, paramsJSONObject, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            case 1:
                sendBroadcastAction = unregisterAction(optString, paramsJSONObject, aiApp);
                break;
            case 2:
                sendBroadcastAction = sendBroadcastAction(optString, paramsJSONObject, unitedSchemeEntity, callbackHandler, aiApp);
                break;
            default:
                sendBroadcastAction = false;
                break;
        }
        AiAppsLog.i(MODULE_TAG, "handle subAction status = " + sendBroadcastAction);
        if (sendBroadcastAction) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return super.handleSubAction(context, unitedSchemeEntity, callbackHandler, str, aiApp);
    }

    private JSONObject getParamsJSONObject(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            AiAppsLog.e(MODULE_TAG, "getParamsJSONObject exception = " + e.getMessage());
            jSONObject = null;
        }
        return jSONObject;
    }

    private boolean registerAction(String str, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e(MODULE_TAG, "registerAction callback name is empty");
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 508314180:
                if (str.equals(ConcreteSubAction.IM_MSG_ACTION)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return AiAppImClientManager.getIns().registerIm(optString, optJSONObject, callbackHandler, aiApp);
            default:
                return false;
        }
    }

    private boolean unregisterAction(String str, JSONObject jSONObject, AiApp aiApp) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        char c = 65535;
        switch (str.hashCode()) {
            case 508314180:
                if (str.equals(ConcreteSubAction.IM_MSG_ACTION)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return AiAppImClientManager.getIns().unregisterIm(optJSONObject, aiApp);
            default:
                return false;
        }
    }

    private boolean sendBroadcastAction(String str, JSONObject jSONObject, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        String optString = jSONObject.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e(MODULE_TAG, "sendBroadcastAction callback name is empty");
            return false;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 508314180:
                if (str.equals(ConcreteSubAction.IM_MSG_ACTION)) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return AiAppImClientManager.getIns().sendImMsg(optString, optJSONObject, callbackHandler, aiApp);
            default:
                return false;
        }
    }
}
