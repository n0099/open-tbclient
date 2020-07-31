package com.baidu.swan.apps.o;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes7.dex */
public class a {
    private static volatile a clr;
    private String mContent;

    private a() {
    }

    public static a agm() {
        if (clr == null) {
            synchronized (a.class) {
                if (clr == null) {
                    clr = new a();
                }
            }
        }
        return clr;
    }

    public static void release() {
        if (clr != null) {
            if (clr.mContent != null) {
                clr.mContent = null;
            }
            clr = null;
        }
    }

    public void kV(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean agn() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        if (activity != null && bVar != null) {
            g.a aVar = new g.a(activity);
            aVar.fi(a.h.aiapps_confirm_close_title).og(agm().getContent()).a(new com.baidu.swan.apps.view.c.a()).fh(true);
            aVar.gR(a.c.aiapps_modal_confirm_color);
            aVar.c(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.o.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.pq("cancel");
                    bVar.J(false);
                }
            });
            aVar.d(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.o.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.pq("confirm");
                    bVar.J(true);
                }
            });
            aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.o.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    h.pq("show");
                }
            });
            aVar.ard();
        }
    }
}
