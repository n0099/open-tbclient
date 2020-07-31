package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.al;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends com.baidu.swan.apps.api.a.d {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b iB(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aS.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aS.second;
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
        al.p(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.g.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aqR = com.baidu.swan.apps.res.widget.a.aqR();
                if (actionBar == null || aqR == null) {
                    g.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aqR.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aqT();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        g.eA(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aqR.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aqT();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        g.eA(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aqS();
                        actionBar.setVisibility(0);
                        aqR.setVisibility(0);
                        g.Wg();
                        break;
                }
                h.Wh().eC(i);
                g.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Wg() {
        SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
        akb.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.isImmersionEnabled(com.baidu.swan.apps.res.widget.a.K(akb))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (akb.getWindow() != null) {
            akb.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.akr().aba() != null) {
            com.baidu.swan.apps.v.f.akr().aba().resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void eA(int i) {
        SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
        akb.setRequestedOrientation(i);
        akb.getWindow().setFlags(1024, 1024);
    }
}
