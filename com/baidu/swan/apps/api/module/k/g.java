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

    public com.baidu.swan.apps.api.c.b ir(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) aR.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) aR.second;
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
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.g.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aph = com.baidu.swan.apps.res.widget.a.aph();
                if (actionBar == null || aph == null) {
                    g.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aph.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.apk();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        g.ez(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aph.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.apk();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        g.ez(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.apj();
                        actionBar.setVisibility(0);
                        aph.setVisibility(0);
                        g.VA();
                        break;
                }
                h.VB().eB(i);
                g.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void VA() {
        SwanAppActivity aiL = com.baidu.swan.apps.w.f.ajb().aiL();
        aiL.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.isImmersionEnabled(com.baidu.swan.apps.res.widget.a.L(aiL))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (aiL.getWindow() != null) {
            aiL.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.w.f.ajb().ZW() != null) {
            com.baidu.swan.apps.w.f.ajb().ZW().resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ez(int i) {
        SwanAppActivity aiL = com.baidu.swan.apps.w.f.ajb().aiL();
        aiL.setRequestedOrientation(i);
        aiL.getWindow().setFlags(1024, 1024);
    }
}
