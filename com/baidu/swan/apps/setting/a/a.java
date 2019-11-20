package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/authorize");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            com.baidu.swan.games.r.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null").toString());
            return false;
        } else if (TextUtils.isEmpty(bVar.getAppKey())) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId");
            com.baidu.swan.games.r.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
                com.baidu.swan.games.r.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams").toString());
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
                com.baidu.swan.games.r.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb").toString());
                return false;
            }
            final String optString2 = optParamsAsJo.optString("scope");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
                com.baidu.swan.games.r.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope").toString());
                return false;
            }
            bVar.Rf().b((Activity) context, optString2, new com.baidu.swan.apps.an.d.a<com.baidu.swan.apps.setting.oauth.g<b.d>>() { // from class: com.baidu.swan.apps.setting.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.d.a
                /* renamed from: a */
                public void B(com.baidu.swan.apps.setting.oauth.g<b.d> gVar) {
                    a.this.a(callbackHandler, optString2, optString, gVar);
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CallbackHandler callbackHandler, String str, String str2, com.baidu.swan.apps.setting.oauth.g<b.d> gVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scope", str);
            if (gVar == null || gVar.mData == null) {
                jSONObject.put("errMsg", "empty auth result");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 11001).toString());
                com.baidu.swan.apps.setting.oauth.c.aH("AuthorizeAction", "null == result || null == result.mData");
                com.baidu.swan.games.r.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 11001).toString());
            } else if (!gVar.isOk()) {
                OAuthException St = gVar.St();
                jSONObject.put("errMsg", St == null ? "" : St.getMessage());
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(gVar.getErrorCode()).toString());
                com.baidu.swan.games.r.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, gVar.getErrorCode()).toString());
            } else {
                jSONObject.put("code", gVar.mData.code);
                jSONObject.put("errMsg", gVar.mData.bog ? "authorize:ok" : "authorize:fail auth deny");
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, gVar.mData.bog ? 0 : 10003).toString());
                if (!gVar.mData.bog) {
                    com.baidu.swan.games.r.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, gVar.getErrorCode()).toString());
                }
            }
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
            callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "json exception").toString());
            com.baidu.swan.games.r.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 10001, "json exception").toString());
        }
    }
}
