package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class h extends com.baidu.swan.apps.api.a.d {
    public h(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lf(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bc = com.baidu.swan.apps.api.d.b.bc("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bc.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bc.second;
        aa(i(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private int i(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    private void aa(final int i, final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.h.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aCv = com.baidu.swan.apps.res.widget.a.aCv();
                if (actionBar == null || aCv == null) {
                    h.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aCv.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aCx();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.he(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aCv.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aCx();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.he(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aCw();
                        actionBar.setVisibility(0);
                        aCv.setVisibility(0);
                        h.afH();
                        break;
                }
                j.afJ().hg(i);
                h.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void afH() {
        SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
        ave.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.isImmersionEnabled(com.baidu.swan.apps.res.widget.a.getDecorView(ave))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (ave.getWindow() != null) {
            ave.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.avu().akI() != null) {
            com.baidu.swan.apps.v.f.avu().akI().resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void he(int i) {
        SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
        ave.setRequestedOrientation(i);
        ave.getWindow().setFlags(1024, 1024);
    }
}
