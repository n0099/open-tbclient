package com.baidu.swan.games.b;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.res.widget.dialog.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c {
    private com.baidu.swan.apps.res.widget.dialog.g dZN;

    public void a(final Activity activity, final String str, final String str2, final boolean z, final DialogInterface.OnClickListener onClickListener) {
        ak.l(new Runnable() { // from class: com.baidu.swan.games.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.dZN != null && c.this.dZN.isShowing()) {
                    c.this.dZN.dismiss();
                }
                if (activity != null && !activity.isFinishing()) {
                    g.a b2 = c.this.b(activity, str, str2, z, onClickListener);
                    c.this.dZN = b2.aHE();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.a b(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.re(str).aHz().a(new com.baidu.swan.apps.view.c.a()).gR(z).iS(a.c.swan_games_antiaddiction_positive).gP(true);
        aVar.a(str2, onClickListener);
        return aVar;
    }

    public void destroy() {
        if (this.dZN != null) {
            if (this.dZN.isShowing()) {
                this.dZN.dismiss();
            }
            this.dZN = null;
        }
    }
}
