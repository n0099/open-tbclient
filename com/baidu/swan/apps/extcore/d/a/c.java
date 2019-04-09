package com.baidu.swan.apps.extcore.d.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends y {
    private static final String avF = c.class.getSimpleName();

    public c(j jVar) {
        super(jVar, "/swan/debug/setDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!DEBUG) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, "params");
        if (c == null) {
            com.baidu.swan.apps.console.c.e(avF, "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optJSONObject = c.optJSONObject("config");
        if (optJSONObject == null) {
            com.baidu.swan.apps.console.c.e(avF, "config is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        if (optJSONObject.has("emitLive")) {
            com.baidu.swan.apps.ac.a.a.bx(com.baidu.swan.apps.extcore.d.a.ct(optJSONObject.optInt("emitLive")));
        }
        if (optJSONObject.has("emitHttps")) {
            com.baidu.swan.apps.ac.a.a.by(com.baidu.swan.apps.extcore.d.a.ct(optJSONObject.optInt("emitHttps")));
        }
        if (optJSONObject.has("emitDomain")) {
            com.baidu.swan.apps.ac.a.a.bv(!com.baidu.swan.apps.extcore.d.a.ct(optJSONObject.optInt("emitDomain")));
            com.baidu.swan.apps.ac.a.a.bu(!com.baidu.swan.apps.extcore.d.a.ct(optJSONObject.optInt("emitDomain")));
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
