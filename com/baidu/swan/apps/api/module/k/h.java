package com.baidu.swan.apps.api.module.k;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class h extends com.baidu.swan.apps.api.a.d {
    public h(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lo(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bh = com.baidu.swan.apps.api.d.b.bh("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bh.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bh.second;
        an(h(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private int h(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    private void an(final int i, final String str) {
        ak.k(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.h.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aHH = com.baidu.swan.apps.res.widget.a.aHH();
                if (actionBar == null || aHH == null) {
                    h.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aHH.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aHK();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gj(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aHH.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aHK();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gj(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aHJ();
                        actionBar.setVisibility(0);
                        aHH.setVisibility(0);
                        h.akq();
                        break;
                }
                j.aks().gl(i);
                h.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void akq() {
        SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
        azV.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.aF(com.baidu.swan.apps.res.widget.a.getDecorView(azV))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (azV.getWindow() != null) {
            azV.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.aAl().apy() != null) {
            com.baidu.swan.apps.v.f.aAl().apy().aoL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gj(int i) {
        SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
        azV.setRequestedOrientation(i);
        azV.getWindow().setFlags(1024, 1024);
    }
}
