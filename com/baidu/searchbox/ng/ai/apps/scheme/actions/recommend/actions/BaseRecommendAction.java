package com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.delegation.ProcessUrlDelegation;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.model.AiAppsLocationInfo;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.model.RecommendRequestParam;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.utils.AiAppsRecommendUtils;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
import rx.d;
import rx.functions.b;
/* loaded from: classes2.dex */
public abstract class BaseRecommendAction extends AiAppAction {
    private static final boolean DEBUG = false;
    private static final String MEDIA_TYPE = "application/json";
    private static final String MODULE_TAG = "recommend";
    private static final String PARAM_DATA_KEY = "data";
    private static final long REQ_LOCATION_TIMEOUT_MILLISECONDS = 60;
    private static final String RESPONSE_PRODUCTS_KEY = "products";
    private static final String RESPONSE_SEARCH_ID_KEY = "search_id";
    private static final String TAG = "BaseRecommendAction";

    @NonNull
    protected abstract String getUrl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseRecommendAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher, String str) {
        super(unitedSchemeAiAppDispatcher, str);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (aiApp == null) {
            AiAppsLog.e(MODULE_TAG, "aiApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "aiApp is null");
            return false;
        }
        JSONObject paramAsJo = getParamAsJo(unitedSchemeEntity, "params");
        if (paramAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal params");
            return false;
        }
        String optString = paramAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            AiAppsLog.e(MODULE_TAG, "cb is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        JSONObject optJSONObject = paramAsJo.optJSONObject("data");
        if (optJSONObject == null || optJSONObject.length() <= 0) {
            AiAppsLog.e(MODULE_TAG, "param data is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "param data is empty");
            return false;
        }
        AiAppsLog.i(MODULE_TAG, "start perform request");
        performRequest(context, callbackHandler, optString, optJSONObject);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    private void performRequest(@NonNull final Context context, @NonNull final CallbackHandler callbackHandler, @NonNull final String str, @NonNull JSONObject jSONObject) {
        AiAppsLog.i(MODULE_TAG, "get request params");
        final RecommendRequestParam recommendRequestParam = new RecommendRequestParam(context, jSONObject);
        d<AiAppsLocationInfo> locationInfo = AiAppsRuntime.getLocationRuntime().getLocationInfo(context);
        if (locationInfo != null) {
            locationInfo.timeout((long) REQ_LOCATION_TIMEOUT_MILLISECONDS, TimeUnit.MILLISECONDS).subscribe(new b<AiAppsLocationInfo>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions.BaseRecommendAction.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(AiAppsLocationInfo aiAppsLocationInfo) {
                    AiAppsRecommendUtils.fillRequestParamLocationInfo(recommendRequestParam, aiAppsLocationInfo);
                    BaseRecommendAction.this.realPerformRequest(context, callbackHandler, str, recommendRequestParam);
                }
            }, new b<Throwable>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions.BaseRecommendAction.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(Throwable th) {
                    AiAppsLog.w(BaseRecommendAction.MODULE_TAG, "get param(l) info fail: " + th.getMessage());
                    BaseRecommendAction.this.realPerformRequest(context, callbackHandler, str, recommendRequestParam);
                }
            });
            return;
        }
        AiAppsLog.w(MODULE_TAG, "get param(l) is null");
        realPerformRequest(context, callbackHandler, str, recommendRequestParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realPerformRequest(@NonNull Context context, @NonNull CallbackHandler callbackHandler, @NonNull String str, @NonNull RecommendRequestParam recommendRequestParam) {
        AiAppsLog.i(MODULE_TAG, "start real perform request");
        String url = getUrl();
        Bundle bundle = new Bundle();
        bundle.putString(ProcessUrlDelegation.PARAM_URL_KEY, url);
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, ProcessUrlDelegation.class, bundle);
        if (callOnMainWithContentProvider.isOk() && !TextUtils.isEmpty(callOnMainWithContentProvider.mResult.getString(ProcessUrlDelegation.RESULT_URL_KEY))) {
            url = callOnMainWithContentProvider.mResult.getString(ProcessUrlDelegation.RESULT_URL_KEY, url);
        } else {
            AiAppsLog.w(MODULE_TAG, "process url fail");
        }
        TypedCallback<JSONObject> buildRequestCallback = buildRequestCallback(callbackHandler, str);
        ResponseCallback<JSONObject> buildResponseCallback = buildResponseCallback(buildRequestCallback);
        MediaType parse = MediaType.parse(MEDIA_TYPE);
        AiAppsLog.i(MODULE_TAG, "encrypt request param");
        String encrypt = AiAppsRecommendUtils.encrypt(recommendRequestParam.toJsonString(), AiAppsRecommendUtils.AES_KEY, AiAppsRecommendUtils.AES_IV);
        if (TextUtils.isEmpty(encrypt)) {
            AiAppsLog.e(MODULE_TAG, "encrypt request param fail");
            buildRequestCallback.onCallback(null);
            return;
        }
        AiAppsLog.i(MODULE_TAG, "execute request");
        ((PostBodyRequest.PostBodyRequestBuilder) HttpManager.getDefault(context.getApplicationContext()).postRequest().url(url)).requestBody(RequestBody.create(parse, encrypt)).build().executeAsync(buildResponseCallback);
    }

    @NonNull
    private TypedCallback<JSONObject> buildRequestCallback(@NonNull final CallbackHandler callbackHandler, @NonNull final String str) {
        return new TypedCallback<JSONObject>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions.BaseRecommendAction.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(JSONObject jSONObject) {
                if (jSONObject == null) {
                    AiAppsLog.e(BaseRecommendAction.MODULE_TAG, "response is null");
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "response is null").toString());
                    return;
                }
                AiAppsLog.i(BaseRecommendAction.MODULE_TAG, "recommend action execute success");
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        };
    }

    @NonNull
    private ResponseCallback<JSONObject> buildResponseCallback(@NonNull final TypedCallback<JSONObject> typedCallback) {
        return new ResponseCallback<JSONObject>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.recommend.actions.BaseRecommendAction.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public JSONObject parseResponse(Response response, int i) throws Exception {
                AiAppsLog.i(BaseRecommendAction.MODULE_TAG, "parse response");
                if (response == null || response.body() == null) {
                    return null;
                }
                String string = response.body().string();
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return new JSONObject(string);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onSuccess(JSONObject jSONObject, int i) {
                typedCallback.onCallback(jSONObject);
            }

            @Override // com.baidu.searchbox.http.callback.ResponseCallback
            public void onFail(Exception exc) {
                AiAppsLog.e(BaseRecommendAction.MODULE_TAG, "http response with exception:", exc);
                typedCallback.onCallback(null);
            }
        };
    }
}
