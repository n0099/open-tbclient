package com.baidu.swan.games.b;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes11.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = h.class.getSimpleName();
    private View cmk;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void Nm() {
        IN().setVisibility(8);
        IN().setBackgroundColor(0);
        i.ank();
        anj();
        String anf = d.amV().anf();
        if (DEBUG) {
            Log.d(TAG, "url:" + anf);
        }
        loadUrl(anf);
    }

    private void anj() {
        a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.games.b.h.1
            @Override // com.baidu.swan.apps.core.b
            public void em(String str) {
                super.em(str);
                if (h.DEBUG) {
                    Log.e(h.TAG, "onPageFinished");
                }
                i.anl();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ad(View view) {
        this.cmk = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aq(String str, String str2) {
        i.bE(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void IE() {
        i.ch(false);
        this.cmk = null;
        super.IE();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void bW(boolean z) {
        if (IN().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.y.f.WQ().a("console", c.eB(true));
            }
            if (this.cmk != null) {
                this.cmk.setVisibility(z ? 4 : 0);
            }
            super.bW(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IP() {
        return "console";
    }
}
