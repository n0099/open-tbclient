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
/* loaded from: classes9.dex */
public class b extends aa {
    public b(j jVar) {
        super(jVar, "/swanAPI/debug/getDebugConfig");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        final JSONObject jSONObject = new JSONObject();
        com.baidu.swan.apps.console.c.i("getDebugConfig", "swan getDebugConfig");
        if (com.baidu.swan.apps.runtime.d.aMh().ajl() == 0) {
            eVar.aMx().b(context, "mapp_cts_debug", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.ao.e.b
                /* renamed from: a */
                public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                    if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                        try {
                            jSONObject.put("loadCts", b.this.p(context.getResources().getString(a.h.aiapps_debug_load_cts), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aIJ()))));
                            jSONObject.put("emitLive", b.this.p(context.getResources().getString(a.h.aiapps_debug_emit_live), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aID()))));
                            jSONObject.put("emitHttps", b.this.p(context.getResources().getString(a.h.aiapps_debug_emit_https), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aIE()))));
                            jSONObject.put("useExtension", b.this.p(context.getResources().getString(a.h.aiapps_debug_use_extension), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aIB()))));
                            jSONObject.put("emitDomain", b.this.p(context.getResources().getString(a.h.aiapps_debug_emit_domain), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF((com.baidu.swan.apps.ad.a.a.aIw() || com.baidu.swan.apps.ad.a.a.aIv()) ? false : true))));
                            jSONObject.put("emitWss", b.this.p(context.getResources().getString(a.h.aiapps_debug_emit_wss), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aII()))));
                            jSONObject.put("emitLaunchMode", b.this.p(context.getResources().getString(a.h.aiapps_debug_emit_launch_mode), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aIH()))));
                            jSONObject.put("debugEnvData", b.this.p(context.getResources().getString(a.h.aiapps_debug_game_extra_data), com.baidu.swan.apps.ad.a.a.aIK()));
                            jSONObject.put("emitReplaceSwanCore", b.this.p(context.getResources().getString(a.h.aiapps_debug_emit_replace_swan_core), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aIF()))));
                            jSONObject.put("emitReplaceGameCore", b.this.p(context.getResources().getString(a.h.aiapps_debug_emit_replace_game_core), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aIG()))));
                            jSONObject.put("emitReplaceJsNative", b.this.p(context.getResources().getString(a.h.aiapps_debug_emit_replace_js_native), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aIN()))));
                            jSONObject.put("emitReplaceV8Core", b.this.p(context.getResources().getString(a.h.aiapps_debug_emit_replace_v8_core), Integer.valueOf(com.baidu.swan.apps.extcore.c.a.fF(d.C0436d.awt()))));
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
        } else if (com.baidu.swan.apps.runtime.d.aMh().ajl() == 1) {
            com.baidu.swan.apps.console.c.i("getDebugConfig", "swangame getDebugConfig");
            if (!DEBUG) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            }
            JSONObject b2 = b(unitedSchemeEntity, "params");
            if (b2 == null) {
                com.baidu.swan.apps.console.c.e("getDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!b2.optString("category").equals("swanGame")) {
                com.baidu.swan.apps.console.c.e("getDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                try {
                    jSONObject.put("emitHttps", com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aIE()));
                    jSONObject.put("emitWss", com.baidu.swan.apps.extcore.c.a.fF(com.baidu.swan.apps.ad.a.a.aII()));
                    jSONObject.put("debugEnvData", com.baidu.swan.apps.ad.a.a.aIK());
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
    public JSONObject p(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        jSONObject.put("value", obj);
        return jSONObject;
    }
}
