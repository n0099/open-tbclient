package com.baidu.swan.apps.scheme;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeAbsDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.UnitedSchemeStatisticUtil;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class h extends UnitedSchemeBaseDispatcher {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = h.class.getSimpleName();

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public String getDispatcherName() {
        return "BDWallet";
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public boolean invoke(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (DEBUG) {
            Log.i(TAG, String.format(Locale.getDefault(), "entity(%s)", unitedSchemeEntity.getUri()));
        }
        com.baidu.swan.apps.console.c.d(TAG, "start UnitedSchemeWalletDispatcher");
        String path = unitedSchemeEntity.getPath(false);
        if (TextUtils.isEmpty(path)) {
            if (!unitedSchemeEntity.isOnlyVerify()) {
                UnitedSchemeStatisticUtil.doUBCForInvalidScheme(unitedSchemeEntity.getUri(), "no action");
            }
            if (DEBUG) {
                Log.w(TAG, "Uri action is null");
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
            String optString = optParamsAsJo.optString("orderInfo");
            String optString2 = optParamsAsJo.optString("version");
            String optString3 = optParamsAsJo.optString("cb");
            com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
            if (apM == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (apM.apG() == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                com.baidu.swan.apps.ac.b bVar = new com.baidu.swan.apps.ac.b(apM, unitedSchemeEntity, callbackHandler, optString2, apM.getAppKey(), optString3);
                if ("requestPayment".equals(path)) {
                    com.baidu.swan.apps.console.c.d(TAG, "start PAYMENT");
                    return bVar.bB("mapp_request_duxiaoman", optString);
                } else if ("requestAliPayment".equals(path)) {
                    com.baidu.swan.apps.console.c.d(TAG, "start ALI PAYMENT");
                    return bVar.bB("mapp_request_alipayment", optString);
                } else if ("requestPolymerPayment".equals(path)) {
                    com.baidu.swan.apps.console.c.d(TAG, "start POLYMER PAYMENT");
                    return bVar.f(optString, optParamsAsJo);
                } else if (TextUtils.equals("requestWeChatPayment", path)) {
                    com.baidu.swan.apps.console.c.d(TAG, "start WECHAT HTML5 PAYMENT");
                    return bVar.bB("mapp_request_wechatpayment", optString);
                } else {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
            }
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher
    public Class<? extends UnitedSchemeAbsDispatcher> getSubDispatcher(String str) {
        return null;
    }
}
