package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.install.e;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends z {
    public e(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/debugSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            JSONObject c = c(unitedSchemeEntity, "params");
            if (c == null) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_params_empty, 1).show();
                return false;
            }
            String optString = c.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_url_empty, 1).show();
                return false;
            }
            com.baidu.swan.apps.install.e.a(optString, new e.b() { // from class: com.baidu.swan.apps.scheme.actions.e.1
                @Override // com.baidu.swan.apps.install.e.b
                public void cr(int i) {
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onSuccess() {
                    File Ib = com.baidu.swan.apps.swancore.c.a.Ib();
                    File HZ = com.baidu.swan.apps.swancore.c.a.HZ();
                    if (Ib.exists() && com.baidu.swan.c.a.bz(Ib.getPath(), HZ.getPath())) {
                        com.baidu.swan.apps.swancore.b.cQ(true);
                        Toast.makeText(com.baidu.swan.apps.u.a.Jj(), a.h.aiapps_debug_swan_core_download_success, 1).show();
                        return;
                    }
                    Toast.makeText(com.baidu.swan.apps.u.a.Jj(), a.h.aiapps_debug_swan_core_download_failed, 1).show();
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onFailed() {
                    Toast.makeText(com.baidu.swan.apps.u.a.Jj(), a.h.aiapps_debug_swan_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
