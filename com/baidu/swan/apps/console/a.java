package com.baidu.swan.apps.console;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes25.dex */
public class a {
    private static boolean cKn;

    public static void r(Context context, boolean z) {
        final e aJU = e.aJU();
        if (aJU != null) {
            b.eQ(z);
            new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).st(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).gJ(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aJO = e.this.aJO();
                    if (aJO != null && Build.VERSION.SDK_INT >= 21) {
                        aJO.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aJB();
        }
    }

    public static void cy(Context context) {
        r(context, !anV());
    }

    public static boolean anV() {
        return cKn;
    }

    public static void eP(boolean z) {
        cKn = z;
    }
}
