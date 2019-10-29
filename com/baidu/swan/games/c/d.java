package com.baidu.swan.games.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.games.c.a.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends z {
    public d(j jVar) {
        super(jVar, "/swan/debugGameSconsole");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            JSONObject c = c(unitedSchemeEntity, "params");
            if (c == null) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_params_empty, 1).show();
            } else {
                String optString = c.optString("downloadurl");
                if (TextUtils.isEmpty(optString)) {
                    Toast.makeText(context, a.h.aiapps_debug_swan_core_url_empty, 1).show();
                } else {
                    com.baidu.swan.games.c.a.b.Wj().a(optString, new b.a() { // from class: com.baidu.swan.games.c.d.1
                        @Override // com.baidu.swan.games.c.a.b.a
                        public void bs(boolean z) {
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
