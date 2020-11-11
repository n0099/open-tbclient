package com.baidu.swan.apps.extcore.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/debug/downloadExtension");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "params is null");
            com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_extension_core_params_empty).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final String optString = b.optString("url");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "url is null");
            com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_extension_core_url_empty).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final String optString2 = b.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "cb is null");
            com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_extension_core_cb_empty).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        eVar.aHG().b(context, "mapp_cts_debug", new com.baidu.swan.apps.ap.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: a */
            public void M(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    a.this.a(optString, optString2, callbackHandler);
                } else {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString2);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, final String str2, final CallbackHandler callbackHandler) {
        final JSONObject jSONObject = new JSONObject();
        com.baidu.swan.apps.r.d.b(str, new d.b() { // from class: com.baidu.swan.apps.extcore.c.a.a.2
            @Override // com.baidu.swan.apps.r.d.b
            public void fa(int i) {
            }

            @Override // com.baidu.swan.apps.r.d.b
            public void onSuccess() {
                if (callbackHandler == null) {
                    com.baidu.swan.apps.console.c.w("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    File auh = com.baidu.swan.apps.extcore.c.b.auh();
                    File auf = com.baidu.swan.apps.extcore.c.b.auf();
                    if (auh.exists() && com.baidu.swan.c.d.unzipFile(auh.getPath(), auf.getPath())) {
                        com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "download success");
                        com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.awA(), a.h.aiapps_debug_extension_core_download_success).showToast();
                        jSONObject.put("status", 0);
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                    } else {
                        com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "download failed");
                        com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.awA(), a.h.aiapps_debug_extension_core_download_failed).showToast();
                        jSONObject.put("status", -1);
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001).toString());
                    }
                } catch (JSONException e) {
                    com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "build result with exception", e);
                    e.printStackTrace();
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001).toString());
                }
            }

            @Override // com.baidu.swan.apps.r.d.b
            public void onFailed() {
                if (callbackHandler == null) {
                    com.baidu.swan.apps.console.c.w("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "download failed");
                    com.baidu.swan.apps.res.widget.b.d.k(com.baidu.swan.apps.t.a.awA(), a.h.aiapps_debug_extension_core_download_failed).showToast();
                    jSONObject.put("status", -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001).toString());
            }
        });
    }
}
