package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes25.dex */
public class a {
    private static volatile a dav;
    private String mContent;

    private a() {
    }

    public static a axL() {
        if (dav == null) {
            synchronized (a.class) {
                if (dav == null) {
                    dav = new a();
                }
            }
        }
        return dav;
    }

    public static void release() {
        if (dav != null) {
            if (dav.mContent != null) {
                dav.mContent = null;
            }
            dav = null;
        }
    }

    public void oZ(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean axM() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        if (activity != null && bVar != null) {
            g.a aVar = new g.a(activity);
            aVar.iz(a.h.aiapps_confirm_close_title).st(axL().getContent()).a(new com.baidu.swan.apps.view.c.a()).gJ(true);
            aVar.kv(a.c.aiapps_modal_confirm_color);
            aVar.c(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.tG("cancel");
                    bVar.O(false);
                }
            });
            aVar.d(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.tG("confirm");
                    bVar.O(true);
                }
            });
            aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.p.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    h.tG("show");
                }
            });
            aVar.aJB();
        }
    }
}
