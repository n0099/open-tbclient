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
    private static boolean cPi;

    public static void p(Context context, boolean z) {
        final e aMl = e.aMl();
        if (aMl != null) {
            b.eZ(z);
            new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).sp(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).gV(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aMf = e.this.aMf();
                    if (aMf != null && Build.VERSION.SDK_INT >= 21) {
                        aMf.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aLy();
        }
    }

    public static void cG(Context context) {
        p(context, !aph());
    }

    public static boolean aph() {
        return cPi;
    }

    public static void eY(boolean z) {
        cPi = z;
    }
}
