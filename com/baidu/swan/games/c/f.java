package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes2.dex */
public class f extends com.baidu.swan.apps.core.b.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    private View bbj;

    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.b.d
    protected void xQ() {
        wb().setVisibility(8);
        wb().setBackgroundColor(0);
        e.NA();
        NC();
        String NM = com.baidu.swan.games.c.a.b.ND().NM();
        if (DEBUG) {
            Log.d(TAG, "url:" + NM);
        }
        loadUrl(NM);
    }

    private void NC() {
        a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.games.c.f.1
            @Override // com.baidu.swan.apps.core.c
            public void dF(String str) {
                super.dF(str);
                if (f.DEBUG) {
                    Log.e(f.TAG, "onPageFinished");
                }
                e.NB();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.b.d, com.baidu.swan.apps.b.c.a
    public void L(View view) {
        this.bbj = view;
    }

    @Override // com.baidu.swan.apps.core.b.d, com.baidu.swan.apps.b.c.a
    public void W(String str, String str2) {
        e.aR(str, str2);
    }

    @Override // com.baidu.swan.apps.core.b.d, com.baidu.swan.apps.b.c.a
    public void aM(boolean z) {
        if (wb().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.w.e.Ea().a("console", b.cu(true));
            }
            if (this.bbj != null) {
                this.bbj.setVisibility(z ? 4 : 0);
            }
            super.aM(z);
        }
    }

    @Override // com.baidu.swan.apps.core.b.d, com.baidu.swan.apps.b.c.e
    public String wd() {
        return "console";
    }
}
