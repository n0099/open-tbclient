package com.baidu.swan.apps.extcore.d.a;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends ab {
    private static final String buM = b.class.getSimpleName();

    public b(j jVar) {
        super(jVar, "/swanAPI/debug/getDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject jSONObject = new JSONObject();
        com.baidu.swan.apps.console.c.d(buM, "swan getDebugConfig");
        if (com.baidu.swan.apps.runtime.d.acC().Gu() == 0) {
            eVar.acP().b(context, "mapp_cts_debug", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.d.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.as.d.b
                /* renamed from: a */
                public void D(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        try {
                            jSONObject.put("loadCts", b.this.j(context.getResources().getString(a.h.aiapps_debug_load_cts), Integer.valueOf(com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aaB()))));
                            jSONObject.put("emitLive", b.this.j(context.getResources().getString(a.h.aiapps_debug_emit_live), Integer.valueOf(com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aav()))));
                            jSONObject.put("emitHttps", b.this.j(context.getResources().getString(a.h.aiapps_debug_emit_https), Integer.valueOf(com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aaw()))));
                            jSONObject.put("useExtension", b.this.j(context.getResources().getString(a.h.aiapps_debug_use_extension), Integer.valueOf(com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aat()))));
                            jSONObject.put("emitDomain", b.this.j(context.getResources().getString(a.h.aiapps_debug_emit_domain), Integer.valueOf(com.baidu.swan.apps.extcore.d.a.cC((com.baidu.swan.apps.ah.a.a.aao() || com.baidu.swan.apps.ah.a.a.aan()) ? false : true))));
                            jSONObject.put("emitWss", b.this.j(context.getResources().getString(a.h.aiapps_debug_emit_wss), Integer.valueOf(com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aaA()))));
                            jSONObject.put("emitLaunchMode", b.this.j(context.getResources().getString(a.h.aiapps_debug_emit_launch_mode), Integer.valueOf(com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aaz()))));
                            jSONObject.put("debugEnvData", b.this.j(context.getResources().getString(a.h.aiapps_debug_game_extra_data), com.baidu.swan.apps.ah.a.a.aaC()));
                            jSONObject.put("emitReplaceSwanCore", b.this.j(context.getResources().getString(a.h.aiapps_debug_emit_replace_swan_core), Integer.valueOf(com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aax()))));
                            jSONObject.put("emitReplaceGameCore", b.this.j(context.getResources().getString(a.h.aiapps_debug_emit_replace_game_core), Integer.valueOf(com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aay()))));
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
        } else if (com.baidu.swan.apps.runtime.d.acC().Gu() == 1) {
            com.baidu.swan.apps.console.c.d(buM, "swangame getDebugConfig");
            if (!DEBUG) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                com.baidu.swan.apps.console.c.e(buM, "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!b.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e(buM, "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    jSONObject.put("emitHttps", com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aaw()));
                    jSONObject.put("emitWss", com.baidu.swan.apps.extcore.d.a.cC(com.baidu.swan.apps.ah.a.a.aaA()));
                    jSONObject.put("debugEnvData", com.baidu.swan.apps.ah.a.a.aaC());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException e) {
                    e.printStackTrace();
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                    return false;
                }
            }
        } else {
            com.baidu.swan.apps.console.c.e(buM, "frame type error");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "frame type error");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject j(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("value", obj);
        return jSONObject;
    }
}
