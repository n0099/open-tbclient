package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes9.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View eeV;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void anV() {
        aiW().setVisibility(8);
        aiW().setBackgroundColor(0);
        i.aVP();
        aVO();
        String aVK = d.aVA().aVK();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aVK);
        }
        loadUrl(aVK);
    }

    private void aVO() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void iu(String str) {
                super.iu(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aVQ();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ao(View view) {
        this.eeV = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void be(String str, String str2) {
        i.cS(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aiM() {
        i.eY(false);
        this.eeV = null;
        super.aiM();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void eM(boolean z) {
        if (aiW().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.aAl().a("console", c.ib(true));
            }
            if (this.eeV != null) {
                this.eeV.setVisibility(z ? 4 : 0);
            }
            super.eM(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiY() {
        return "console";
    }
}
