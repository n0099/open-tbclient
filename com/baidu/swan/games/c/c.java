package com.baidu.swan.games.c;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.games.c.a.b;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends y {
    public c(j jVar) {
        super(jVar, "/swan/debugGameSconsole");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (DEBUG) {
            JSONObject c = c(unitedSchemeEntity, LegoListActivityConfig.PARAMS);
            if (c == null) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_params_empty, 1).show();
            } else {
                String optString = c.optString("downloadurl");
                if (TextUtils.isEmpty(optString)) {
                    Toast.makeText(context, a.h.aiapps_debug_swan_core_url_empty, 1).show();
                } else {
                    com.baidu.swan.games.c.a.b.NF().a(optString, new b.a() { // from class: com.baidu.swan.games.c.c.1
                        @Override // com.baidu.swan.games.c.a.b.a
                        public void aV(boolean z) {
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
