package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes7.dex */
public class a {
    private static volatile a cTA;
    private String mContent;

    private a() {
    }

    public static a auD() {
        if (cTA == null) {
            synchronized (a.class) {
                if (cTA == null) {
                    cTA = new a();
                }
            }
        }
        return cTA;
    }

    public static void release() {
        if (cTA != null) {
            if (cTA.mContent != null) {
                cTA.mContent = null;
            }
            cTA = null;
        }
    }

    public void os(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean auE() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        if (activity != null && bVar != null) {
            g.a aVar = new g.a(activity);
            aVar.ib(a.h.aiapps_confirm_close_title).rL(auD().getContent()).a(new com.baidu.swan.apps.view.c.a()).gu(true);
            aVar.jX(a.c.aiapps_modal_confirm_color);
            aVar.c(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.sZ("cancel");
                    bVar.O(false);
                }
            });
            aVar.d(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.sZ("confirm");
                    bVar.O(true);
                }
            });
            aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.p.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    h.sZ("show");
                }
            });
            aVar.aGt();
        }
    }
}
