package com.baidu.swan.apps.extcore.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.t.e;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/debug/downloadExtension");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "params is null");
            com.baidu.swan.apps.res.widget.b.d.q(context, a.h.aiapps_debug_extension_core_params_empty).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final String optString = b.optString("url");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "url is null");
            com.baidu.swan.apps.res.widget.b.d.q(context, a.h.aiapps_debug_extension_core_url_empty).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final String optString2 = b.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "cb is null");
            com.baidu.swan.apps.res.widget.b.d.q(context, a.h.aiapps_debug_extension_core_cb_empty).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        eVar.acS().b(context, "mapp_cts_debug", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.d.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void D(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
        com.baidu.swan.apps.t.e.b(str, new e.b() { // from class: com.baidu.swan.apps.extcore.d.a.a.2
            @Override // com.baidu.swan.apps.t.e.b
            public void cX(int i) {
            }

            @Override // com.baidu.swan.apps.t.e.b
            public void onSuccess() {
                if (callbackHandler == null) {
                    com.baidu.swan.apps.console.c.w("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    File RY = com.baidu.swan.apps.extcore.d.b.RY();
                    File RW = com.baidu.swan.apps.extcore.d.b.RW();
                    if (RY.exists() && com.baidu.swan.d.c.unzipFile(RY.getPath(), RW.getPath())) {
                        com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "download success");
                        com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.w.a.TZ(), a.h.aiapps_debug_extension_core_download_success).showToast();
                        jSONObject.put("status", 0);
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                    } else {
                        com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "download failed");
                        com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.w.a.TZ(), a.h.aiapps_debug_extension_core_download_failed).showToast();
                        jSONObject.put("status", -1);
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001).toString());
                    }
                } catch (JSONException e) {
                    com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "build result with exception", e);
                    e.printStackTrace();
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001).toString());
                }
            }

            @Override // com.baidu.swan.apps.t.e.b
            public void onFailed() {
                if (callbackHandler == null) {
                    com.baidu.swan.apps.console.c.w("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "download failed");
                    com.baidu.swan.apps.res.widget.b.d.q(com.baidu.swan.apps.w.a.TZ(), a.h.aiapps_debug_extension_core_download_failed).showToast();
                    jSONObject.put("status", -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 1001).toString());
            }
        });
    }
}
