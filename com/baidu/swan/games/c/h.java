package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes7.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View dRG;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void amX() {
        ahZ().setVisibility(8);
        ahZ().setBackgroundColor(0);
        i.aTX();
        aTW();
        String aTS = d.aTI().aTS();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aTS);
        }
        loadUrl(aTS);
    }

    private void aTW() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void hP(String str) {
                super.hP(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aTY();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ap(View view) {
        this.dRG = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void bf(String str, String str2) {
        i.cT(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ahP() {
        i.eC(false);
        this.dRG = null;
        super.ahP();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void eq(boolean z) {
        if (ahZ().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.azg().a("console", c.hw(true));
            }
            if (this.dRG != null) {
                this.dRG.setVisibility(z ? 4 : 0);
            }
            super.eq(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aib() {
        return "console";
    }
}
