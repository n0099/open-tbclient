package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends com.baidu.swan.apps.api.a.d {
    public h(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b kt(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aX.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aX.second;
        P(h(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private int h(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    private void P(final int i, final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.h.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout azM = com.baidu.swan.apps.res.widget.a.azM();
                if (actionBar == null || azM == null) {
                    h.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        azM.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.azO();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gH(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        azM.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.azO();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gH(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.azN();
                        actionBar.setVisibility(0);
                        azM.setVisibility(0);
                        h.acV();
                        break;
                }
                j.acX().gJ(i);
                h.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void acV() {
        SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
        ast.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.isImmersionEnabled(com.baidu.swan.apps.res.widget.a.getDecorView(ast))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (ast.getWindow() != null) {
            ast.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.asJ().ahX() != null) {
            com.baidu.swan.apps.v.f.asJ().ahX().resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gH(int i) {
        SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
        ast.setRequestedOrientation(i);
        ast.getWindow().setFlags(1024, 1024);
    }
}
