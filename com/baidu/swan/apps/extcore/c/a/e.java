package com.baidu.swan.apps.extcore.c.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class e extends aa {
    public e(j jVar) {
        super(jVar, "/swanAPI/debug/setDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e("setDebugConfig", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final JSONObject optJSONObject = b.optJSONObject("config");
        if (optJSONObject == null) {
            com.baidu.swan.apps.console.c.e("setDebugConfig", "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (com.baidu.swan.apps.runtime.d.azE().XP() == 0) {
            eVar.azU().b(context, "mapp_cts_debug", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void I(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                        return;
                    }
                    if (optJSONObject.has("emitLive")) {
                        com.baidu.swan.apps.ad.a.a.ff(com.baidu.swan.apps.extcore.c.a.hA(optJSONObject.optInt("emitLive")));
                    }
                    if (optJSONObject.has("emitHttps")) {
                        com.baidu.swan.apps.ad.a.a.fg(com.baidu.swan.apps.extcore.c.a.hA(optJSONObject.optInt("emitHttps")));
                    }
                    if (optJSONObject.has("emitDomain")) {
                        com.baidu.swan.apps.ad.a.a.fd(!com.baidu.swan.apps.extcore.c.a.hA(optJSONObject.optInt("emitDomain")));
                        com.baidu.swan.apps.ad.a.a.fc(com.baidu.swan.apps.extcore.c.a.hA(optJSONObject.optInt("emitDomain")) ? false : true);
                    }
                    if (optJSONObject.has("emitWss")) {
                        com.baidu.swan.apps.ad.a.a.fk(com.baidu.swan.apps.extcore.c.a.hA(optJSONObject.optInt("emitWss")));
                    }
                    if (optJSONObject.has("emitLaunchMode")) {
                        com.baidu.swan.apps.ad.a.a.fj(com.baidu.swan.apps.extcore.c.a.hA(optJSONObject.optInt("emitLaunchMode")));
                    }
                    if (optJSONObject.has("debugEnvData")) {
                        com.baidu.swan.apps.ad.a.a.pD(optJSONObject.optString("debugEnvData"));
                    }
                    if (optJSONObject.has("emitReplaceJsNative")) {
                        com.baidu.swan.apps.ad.a.a.fm(com.baidu.swan.apps.extcore.c.a.hA(optJSONObject.optInt("emitReplaceJsNative")));
                    }
                    if (optJSONObject.has("emitReplaceV8Core")) {
                        d.C0396d.lU(d.C0396d.hp(optJSONObject.optInt("emitReplaceV8Core")));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    com.baidu.swan.apps.ad.a.a.agw();
                }
            });
        } else if (com.baidu.swan.apps.runtime.d.azE().XP() == 1) {
            if (!DEBUG) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!b.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject.has("emitHttps")) {
                    com.baidu.swan.apps.ad.a.a.fg(com.baidu.swan.apps.extcore.c.a.hA(optJSONObject.optInt("emitHttps")));
                }
                if (optJSONObject.has("emitWss")) {
                    com.baidu.swan.apps.ad.a.a.fk(com.baidu.swan.apps.extcore.c.a.hA(optJSONObject.optInt("emitWss")));
                }
                if (optJSONObject.has("debugEnvData")) {
                    com.baidu.swan.apps.ad.a.a.pD(optJSONObject.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.ad.a.a.agw();
            }
        } else {
            com.baidu.swan.apps.console.c.e("setDebugConfig", "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return true;
    }
}
