package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class h extends com.baidu.swan.apps.api.a.d {
    public h(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b mo(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bp.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bp.second;
        ag(i(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private int i(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    private void ag(final int i, final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.h.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aJp = com.baidu.swan.apps.res.widget.a.aJp();
                if (actionBar == null || aJp == null) {
                    h.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aJp.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aJr();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.hT(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aJp.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aJr();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.hT(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aJq();
                        actionBar.setVisibility(0);
                        aJp.setVisibility(0);
                        h.amB();
                        break;
                }
                j.amD().hV(i);
                h.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void amB() {
        SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
        aBZ.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.isImmersionEnabled(com.baidu.swan.apps.res.widget.a.getDecorView(aBZ))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (aBZ.getWindow() != null) {
            aBZ.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.aCp().arC() != null) {
            com.baidu.swan.apps.v.f.aCp().arC().resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hT(int i) {
        SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
        aBZ.setRequestedOrientation(i);
        aBZ.getWindow().setFlags(1024, 1024);
    }
}
