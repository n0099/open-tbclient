package com.baidu.searchbox.ng.ai.apps.scheme;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.pay.AiAppsPaymentManager;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppUnitedSchemeWalletDispatcher extends UnitedSchemeBaseDispatcher {
    private static final String ACTION_REQUEST_ALI_PAYMENT = "requestAliPayment";
    private static final String ACTION_REQUEST_PAYMENT = "requestPayment";
    private static final String ACTION_REQUEST_POLYMER_PAYMENT = "requestPolymerPayment";
    private static final String ACTION_REQUEST_WECHAT_PAYMENT = "requestWeChatPayment";
    private static final boolean DEBUG = false;
    public static final String MODULE_WALLET = "BDWallet";
    private static final String ORDER_INFO = "orderInfo";
    private static final String PARAM_VERSION = "version";
    private static final String TAG = AiAppUnitedSchemeWalletDispatcher.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        AiAppsLog.d(TAG, "start UnitedSchemeWalletDispatcher");
        String path = unitedSchemeEntity.getPath(false);
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
            String optString2 = optParamsAsJo.optString("version");
            AiApp aiApp = AiApp.get();
            if (aiApp == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (aiApp.getActivity() == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (ACTION_REQUEST_PAYMENT.equals(path)) {
                AiAppsLog.d(TAG, "start UnitedSchemeWalletDispatcher ACTION_REQUEST_PAYMENT");
                return AiAppsPaymentManager.getInstance(context, aiApp).baiduPay(optString, unitedSchemeEntity, callbackHandler, optString2);
            } else if (ACTION_REQUEST_ALI_PAYMENT.equals(path)) {
                return AiAppsPaymentManager.getInstance(context, aiApp).aliPay(optString, unitedSchemeEntity, callbackHandler, optString2);
            } else {
                if (ACTION_REQUEST_POLYMER_PAYMENT.equals(path)) {
                    return AiAppsPaymentManager.getInstance(context, aiApp).polymerPay(optParamsAsJo, optString, unitedSchemeEntity, callbackHandler, optString2);
                }
                if (TextUtils.equals(ACTION_REQUEST_WECHAT_PAYMENT, path)) {
                    return AiAppsPaymentManager.getInstance(context, aiApp).weChatH5Pay(unitedSchemeEntity, callbackHandler, optString2);
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }
}
