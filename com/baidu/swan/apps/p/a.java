package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes8.dex */
public class a {
    private static volatile a daC;
    private String mContent;

    private a() {
    }

    public static a avj() {
        if (daC == null) {
            synchronized (a.class) {
                if (daC == null) {
                    daC = new a();
                }
            }
        }
        return daC;
    }

    public static void release() {
        if (daC != null) {
            if (daC.mContent != null) {
                daC.mContent = null;
            }
            daC = null;
        }
    }

    public void nF(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean avk() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        if (activity != null && bVar != null) {
            g.a aVar = new g.a(activity);
            aVar.gO(a.h.aiapps_confirm_close_title).re(avj().getContent()).a(new com.baidu.swan.apps.view.c.a()).gR(true);
            aVar.iS(a.c.aiapps_modal_confirm_color);
            aVar.c(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.ss("cancel");
                    bVar.N(false);
                }
            });
            aVar.d(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.ss("confirm");
                    bVar.N(true);
                }
            });
            aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.p.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    h.ss("show");
                }
            });
            aVar.aHE();
        }
    }
}
