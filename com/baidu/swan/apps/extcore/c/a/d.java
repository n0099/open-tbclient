package com.baidu.swan.apps.extcore.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends aa {
    public d(j jVar) {
        super(jVar, "/swanAPI/debug/replaceSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_swan_core_params_empty).aIv();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
            return false;
        }
        final String optString = b.optString("url");
        final String optString2 = b.optString("cb");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_swan_core_url_empty).aIv();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swan core url or cb is null");
            return false;
        }
        eVar.aIZ().b(context, "mapp_cts_debug", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void N(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    d.this.b(context, optString, optString2, callbackHandler);
                } else {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString2);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final Context context, String str, final String str2, final CallbackHandler callbackHandler) {
        com.baidu.swan.apps.r.d.a(str, new d.b() { // from class: com.baidu.swan.apps.extcore.c.a.d.2
            @Override // com.baidu.swan.apps.r.d.b
            public void fo(int i) {
            }

            @Override // com.baidu.swan.apps.r.d.b
            public void onSuccess() {
                File auH = com.baidu.swan.apps.swancore.b.a.auH();
                File auF = com.baidu.swan.apps.swancore.b.a.auF();
                if (d.DEBUG) {
                    Log.d("replaceSwanCore", "swanCoreZipFile: " + auH + " swanCoreDir: " + auF);
                }
                if (auH.exists() && com.baidu.swan.c.d.unzipFile(auH.getPath(), auF.getPath())) {
                    com.baidu.swan.apps.ad.a.a.gx(true);
                    com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_swan_core_download_success).aIv();
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_swan_core_download_failed).aIv();
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }

            @Override // com.baidu.swan.apps.r.d.b
            public void onFailed() {
                com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_swan_core_download_failed).aIv();
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        });
    }
}
