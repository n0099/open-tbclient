package com.baidu.swan.apps.extcore.c.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/debug/getDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject jSONObject = new JSONObject();
        com.baidu.swan.apps.console.c.i("getDebugConfig", "swan getDebugConfig");
        if (com.baidu.swan.apps.runtime.d.aGI().aeW() == 0) {
            eVar.aGY().b(context, "mapp_cts_debug", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ap.e.b
                /* renamed from: a */
                public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        try {
                            jSONObject.put("loadCts", b.this.q(context.getResources().getString(a.h.aiapps_debug_load_cts), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEh()))));
                            jSONObject.put("emitLive", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_live), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEb()))));
                            jSONObject.put("emitHttps", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_https), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEc()))));
                            jSONObject.put("useExtension", b.this.q(context.getResources().getString(a.h.aiapps_debug_use_extension), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aDZ()))));
                            jSONObject.put("emitDomain", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_domain), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh((com.baidu.swan.apps.ad.a.a.aDU() || com.baidu.swan.apps.ad.a.a.aDT()) ? false : true))));
                            jSONObject.put("emitWss", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_wss), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEg()))));
                            jSONObject.put("emitLaunchMode", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_launch_mode), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEf()))));
                            jSONObject.put("debugEnvData", b.this.q(context.getResources().getString(a.h.aiapps_debug_game_extra_data), com.baidu.swan.apps.ad.a.a.aEi()));
                            jSONObject.put("emitReplaceSwanCore", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_replace_swan_core), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEd()))));
                            jSONObject.put("emitReplaceGameCore", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_replace_game_core), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEe()))));
                            jSONObject.put("emitReplaceJsNative", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_replace_js_native), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEl()))));
                            jSONObject.put("emitReplaceV8Core", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_replace_v8_core), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fh(d.C0432d.arR()))));
                            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                            return;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                            return;
                        }
                    }
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, unitedSchemeEntity);
                }
            });
        } else if (com.baidu.swan.apps.runtime.d.aGI().aeW() == 1) {
            com.baidu.swan.apps.console.c.i("getDebugConfig", "swangame getDebugConfig");
            if (!DEBUG) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                com.baidu.swan.apps.console.c.e("getDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!b.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e("getDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    jSONObject.put("emitHttps", com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEc()));
                    jSONObject.put("emitWss", com.baidu.swan.apps.extcore.c.a.fh(com.baidu.swan.apps.ad.a.a.aEg()));
                    jSONObject.put("debugEnvData", com.baidu.swan.apps.ad.a.a.aEi());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException e) {
                    e.printStackTrace();
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                    return false;
                }
            }
        } else {
            com.baidu.swan.apps.console.c.e("getDebugConfig", "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "frame type error");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject q(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("value", obj);
        return jSONObject;
    }
}
