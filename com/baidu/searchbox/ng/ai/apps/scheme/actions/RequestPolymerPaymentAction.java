package com.baidu.searchbox.ng.ai.apps.scheme.actions;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.setting.oauth.ScopeInfo;
import com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class RequestPolymerPaymentAction extends AiAppAction {
    private static final String ACTION_TYPE = "/swan/requestWalletPolymerPayment";
    private static final String MODULE_TAG = "polymerPayment";
    private static final String ORDER_INFO = "orderInfo";
    public static final String PACKAGE_NAME = "com.baidu.wallet";
    private static final String PARAM_ADD_CALLBACK = "cb";
    private static final String PARAM_PARAMS = "params";
    private static final String PAY_ORDER_INFO = "order_info";
    private static final String PAY_REQ_DATA = "req_data";
    private static final String PAY_RESULT_CANCEL_MSG = "支付取消";
    private static final String PAY_RESULT_FAILED_MSG = "支付失败";
    private static final String PAY_RESULT_SUCCESS_MSG = "支付成功";
    public static final int PAY_STATUS_CANCEL = 2;
    public static final int PAY_STATUS_SUCCESS = 0;
    private static final String REQ_DATA = "reqData";
    private static final String RESULT_CODE = "status_code";
    private static final String RESULT_DATA = "params";
    private HashMap<String, String> mParamsHashMap;

    /* loaded from: classes2.dex */
    public interface OnWalletPayBack {
        void OnPayResult(int i, String str);
    }

    public RequestPolymerPaymentAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, ACTION_TYPE);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, AiApp aiApp) {
        if (!(context instanceof Activity)) {
            AiAppsLog.e(MODULE_TAG, "the context is not an activity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        }
        this.mParamsHashMap = unitedSchemeEntity.getParams();
        AiApp aiApp2 = AiApp.get();
        if (aiApp2 == null) {
            AiAppsLog.e(MODULE_TAG, "AiApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty aiapp");
            return false;
        }
        final JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e(MODULE_TAG, "paramsJson is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        aiApp2.getSetting().checkOrAuthorize((Activity) context, ScopeInfo.SCOPE_ID_MAPP_I_POLYMEPAYMENT, new TypedCallback<Boolean>() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.RequestPolymerPaymentAction.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.ng.ai.apps.util.typedbox.TypedCallback
            public void onCallback(Boolean bool) {
                if (!bool.booleanValue()) {
                    RequestPolymerPaymentAction.this.sendSecondCallback(callbackHandler, 1001, "Permission denied");
                } else {
                    DelegateUtils.callOnMainWithActivity(AiAppsController.getInstance().getActivity(), PluginDelegateActivity.class, RequestPolymerPaymentDelegation.class, RequestPolymerPaymentDelegation.createExecParams(optParamsAsJo), new DelegateListener() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.actions.RequestPolymerPaymentAction.1.1
                        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
                        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                            RequestPolymerPaymentAction.this.sendSecondCallback(callbackHandler, delegateResult.mResult.getInt("status_code"), delegateResult.mResult.getString("params"));
                        }
                    });
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendSecondCallback(CallbackHandler callbackHandler, int i, String str) {
        String str2 = this.mParamsHashMap.get("params");
        if (!TextUtils.isEmpty(str2)) {
            try {
                String optString = new JSONObject(str2).optString("cb");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject = new JSONObject(str);
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParamsWithBase64(jSONObject, i, getSecondCallbackMsg(i)).toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getSecondCallbackMsg(int i) {
        switch (i) {
            case 0:
                return PAY_RESULT_SUCCESS_MSG;
            case 1:
            default:
                return PAY_RESULT_FAILED_MSG;
            case 2:
                return PAY_RESULT_CANCEL_MSG;
        }
    }

    /* loaded from: classes2.dex */
    public static class RequestPolymerPaymentDelegation extends PluginBaseDelegation implements OnWalletPayBack {
        private static final String BUNDLE_PARAMS_KEY = "params";
        public static final String RESULT_CODE = "status_code";
        public static final String RESULT_DATA = "params";

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.PluginBaseDelegation
        public String getPluginPackageName() {
            return RequestPolymerPaymentAction.PACKAGE_NAME;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
        protected boolean onExec() {
            if (!this.mParams.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(this.mParams.getString("params"));
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        JSONObject optJSONObject = jSONObject.optJSONObject(RequestPolymerPaymentAction.ORDER_INFO);
                        JSONObject optJSONObject2 = jSONObject.optJSONObject(RequestPolymerPaymentAction.REQ_DATA);
                        jSONObject2.put(RequestPolymerPaymentAction.PAY_ORDER_INFO, optJSONObject);
                        jSONObject2.put(RequestPolymerPaymentAction.PAY_REQ_DATA, optJSONObject2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    AiAppsRuntime.getPaymentRuntime().doPolymerPayBySwan(getAgent(), jSONObject2, this);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }

        static Bundle createExecParams(JSONObject jSONObject) {
            Bundle bundle = new Bundle();
            bundle.putString("params", jSONObject.toString());
            return bundle;
        }

        @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.RequestPolymerPaymentAction.OnWalletPayBack
        public void OnPayResult(int i, String str) {
            this.mResult.putInt("status_code", i);
            this.mResult.putString("params", str);
            finish();
        }
    }
}
