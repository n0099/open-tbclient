package com.baidu.swan.apps.console;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes8.dex */
public class a {
    private static boolean ccp;

    public static void l(Context context, boolean z) {
        final e azI = e.azI();
        if (azI != null) {
            b.dI(z);
            new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).qf(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).fB(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity azC = e.this.azC();
                    if (azC != null && Build.VERSION.SDK_INT >= 21) {
                        azC.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).azp();
        }
    }

    public static void bN(Context context) {
        l(context, !adG());
    }

    public static boolean adG() {
        return ccp;
    }

    public static void dH(boolean z) {
        ccp = z;
    }
}
