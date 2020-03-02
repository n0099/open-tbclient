package com.baidu.swan.games.j.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.t.e;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/debugGameCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
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
            com.baidu.swan.games.k.a.c(optString, new e.b() { // from class: com.baidu.swan.games.j.a.a.1
                @Override // com.baidu.swan.apps.t.e.b
                public void cX(int i) {
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onSuccess() {
                    File RV = b.RV();
                    File RT = b.RT();
                    if (RV.exists() && com.baidu.swan.d.c.unzipFile(RV.getPath(), RT.getPath())) {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_success, 1).show();
                    } else {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                    }
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onFailed() {
                    Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
