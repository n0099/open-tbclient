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
    protected void arr() {
        amr().setVisibility(8);
        amr().setBackgroundColor(0);
        i.aZw();
        aZv();
        String aZr = d.aZh().aZr();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aZr);
        }
        loadUrl(aZr);
    }

    private void aZv() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void ig(String str) {
                super.ig(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aZx();
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
    public void amh() {
        i.fa(false);
        this.ehB = null;
        super.amh();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void eO(boolean z) {
        if (amr().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.aDG().a("console", c.id(true));
            }
            if (this.ehB != null) {
                this.ehB.setVisibility(z ? 4 : 0);
            }
            super.eO(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String amt() {
        return "console";
    }
}
