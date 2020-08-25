package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes8.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View dqQ;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void afQ() {
        aaS().setVisibility(8);
        aaS().setBackgroundColor(0);
        i.aMR();
        aMQ();
        String aMM = d.aMC().aMM();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aMM);
        }
        loadUrl(aMM);
    }

    private void aMQ() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void hs(String str) {
                super.hs(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aMS();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ag(View view) {
        this.dqQ = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aU(String str, String str2) {
        i.cI(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aaI() {
        i.dI(false);
        this.dqQ = null;
        super.aaI();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void dw(boolean z) {
        if (aaS().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.arY().a("console", c.gC(true));
            }
            if (this.dqQ != null) {
                this.dqQ.setVisibility(z ? 4 : 0);
            }
            super.dw(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aaU() {
        return "console";
    }
}
