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
/* loaded from: classes9.dex */
public class a extends aa {
    public a(j jVar) {
        super(jVar, "/swanAPI/debug/dashboardConnect");
    }

    @Override // com.baidu.swan.apps.scheme.actions.aa
    public boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (DEBUG) {
            JSONObject b2 = b(unitedSchemeEntity, "params");
            if (b2 == null) {
                showToast(a.h.aiapps_debug_swan_core_params_empty);
            } else {
                String optString = b2.optString("meterUrl");
                if (TextUtils.isEmpty(optString)) {
                    showToast(a.h.aiapps_debug_swan_core_url_empty);
                } else {
                    b.auD();
                    d.c cVar = new d.c();
                    cVar.mDownloadUrl = av(context, optString);
                    new com.baidu.swan.apps.l.a().a(cVar, b.auE().getPath(), new d.b() { // from class: com.baidu.swan.games.e.a.1
                        @Override // com.baidu.swan.apps.r.d.b
                        public void fn(int i) {
                        }

                        @Override // com.baidu.swan.apps.r.d.b
                        public void onSuccess() {
                            File auE = b.auE();
                            File auC = b.auC();
                            if (!auE.exists() || !com.baidu.swan.c.d.unzipFile(auE.getPath(), auC.getPath())) {
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

    private String av(Context context, String str) {
        return str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "cuid=" + new String(com.baidu.swan.games.m.a.aXp().j("BASE64", (com.baidu.swan.apps.t.a.axb().cb(context) + "\u0000\u0000").getBytes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(int i) {
        Toast.makeText(com.baidu.swan.apps.t.a.awW(), i, 1).show();
    }
}
