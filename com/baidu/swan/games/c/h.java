package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes11.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = h.class.getSimpleName();
    private View daY;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void YP() {
        Un().setVisibility(8);
        Un().setBackgroundColor(0);
        i.aAx();
        aAw();
        String aAs = d.aAi().aAs();
        if (DEBUG) {
            Log.d(TAG, "url:" + aAs);
        }
        loadUrl(aAs);
    }

    private void aAw() {
        a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.b
            public void fJ(String str) {
                super.fJ(str);
                if (h.DEBUG) {
                    Log.e(h.TAG, "onPageFinished");
                }
                i.aAy();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ac(View view) {
        this.daY = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aP(String str, String str2) {
        i.cl(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void Ue() {
        i.dw(false);
        this.daY = null;
        super.Ue();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void dl(boolean z) {
        if (Un().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.w.f.ajb().a("console", c.fP(true));
            }
            if (this.daY != null) {
                this.daY.setVisibility(z ? 4 : 0);
            }
            super.dl(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Up() {
        return "console";
    }
}
