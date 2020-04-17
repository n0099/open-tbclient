package com.baidu.swan.games.d;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.ab;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.d.c;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends ab {
    public a(j jVar) {
        super(jVar, "/swanAPI/debug/dashboardConnect");
    }

    @Override // com.baidu.swan.apps.scheme.actions.ab
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
                    b.ZM();
                    e.c cVar = new e.c();
                    cVar.mDownloadUrl = ap(context, optString);
                    new com.baidu.swan.apps.l.a().a(cVar, b.ZN().getPath(), new e.b() { // from class: com.baidu.swan.games.d.a.1
                        @Override // com.baidu.swan.apps.t.e.b
                        public void dm(int i) {
                        }

                        @Override // com.baidu.swan.apps.t.e.b
                        public void onSuccess() {
                            File ZN = b.ZN();
                            File ZL = b.ZL();
                            if (!ZN.exists() || !c.unzipFile(ZN.getPath(), ZL.getPath())) {
                                a.this.showToast(a.h.swangame_dashboard_download_failed);
                            } else {
                                a.this.showToast(a.h.swangame_dashboard_download_success);
                            }
                        }

                        @Override // com.baidu.swan.apps.t.e.b
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
        return str + (str.contains("?") ? ETAG.ITEM_SEPARATOR : "?") + "cuid" + ETAG.EQUAL + new String(com.baidu.swan.games.l.a.axa().h("BASE64", (com.baidu.swan.apps.w.a.abT().be(context) + "\u0000\u0000").getBytes()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToast(int i) {
        Toast.makeText(com.baidu.swan.apps.w.a.abO(), i, 1).show();
    }
}
