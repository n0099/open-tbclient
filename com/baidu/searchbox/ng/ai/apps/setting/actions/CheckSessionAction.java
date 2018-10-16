package com.baidu.searchbox.ng.ai.apps.setting.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthUtils;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.TaskResult;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.request.OAuthRequest;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CheckSessionAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/checkSession";
    private static final int ERROR_CODE_NO_LOGIN = 10004;
    private static final String ERROR_MSG_NO_LOGIN = "user not login";

    public CheckSessionAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiApp");
            return false;
        }
        final String appKey = aiApp.getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else if (!aiApp.getAccount().isLogin(context)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, ERROR_MSG_NO_LOGIN);
            return false;
        } else {
            new OAuthRequest<JSONObject>("ma/user/checksessionkey") { // from class: com.baidu.searchbox.ng.ai.apps.setting.actions.CheckSessionAction.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
                public boolean onFinalPrepare() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(AiAppsApsUtils.APP_KEY, appKey);
                        jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
                        jSONObject.put("host_key_hash", OAuthUtils.getKeyHash());
                        String hostApiKey = AiAppsRuntime.getAiAppAccountRuntime().getHostApiKey();
                        if (!TextUtils.isEmpty(hostApiKey)) {
                            jSONObject.put("host_api_key", hostApiKey);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    addQuery("data", jSONObject.toString());
                    return super.onFinalPrepare();
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }.regCallback(new TypedCallback<TaskResult<JSONObject>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.actions.CheckSessionAction.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                public void onCallback(TaskResult<JSONObject> taskResult) {
                    JSONObject wrapCallbackParams;
                    if (taskResult.isOk() && taskResult.mData != null) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(taskResult.mData, taskResult.getErrorCode());
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(taskResult.getErrorCode());
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, wrapCallbackParams.toString());
                }
            }).call();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
