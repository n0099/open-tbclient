package com.baidu.swan.games.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.games.c.d;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class e extends aa {
    public e(j jVar) {
        super(jVar, "/swanAPI/debugGameSconsole");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        if (DEBUG) {
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_params_empty, 1).show();
            } else {
                String optString = b.optString("downloadurl");
                if (TextUtils.isEmpty(optString)) {
                    Toast.makeText(context, a.h.aiapps_debug_swan_core_url_empty, 1).show();
                } else {
                    d.aWN().a(optString, new d.a() { // from class: com.baidu.swan.games.c.e.1
                        @Override // com.baidu.swan.games.c.d.a
                        public void eZ(boolean z) {
                            Context appContext = AppRuntime.getAppContext();
                            if (z) {
                                Toast.makeText(appContext, a.h.aiapps_debug_game_sconsole_download_success, 1).show();
                            } else {
                                Toast.makeText(appContext, a.h.aiapps_debug_game_sconsole_download_failed, 1).show();
                            }
                        }
                    });
                }
            }
        }
        return false;
    }
}
