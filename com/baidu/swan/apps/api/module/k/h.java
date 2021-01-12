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

    public com.baidu.swan.apps.api.c.b kW(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bn.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bn.second;
        aj(h(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private int h(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    private void aj(final int i, final String str) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.h.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aHo = com.baidu.swan.apps.res.widget.a.aHo();
                if (actionBar == null || aHo == null) {
                    h.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aHo.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aHr();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gg(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aHo.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aHr();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.gg(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aHq();
                        actionBar.setVisibility(0);
                        aHo.setVisibility(0);
                        h.ajS();
                        break;
                }
                j.ajU().gi(i);
                h.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ajS() {
        SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
        azx.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.aJ(com.baidu.swan.apps.res.widget.a.getDecorView(azx))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (azx.getWindow() != null) {
            azx.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.azN().aoZ() != null) {
            com.baidu.swan.apps.v.f.azN().aoZ().aon();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gg(int i) {
        SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
        azx.setRequestedOrientation(i);
        azx.getWindow().setFlags(1024, 1024);
    }
}
