package com.baidu.swan.games.b;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.res.widget.dialog.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class c {
    private com.baidu.swan.apps.res.widget.dialog.g ebU;

    public void a(final Activity activity, final String str, final String str2, final boolean z, final DialogInterface.OnClickListener onClickListener) {
        ak.k(new Runnable() { // from class: com.baidu.swan.games.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.ebU != null && c.this.ebU.isShowing()) {
                    c.this.ebU.dismiss();
                }
                if (activity != null && !activity.isFinishing()) {
                    g.a b2 = c.this.b(activity, str, str2, z, onClickListener);
                    c.this.ebU = b2.aHX();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.a b(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.rx(str).aHS().a(new com.baidu.swan.apps.view.c.a()).gT(z).iV(a.c.swan_games_antiaddiction_positive).gR(true);
        aVar.a(str2, onClickListener);
        return aVar;
    }

    public void destroy() {
        if (this.ebU != null) {
            if (this.ebU.isShowing()) {
                this.ebU.dismiss();
            }
            this.ebU = null;
        }
    }
}
