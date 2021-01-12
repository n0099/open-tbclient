package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes8.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private View ecO;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void anx() {
        aiy().setVisibility(8);
        aiy().setBackgroundColor(0);
        i.aVD();
        aVC();
        String aVy = d.aVo().aVy();
        if (DEBUG) {
            Log.d("SwanGameConsoleManager", "url:" + aVy);
        }
        loadUrl(aVy);
    }

    private void aVC() {
        a(new com.baidu.swan.apps.core.g() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.g
            public void gV(String str) {
                super.gV(str);
                if (h.DEBUG) {
                    Log.e("SwanGameConsoleManager", "onPageFinished");
                }
                i.aVE();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void as(View view) {
        this.ecO = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void bk(String str, String str2) {
        i.cY(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aio() {
        i.eW(false);
        this.ecO = null;
        super.aio();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void eK(boolean z) {
        if (aiy().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i("SwanGameConsoleManager", "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.azN().a("console", c.hZ(true));
            }
            if (this.ecO != null) {
                this.ecO.setVisibility(z ? 4 : 0);
            }
            super.eK(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String aiA() {
        return "console";
    }
}
