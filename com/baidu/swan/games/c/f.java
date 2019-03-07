package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes2.dex */
public class f extends com.baidu.swan.apps.core.b.d {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static final String TAG = f.class.getSimpleName();
    private View bbe;

    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.b.d
    protected void xR() {
        wc().setVisibility(8);
        wc().setBackgroundColor(0);
        e.NC();
        NE();
        String NO = com.baidu.swan.games.c.a.b.NF().NO();
        if (DEBUG) {
            Log.d(TAG, "url:" + NO);
        }
        loadUrl(NO);
    }

    private void NE() {
        a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.games.c.f.1
            @Override // com.baidu.swan.apps.core.c
            public void dD(String str) {
                super.dD(str);
                if (f.DEBUG) {
                    Log.e(f.TAG, "onPageFinished");
                }
                e.ND();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.b.d, com.baidu.swan.apps.b.c.a
    public void L(View view) {
        this.bbe = view;
    }

    @Override // com.baidu.swan.apps.core.b.d, com.baidu.swan.apps.b.c.a
    public void W(String str, String str2) {
        e.aR(str, str2);
    }

    @Override // com.baidu.swan.apps.core.b.d, com.baidu.swan.apps.b.c.a
    public void aM(boolean z) {
        if (wc().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.w.e.Ec().a("console", b.cu(true));
            }
            if (this.bbe != null) {
                this.bbe.setVisibility(z ? 4 : 0);
            }
            super.aM(z);
        }
    }

    @Override // com.baidu.swan.apps.core.b.d, com.baidu.swan.apps.b.c.e
    public String we() {
        return "console";
    }
}
