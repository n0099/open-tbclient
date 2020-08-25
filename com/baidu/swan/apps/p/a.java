package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes8.dex */
public class a {
    private static volatile a csE;
    private String mContent;

    private a() {
    }

    public static a anu() {
        if (csE == null) {
            synchronized (a.class) {
                if (csE == null) {
                    csE = new a();
                }
            }
        }
        return csE;
    }

    public static void release() {
        if (csE != null) {
            if (csE.mContent != null) {
                csE.mContent = null;
            }
            csE = null;
        }
    }

    public void mJ(String str) {
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
            aVar.he(a.h.aiapps_confirm_close_title).qe(anu().getContent()).a(new com.baidu.swan.apps.view.c.a()).fA(true);
            aVar.iY(a.c.aiapps_modal_confirm_color);
            aVar.c(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.rq("cancel");
                    bVar.K(false);
                }
            });
            aVar.d(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.rq("confirm");
                    bVar.K(true);
                }
            });
            aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.p.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    h.rq("show");
                }
            });
            aVar.azp();
        }
    }
}
