package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes11.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = h.class.getSimpleName();
    private View cWm;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void XJ() {
        Th().setVisibility(8);
        Th().setBackgroundColor(0);
        i.azr();
        azq();
        String azm = d.azc().azm();
        if (DEBUG) {
            Log.d(TAG, "url:" + azm);
        }
        loadUrl(azm);
    }

    private void azq() {
        a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.b
            public void fQ(String str) {
                super.fQ(str);
                if (h.DEBUG) {
                    Log.e(h.TAG, "onPageFinished");
                }
                i.azs();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ac(View view) {
        this.cWm = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aN(String str, String str2) {
        i.cj(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void SY() {
        i.dr(false);
        this.cWm = null;
        super.SY();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void dg(boolean z) {
        if (Th().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.w.f.ahV().a("console", c.fK(true));
            }
            if (this.cWm != null) {
                this.cWm.setVisibility(z ? 4 : 0);
            }
            super.dg(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String Tj() {
        return "console";
    }
}
