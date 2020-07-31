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
/* loaded from: classes7.dex */
public class e extends aa {
    private static final String cjR = e.class.getSimpleName();

    public e(j jVar) {
        super(jVar, "/swanAPI/debug/setDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e(cjR, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final JSONObject optJSONObject = b.optJSONObject("config");
        if (optJSONObject == null) {
            com.baidu.swan.apps.console.c.e(cjR, "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (com.baidu.swan.apps.runtime.d.arr().RU() == 0) {
            eVar.arH().b(context, "mapp_cts_debug", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                        return;
                    }
                    if (optJSONObject.has("emitLive")) {
                        com.baidu.swan.apps.ae.a.a.eM(com.baidu.swan.apps.extcore.c.a.fD(optJSONObject.optInt("emitLive")));
                    }
                    if (optJSONObject.has("emitHttps")) {
                        com.baidu.swan.apps.ae.a.a.eN(com.baidu.swan.apps.extcore.c.a.fD(optJSONObject.optInt("emitHttps")));
                    }
                    if (optJSONObject.has("emitDomain")) {
                        com.baidu.swan.apps.ae.a.a.eK(!com.baidu.swan.apps.extcore.c.a.fD(optJSONObject.optInt("emitDomain")));
                        com.baidu.swan.apps.ae.a.a.eJ(com.baidu.swan.apps.extcore.c.a.fD(optJSONObject.optInt("emitDomain")) ? false : true);
                    }
                    if (optJSONObject.has("emitWss")) {
                        com.baidu.swan.apps.ae.a.a.eR(com.baidu.swan.apps.extcore.c.a.fD(optJSONObject.optInt("emitWss")));
                    }
                    if (optJSONObject.has("emitLaunchMode")) {
                        com.baidu.swan.apps.ae.a.a.eQ(com.baidu.swan.apps.extcore.c.a.fD(optJSONObject.optInt("emitLaunchMode")));
                    }
                    if (optJSONObject.has("debugEnvData")) {
                        com.baidu.swan.apps.ae.a.a.nF(optJSONObject.optString("debugEnvData"));
                    }
                    if (optJSONObject.has("emitReplaceJsNative")) {
                        com.baidu.swan.apps.ae.a.a.eT(com.baidu.swan.apps.extcore.c.a.fD(optJSONObject.optInt("emitReplaceJsNative")));
                    }
                    if (optJSONObject.has("emitReplaceV8Core")) {
                        d.b.kr(d.b.fs(optJSONObject.optInt("emitReplaceV8Core")));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    com.baidu.swan.apps.ae.a.a.aam();
                }
            });
        } else if (com.baidu.swan.apps.runtime.d.arr().RU() == 1) {
            if (!DEBUG) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!b.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e(cjR, "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject.has("emitHttps")) {
                    com.baidu.swan.apps.ae.a.a.eN(com.baidu.swan.apps.extcore.c.a.fD(optJSONObject.optInt("emitHttps")));
                }
                if (optJSONObject.has("emitWss")) {
                    com.baidu.swan.apps.ae.a.a.eR(com.baidu.swan.apps.extcore.c.a.fD(optJSONObject.optInt("emitWss")));
                }
                if (optJSONObject.has("debugEnvData")) {
                    com.baidu.swan.apps.ae.a.a.nF(optJSONObject.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.ae.a.a.aam();
            }
        } else {
            com.baidu.swan.apps.console.c.e(cjR, "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return true;
    }
}
