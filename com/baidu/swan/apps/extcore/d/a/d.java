package com.baidu.swan.apps.extcore.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.t.e;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends ab {
    private static final String bTf = d.class.getSimpleName();

    public d(j jVar) {
        super(jVar, "/swanAPI/debug/replaceSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
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
        eVar.akX().b(context, "mapp_cts_debug", new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.d.a.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void E(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
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
        com.baidu.swan.apps.t.e.a(str, new e.b() { // from class: com.baidu.swan.apps.extcore.d.a.d.2
            @Override // com.baidu.swan.apps.t.e.b
            public void dm(int i) {
            }

            @Override // com.baidu.swan.apps.t.e.b
            public void onSuccess() {
                File ZN = com.baidu.swan.apps.swancore.c.a.ZN();
                File ZL = com.baidu.swan.apps.swancore.c.a.ZL();
                if (d.DEBUG) {
                    Log.d(d.bTf, "swanCoreZipFile: " + ZN + " swanCoreDir: " + ZL);
                }
                if (ZN.exists() && com.baidu.swan.d.c.unzipFile(ZN.getPath(), ZL.getPath())) {
                    com.baidu.swan.apps.ah.a.a.ej(true);
                    com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_swan_core_download_success).showToast();
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_swan_core_download_failed).showToast();
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }

            @Override // com.baidu.swan.apps.t.e.b
            public void onFailed() {
                com.baidu.swan.apps.res.widget.b.d.k(context, a.h.aiapps_debug_swan_core_download_failed).showToast();
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        });
    }
}
