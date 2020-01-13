package com.baidu.swan.games.b;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes10.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = h.class.getSimpleName();
    private View cig;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void KX() {
        Gy().setVisibility(8);
        Gy().setBackgroundColor(0);
        i.akW();
        akV();
        String akR = d.akH().akR();
        if (DEBUG) {
            Log.d(TAG, "url:" + akR);
        }
        loadUrl(akR);
    }

    private void akV() {
        a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.games.b.h.1
            @Override // com.baidu.swan.apps.core.b
            public void dX(String str) {
                super.dX(str);
                if (h.DEBUG) {
                    Log.e(h.TAG, "onPageFinished");
                }
                i.akX();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ad(View view) {
        this.cig = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ag(String str, String str2) {
        i.bv(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void Gp() {
        i.bZ(false);
        this.cig = null;
        super.Gp();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void bO(boolean z) {
        if (Gy().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.y.f.UC().a("console", c.eu(true));
            }
            if (this.cig != null) {
                this.cig.setVisibility(z ? 4 : 0);
            }
            super.bO(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String GA() {
        return "console";
    }
}
