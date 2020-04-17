package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.a.b;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.swan.apps.setting.oauth.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends ab {
    public g(j jVar) {
        super(jVar, "/swanAPI/login");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, final com.baidu.swan.apps.runtime.e eVar) {
        if (eVar != null && eVar.Ru()) {
            if (DEBUG) {
                Log.d("LoginAction", "LoginAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "ui operation does not supported when app is invisible.");
            return false;
        } else if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
            com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception").toString());
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "params is null").toString());
                com.baidu.swan.apps.api.module.a.b.a(eVar, 1, 201, "params is null");
                return false;
            }
            final String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                com.baidu.swan.apps.api.module.a.b.a(eVar, 1, 201, "empty cb");
                return false;
            } else if (!optParamsAsJo.optBoolean("force", true) && !eVar.akY().isLogin(context)) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                com.baidu.swan.apps.api.module.a.b.a(eVar, 43, 10004, "user not logged in");
                return true;
            } else {
                final b.a aVar = new b.a(optParamsAsJo);
                final Activity activity = (Activity) context;
                String optString2 = optParamsAsJo.optString("__plugin__", null);
                if (!TextUtils.isEmpty(optString2)) {
                    com.baidu.swan.apps.setting.b.a.a(activity, "snsapi_userinfo", com.baidu.swan.apps.ag.g.b.lx(optString2), false, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.setting.a.g.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.as.d.b
                        /* renamed from: a */
                        public void E(com.baidu.swan.apps.setting.b.a aVar2) {
                            if (aVar2 == null) {
                                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                            } else if (aVar2.amM()) {
                                eVar.akX().a(activity, aVar, (Bundle) null, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<e.c>>() { // from class: com.baidu.swan.apps.setting.a.g.1.1
                                    /* JADX DEBUG: Method merged with bridge method */
                                    @Override // com.baidu.swan.apps.as.d.b
                                    /* renamed from: a */
                                    public void E(com.baidu.swan.apps.setting.oauth.h<e.c> hVar) {
                                        g.this.a(hVar, callbackHandler, eVar, optString);
                                    }
                                });
                            } else {
                                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                            }
                        }
                    });
                } else {
                    eVar.akX().a(activity, aVar, (Bundle) null, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<e.c>>() { // from class: com.baidu.swan.apps.setting.a.g.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.as.d.b
                        /* renamed from: a */
                        public void E(com.baidu.swan.apps.setting.oauth.h<e.c> hVar) {
                            g.this.a(hVar, callbackHandler, eVar, optString);
                        }
                    });
                }
                com.baidu.swan.apps.api.module.a.b.a(eVar, (Activity) context, optParamsAsJo, callbackHandler, optString);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.setting.oauth.h<e.c> hVar, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar, String str) {
        if (!hVar.isOk()) {
            int errorCode = hVar.getErrorCode();
            OAuthException amF = hVar.amF();
            String message = amF != null ? amF.getMessage() : "exception is null";
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(errorCode, message).toString());
            com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(errorCode, message).toString());
            a(eVar, 43, errorCode, message);
        } else if (TextUtils.isEmpty(hVar.mData.code)) {
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
            com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
            a(eVar, 43, 1001, "empty code");
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", hVar.mData.code);
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.getErrorCode()).toString());
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                com.baidu.swan.games.u.c.f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                a(eVar, 43, 1001, e.getMessage());
            }
        }
    }

    private void a(com.baidu.swan.apps.runtime.e eVar, int i, int i2, String str) {
        int Om;
        if (eVar != null && (Om = eVar.Om()) == 0) {
            com.baidu.swan.apps.statistic.a.d na = new com.baidu.swan.apps.statistic.a.d().e(new com.baidu.swan.apps.ap.a().bn(5L).bo(i)).a(eVar.Ow()).mZ(com.baidu.swan.apps.statistic.f.gz(Om)).na(com.baidu.swan.apps.runtime.e.akP());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
            na.bk(jSONObject);
            com.baidu.swan.apps.statistic.f.b(na);
        }
    }
}
