package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes2.dex */
public class g extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = g.class.getSimpleName();
    private View bzj;

    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void Eo() {
        Cr().setVisibility(8);
        Cr().setBackgroundColor(0);
        f.Wf();
        Wh();
        String Ws = com.baidu.swan.games.c.a.b.Wj().Ws();
        if (DEBUG) {
            Log.d(TAG, "url:" + Ws);
        }
        loadUrl(Ws);
    }

    private void Wh() {
        a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.games.c.g.1
            @Override // com.baidu.swan.apps.core.c
            public void db(String str) {
                super.db(str);
                if (g.DEBUG) {
                    Log.e(g.TAG, "onPageFinished");
                }
                f.Wg();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void T(View view) {
        this.bzj = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void Y(String str, String str2) {
        f.bb(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void Cj() {
        f.bo(false);
        this.bzj = null;
        super.Cj();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void bj(boolean z) {
        if (Cr().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.w.e.LD().a("console", c.df(true));
            }
            if (this.bzj != null) {
                this.bzj.setVisibility(z ? 4 : 0);
            }
            super.bj(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.e
    public String Ct() {
        return "console";
    }
}
