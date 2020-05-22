package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.aj;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class g extends com.baidu.swan.apps.api.a.d {
    public g(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ij(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aP = com.baidu.swan.apps.api.d.b.aP("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aP.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aP.second;
        N(h(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private int h(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    private void N(final int i, final String str) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.g.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aob = com.baidu.swan.apps.res.widget.a.aob();
                if (actionBar == null || aob == null) {
                    g.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aob.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aod();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        g.em(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aob.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aod();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        g.em(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aoc();
                        actionBar.setVisibility(0);
                        aob.setVisibility(0);
                        g.Uu();
                        break;
                }
                h.Uv().eo(i);
                g.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Uu() {
        SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
        ahF.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.isImmersionEnabled(com.baidu.swan.apps.res.widget.a.L(ahF))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (ahF.getWindow() != null) {
            ahF.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.w.f.ahV().YQ() != null) {
            com.baidu.swan.apps.w.f.ahV().YQ().resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void em(int i) {
        SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
        ahF.setRequestedOrientation(i);
        ahF.getWindow().setFlags(1024, 1024);
    }
}
