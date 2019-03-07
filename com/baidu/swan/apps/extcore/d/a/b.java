package com.baidu.swan.apps.extcore.d.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends y {
    private static final String avA = b.class.getSimpleName();

    public b(j jVar) {
        super(jVar, "/swan/debug/getDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!DEBUG) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        com.baidu.swan.apps.console.c.d(avA, "getDebugConfig");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loadCts", A(context.getResources().getString(b.h.aiapps_debug_load_cts), com.baidu.swan.apps.extcore.d.a.ba(com.baidu.swan.apps.ac.a.a.Gi())));
            jSONObject.put("emitLive", A(context.getResources().getString(b.h.aiapps_debug_emit_live), com.baidu.swan.apps.extcore.d.a.ba(com.baidu.swan.apps.ac.a.a.Gg())));
            jSONObject.put("emitHttps", A(context.getResources().getString(b.h.aiapps_debug_emit_https), com.baidu.swan.apps.extcore.d.a.ba(com.baidu.swan.apps.ac.a.a.Gh())));
            jSONObject.put("useExtension", A(context.getResources().getString(b.h.aiapps_debug_use_extension), com.baidu.swan.apps.extcore.d.a.ba(com.baidu.swan.apps.ac.a.a.Gf())));
            jSONObject.put("emitDomain", A(context.getResources().getString(b.h.aiapps_debug_emit_domain), com.baidu.swan.apps.extcore.d.a.ba((com.baidu.swan.apps.ac.a.a.Gc() || com.baidu.swan.apps.ac.a.a.Gb()) ? false : true)));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
            return false;
        }
    }

    private JSONObject A(String str, int i) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put(UBC.CONTENT_KEY_VALUE, i);
        return jSONObject;
    }
}
