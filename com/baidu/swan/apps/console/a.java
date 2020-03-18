package com.baidu.swan.apps.console;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class a {
    private static boolean bjU;

    public static void i(Context context, boolean z) {
        final e acI = e.acI();
        if (acI != null) {
            b.ch(z);
            new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).kI(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).dE(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity acE = e.this.acE();
                    if (acE != null && Build.VERSION.SDK_INT >= 21) {
                        acE.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).acs();
        }
    }

    public static void bQ(Context context) {
        i(context, !Lu());
    }

    public static boolean Lu() {
        return bjU;
    }

    public static void cg(boolean z) {
        bjU = z;
    }
}
