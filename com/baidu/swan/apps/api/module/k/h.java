package com.baidu.swan.apps.api.module.k;

import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h extends com.baidu.swan.apps.api.a.d {
    public h(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b lv(String str) {
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
        ak.j(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.h.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aHK = com.baidu.swan.apps.res.widget.a.aHK();
                if (actionBar == null || aHK == null) {
                    h.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aHK.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aHN();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gk(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aHK.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aHN();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gk(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aHM();
                        actionBar.setVisibility(0);
                        aHK.setVisibility(0);
                        h.akt();
                        break;
                }
                j.akv().gm(i);
                h.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void akt() {
        SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
        azY.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.aF(com.baidu.swan.apps.res.widget.a.getDecorView(azY))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (azY.getWindow() != null) {
            azY.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.aAo().apB() != null) {
            com.baidu.swan.apps.v.f.aAo().apB().aoO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gk(int i) {
        SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
        azY.setRequestedOrientation(i);
        azY.getWindow().setFlags(1024, 1024);
    }
}
