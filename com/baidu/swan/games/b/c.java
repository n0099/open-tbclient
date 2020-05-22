package com.baidu.swan.games.b;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.res.widget.dialog.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class c {
    private com.baidu.swan.apps.res.widget.dialog.g cTl;

    public void a(final Activity activity, final String str, final String str2, final boolean z, final DialogInterface.OnClickListener onClickListener) {
        aj.p(new Runnable() { // from class: com.baidu.swan.games.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.cTl != null && c.this.cTl.isShowing()) {
                    c.this.cTl.dismiss();
                }
                if (activity != null && !activity.isFinishing()) {
                    g.a b = c.this.b(activity, str, str2, z, onClickListener);
                    c.this.cTl = b.aon();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.a b(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.nq(str).aoj().a(new com.baidu.swan.apps.view.c.a()).eT(z).gv(a.c.swan_games_antiaddiction_positive).eR(true);
        aVar.a(str2, onClickListener);
        return aVar;
    }
}
