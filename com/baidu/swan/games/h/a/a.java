package com.baidu.swan.games.h.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/debugGameCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            JSONObject c = c(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
            if (c == null) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_params_empty, 1).show();
                return false;
            }
            String optString = c.optString("downloadurl");
            if (TextUtils.isEmpty(optString)) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_url_empty, 1).show();
                return false;
            }
            com.baidu.swan.games.i.a.c(optString, new c.b() { // from class: com.baidu.swan.games.h.a.a.1
                @Override // com.baidu.swan.apps.install.c.b
                public void cv(int i) {
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onSuccess() {
                    File Bs = b.Bs();
                    File Bq = b.Bq();
                    if (Bs.exists() && com.baidu.swan.c.b.bl(Bs.getPath(), Bq.getPath())) {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_success, 1).show();
                    } else {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                    }
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onFailed() {
                    Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
