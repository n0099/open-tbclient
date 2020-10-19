package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes10.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View dEZ;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void ajl() {
        aen().setVisibility(8);
        aen().setBackgroundColor(0);
        i.aQl();
        aQk();
        String aQg = d.aPW().aQg();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aQg);
        }
        loadUrl(aQg);
    }

    private void aQk() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void hG(String str) {
                super.hG(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aQm();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aj(View view) {
        this.dEZ = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aZ(String str, String str2) {
        i.cN(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aed() {
        i.ed(false);
        this.dEZ = null;
        super.aed();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void dR(boolean z) {
        if (aen().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.avu().a("console", c.gX(true));
            }
            if (this.dEZ != null) {
                this.dEZ.setVisibility(z ? 4 : 0);
            }
            super.dR(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aep() {
        return "console";
    }
}
