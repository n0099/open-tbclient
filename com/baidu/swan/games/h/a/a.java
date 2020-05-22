package com.baidu.swan.games.h.a;

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
        super(jVar, "/swanAPI/debugGameExtensionCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                Toast.makeText(context, a.h.aiapps_debug_swan_core_params_empty, 1).show();
            } else {
                String optString = b.optString("downloadurl");
                if (TextUtils.isEmpty(optString)) {
                    Toast.makeText(context, a.h.aiapps_debug_swan_core_url_empty, 1).show();
                } else {
                    com.baidu.swan.games.l.a.b(optString, new e.b() { // from class: com.baidu.swan.games.h.a.a.1
                        @Override // com.baidu.swan.apps.r.e.b
                        public void dr(int i) {
                        }

                        @Override // com.baidu.swan.apps.r.e.b
                        public void onSuccess() {
                            File acM = b.acM();
                            File acK = b.acK();
                            if (acM.exists() && d.unzipFile(acM.getPath(), acK.getPath())) {
                                Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_extension_download_success, 1).show();
                            } else {
                                Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_extension_download_failed, 1).show();
                            }
                        }

                        @Override // com.baidu.swan.apps.r.e.b
                        public void onFailed() {
                            Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_extension_download_failed, 1).show();
                        }
                    });
                }
            }
        }
        return false;
    }
}
