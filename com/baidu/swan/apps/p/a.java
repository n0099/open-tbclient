package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes8.dex */
public class a {
    private static volatile a csI;
    private String mContent;

    private a() {
    }

    public static a anu() {
        if (csI == null) {
            synchronized (a.class) {
                if (csI == null) {
                    csI = new a();
                }
            }
        }
        return csI;
    }

    public static void release() {
        if (csI != null) {
            if (csI.mContent != null) {
                csI.mContent = null;
            }
            csI = null;
        }
    }

    public void mK(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean anv() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        if (activity != null && bVar != null) {
            g.a aVar = new g.a(activity);
            aVar.he(a.h.aiapps_confirm_close_title).qf(anu().getContent()).a(new com.baidu.swan.apps.view.c.a()).fB(true);
            aVar.iY(a.c.aiapps_modal_confirm_color);
            aVar.c(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.rr("cancel");
                    bVar.K(false);
                }
            });
            aVar.d(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.rr("confirm");
                    bVar.K(true);
                }
            });
            aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.p.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    h.rr("show");
                }
            });
            aVar.azp();
        }
    }
}
