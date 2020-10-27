package com.baidu.swan.games.b;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.res.widget.dialog.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class c {
    private com.baidu.swan.apps.res.widget.dialog.g dKu;

    public void a(final Activity activity, final String str, final String str2, final boolean z, final DialogInterface.OnClickListener onClickListener) {
        ak.m(new Runnable() { // from class: com.baidu.swan.games.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.dKu != null && c.this.dKu.isShowing()) {
                    c.this.dKu.dismiss();
                }
                if (activity != null && !activity.isFinishing()) {
                    g.a b = c.this.b(activity, str, str2, z, onClickListener);
                    c.this.dKu = b.aEB();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.a b(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.rD(str).aEx().a(new com.baidu.swan.apps.view.c.a()).gi(z).jR(a.c.swan_games_antiaddiction_positive).gg(true);
        aVar.a(str2, onClickListener);
        return aVar;
    }

    public void destroy() {
        if (this.dKu != null) {
            if (this.dKu.isShowing()) {
                this.dKu.dismiss();
            }
            this.dKu = null;
        }
    }
}
