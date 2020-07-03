package com.baidu.swan.apps.extcore.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends aa {
    private static final String chS = d.class.getSimpleName();

    public d(j jVar) {
        super(jVar, "/swanAPI/debug/replaceSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b = b(unitedSchemeEntity, "params");
        if (b == null) {
            com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_swan_core_params_empty).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
            return false;
        }
        final String optString = b.optString("url");
        final String optString2 = b.optString("cb");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_swan_core_url_empty).showToast();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swan core url or cb is null");
            return false;
        }
        eVar.apY().b(context, "mapp_cts_debug", new com.baidu.swan.apps.aq.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: a */
            public void H(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
        com.baidu.swan.apps.r.e.a(str, new e.b() { // from class: com.baidu.swan.apps.extcore.c.a.d.2
            @Override // com.baidu.swan.apps.r.e.b
            public void dE(int i) {
            }

            @Override // com.baidu.swan.apps.r.e.b
            public void onSuccess() {
                File adS = com.baidu.swan.apps.swancore.b.a.adS();
                File adQ = com.baidu.swan.apps.swancore.b.a.adQ();
                if (d.DEBUG) {
                    Log.d(d.chS, "swanCoreZipFile: " + adS + " swanCoreDir: " + adQ);
                }
                if (adS.exists() && com.baidu.swan.e.d.unzipFile(adS.getPath(), adQ.getPath())) {
                    com.baidu.swan.apps.af.a.a.eF(true);
                    com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_swan_core_download_success).showToast();
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_swan_core_download_failed).showToast();
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }

            @Override // com.baidu.swan.apps.r.e.b
            public void onFailed() {
                com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_swan_core_download_failed).showToast();
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        });
    }
}
