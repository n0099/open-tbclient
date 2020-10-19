package com.baidu.swan.games.k.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
            com.baidu.swan.games.l.a.c(optString, new d.b() { // from class: com.baidu.swan.games.k.a.a.1
                @Override // com.baidu.swan.apps.r.d.b
                public void eX(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    File apM = b.apM();
                    File apK = b.apK();
                    if (apM.exists() && com.baidu.swan.c.d.unzipFile(apM.getPath(), apK.getPath())) {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_success, 1).show();
                    } else {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                    }
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_download_failed, 1).show();
                }
            });
            return true;
        }
        return false;
    }
}
