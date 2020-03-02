package com.baidu.swan.games.b;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes11.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = h.class.getSimpleName();
    private View cml;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void No() {
        IP().setVisibility(8);
        IP().setBackgroundColor(0);
        i.anm();
        anl();
        String anh = d.amX().anh();
        if (DEBUG) {
            Log.d(TAG, "url:" + anh);
        }
        loadUrl(anh);
    }

    private void anl() {
        a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.games.b.h.1
            @Override // com.baidu.swan.apps.core.b
            public void em(String str) {
                super.em(str);
                if (h.DEBUG) {
                    Log.e(h.TAG, "onPageFinished");
                }
                i.ann();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void ad(View view) {
        this.cml = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aq(String str, String str2) {
        i.bE(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void IG() {
        i.ch(false);
        this.cml = null;
        super.IG();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void bW(boolean z) {
        if (IP().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.y.f.WS().a("console", c.eB(true));
            }
            if (this.cml != null) {
                this.cml.setVisibility(z ? 4 : 0);
            }
            super.bW(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String IR() {
        return "console";
    }
}
