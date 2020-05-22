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
    private static boolean bQY;

    public static void k(Context context, boolean z) {
        final e aoF = e.aoF();
        if (aoF != null) {
            b.dq(z);
            new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).nq(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).eT(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aoz = e.this.aoz();
                    if (aoz != null && Build.VERSION.SDK_INT >= 21) {
                        aoz.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aon();
        }
    }

    public static void bC(Context context) {
        k(context, !VO());
    }

    public static boolean VO() {
        return bQY;
    }

    public static void dp(boolean z) {
        bQY = z;
    }
}
