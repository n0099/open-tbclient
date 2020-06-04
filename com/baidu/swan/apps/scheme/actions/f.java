package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.e;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends aa {
    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/debugSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_params_empty, 1).show();
                return false;
            }
            String optString = b.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_url_empty, 1).show();
                return false;
            }
            com.baidu.swan.apps.r.e.a(optString, new e.b() { // from class: com.baidu.swan.apps.scheme.actions.f.1
                @Override // com.baidu.swan.apps.r.e.b
                public void dt(int i) {
                }

                @Override // com.baidu.swan.apps.r.e.b
                public void onSuccess() {
                    File acM = com.baidu.swan.apps.swancore.b.a.acM();
                    File acK = com.baidu.swan.apps.swancore.b.a.acK();
                    if (acM.exists() && com.baidu.swan.e.d.unzipFile(acM.getPath(), acK.getPath())) {
                        com.baidu.swan.apps.af.a.a.eA(true);
                        Toast.makeText(com.baidu.swan.apps.u.a.aeR(), a.h.aiapps_debug_swan_core_download_success, 1).show();
                        return;
                    }
                    Toast.makeText(com.baidu.swan.apps.u.a.aeR(), a.h.aiapps_debug_swan_core_download_failed, 1).show();
                }

                @Override // com.baidu.swan.apps.r.e.b
                public void onFailed() {
                    Toast.makeText(com.baidu.swan.apps.u.a.aeR(), a.h.aiapps_debug_swan_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
