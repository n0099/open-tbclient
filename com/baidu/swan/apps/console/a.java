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
        final e aMk = e.aMk();
        if (aMk != null) {
            b.eZ(z);
            new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).sp(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).gV(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aMe = e.this.aMe();
                    if (aMe != null && Build.VERSION.SDK_INT >= 21) {
                        aMe.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aLx();
        }
    }

    public static void cG(Context context) {
        p(context, !apg());
    }

    public static boolean apg() {
        return cPi;
    }

    public static void eY(boolean z) {
        cPi = z;
    }
}
