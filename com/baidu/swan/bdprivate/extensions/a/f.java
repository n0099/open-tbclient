package com.baidu.swan.bdprivate.extensions.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.a;
import com.baidu.swan.support.v4.app.FragmentActivity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends aa {
    public f(j jVar) {
        super(jVar, "/swanAPI/getPhoneNumberByLogin");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty params");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        com.baidu.swan.apps.a.b azV = com.baidu.swan.apps.runtime.d.azE().azA().azV();
        if (azV == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty account");
            return false;
        }
        if (azV.isLogin(context)) {
            a(true, null, callbackHandler, optString, 20050001, "user already login");
        } else {
            eVar.azU().e("login_with_mobile", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.e>() { // from class: com.baidu.swan.bdprivate.extensions.a.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: c */
                public void I(com.baidu.swan.apps.setting.oauth.e eVar2) {
                    if (eVar2 == null || eVar2.forbidden) {
                        f.this.a(false, null, callbackHandler, optString, 10005, "system deny");
                        com.baidu.swan.apps.statistic.h.b(10005, eVar2);
                        return;
                    }
                    f.this.a(eVar2, callbackHandler, optString);
                }
            });
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.baidu.swan.apps.setting.oauth.e eVar, final CallbackHandler callbackHandler, final String str) {
        new com.baidu.swan.bdprivate.extensions.loginauthmobile.a().c(new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.bdprivate.extensions.a.f.2
            @Override // com.baidu.swan.apps.a.a
            public void onResult(int i) {
                if (f.DEBUG) {
                    Log.d("LoginAndGetMobileAction", "onResult: loginStatusCode = " + i);
                }
                switch (i) {
                    case -2:
                        f.this.a(false, null, callbackHandler, str, 20050002, "user did cancel login");
                        return;
                    case -1:
                    default:
                        f.this.a(false, null, callbackHandler, str, 20050003, "user fail to login");
                        return;
                    case 0:
                        f.this.a(eVar.cVg, com.baidu.swan.apps.v.f.arY().arI(), callbackHandler, str);
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, FragmentActivity fragmentActivity, final CallbackHandler callbackHandler, final String str) {
        if (z) {
            com.baidu.swan.apps.runtime.d.azE().azG().Yq().aah().a(fragmentActivity, z, "login_with_mobile", null).A(new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<a.C0445a>>() { // from class: com.baidu.swan.bdprivate.extensions.a.f.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void I(com.baidu.swan.apps.setting.oauth.h<a.C0445a> hVar) {
                    if (hVar == null || !hVar.isOk() || hVar.mData == null || hVar.mData.cVR == null) {
                        f.this.a(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", hVar.mData.cVR.optString("data"));
                        jSONObject.put("iv", hVar.mData.cVR.optString("iv"));
                        f.this.a(true, jSONObject, callbackHandler, str, 0, "success");
                    } catch (JSONException e) {
                    }
                }
            }).aBy();
        } else {
            a(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, JSONObject jSONObject, CallbackHandler callbackHandler, String str, int i, String str2) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("loginState", z);
            if (jSONObject != null) {
                jSONObject2.put("mobile", jSONObject);
            }
            jSONObject3 = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, i, str2);
        } catch (JSONException e) {
        }
        callbackHandler.handleSchemeDispatchCallback(str, jSONObject3.toString());
    }
}
