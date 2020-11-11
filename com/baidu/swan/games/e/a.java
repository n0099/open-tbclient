package com.baidu.swan.games.e;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.aa;
import com.baidu.swan.apps.scheme.j;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/debug/dashboardConnect");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            JSONObject b = b(unitedSchemeEntity, "params");
            if (b == null) {
                showToast(a.h.aiapps_debug_swan_core_params_empty);
            } else {
                String optString = b.optString("meterUrl");
                if (TextUtils.isEmpty(optString)) {
                    showToast(a.h.aiapps_debug_swan_core_url_empty);
                } else {
                    b.aug();
                    d.c cVar = new d.c();
                    cVar.mDownloadUrl = ap(context, optString);
                    new com.baidu.swan.apps.l.a().a(cVar, b.auh().getPath(), new d.b() { // from class: com.baidu.swan.games.e.a.1
                        @Override // com.baidu.swan.apps.r.d.b
                        public void fa(int i) {
                        }

                        @Override // com.baidu.swan.apps.r.d.b
                        public void onSuccess() {
                            File auh = b.auh();
                            File auf = b.auf();
                            if (!auh.exists() || !com.baidu.swan.c.d.unzipFile(auh.getPath(), auf.getPath())) {
                                a.this.showToast(a.h.swangame_dashboard_download_failed);
                            } else {
                                a.this.showToast(a.h.swangame_dashboard_download_success);
                            }
                        }

                        @Override // com.baidu.swan.apps.r.d.b
                        public void onFailed() {
                            a.this.showToast(a.h.swangame_dashboard_download_failed);
                        }
                    });
                }
            }
        }
        return false;
    }

    private String ap(Context context, String str) {
        return str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "cuid" + ETAG.EQUAL + new String(com.baidu.swan.games.m.a.aWf().h("BASE64", (com.baidu.swan.apps.t.a.awF().bq(context) + "\u0000\u0000").getBytes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(int i) {
        Toast.makeText(com.baidu.swan.apps.t.a.awA(), i, 1).show();
    }
}
