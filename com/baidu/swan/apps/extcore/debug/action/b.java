package com.baidu.swan.apps.extcore.debug.action;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends z {
    private static final String aPY = b.class.getSimpleName();

    public b(j jVar) {
        super(jVar, "/swan/debug/getDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!DEBUG) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.baidu.swan.apps.ae.b.AC() == 0) {
                com.baidu.swan.apps.console.c.d(aPY, "swan getDebugConfig");
                jSONObject.put("loadCts", w(context.getResources().getString(a.h.aiapps_debug_load_cts), com.baidu.swan.apps.extcore.debug.a.bz(com.baidu.swan.apps.ac.a.a.Oc())));
                jSONObject.put("emitLive", w(context.getResources().getString(a.h.aiapps_debug_emit_live), com.baidu.swan.apps.extcore.debug.a.bz(com.baidu.swan.apps.ac.a.a.NZ())));
                jSONObject.put("emitHttps", w(context.getResources().getString(a.h.aiapps_debug_emit_https), com.baidu.swan.apps.extcore.debug.a.bz(com.baidu.swan.apps.ac.a.a.Oa())));
                jSONObject.put("useExtension", w(context.getResources().getString(a.h.aiapps_debug_use_extension), com.baidu.swan.apps.extcore.debug.a.bz(com.baidu.swan.apps.ac.a.a.NY())));
                jSONObject.put("emitDomain", w(context.getResources().getString(a.h.aiapps_debug_emit_domain), com.baidu.swan.apps.extcore.debug.a.bz((com.baidu.swan.apps.ac.a.a.NV() || com.baidu.swan.apps.ac.a.a.NU()) ? false : true)));
            } else if (com.baidu.swan.apps.ae.b.AC() == 1) {
                com.baidu.swan.apps.console.c.d(aPY, "swangame getDebugConfig");
                JSONObject c = c(unitedSchemeEntity, "params");
                if (c == null) {
                    com.baidu.swan.apps.console.c.e(aPY, "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!c.optString("category").equals("swanGame")) {
                    com.baidu.swan.apps.console.c.e(aPY, "params is not swangame");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    jSONObject.put("emitHttps", com.baidu.swan.apps.extcore.debug.a.bz(com.baidu.swan.apps.ac.a.a.Oa()));
                    jSONObject.put("emitWss", com.baidu.swan.apps.extcore.debug.a.bz(com.baidu.swan.apps.ac.a.a.Ob()));
                    jSONObject.put("debugEnvData", com.baidu.swan.apps.ac.a.a.Od());
                }
            } else {
                com.baidu.swan.apps.console.c.e(aPY, "frame type error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "frame type error");
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
            return false;
        }
    }

    private JSONObject w(String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("value", i);
        return jSONObject;
    }
}
