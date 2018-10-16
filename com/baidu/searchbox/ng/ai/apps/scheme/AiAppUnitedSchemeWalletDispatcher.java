package com.baidu.searchbox.ng.ai.apps.scheme;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PayCallback;
import com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppUnitedSchemeWalletDispatcher extends UnitedSchemeBaseDispatcher {
    private static final String ACTION_REQUEST_ALI_PAYMENT = "requestAliPayment";
    private static final String ACTION_REQUEST_PAYMENT = "requestPayment";
    private static final String ACTION_REQUEST_POLYMER_PAYMENT = "requestPolymerPayment";
    private static final String BANNED_CHANNELS = "bannedChannels";
    private static final boolean DEBUG = false;
    private static final int DEF_CODE = 0;
    public static final String MODULE_WALLET = "BDWallet";
    private static final String ORDER_INFO = "orderInfo";
    private static final String PARAM_ADD_CALLBACK = "cb";
    private static final String PARAM_FROM = "from";
    private static final String PARAM_PARAMS = "params";
    private static final String PAY_RESULT_CANCEL_MSG = "支付取消";
    private static final String PAY_RESULT_FAILED_MSG = "支付失败";
    private static final String PAY_RESULT_SUCCESS_MSG = "支付成功";
    private static final String TAG = AiAppUnitedSchemeWalletDispatcher.class.getSimpleName();
    private HashMap<String, String> mParamsHashMap;

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.d(TAG, "start UnitedSchemeWalletDispatcher");
        String path = unitedSchemeEntity.getPath(false);
        this.mParamsHashMap = unitedSchemeEntity.getParams();
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(201));
            return false;
        } else if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString = optParamsAsJo.optString(ORDER_INFO);
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (ACTION_REQUEST_PAYMENT.equalsIgnoreCase(path)) {
                AiAppsRuntime.getPaymentRuntime().doPay(context, optString, new PayCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeWalletDispatcher.1
                    @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.PayCallback
                    public void onPayResult(int i, String str) {
                        AiAppsLog.d(AiAppUnitedSchemeWalletDispatcher.MODULE_WALLET, "do pay params: " + str);
                    }
                });
            } else if (ACTION_REQUEST_ALI_PAYMENT.equals(path)) {
                AiAppsRuntime.getPaymentRuntime().doAliPay(context, optString, new AliPayCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeWalletDispatcher.2
                    @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback
                    public void onPayResult(int i, JSONObject jSONObject) {
                        AiAppsLog.d(AiAppUnitedSchemeWalletDispatcher.MODULE_WALLET, "do ali pay result: " + jSONObject);
                    }
                });
            } else if (ACTION_REQUEST_POLYMER_PAYMENT.equals(path)) {
                AiAppsLog.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_POLYMER_PAYMENT");
                JSONArray optJSONArray = optParamsAsJo.optJSONArray(BANNED_CHANNELS);
                String[] strArr = null;
                if (optJSONArray != null) {
                    strArr = new String[optJSONArray.length()];
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        strArr[i] = String.valueOf(optJSONArray.opt(i));
                    }
                }
                AiApp aiApp = AiApp.get();
                if (aiApp == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                Activity activity = aiApp.getActivity();
                if (activity == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                AiAppsRuntime.getPaymentRuntime().doPolymerPay(context, activity, optString, strArr, new PolymerPayCallback() { // from class: com.baidu.searchbox.ng.ai.apps.scheme.AiAppUnitedSchemeWalletDispatcher.3
                    @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.PolymerPayCallback
                    public void onPolymerPayResult(int i2, String str) {
                        AiAppsLog.d(AiAppUnitedSchemeWalletDispatcher.MODULE_WALLET, "do  polymer pay params: " + str);
                    }
                });
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
    }

    private void sendSecondCallback(CallbackHandler callbackHandler, int i, String str) {
        String str2;
        AiAppsLog.d(TAG, "sendSecondCallback, arg0: " + i + ", arg1: " + str);
        String str3 = this.mParamsHashMap.get("params");
        if (!TextUtils.isEmpty(str3)) {
            try {
                str2 = new JSONObject(str3).optString("cb");
            } catch (JSONException e) {
                e = e;
                str2 = null;
            }
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject = new JSONObject(str);
                    }
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(jSONObject, i, getSecondCallbackMsg(i)).toString());
                }
            } catch (JSONException e2) {
                e = e2;
                e.printStackTrace();
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParamsWithBase64(null, i, getSecondCallbackMsg(i)).toString());
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

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }
}
