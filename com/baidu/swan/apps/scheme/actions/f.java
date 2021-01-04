package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class f extends aa {
    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/debugSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            JSONObject b2 = b(unitedSchemeEntity, "params");
            if (b2 == null) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_params_empty, 1).show();
                return false;
            }
            String optString = b2.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_url_empty, 1).show();
                return false;
            }
            com.baidu.swan.apps.r.d.a(optString, new d.b() { // from class: com.baidu.swan.apps.scheme.actions.f.1
                @Override // com.baidu.swan.apps.r.d.b
                public void fu(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File axZ = com.baidu.swan.apps.swancore.b.a.axZ();
                    File axX = com.baidu.swan.apps.swancore.b.a.axX();
                    if (axZ.exists() && com.baidu.swan.c.d.unzipFile(axZ.getPath(), axX.getPath())) {
                        com.baidu.swan.apps.ad.a.a.gz(true);
                        Toast.makeText(com.baidu.swan.apps.t.a.aAr(), a.h.aiapps_debug_swan_core_download_success, 1).show();
                        return;
                    }
                    Toast.makeText(com.baidu.swan.apps.t.a.aAr(), a.h.aiapps_debug_swan_core_download_failed, 1).show();
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    Toast.makeText(com.baidu.swan.apps.t.a.aAr(), a.h.aiapps_debug_swan_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
