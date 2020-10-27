package com.baidu.swan.apps.setting.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/authorize");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            com.baidu.swan.games.v.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
            com.baidu.swan.games.v.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams").toString());
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
            com.baidu.swan.games.v.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb").toString());
            return false;
        }
        final String optString2 = optParamsAsJo.optString("scope");
        if (TextUtils.isEmpty(optString2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
            com.baidu.swan.games.v.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope").toString());
            return false;
        }
        eVar.aFg().b(context, optString2, false, new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.setting.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                a.this.a(callbackHandler, optString2, optString, hVar);
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, String str, String str2, com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope", str);
            if (hVar == null || hVar.mData == null) {
                int errorCode = hVar == null ? 10001 : hVar.getErrorCode();
                com.baidu.swan.apps.setting.oauth.c.c("empty auth result", true);
                jSONObject.put("errMsg", com.baidu.swan.apps.setting.oauth.c.ht(errorCode));
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, errorCode).toString());
                com.baidu.swan.games.v.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, errorCode).toString());
            } else if (!hVar.isOk()) {
                OAuthException aHd = hVar.aHd();
                jSONObject.put("errMsg", aHd == null ? "" : aHd.getMessage());
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(hVar.getErrorCode()).toString());
                com.baidu.swan.games.v.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.getErrorCode()).toString());
            } else {
                jSONObject.put("code", hVar.mData.code);
                jSONObject.put("errMsg", hVar.mData.drU ? "authorize:ok" : "user deny");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.mData.drU ? 0 : 10003).toString());
                if (!hVar.mData.drU) {
                    com.baidu.swan.games.v.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.getErrorCode()).toString());
                }
            }
        } catch (JSONException e) {
            com.baidu.swan.apps.setting.oauth.c.c("json exception", true);
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "internal error").toString());
            com.baidu.swan.games.v.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 10001, "internal error").toString());
        }
    }
}
