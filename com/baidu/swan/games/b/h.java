package com.baidu.swan.games.b;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes11.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = h.class.getSimpleName();
    private View cLt;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void Ve() {
        QE().setVisibility(8);
        QE().setBackgroundColor(0);
        i.avC();
        avB();
        String avx = d.avn().avx();
        if (DEBUG) {
            Log.d(TAG, "url:" + avx);
        }
        loadUrl(avx);
    }

    private void avB() {
        a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.games.b.h.1
            @Override // com.baidu.swan.apps.core.b
            public void fe(String str) {
                super.fe(str);
                if (h.DEBUG) {
                    Log.e(h.TAG, "onPageFinished");
                }
                i.avD();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ad(View view) {
        this.cLt = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ay(String str, String str2) {
        i.bO(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void Qv() {
        i.de(false);
        this.cLt = null;
        super.Qv();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void cT(boolean z) {
        if (QE().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.y.f.aeK().a("console", c.fz(true));
            }
            if (this.cLt != null) {
                this.cLt.setVisibility(z ? 4 : 0);
            }
            super.cT(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String QG() {
        return "console";
    }
}
