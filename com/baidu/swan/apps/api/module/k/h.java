package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h extends com.baidu.swan.apps.api.a.d {
    public h(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ka(String str) {
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
        O(h(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private int h(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    private void O(final int i, final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.h.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout azd = com.baidu.swan.apps.res.widget.a.azd();
                if (actionBar == null || azd == null) {
                    h.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        azd.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.azf();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gy(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        azd.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.azf();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gy(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aze();
                        actionBar.setVisibility(0);
                        azd.setVisibility(0);
                        h.acm();
                        break;
                }
                j.aco().gA(i);
                h.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void acm() {
        SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
        arI.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.isImmersionEnabled(com.baidu.swan.apps.res.widget.a.getDecorView(arI))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (arI.getWindow() != null) {
            arI.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.arY().ahn() != null) {
            com.baidu.swan.apps.v.f.arY().ahn().resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gy(int i) {
        SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
        arI.setRequestedOrientation(i);
        arI.getWindow().setFlags(1024, 1024);
    }
}
