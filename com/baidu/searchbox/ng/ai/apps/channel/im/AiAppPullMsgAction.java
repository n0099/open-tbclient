package com.baidu.searchbox.ng.ai.apps.channel.im;

import android.content.Context;
import android.text.TextUtils;
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
public class AiAppPullMsgAction extends AiAppAction {
    private static final String ACTION = "action";
    public static final String ACTION_TYPE = "/swan/im/pullMsg";
    private static final String MODULE_TAG = "AiAppIm";

    public AiAppPullMsgAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject paramsJSONObject = getParamsJSONObject(unitedSchemeEntity.getParam("params"));
        if (paramsJSONObject == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e(MODULE_TAG, "params is null");
            return false;
        } else if (TextUtils.isEmpty(paramsJSONObject.optString("action"))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            AiAppsLog.e(MODULE_TAG, "can't find concrete sub action, it's null");
            return false;
        } else {
            JSONObject optJSONObject = paramsJSONObject.optJSONObject("data");
            String optString = paramsJSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                AiAppsLog.e(MODULE_TAG, "sendBroadcastAction callback name is empty");
                return false;
            }
            AiAppImClientManager.getIns().fetchImMsgList(optString, optJSONObject, callbackHandler, aiApp);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public JSONObject getParamsJSONObject(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            AiAppsLog.i(MODULE_TAG, "getParamsJSONObject exception = " + e.getMessage());
            jSONObject = null;
        }
        return jSONObject;
    }
}
