package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes25.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View dYE;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void aqf() {
        alh().setVisibility(8);
        alh().setBackgroundColor(0);
        i.aXc();
        aXb();
        String aWX = d.aWN().aWX();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aWX);
        }
        loadUrl(aWX);
    }

    private void aXb() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void it(String str) {
                super.it(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aXd();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ar(View view) {
        this.dYE = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void bm(String str, String str2) {
        i.da(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void akX() {
        i.eR(false);
        this.dYE = null;
        super.akX();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void eF(boolean z) {
        if (alh().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.aCp().a("console", c.hL(true));
            }
            if (this.dYE != null) {
                this.dYE.setVisibility(z ? 4 : 0);
            }
            super.eF(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String alj() {
        return "console";
    }
}
