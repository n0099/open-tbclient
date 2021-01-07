package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes9.dex */
public class a {
    private static volatile a dfr;
    private String mContent;

    private a() {
    }

    public static a azd() {
        if (dfr == null) {
            synchronized (a.class) {
                if (dfr == null) {
                    dfr = new a();
                }
            }
        }
        return dfr;
    }

    public static void release() {
        if (dfr != null) {
            if (dfr.mContent != null) {
                dfr.mContent = null;
            }
            dfr = null;
        }
    }

    public void oS(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean aze() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        if (activity != null && bVar != null) {
            g.a aVar = new g.a(activity);
            aVar.iu(a.h.aiapps_confirm_close_title).sp(azd().getContent()).a(new com.baidu.swan.apps.view.c.a()).gV(true);
            aVar.ky(a.c.aiapps_modal_confirm_color);
            aVar.c(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.tD("cancel");
                    bVar.N(false);
                }
            });
            aVar.d(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.tD("confirm");
                    bVar.N(true);
                }
            });
            aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.p.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    h.tD("show");
                }
            });
            aVar.aLy();
        }
    }
}
