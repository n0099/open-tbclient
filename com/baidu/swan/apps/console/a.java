package com.baidu.swan.apps.console;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes7.dex */
public class a {
    private static boolean cDs;

    public static void m(Context context, boolean z) {
        final e aGM = e.aGM();
        if (aGM != null) {
            b.eB(z);
            new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).rL(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).gu(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aGG = e.this.aGG();
                    if (aGG != null && Build.VERSION.SDK_INT >= 21) {
                        aGG.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aGt();
        }
    }

    public static void bS(Context context) {
        m(context, !akN());
    }

    public static boolean akN() {
        return cDs;
    }

    public static void eA(boolean z) {
        cDs = z;
    }
}
