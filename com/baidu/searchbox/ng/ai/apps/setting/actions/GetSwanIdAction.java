package com.baidu.searchbox.ng.ai.apps.setting.actions;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.network.AiAppNetworkUtils;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.TaskResult;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.request.OAuthRequest;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetSwanIdAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getSwanId";
    private static final int INTERNAL_ERROR = 10001;
    private static final String KEY_DATA = "data";
    private static final String KEY_MA_ID = "ma_id";
    private static final String MODULE_TAG = "getSwanId";
    private static final int NETWORK_ERROR = 10002;
    private static final String URL = "ma/user/swanid";

    public GetSwanIdAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "illegal aiApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiApp");
            return false;
        } else if (TextUtils.isEmpty(aiApp.getAppKey())) {
            AiAppsLog.e(MODULE_TAG, "empty clientId");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                AiAppsLog.e(MODULE_TAG, "empty joParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                AiAppsLog.e(MODULE_TAG, "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            handleGetSwanId(context, unitedSchemeEntity, callbackHandler, aiApp, optString);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    private void handleGetSwanId(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp, final String str) {
        AiAppsLog.i(MODULE_TAG, "getSwanId start");
        if (!AiAppNetworkUtils.isNetworkConnected(context)) {
            AiAppsLog.e(MODULE_TAG, "network_error");
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10002, "network_error").toString(), str);
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_MA_ID, aiApp.id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new OAuthRequest<JSONObject>(URL) { // from class: com.baidu.searchbox.ng.ai.apps.setting.actions.GetSwanIdAction.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
            public boolean onFinalPrepare() {
                addQuery("data", jSONObject.toString());
                return super.onFinalPrepare();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.searchbox.ng.ai.apps.setting.oauth.OAuthTask
            public JSONObject parse(JSONObject jSONObject2) throws JSONException {
                return jSONObject2;
            }
        }.regCallback(new TypedCallback<TaskResult<JSONObject>>() { // from class: com.baidu.searchbox.ng.ai.apps.setting.actions.GetSwanIdAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(TaskResult<JSONObject> taskResult) {
                if (taskResult.isOk() && taskResult.mData != null) {
                    String jSONObject2 = UnitedSchemeUtility.wrapCallbackParams(taskResult.mData, 0).toString();
                    AiAppsLog.i(GetSwanIdAction.MODULE_TAG, "getSwanId success");
                    UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, jSONObject2, str);
                    return;
                }
                AiAppsLog.e(GetSwanIdAction.MODULE_TAG, "getSwanId failed: internal_error");
                UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(10001, "internal_error").toString(), str);
            }
        }).call();
    }
}
