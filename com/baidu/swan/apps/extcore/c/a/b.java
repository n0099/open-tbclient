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
/* loaded from: classes11.dex */
public class b extends aa {
    private static final String chS = b.class.getSimpleName();

    public b(j jVar) {
        super(jVar, "/swanAPI/debug/getDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject jSONObject = new JSONObject();
        com.baidu.swan.apps.console.c.d(chS, "swan getDebugConfig");
        if (com.baidu.swan.apps.runtime.d.apI().RF() == 0) {
            eVar.apY().b(context, "mapp_cts_debug", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.aq.e.b
                /* renamed from: a */
                public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        try {
                            jSONObject.put("loadCts", b.this.q(context.getResources().getString(a.h.aiapps_debug_load_cts), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.anv()))));
                            jSONObject.put("emitLive", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_live), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.anp()))));
                            jSONObject.put("emitHttps", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_https), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.anq()))));
                            jSONObject.put("useExtension", b.this.q(context.getResources().getString(a.h.aiapps_debug_use_extension), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.ann()))));
                            jSONObject.put("emitDomain", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_domain), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT((com.baidu.swan.apps.af.a.a.ani() || com.baidu.swan.apps.af.a.a.anh()) ? false : true))));
                            jSONObject.put("emitWss", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_wss), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.anu()))));
                            jSONObject.put("emitLaunchMode", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_launch_mode), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.ant()))));
                            jSONObject.put("debugEnvData", b.this.q(context.getResources().getString(a.h.aiapps_debug_game_extra_data), com.baidu.swan.apps.af.a.a.anw()));
                            jSONObject.put("emitReplaceSwanCore", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_replace_swan_core), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.anr()))));
                            jSONObject.put("emitReplaceGameCore", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_replace_game_core), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.ans()))));
                            jSONObject.put("emitReplaceJsNative", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_replace_js_native), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.anz()))));
                            jSONObject.put("emitReplaceV8Core", b.this.q(context.getResources().getString(a.h.aiapps_debug_emit_replace_v8_core), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.dT(d.b.acV()))));
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
        } else if (com.baidu.swan.apps.runtime.d.apI().RF() == 1) {
            com.baidu.swan.apps.console.c.d(chS, "swangame getDebugConfig");
            if (!DEBUG) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                com.baidu.swan.apps.console.c.e(chS, "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!b.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e(chS, "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    jSONObject.put("emitHttps", com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.anq()));
                    jSONObject.put("emitWss", com.baidu.swan.apps.extcore.c.a.dT(com.baidu.swan.apps.af.a.a.anu()));
                    jSONObject.put("debugEnvData", com.baidu.swan.apps.af.a.a.anw());
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                } catch (JSONException e) {
                    e.printStackTrace();
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                    return false;
                }
            }
        } else {
            com.baidu.swan.apps.console.c.e(chS, "frame type error");
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
