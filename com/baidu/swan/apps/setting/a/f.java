package com.baidu.swan.apps.setting.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends aa {
    public f(j jVar) {
        super(jVar, "/swanAPI/getUserInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            com.baidu.swan.games.v.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            com.baidu.swan.games.v.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            com.baidu.swan.games.v.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
            return false;
        } else if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            com.baidu.swan.games.v.c.g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
            return false;
        } else {
            final String nD = com.baidu.swan.apps.ad.g.b.nD(optParamsAsJo.optString("__plugin__", null));
            com.baidu.swan.apps.a.b arI = eVar.arI();
            final boolean bu = com.baidu.swan.apps.setting.oauth.c.bu(optParamsAsJo);
            if (arI.isLogin(context) || !bu) {
                a(bu, callbackHandler, optString, (Activity) context, nD, "snsapi_userinfo");
            } else {
                arI.a((Activity) context, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.setting.a.f.1
                    @Override // com.baidu.swan.apps.a.a
                    public void onResult(int i) {
                        switch (i) {
                            case 0:
                                f.this.a(bu, callbackHandler, optString, (Activity) context, nD, "snsapi_userinfo");
                                return;
                            default:
                                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                                return;
                        }
                    }
                });
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final CallbackHandler callbackHandler, final String str, Activity activity, String str2, String str3) {
        com.baidu.swan.apps.setting.b.a.a(activity, str3, str2, z, new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.setting.a.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(com.baidu.swan.apps.setting.b.a aVar) {
                com.baidu.swan.apps.console.c.c("OpenData", "onOpenDataCallback:: ", aVar);
                if (!aVar.atS()) {
                    com.baidu.swan.apps.setting.oauth.c.a(aVar, callbackHandler, str);
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(aVar.cMD, 0).toString());
                }
            }
        });
    }
}
