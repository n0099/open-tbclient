package com.baidu.swan.games.c;

import android.content.Context;
import android.util.Log;
import android.view.View;
/* loaded from: classes2.dex */
public class g extends com.baidu.swan.apps.core.c.d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = g.class.getSimpleName();
    private View bgq;

    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.swan.apps.core.c.d
    protected void zt() {
        xx().setVisibility(8);
        xx().setBackgroundColor(0);
        f.Ro();
        Rq();
        String RB = com.baidu.swan.games.c.a.b.Rs().RB();
        if (DEBUG) {
            Log.d(TAG, "url:" + RB);
        }
        loadUrl(RB);
    }

    private void Rq() {
        a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.games.c.g.1
            @Override // com.baidu.swan.apps.core.c
            public void dy(String str) {
                super.dy(str);
                if (g.DEBUG) {
                    Log.e(g.TAG, "onPageFinished");
                }
                f.Rp();
            }
        });
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void N(View view) {
        this.bgq = view;
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void R(String str, String str2) {
        f.aU(str, str2);
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void xp() {
        f.aW(false);
        this.bgq = null;
        super.xp();
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.a
    public void aR(boolean z) {
        if (xx().getVisibility() != (z ? 0 : 8)) {
            if (DEBUG) {
                Log.i(TAG, "setConsoleVisible:" + z);
            }
            if (z) {
                com.baidu.swan.apps.w.e.GJ().a("console", c.cO(true));
            }
            if (this.bgq != null) {
                this.bgq.setVisibility(z ? 4 : 0);
            }
            super.aR(z);
        }
    }

    @Override // com.baidu.swan.apps.core.c.d, com.baidu.swan.apps.b.c.e
    public String xz() {
        return "console";
    }
}
