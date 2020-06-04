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
/* loaded from: classes11.dex */
public class e extends aa {
    private static final String cde = e.class.getSimpleName();

    public e(j jVar) {
        super(jVar, "/swanAPI/debug/setDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e(cde, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final JSONObject optJSONObject = b.optJSONObject("config");
        if (optJSONObject == null) {
            com.baidu.swan.apps.console.c.e(cde, "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (com.baidu.swan.apps.runtime.d.aoB().Qz() == 0) {
            eVar.aoR().b(context, "mapp_cts_debug", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                        return;
                    }
                    if (optJSONObject.has("emitLive")) {
                        com.baidu.swan.apps.af.a.a.ey(com.baidu.swan.apps.extcore.c.a.fj(optJSONObject.optInt("emitLive")));
                    }
                    if (optJSONObject.has("emitHttps")) {
                        com.baidu.swan.apps.af.a.a.ez(com.baidu.swan.apps.extcore.c.a.fj(optJSONObject.optInt("emitHttps")));
                    }
                    if (optJSONObject.has("emitDomain")) {
                        com.baidu.swan.apps.af.a.a.ew(!com.baidu.swan.apps.extcore.c.a.fj(optJSONObject.optInt("emitDomain")));
                        com.baidu.swan.apps.af.a.a.ev(com.baidu.swan.apps.extcore.c.a.fj(optJSONObject.optInt("emitDomain")) ? false : true);
                    }
                    if (optJSONObject.has("emitWss")) {
                        com.baidu.swan.apps.af.a.a.eD(com.baidu.swan.apps.extcore.c.a.fj(optJSONObject.optInt("emitWss")));
                    }
                    if (optJSONObject.has("emitLaunchMode")) {
                        com.baidu.swan.apps.af.a.a.eC(com.baidu.swan.apps.extcore.c.a.fj(optJSONObject.optInt("emitLaunchMode")));
                    }
                    if (optJSONObject.has("debugEnvData")) {
                        com.baidu.swan.apps.af.a.a.mQ(optJSONObject.optString("debugEnvData"));
                    }
                    if (optJSONObject.has("emitReplaceJsNative")) {
                        com.baidu.swan.apps.af.a.a.eF(com.baidu.swan.apps.extcore.c.a.fj(optJSONObject.optInt("emitReplaceJsNative")));
                    }
                    if (optJSONObject.has("emitReplaceV8Core")) {
                        d.b.jP(d.b.fc(optJSONObject.optInt("emitReplaceV8Core")));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    com.baidu.swan.apps.af.a.a.Yc();
                }
            });
        } else if (com.baidu.swan.apps.runtime.d.aoB().Qz() == 1) {
            if (!DEBUG) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!b.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e(cde, "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject.has("emitHttps")) {
                    com.baidu.swan.apps.af.a.a.ez(com.baidu.swan.apps.extcore.c.a.fj(optJSONObject.optInt("emitHttps")));
                }
                if (optJSONObject.has("emitWss")) {
                    com.baidu.swan.apps.af.a.a.eD(com.baidu.swan.apps.extcore.c.a.fj(optJSONObject.optInt("emitWss")));
                }
                if (optJSONObject.has("debugEnvData")) {
                    com.baidu.swan.apps.af.a.a.mQ(optJSONObject.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.af.a.a.Yc();
            }
        } else {
            com.baidu.swan.apps.console.c.e(cde, "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return true;
    }
}
