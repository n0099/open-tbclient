package com.baidu.swan.apps.p;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.h;
/* loaded from: classes3.dex */
public class a {
    private static volatile a cuO;
    private String mContent;

    private a() {
    }

    public static a aoe() {
        if (cuO == null) {
            synchronized (a.class) {
                if (cuO == null) {
                    cuO = new a();
                }
            }
        }
        return cuO;
    }

    public static void release() {
        if (cuO != null) {
            if (cuO.mContent != null) {
                cuO.mContent = null;
            }
            cuO = null;
        }
    }

    public void nd(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean aof() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        if (activity != null && bVar != null) {
            g.a aVar = new g.a(activity);
            aVar.hn(a.h.aiapps_confirm_close_title).qy(aoe().getContent()).a(new com.baidu.swan.apps.view.c.a()).fz(true);
            aVar.jj(a.c.aiapps_modal_confirm_color);
            aVar.c(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.rK("cancel");
                    bVar.L(false);
                }
            });
            aVar.d(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.p.a.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    h.rK("confirm");
                    bVar.L(true);
                }
            });
            aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.p.a.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    h.rK("show");
                }
            });
            aVar.azY();
        }
    }
}
