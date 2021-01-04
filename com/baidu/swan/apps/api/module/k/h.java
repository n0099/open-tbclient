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

    public com.baidu.swan.apps.api.c.b mh(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bo.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bo.second;
        ai(h(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private int h(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    private void ai(final int i, final String str) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.h.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aLh = com.baidu.swan.apps.res.widget.a.aLh();
                if (actionBar == null || aLh == null) {
                    h.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aLh.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aLk();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.hN(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aLh.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aLk();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.hN(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aLj();
                        actionBar.setVisibility(0);
                        aLh.setVisibility(0);
                        h.anL();
                        break;
                }
                j.anN().hP(i);
                h.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void anL() {
        SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
        aDq.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.aJ(com.baidu.swan.apps.res.widget.a.getDecorView(aDq))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (aDq.getWindow() != null) {
            aDq.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.aDG().asU() != null) {
            com.baidu.swan.apps.v.f.aDG().asU().ash();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hN(int i) {
        SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
        aDq.setRequestedOrientation(i);
        aDq.getWindow().setFlags(1024, 1024);
    }
}
