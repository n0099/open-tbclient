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
/* loaded from: classes2.dex */
public class h extends UnitedSchemeBaseDispatcher {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = h.class.getSimpleName();

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
            com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
            if (IV == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (IV.getActivity() == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                com.baidu.swan.apps.aa.a aVar = new com.baidu.swan.apps.aa.a(IV, unitedSchemeEntity, callbackHandler, optString2, IV.getAppKey());
                if ("requestPayment".equals(path)) {
                    com.baidu.swan.apps.console.c.d(TAG, "start PAYMENT");
                    return aVar.fw(optString);
                } else if ("requestAliPayment".equals(path)) {
                    com.baidu.swan.apps.console.c.d(TAG, "start ALI PAYMENT");
                    return aVar.fx(optString);
                } else if ("requestPolymerPayment".equals(path)) {
                    com.baidu.swan.apps.console.c.d(TAG, "start POLYMER PAYMENT");
                    return com.baidu.swan.apps.u.a.Dd().a(context, optString, unitedSchemeEntity, optParamsAsJo, callbackHandler, optString2);
                } else if (TextUtils.equals("requestWeChatPayment", path)) {
                    com.baidu.swan.apps.console.c.d(TAG, "start WECHAT HTML5 PAYMENT");
                    return aVar.Fq();
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
