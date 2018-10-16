package com.baidu.searchbox.ng.ai.apps.setting.actions;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthErrorCode;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthException;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.TaskResult;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.request.Authorize;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AuthorizeAction extends AiAppAction implements OAuthErrorCode {
    private static final String ACTION_TYPE = "/swan/authorize";

    public AuthorizeAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "aiApp is null");
            return false;
        } else if (TextUtils.isEmpty(aiApp.getAppKey())) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
                return false;
            }
            final String optString2 = optParamsAsJo.optString("scope");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
                return false;
            }
            aiApp.getSetting().authorize((Activity) context, optString2, new TypedCallback<TaskResult<Authorize.Result>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.actions.AuthorizeAction.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(TaskResult<Authorize.Result> taskResult) {
                    AuthorizeAction.this.handleAuthorized(callbackHandler, optString2, optString, taskResult);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAuthorized(CallbackHandler callbackHandler, String str, String str2, TaskResult<Authorize.Result> taskResult) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope", str);
            if (taskResult == null || taskResult.mData == null) {
                jSONObject.put("errMsg", "empty auth result");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 11001).toString());
            } else if (!taskResult.isOk()) {
                OAuthException error = taskResult.getError();
                jSONObject.put("errMsg", error == null ? "" : error.getMessage());
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(taskResult.getErrorCode()).toString());
            } else {
                jSONObject.put("code", taskResult.mData.code);
                jSONObject.put("errMsg", taskResult.mData.permit ? "authorize:ok" : "authorize:fail auth deny");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, taskResult.mData.permit ? 0 : 10003).toString());
            }
        } catch (JSONException e) {
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "json exception").toString());
        }
    }
}
