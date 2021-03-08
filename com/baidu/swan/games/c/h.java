package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes8.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View egx;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void anY() {
        aiZ().setVisibility(8);
        aiZ().setBackgroundColor(0);
        i.aVS();
        aVR();
        String aVN = d.aVD().aVN();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aVN);
        }
        loadUrl(aVN);
    }

    private void aVR() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void iA(String str) {
                super.iA(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aVT();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ao(View view) {
        this.egx = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void be(String str, String str2) {
        i.cS(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aiP() {
        i.eY(false);
        this.egx = null;
        super.aiP();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void eM(boolean z) {
        if (aiZ().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.aAo().a("console", c.ib(true));
            }
            if (this.egx != null) {
                this.egx.setVisibility(z ? 4 : 0);
            }
            super.eM(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String ajb() {
        return "console";
    }
}
