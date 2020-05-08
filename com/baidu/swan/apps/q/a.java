package com.baidu.swan.apps.q;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.f;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bUn;
    private String mContent;

    private a() {
    }

    public static a aaU() {
        if (bUn == null) {
            synchronized (a.class) {
                if (bUn == null) {
                    bUn = new a();
                }
            }
        }
        return bUn;
    }

    public static void release() {
        if (bUn != null) {
            if (bUn.mContent != null) {
                bUn.mContent = null;
            }
            bUn = null;
        }
    }

    public void jj(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean aaV() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        g.a aVar = new g.a(activity);
        aVar.eI(a.h.aiapps_confirm_close_title).lV(aaU().getContent()).a(new com.baidu.swan.apps.view.c.a()).eA(true);
        aVar.gd(a.c.aiapps_modal_confirm_color);
        aVar.c(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.q.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.mV("confirm");
                bVar.H(true);
            }
        });
        aVar.d(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.q.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.mV("cancel");
            }
        });
        aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.q.a.3
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                f.mV("show");
            }
        });
        aVar.akw();
    }
}
