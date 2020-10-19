package com.baidu.swan.apps.console;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class a {
    private static boolean cqI;

    public static void m(Context context, boolean z) {
        final e aDa = e.aDa();
        if (aDa != null) {
            b.ec(z);
            new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).rk(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).fV(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aCU = e.this.aCU();
                    if (aCU != null && Build.VERSION.SDK_INT >= 21) {
                        aCU.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aCH();
        }
    }

    public static void bS(Context context) {
        m(context, !ahb());
    }

    public static boolean ahb() {
        return cqI;
    }

    public static void eb(boolean z) {
        cqI = z;
    }
}
