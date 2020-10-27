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

    public com.baidu.swan.apps.api.c.b ly(String str) {
        if (DEBUG) {
            Log.d("Api-FullScreenApi", "start set full screen");
        }
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-FullScreenApi", str);
        com.baidu.swan.apps.api.c.b bVar = (com.baidu.swan.apps.api.c.b) bj.first;
        if (!bVar.isSuccess()) {
            if (DEBUG) {
                com.baidu.swan.apps.console.c.e("Api-FullScreenApi", "parse fail");
                return bVar;
            }
            return bVar;
        }
        JSONObject jSONObject = (JSONObject) bj.second;
        ac(i(jSONObject.optBoolean("fullScreen"), jSONObject.optInt("direction")), jSONObject.optString("cb"));
        return new com.baidu.swan.apps.api.c.b(0);
    }

    private int i(boolean z, int i) {
        if (z) {
            return i;
        }
        return -1;
    }

    private void ac(final int i, final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.api.module.k.h.1
            @Override // java.lang.Runnable
            public void run() {
                View actionBar = com.baidu.swan.apps.res.widget.a.getActionBar();
                LinearLayout aEp = com.baidu.swan.apps.res.widget.a.aEp();
                if (actionBar == null || aEp == null) {
                    h.this.a(str, new com.baidu.swan.apps.api.c.b(1001));
                    return;
                }
                switch (i) {
                    case -90:
                        actionBar.setVisibility(8);
                        aEp.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aEr();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.hp(8);
                        break;
                    case 90:
                        actionBar.setVisibility(8);
                        aEp.setVisibility(8);
                        com.baidu.swan.apps.res.widget.a.aEr();
                        com.baidu.swan.apps.res.widget.a.setImmersive(true);
                        h.hp(0);
                        break;
                    default:
                        com.baidu.swan.apps.res.widget.a.aEq();
                        actionBar.setVisibility(0);
                        aEp.setVisibility(0);
                        h.ahB();
                        break;
                }
                j.ahD().hr(i);
                h.this.a(str, new com.baidu.swan.apps.api.c.b(0));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ahB() {
        SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
        awY.setRequestedOrientation(1);
        if (!com.baidu.swan.apps.res.widget.a.isImmersionEnabled(com.baidu.swan.apps.res.widget.a.getDecorView(awY))) {
            com.baidu.swan.apps.res.widget.a.setImmersive(false);
        }
        if (awY.getWindow() != null) {
            awY.getWindow().clearFlags(1024);
        }
        if (com.baidu.swan.apps.v.f.axo().amC() != null) {
            com.baidu.swan.apps.v.f.axo().amC().resetWithCurImmersion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hp(int i) {
        SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
        awY.setRequestedOrientation(i);
        awY.getWindow().setFlags(1024, 1024);
    }
}
