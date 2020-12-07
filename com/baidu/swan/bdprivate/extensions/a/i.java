package com.baidu.swan.bdprivate.extensions.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.api.module.a.b;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class i extends aa {
    private final int dNH;
    private final String dNI;

    public i(j jVar) {
        super(jVar, "/swanAPI/thirdPartyLogin");
        this.dNH = 10008;
        this.dNI = "app not installed";
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
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
        }
        final String optString2 = optParamsAsJo.optString("type", "");
        int vw = vw(optString2);
        final b.a aVar = new b.a(optParamsAsJo);
        final Bundle bundle = new Bundle();
        bundle.putInt("key_login_mode", vw);
        eVar.aKg().b(context, "mapp_i_login", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.bdprivate.extensions.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    if (i.this.al(context, optString2)) {
                        i.this.a(eVar, (Activity) context, aVar, callbackHandler, optString, bundle);
                        return;
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                        return;
                    }
                }
                com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.runtime.e eVar, Activity activity, final b.a aVar, final CallbackHandler callbackHandler, final String str, Bundle bundle) {
        eVar.aKg().a(activity, aVar, bundle, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<f.c>>() { // from class: com.baidu.swan.bdprivate.extensions.a.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<f.c> hVar) {
                if (!hVar.isOk()) {
                    com.baidu.swan.apps.console.c.w("ThirdPartyLoginAction", hVar.getErrorCode() + " " + aVar.toString());
                    String hX = com.baidu.swan.apps.setting.oauth.c.hX(hVar.getErrorCode());
                    if (!TextUtils.isEmpty(hX)) {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(hVar.getErrorCode(), hX).toString());
                    } else {
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(hVar.getErrorCode()).toString());
                    }
                } else if (TextUtils.isEmpty(hVar.mData.code)) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("code", hVar.mData.code);
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.getErrorCode()).toString());
                    } catch (JSONException e) {
                        if (i.DEBUG) {
                            e.printStackTrace();
                        }
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                    }
                }
            }
        });
    }

    private int vw(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -791575966:
                if (str.equals(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                    c = 2;
                    break;
                }
                break;
            case -265713450:
                if (str.equals("username")) {
                    c = 0;
                    break;
                }
                break;
            case 3616:
                if (str.equals("qq")) {
                    c = 3;
                    break;
                }
                break;
            case 114009:
                if (str.equals(LoginConstants.SMS_LOGIN)) {
                    c = 1;
                    break;
                }
                break;
            case 113011944:
                if (str.equals(LogConfig.LIVE_SHARE_HK_WEIBO)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean al(Context context, String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -791575966:
                if (str.equals(LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND)) {
                    c = 0;
                    break;
                }
                break;
            case -265713450:
                if (str.equals("username")) {
                    c = 4;
                    break;
                }
                break;
            case 3616:
                if (str.equals("qq")) {
                    c = 1;
                    break;
                }
                break;
            case 114009:
                if (str.equals(LoginConstants.SMS_LOGIN)) {
                    c = 3;
                    break;
                }
                break;
            case 113011944:
                if (str.equals(LogConfig.LIVE_SHARE_HK_WEIBO)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return ak.isAppInstalled(context, "com.tencent.mm");
            case 1:
                return ak.isAppInstalled(context, "com.tencent.mobileqq");
            case 2:
                return ak.isAppInstalled(context, "com.sina.weibo");
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }
}
