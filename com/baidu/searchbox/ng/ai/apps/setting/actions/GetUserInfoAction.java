package com.baidu.searchbox.ng.ai.apps.setting.actions;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.setting.opendata.OpenData;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetUserInfoAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getUserInfo";
    private static final String LOG_TAG = "GetUserInfoAction";

    public GetUserInfoAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiApp");
            return false;
        } else if (TextUtils.isEmpty(aiApp.getAppKey())) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            } else if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                return false;
            } else {
                OpenData.get((Activity) context, ScopeInfo.SCOPE_ID_USERINFO, new TypedCallback<OpenData>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.actions.GetUserInfoAction.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
                    public void onCallback(OpenData openData) {
                        JSONObject wrapCallbackParams;
                        AiAppsLog.i(OpenData.LOG_TAG, "onOpenDataCallback:: " + openData.toString());
                        if (openData.isUserInfoResultOK()) {
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(openData.mOpenData, 0);
                        } else {
                            wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied;\n err by -> " + openData.mErr.toString(-200));
                        }
                        callbackHandler.handleSchemeDispatchCallback(optString, wrapCallbackParams.toString());
                    }
                });
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }
}
