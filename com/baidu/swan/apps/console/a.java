package com.baidu.swan.apps.console;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes3.dex */
public class a {
    private static boolean ces;

    public static void m(Context context, boolean z) {
        final e aAr = e.aAr();
        if (aAr != null) {
            b.dG(z);
            new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).qy(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).fz(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aAl = e.this.aAl();
                    if (aAl != null && Build.VERSION.SDK_INT >= 21) {
                        aAl.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).azY();
        }
    }

    public static void bM(Context context) {
        m(context, !aeq());
    }

    public static boolean aeq() {
        return ces;
    }

    public static void dF(boolean z) {
        ces = z;
    }
}
