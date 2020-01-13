package com.baidu.swan.apps.q;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.statistic.f;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a brD;
    private String mContent;

    private a() {
    }

    public static a QN() {
        if (brD == null) {
            synchronized (a.class) {
                if (brD == null) {
                    brD = new a();
                }
            }
        }
        return brD;
    }

    public static void release() {
        if (brD != null) {
            if (brD.mContent != null) {
                brD.mContent = null;
            }
            brD = null;
        }
    }

    public void hH(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean QO() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        g.a aVar = new g.a(activity);
        aVar.en(a.h.aiapps_confirm_close_title).ku(QN().getContent()).a(new com.baidu.swan.apps.view.c.a()).dw(true);
        aVar.fG(a.c.aiapps_modal_confirm_color);
        aVar.c(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.q.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.lu("confirm");
                bVar.D(true);
            }
        });
        aVar.d(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.q.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.lu(UgcUBCUtils.UGC_TIME_CANCEL);
            }
        });
        aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.q.a.3
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                f.lu("show");
            }
        });
        aVar.ZZ();
    }
}
