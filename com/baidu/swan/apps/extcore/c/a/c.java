package com.baidu.swan.apps.extcore.c.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends aa {
    public c(j jVar) {
        super(jVar, "/swanAPI/debug/replaceGameCore");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        JSONObject b2 = b(unitedSchemeEntity, "params");
        if (b2 == null) {
            com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_swan_core_params_empty).aHZ();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "params is null");
            return false;
        }
        final String optString = b2.optString("url");
        final String optString2 = b2.optString("cb");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_swan_core_url_empty).aHZ();
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "game core url or cb is null");
            return false;
        }
        eVar.aID().b(context, "mapp_cts_debug", new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.oauth.h<b.d>>() { // from class: com.baidu.swan.apps.extcore.c.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(com.baidu.swan.apps.setting.oauth.h<b.d> hVar) {
                if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                    c.this.a(context, optString, optString2, callbackHandler);
                } else {
                    com.baidu.swan.apps.setting.oauth.c.a(hVar, callbackHandler, optString2);
                }
            }
        });
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final Context context, String str, final String str2, final CallbackHandler callbackHandler) {
        com.baidu.swan.games.l.a.c(str, new d.b() { // from class: com.baidu.swan.apps.extcore.c.a.c.2
            @Override // com.baidu.swan.apps.r.d.b
            public void dO(int i) {
            }

            @Override // com.baidu.swan.apps.r.d.b
            public void onSuccess() {
                File aug = com.baidu.swan.games.k.a.b.aug();
                File aue = com.baidu.swan.games.k.a.b.aue();
                if (c.DEBUG) {
                    Log.d("replaceGameCore", "gameCoreZipFile: " + aug + " gameCoreDir: " + aue);
                }
                if (aug.exists() && com.baidu.swan.c.d.unzipFile(aug.getPath(), aue.getPath())) {
                    com.baidu.swan.apps.ad.a.a.gw(true);
                    com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_game_core_download_success).aHZ();
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    return;
                }
                com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_game_core_download_failed).aHZ();
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }

            @Override // com.baidu.swan.apps.r.d.b
            public void onFailed() {
                com.baidu.swan.apps.res.widget.b.d.u(context, a.h.aiapps_debug_game_core_download_failed).aHZ();
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
            }
        });
    }
}
