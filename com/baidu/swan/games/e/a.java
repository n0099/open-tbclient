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
/* loaded from: classes3.dex */
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
                    b.amZ();
                    d.c cVar = new d.c();
                    cVar.mDownloadUrl = al(context, optString);
                    new com.baidu.swan.apps.l.a().a(cVar, b.ana().getPath(), new d.b() { // from class: com.baidu.swan.games.e.a.1
                        @Override // com.baidu.swan.apps.r.d.b
                        public void eO(int i) {
                        }

                        @Override // com.baidu.swan.apps.r.d.b
                        public void onSuccess() {
                            File ana = b.ana();
                            File amY = b.amY();
                            if (!ana.exists() || !com.baidu.swan.c.d.unzipFile(ana.getPath(), amY.getPath())) {
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

    private String al(Context context, String str) {
        return str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "cuid" + ETAG.EQUAL + new String(com.baidu.swan.games.m.a.aPc().h("BASE64", (com.baidu.swan.apps.t.a.apz().bk(context) + "\u0000\u0000").getBytes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(int i) {
        Toast.makeText(com.baidu.swan.apps.t.a.apu(), i, 1).show();
    }
}
