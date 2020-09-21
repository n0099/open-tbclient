package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes3.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View dsX;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void agA() {
        abB().setVisibility(8);
        abB().setBackgroundColor(0);
        i.aNC();
        aNB();
        String aNx = d.aNn().aNx();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aNx);
        }
        loadUrl(aNx);
    }

    private void aNB() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void hp(String str) {
                super.hp(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aND();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ai(View view) {
        this.dsX = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aU(String str, String str2) {
        i.cI(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void abr() {
        i.dH(false);
        this.dsX = null;
        super.abr();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void dv(boolean z) {
        if (abB().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.asJ().a("console", c.gB(true));
            }
            if (this.dsX != null) {
                this.dsX.setVisibility(z ? 4 : 0);
            }
            super.dv(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String abD() {
        return "console";
    }
}
