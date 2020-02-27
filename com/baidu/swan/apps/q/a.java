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
    private static volatile a bvN;
    private String mContent;

    private a() {
    }

    public static a Tb() {
        if (bvN == null) {
            synchronized (a.class) {
                if (bvN == null) {
                    bvN = new a();
                }
            }
        }
        return bvN;
    }

    public static void release() {
        if (bvN != null) {
            if (bvN.mContent != null) {
                bvN.mContent = null;
            }
            bvN = null;
        }
    }

    public void hW(String str) {
        this.mContent = str;
    }

    public String getContent() {
        return this.mContent;
    }

    public boolean Tc() {
        return !TextUtils.isEmpty(this.mContent);
    }

    public void a(Activity activity, final com.baidu.swan.apps.core.f.b<Boolean> bVar) {
        g.a aVar = new g.a(activity);
        aVar.eD(a.h.aiapps_confirm_close_title).kJ(Tb().getContent()).a(new com.baidu.swan.apps.view.c.a()).dD(true);
        aVar.fW(a.c.aiapps_modal_confirm_color);
        aVar.c(a.h.aiapps_dialog_positive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.q.a.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.lJ("confirm");
                bVar.F(true);
            }
        });
        aVar.d(a.h.aiapps_dialog_nagtive_button_text, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.q.a.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                f.lJ(UgcUBCUtils.UGC_TIME_CANCEL);
            }
        });
        aVar.a(new DialogInterface.OnShowListener() { // from class: com.baidu.swan.apps.q.a.3
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                f.lJ("show");
            }
        });
        aVar.acn();
    }
}
