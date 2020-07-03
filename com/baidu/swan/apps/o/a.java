package com.baidu.swan.apps.o;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cjr;
    private String mContent;

    private a() {
    }

    public static a afb() {
        if (cjr == null) {
            synchronized (a.class) {
                if (cjr == null) {
                    cjr = new a();
                }
            }
        }
        return cjr;
    }

    public static void release() {
        if (cjr != null) {
            if (cjr.mContent != null) {
                cjr.mContent = null;
            }
            cjr = null;
        }
    }

    public void kz(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean afc() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        if (activity != null && bVar != null) {
            g.a aVar = new g.a(activity);
            aVar.fe(a.h.aiapps_confirm_close_title).ny(afb().getContent()).a(new com.baidu.swan.apps.view.c.a()).eY(true);
            aVar.gI(a.c.aiapps_modal_confirm_color);
            aVar.c(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.o.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.oG("cancel");
                    bVar.K(false);
                }
            });
            aVar.d(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.o.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.oG("confirm");
                    bVar.K(true);
                }
            });
            aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.o.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    h.oG("show");
                }
            });
            aVar.apu();
        }
    }
}
