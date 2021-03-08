package com.baidu.swan.games.b;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.res.widget.dialog.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class c {
    private com.baidu.swan.apps.res.widget.dialog.g edv;

    public void a(final Activity activity, final String str, final String str2, final boolean z, final DialogInterface.OnClickListener onClickListener) {
        ak.j(new Runnable() { // from class: com.baidu.swan.games.b.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.edv != null && c.this.edv.isShowing()) {
                    c.this.edv.dismiss();
                }
                if (activity != null && !activity.isFinishing()) {
                    g.a b = c.this.b(activity, str, str2, z, onClickListener);
                    c.this.edv = b.aIa();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g.a b(Activity activity, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        g.a aVar = new g.a(activity);
        aVar.rE(str).aHV().a(new com.baidu.swan.apps.view.c.a()).gT(z).iW(a.c.swan_games_antiaddiction_positive).gR(true);
        aVar.a(str2, onClickListener);
        return aVar;
    }

    public void destroy() {
        if (this.edv != null) {
            if (this.edv.isShowing()) {
                this.edv.dismiss();
            }
            this.edv = null;
        }
    }
}
