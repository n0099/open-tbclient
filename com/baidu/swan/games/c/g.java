package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes2.dex */
public class g extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = g.class.getSimpleName();
    private View bys;

    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void Ep() {
        Cs().setVisibility(8);
        Cs().setBackgroundColor(0);
        f.Wd();
        Wf();
        String Wq = com.baidu.swan.games.c.a.b.Wh().Wq();
        if (DEBUG) {
            Log.d(TAG, "url:" + Wq);
        }
        loadUrl(Wq);
    }

    private void Wf() {
        a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.games.c.g.1
            @Override // com.baidu.swan.apps.core.c
            public void db(String str) {
                super.db(str);
                if (g.DEBUG) {
                    Log.e(g.TAG, "onPageFinished");
                }
                f.We();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void T(View view) {
        this.bys = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void Y(String str, String str2) {
        f.bb(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void Ck() {
        f.bo(false);
        this.bys = null;
        super.Ck();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void bj(boolean z) {
        if (Cs().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.w.e.LE().a("console", c.df(true));
            }
            if (this.bys != null) {
                this.bys.setVisibility(z ? 4 : 0);
            }
            super.bj(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.e
    public String Cu() {
        return "console";
    }
}
