package com.baidu.swan.apps.extcore.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/debug/downloadExtension");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (!DEBUG) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
            return false;
        }
        JSONObject c = c(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "params is null");
            com.baidu.swan.apps.res.widget.b.d.l(context, a.h.aiapps_debug_extension_core_params_empty).IK();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        String optString = c.optString("url");
        if (TextUtils.isEmpty(optString)) {
            com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "url is null");
            com.baidu.swan.apps.res.widget.b.d.l(context, a.h.aiapps_debug_extension_core_url_empty).IK();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        final String optString2 = c.optString("cb");
        if (TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "cb is null");
            com.baidu.swan.apps.res.widget.b.d.l(context, a.h.aiapps_debug_extension_core_cb_empty).IK();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
            return false;
        }
        com.baidu.swan.apps.install.c.b(optString, new c.b() { // from class: com.baidu.swan.apps.extcore.d.a.a.1
            @Override // com.baidu.swan.apps.install.c.b
            public void cv(int i) {
            }

            @Override // com.baidu.swan.apps.install.c.b
            public void onSuccess() {
                int i;
                File Bs = com.baidu.swan.apps.extcore.d.b.Bs();
                File Bq = com.baidu.swan.apps.extcore.d.b.Bq();
                if (Bs.exists() && com.baidu.swan.c.b.bl(Bs.getPath(), Bq.getPath())) {
                    com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "download success");
                    com.baidu.swan.apps.res.widget.b.d.l(com.baidu.swan.apps.u.a.Cy(), a.h.aiapps_debug_extension_core_download_success).IK();
                    i = 0;
                } else {
                    com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "download failed");
                    i = -1;
                    com.baidu.swan.apps.res.widget.b.d.l(com.baidu.swan.apps.u.a.Cy(), a.h.aiapps_debug_extension_core_download_failed).IK();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("status", i);
                } catch (JSONException e) {
                    com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "build result with exception", e);
                    e.printStackTrace();
                }
                if (callbackHandler != null) {
                    callbackHandler.handleSchemeDispatchCallback(optString2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } else {
                    com.baidu.swan.apps.console.c.w("ExtCore-DebugDownload", "handler is null");
                }
            }

            @Override // com.baidu.swan.apps.install.c.b
            public void onFailed() {
                com.baidu.swan.apps.console.c.e("ExtCore-DebugDownload", "download failed");
                com.baidu.swan.apps.res.widget.b.d.l(com.baidu.swan.apps.u.a.Cy(), a.h.aiapps_debug_extension_core_download_failed).IK();
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
