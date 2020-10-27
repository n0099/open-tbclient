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
/* loaded from: classes10.dex */
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
        if (com.baidu.swan.apps.runtime.d.aEQ().ade() == 0) {
            eVar.aFg().b(context, "mapp_cts_debug", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (!com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                        return;
                    }
                    if (optJSONObject.has("emitLive")) {
                        com.baidu.swan.apps.ad.a.a.fN(com.baidu.swan.apps.extcore.c.a.ir(optJSONObject.optInt("emitLive")));
                    }
                    if (optJSONObject.has("emitHttps")) {
                        com.baidu.swan.apps.ad.a.a.fO(com.baidu.swan.apps.extcore.c.a.ir(optJSONObject.optInt("emitHttps")));
                    }
                    if (optJSONObject.has("emitDomain")) {
                        com.baidu.swan.apps.ad.a.a.fL(!com.baidu.swan.apps.extcore.c.a.ir(optJSONObject.optInt("emitDomain")));
                        com.baidu.swan.apps.ad.a.a.fK(com.baidu.swan.apps.extcore.c.a.ir(optJSONObject.optInt("emitDomain")) ? false : true);
                    }
                    if (optJSONObject.has("emitWss")) {
                        com.baidu.swan.apps.ad.a.a.fS(com.baidu.swan.apps.extcore.c.a.ir(optJSONObject.optInt("emitWss")));
                    }
                    if (optJSONObject.has("emitLaunchMode")) {
                        com.baidu.swan.apps.ad.a.a.fR(com.baidu.swan.apps.extcore.c.a.ir(optJSONObject.optInt("emitLaunchMode")));
                    }
                    if (optJSONObject.has("debugEnvData")) {
                        com.baidu.swan.apps.ad.a.a.rc(optJSONObject.optString("debugEnvData"));
                    }
                    if (optJSONObject.has("emitReplaceJsNative")) {
                        com.baidu.swan.apps.ad.a.a.fU(com.baidu.swan.apps.extcore.c.a.ir(optJSONObject.optInt("emitReplaceJsNative")));
                    }
                    if (optJSONObject.has("emitReplaceV8Core")) {
                        d.C0422d.nt(d.C0422d.ig(optJSONObject.optInt("emitReplaceV8Core")));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    com.baidu.swan.apps.ad.a.a.alL();
                }
            });
        } else if (com.baidu.swan.apps.runtime.d.aEQ().ade() == 1) {
            if (!DEBUG) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!b.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (optJSONObject.has("emitHttps")) {
                    com.baidu.swan.apps.ad.a.a.fO(com.baidu.swan.apps.extcore.c.a.ir(optJSONObject.optInt("emitHttps")));
                }
                if (optJSONObject.has("emitWss")) {
                    com.baidu.swan.apps.ad.a.a.fS(com.baidu.swan.apps.extcore.c.a.ir(optJSONObject.optInt("emitWss")));
                }
                if (optJSONObject.has("debugEnvData")) {
                    com.baidu.swan.apps.ad.a.a.rc(optJSONObject.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                com.baidu.swan.apps.ad.a.a.alL();
            }
        } else {
            com.baidu.swan.apps.console.c.e("setDebugConfig", "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return true;
    }
}
