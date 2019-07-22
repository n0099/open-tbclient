package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes2.dex */
public class g extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = g.class.getSimpleName();
    private View bfS;

    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void zp() {
        xt().setVisibility(8);
        xt().setBackgroundColor(0);
        f.Rk();
        Rm();
        String Rx = com.baidu.swan.games.c.a.b.Ro().Rx();
        if (DEBUG) {
            Log.d(TAG, "url:" + Rx);
        }
        loadUrl(Rx);
    }

    private void Rm() {
        a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.games.c.g.1
            @Override // com.baidu.swan.apps.core.c
            public void dw(String str) {
                super.dw(str);
                if (g.DEBUG) {
                    Log.e(g.TAG, "onPageFinished");
                }
                f.Rl();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void N(View view) {
        this.bfS = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void R(String str, String str2) {
        f.aU(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void xl() {
        f.aW(false);
        this.bfS = null;
        super.xl();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void aR(boolean z) {
        if (xt().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.w.e.GF().a("console", c.cO(true));
            }
            if (this.bfS != null) {
                this.bfS.setVisibility(z ? 4 : 0);
            }
            super.aR(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.e
    public String xv() {
        return "console";
    }
}
