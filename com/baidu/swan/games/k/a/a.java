package com.baidu.swan.games.k.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.e.d;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/debugGameCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
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
            com.baidu.swan.games.l.a.c(optString, new e.b() { // from class: com.baidu.swan.games.k.a.a.1
                @Override // com.baidu.swan.apps.r.e.b
                public void dE(int i) {
                }

                @Override // com.baidu.swan.apps.r.e.b
                public void onSuccess() {
                    File adS = b.adS();
                    File adQ = b.adQ();
                    if (adS.exists() && d.unzipFile(adS.getPath(), adQ.getPath())) {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_success, 1).show();
                    } else {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                    }
                }

                @Override // com.baidu.swan.apps.r.e.b
                public void onFailed() {
                    Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
