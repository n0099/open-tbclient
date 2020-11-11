package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes10.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View dTo;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void anF() {
        aiH().setVisibility(8);
        aiH().setBackgroundColor(0);
        i.aUF();
        aUE();
        String aUA = d.aUq().aUA();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aUA);
        }
        loadUrl(aUA);
    }

    private void aUE() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void hV(String str) {
                super.hV(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aUG();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ap(View view) {
        this.dTo = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void bg(String str, String str2) {
        i.cU(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aix() {
        i.ez(false);
        this.dTo = null;
        super.aix();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void en(boolean z) {
        if (aiH().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.azO().a("console", c.ht(true));
            }
            if (this.dTo != null) {
                this.dTo.setVisibility(z ? 4 : 0);
            }
            super.en(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiJ() {
        return "console";
    }
}
