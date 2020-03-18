package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.t.e;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f extends ab {
    public f(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swanAPI/debugSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
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
            com.baidu.swan.apps.t.e.a(optString, new e.b() { // from class: com.baidu.swan.apps.scheme.actions.f.1
                @Override // com.baidu.swan.apps.t.e.b
                public void cX(int i) {
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onSuccess() {
                    File RY = com.baidu.swan.apps.swancore.c.a.RY();
                    File RW = com.baidu.swan.apps.swancore.c.a.RW();
                    if (RY.exists() && com.baidu.swan.d.c.unzipFile(RY.getPath(), RW.getPath())) {
                        com.baidu.swan.apps.ah.a.a.dn(true);
                        Toast.makeText(com.baidu.swan.apps.w.a.TZ(), a.h.aiapps_debug_swan_core_download_success, 1).show();
                        return;
                    }
                    Toast.makeText(com.baidu.swan.apps.w.a.TZ(), a.h.aiapps_debug_swan_core_download_failed, 1).show();
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onFailed() {
                    Toast.makeText(com.baidu.swan.apps.w.a.TZ(), a.h.aiapps_debug_swan_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
