package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes9.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View ehB;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void ars() {
        ams().setVisibility(8);
        ams().setBackgroundColor(0);
        i.aZx();
        aZw();
        String aZs = d.aZi().aZs();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aZs);
        }
        loadUrl(aZs);
    }

    private void aZw() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void ig(String str) {
                super.ig(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aZy();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void as(View view) {
        this.ehB = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void bl(String str, String str2) {
        i.cZ(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ami() {
        i.fa(false);
        this.ehB = null;
        super.ami();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void eO(boolean z) {
        if (ams().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.aDH().a("console", c.id(true));
            }
            if (this.ehB != null) {
                this.ehB.setVisibility(z ? 4 : 0);
            }
            super.eO(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String amu() {
        return "console";
    }
}
