package com.baidu.swan.apps.extcore.d.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends ab {
    private static final String bqB = e.class.getSimpleName();

    public e(j jVar) {
        super(jVar, "/swanAPI/debug/setDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e(bqB, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final JSONObject optJSONObject = b.optJSONObject("config");
        if (optJSONObject == null) {
            com.baidu.swan.apps.console.c.e(bqB, "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (com.baidu.swan.apps.runtime.d.aam().Ed() == 0) {
            eVar.aaz().b(context, "mapp_cts_debug", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.d.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void B(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                        return;
                    }
                    if (optJSONObject.has("emitLive")) {
                        com.baidu.swan.apps.ah.a.a.dd(com.baidu.swan.apps.extcore.d.a.eB(optJSONObject.optInt("emitLive")));
                    }
                    if (optJSONObject.has("emitHttps")) {
                        com.baidu.swan.apps.ah.a.a.de(com.baidu.swan.apps.extcore.d.a.eB(optJSONObject.optInt("emitHttps")));
                    }
                    if (optJSONObject.has("emitDomain")) {
                        com.baidu.swan.apps.ah.a.a.db(!com.baidu.swan.apps.extcore.d.a.eB(optJSONObject.optInt("emitDomain")));
                        com.baidu.swan.apps.ah.a.a.da(com.baidu.swan.apps.extcore.d.a.eB(optJSONObject.optInt("emitDomain")) ? false : true);
                    }
                    if (optJSONObject.has("emitWss")) {
                        com.baidu.swan.apps.ah.a.a.di(com.baidu.swan.apps.extcore.d.a.eB(optJSONObject.optInt("emitWss")));
                    }
                    if (optJSONObject.has("emitLaunchMode")) {
                        com.baidu.swan.apps.ah.a.a.dh(com.baidu.swan.apps.extcore.d.a.eB(optJSONObject.optInt("emitLaunchMode")));
                    }
                    if (optJSONObject.has("debugEnvData")) {
                        com.baidu.swan.apps.ah.a.a.jY(optJSONObject.optString("debugEnvData"));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    com.baidu.swan.apps.ah.a.a.Lp();
                }
            });
        } else if (com.baidu.swan.apps.runtime.d.aam().Ed() == 1) {
            if (!DEBUG) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!b.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e(bqB, "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject.has("emitHttps")) {
                    com.baidu.swan.apps.ah.a.a.de(com.baidu.swan.apps.extcore.d.a.eB(optJSONObject.optInt("emitHttps")));
                }
                if (optJSONObject.has("emitWss")) {
                    com.baidu.swan.apps.ah.a.a.di(com.baidu.swan.apps.extcore.d.a.eB(optJSONObject.optInt("emitWss")));
                }
                if (optJSONObject.has("debugEnvData")) {
                    com.baidu.swan.apps.ah.a.a.jY(optJSONObject.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.ah.a.a.Lp();
            }
        } else {
            com.baidu.swan.apps.console.c.e(bqB, "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return true;
    }
}
