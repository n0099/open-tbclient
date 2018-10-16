package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apiservice.ActionResult;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class AiAppAction extends BoxAction<UnitedSchemeAiAppDispatcher> {
    protected static final boolean DEBUG = false;
    public static final String MODUEL_SEPARATOR = "/";
    public static final String MODULE_BASE_PATH = "/swan/";
    public static final String PARAMS_DATA = "data";
    public static final String PARAMS_JSON_CALLBACK = "cb";
    public static final String PARAMS_KEY = "params";
    protected static final String TAG = "AiAppAction";

    public abstract boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp);

    public AiAppAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher, String str) {
        super(unitedSchemeAiAppDispatcher, str);
    }

    public AiApp getAiApp() {
        return AiApp.get();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.BoxAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        return TextUtils.equals(this.name, str) ? handle(context, unitedSchemeEntity, callbackHandler, getAiApp()) : handleSubAction(context, unitedSchemeEntity, callbackHandler, str, getAiApp());
    }

    public boolean handleSubAction(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, AiApp aiApp) {
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(101, "not support such action ：" + this.name + str);
        return false;
    }

    public static JSONObject wrapCallbackParams(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            try {
                jSONObject2.put("data", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject2;
    }

    @Nullable
    public static JSONObject getParamAsJo(UnitedSchemeEntity unitedSchemeEntity, String str) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        String param = unitedSchemeEntity.getParam(str);
        if (TextUtils.isEmpty(param)) {
            return null;
        }
        try {
            return new JSONObject(param);
        } catch (JSONException e) {
            return null;
        }
    }

    public boolean processActionResult(String str, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, ActionResult actionResult) {
        if (!actionResult.isSuccess) {
            if (!TextUtils.isEmpty(str)) {
                AiAppsLog.e(str, actionResult.msg);
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(actionResult.msgCode, actionResult.msg);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    public boolean processSecondCallBack(String str, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, ActionResult actionResult, String str2) {
        if (!actionResult.isSuccess) {
            if (!TextUtils.isEmpty(str)) {
                AiAppsLog.e(str, actionResult.msg);
            }
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(actionResult.msgCode, actionResult.msg).toString());
            return false;
        }
        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        return true;
    }
}
