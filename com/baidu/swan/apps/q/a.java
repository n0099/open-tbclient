package com.baidu.swan.apps.q;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.f;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a bwb;
    private String mContent;

    private a() {
    }

    public static a Tg() {
        if (bwb == null) {
            synchronized (a.class) {
                if (bwb == null) {
                    bwb = new a();
                }
            }
        }
        return bwb;
    }

    public static void release() {
        if (bwb != null) {
            if (bwb.mContent != null) {
                bwb.mContent = null;
            }
            bwb = null;
        }
    }

    public void hV(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean Th() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        g.a aVar = new g.a(activity);
        aVar.eD(a.h.aiapps_confirm_close_title).kI(Tg().getContent()).a(new com.baidu.swan.apps.view.c.a()).dE(true);
        aVar.fW(a.c.aiapps_modal_confirm_color);
        aVar.c(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.q.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.lI("confirm");
                bVar.F(true);
            }
        });
        aVar.d(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.q.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.lI(UgcUBCUtils.UGC_TIME_CANCEL);
            }
        });
        aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.q.a.3
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                f.lI("show");
            }
        });
        aVar.acs();
    }
}
