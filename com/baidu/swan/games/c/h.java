package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes10.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View dNw;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void alf() {
        agh().setVisibility(8);
        agh().setBackgroundColor(0);
        i.aSf();
        aSe();
        String aSa = d.aRQ().aSa();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aSa);
        }
        loadUrl(aSa);
    }

    private void aSe() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void hO(String str) {
                super.hO(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aSg();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void al(View view) {
        this.dNw = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void bg(String str, String str2) {
        i.cU(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void afX() {
        i.eq(false);
        this.dNw = null;
        super.afX();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ee(boolean z) {
        if (agh().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.axo().a("console", c.hk(true));
            }
            if (this.dNw != null) {
                this.dNw.setVisibility(z ? 4 : 0);
            }
            super.ee(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String agj() {
        return "console";
    }
}
