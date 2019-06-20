package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes2.dex */
public class g extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = g.class.getSimpleName();
    private View bfg;

    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void yI() {
        wS().setVisibility(8);
        wS().setBackgroundColor(0);
        f.Qr();
        Qt();
        String QE = com.baidu.swan.games.c.a.b.Qv().QE();
        if (DEBUG) {
            Log.d(TAG, "url:" + QE);
        }
        loadUrl(QE);
    }

    private void Qt() {
        a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.games.c.g.1
            @Override // com.baidu.swan.apps.core.c
            public void dr(String str) {
                super.dr(str);
                if (g.DEBUG) {
                    Log.e(g.TAG, "onPageFinished");
                }
                f.Qs();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void L(View view) {
        this.bfg = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void R(String str, String str2) {
        f.aU(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void wK() {
        f.aT(false);
        this.bfg = null;
        super.wK();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void aO(boolean z) {
        if (wS().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.w.e.FV().a("console", c.cL(true));
            }
            if (this.bfg != null) {
                this.bfg.setVisibility(z ? 4 : 0);
            }
            super.aO(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.e
    public String wU() {
        return "console";
    }
}
