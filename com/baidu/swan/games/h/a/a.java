package com.baidu.swan.games.h.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/debugGameCore");
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
            com.baidu.swan.games.i.a.c(optString, new e.b() { // from class: com.baidu.swan.games.h.a.a.1
                @Override // com.baidu.swan.apps.install.e.b
                public void cr(int i) {
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onSuccess() {
                    File Ia = b.Ia();
                    File HY = b.HY();
                    if (Ia.exists() && com.baidu.swan.c.a.bz(Ia.getPath(), HY.getPath())) {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_success, 1).show();
                    } else {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                    }
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onFailed() {
                    Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
