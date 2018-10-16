package com.baidu.searchbox.ng.ai.apps.form;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.network.AntiReplayToken;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.AiAppsCookieManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetFormIdAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/getFormId";
    private static final boolean DEBUG = false;
    private static final String PARAMS_KEY = "params";
    private static final String PARAMS_RESULT = "result";
    private static final String PARAMS_STATUSCODE = "statusCode";
    private static final String PARAM_APPKEY = "appkey";
    private static final String PARAM_DELTA = "delta";
    private static final String PARAM_RASIGN = "rasign";
    private static final String PARAM_TIMESTAMP = "timestamp";
    private static final String SYMBOL_CONNECTOR = "&";
    private static final String TAG = "GetFormIdAction";
    private static final String VALUE_DELTA = "smartapp_formid";
    private Activity mActivity;
    private String mCallBack;
    private boolean mIsLogin;

    public GetFormIdAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
        this.mIsLogin = false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        long seconds;
        if (aiApp == null) {
            AiAppsLog.e(TAG, "aiApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal aiApp");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
            AiAppsLog.e(TAG, "joParams is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        this.mCallBack = paramAsJo.optString("cb");
        if (TextUtils.isEmpty(this.mCallBack)) {
            AiAppsLog.e(TAG, "mCallBack is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "empty callback");
            return false;
        }
        String appKey = aiApp.getAppKey();
        if (TextUtils.isEmpty(appKey)) {
            AiAppsLog.e(TAG, "appKey is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty appkey");
            return false;
        } else if (!(context instanceof Activity)) {
            AiAppsLog.e(TAG, "context is not instanceof Activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            this.mActivity = (Activity) context;
            this.mIsLogin = aiApp.getAccount().isLogin(this.mActivity);
            if (!this.mIsLogin) {
                AiAppsLog.e(TAG, "user not login");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "user not login");
                return false;
            }
            StringBuilder sb = new StringBuilder(AiAppsRuntime.getConfigRuntime().getAiAppFormIdUrl());
            sb.append("?");
            String str = "timestamp=" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            sb.append(str).append("&");
            sb.append("rasign=" + AntiReplayToken.create().generateFormIdRasign(seconds)).append("&");
            sb.append("delta=smartapp_formid");
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(sb.toString())).cookieManager(new AiAppsCookieManager(false))).addParam("appkey", appKey).build().executeAsyncOnUIBack(new ResponseCallback<JSONObject>() { // from class: com.baidu.searchbox.ng.ai.apps.form.GetFormIdAction.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public JSONObject parseResponse(Response response, int i) throws Exception {
                    if (response == null || response.body() == null) {
                        return null;
                    }
                    return new JSONObject(response.body().string());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onSuccess(JSONObject jSONObject, int i) {
                    AiAppsLog.e(GetFormIdAction.TAG, "response:" + jSONObject.toString());
                    if (jSONObject != null) {
                        callbackHandler.handleSchemeDispatchCallback(GetFormIdAction.this.mCallBack, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                    }
                }

                @Override // com.baidu.searchbox.http.callback.ResponseCallback
                public void onFail(Exception exc) {
                    AiAppsLog.e(GetFormIdAction.TAG, "request formId failed");
                    AiAppsLog.e(GetFormIdAction.TAG, exc.toString());
                    callbackHandler.handleSchemeDispatchCallback(GetFormIdAction.this.mCallBack, UnitedSchemeUtility.wrapCallbackParams(1001, exc.getMessage()).toString());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }
}
