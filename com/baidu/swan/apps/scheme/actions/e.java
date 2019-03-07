package com.baidu.swan.apps.scheme.actions;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.install.c;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends y {
    public e(com.baidu.swan.apps.scheme.j jVar) {
        super(jVar, "/swan/debugSwanCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            JSONObject c = c(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
            if (c == null) {
                Toast.makeText(context, b.h.aiapps_debug_swan_core_params_empty, 1).show();
                return false;
            }
            String optString = c.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, b.h.aiapps_debug_swan_core_url_empty, 1).show();
                return false;
            }
            com.baidu.swan.apps.install.c.a(optString, new c.b() { // from class: com.baidu.swan.apps.scheme.actions.e.1
                @Override // com.baidu.swan.apps.install.c.b
                public void cv(int i) {
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onSuccess() {
                    File Bs = com.baidu.swan.apps.swancore.c.a.Bs();
                    File Bq = com.baidu.swan.apps.swancore.c.a.Bq();
                    if (Bs.exists() && com.baidu.swan.c.b.bl(Bs.getPath(), Bq.getPath())) {
                        com.baidu.swan.apps.swancore.b.ch(true);
                        Toast.makeText(com.baidu.swan.apps.u.a.Cy(), b.h.aiapps_debug_swan_core_download_success, 1).show();
                        return;
                    }
                    Toast.makeText(com.baidu.swan.apps.u.a.Cy(), b.h.aiapps_debug_swan_core_download_failed, 1).show();
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onFailed() {
                    Toast.makeText(com.baidu.swan.apps.u.a.Cy(), b.h.aiapps_debug_swan_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
