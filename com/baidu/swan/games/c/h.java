package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes7.dex */
public class h extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = h.class.getSimpleName();
    private View dgH;

    public h(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void ZH() {
        UP().setVisibility(8);
        UP().setBackgroundColor(0);
        i.aEc();
        aEb();
        String aDX = d.aDN().aDX();
        if (DEBUG) {
            Log.d(TAG, "url:" + aDX);
        }
        loadUrl(aDX);
    }

    private void aEb() {
        a(new com.baidu.swan.apps.core.e() { // from class: com.baidu.swan.games.c.h.1
            @Override // com.baidu.swan.apps.core.e
            public void fH(String str) {
                super.fH(str);
                if (h.DEBUG) {
                    Log.e(h.TAG, "onPageFinished");
                }
                i.aEd();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void af(View view) {
        this.dgH = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void aQ(String str, String str2) {
        i.co(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    public void UF() {
        i.dz(false);
        this.dgH = null;
        super.UF();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.adaptation.b.a
    /* renamed from: do */
    public void mo25do(boolean z) {
        if (UP().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.v.f.akr().a("console", c.gg(true));
            }
            if (this.dgH != null) {
                this.dgH.setVisibility(z ? 4 : 0);
            }
            super.mo25do(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.swan.apps.adaptation.b.e
    public String UR() {
        return "console";
    }
}
