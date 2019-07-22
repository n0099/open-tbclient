package com.baidu.swan.apps.extcore.debug.action;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends z {
    private static final String awD = c.class.getSimpleName();

    public c(j jVar) {
        super(jVar, "/swan/debug/setDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!DEBUG) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            com.baidu.swan.apps.console.c.e(awD, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optJSONObject = c.optJSONObject("config");
        if (optJSONObject == null) {
            com.baidu.swan.apps.console.c.e(awD, "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (com.baidu.swan.apps.ae.b.vD() == 0) {
            if (optJSONObject.has("emitLive")) {
                com.baidu.swan.apps.ac.a.a.bI(com.baidu.swan.apps.extcore.debug.a.cu(optJSONObject.optInt("emitLive")));
            }
            if (optJSONObject.has("emitHttps")) {
                com.baidu.swan.apps.ac.a.a.bJ(com.baidu.swan.apps.extcore.debug.a.cu(optJSONObject.optInt("emitHttps")));
            }
            if (optJSONObject.has("emitDomain")) {
                com.baidu.swan.apps.ac.a.a.bG(!com.baidu.swan.apps.extcore.debug.a.cu(optJSONObject.optInt("emitDomain")));
                com.baidu.swan.apps.ac.a.a.bF(!com.baidu.swan.apps.extcore.debug.a.cu(optJSONObject.optInt("emitDomain")));
            }
        } else if (com.baidu.swan.apps.ae.b.vD() == 1) {
            if (!c.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e(awD, "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (optJSONObject.has("emitHttps")) {
                com.baidu.swan.apps.ac.a.a.bJ(com.baidu.swan.apps.extcore.debug.a.cu(optJSONObject.optInt("emitHttps")));
            }
            if (optJSONObject.has("emitWss")) {
                com.baidu.swan.apps.ac.a.a.bK(com.baidu.swan.apps.extcore.debug.a.cu(optJSONObject.optInt("emitWss")));
            }
            if (optJSONObject.has("debugEnvData")) {
                com.baidu.swan.apps.ac.a.a.gg(optJSONObject.optString("debugEnvData"));
            }
        } else {
            com.baidu.swan.apps.console.c.e(awD, "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
