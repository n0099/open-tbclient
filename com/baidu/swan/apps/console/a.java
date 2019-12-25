package com.baidu.swan.apps.console;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class a {
    private static boolean beC;

    public static void i(Context context, boolean z) {
        final e ZS = e.ZS();
        if (ZS != null) {
            b.bT(z);
            new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).kr(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).dr(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity ZO = e.this.ZO();
                    if (ZO != null && Build.VERSION.SDK_INT >= 21) {
                        ZO.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).ZC();
        }
    }

    public static void bN(Context context) {
        i(context, !IE());
    }

    public static boolean IE() {
        return beC;
    }

    public static void bS(boolean z) {
        beC = z;
    }
}
