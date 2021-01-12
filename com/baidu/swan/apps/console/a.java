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
    private static boolean cKw;

    public static void p(Context context, boolean z) {
        final e aIr = e.aIr();
        if (aIr != null) {
            b.eV(z);
            new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).re(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).gR(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aIl = e.this.aIl();
                    if (aIl != null && Build.VERSION.SDK_INT >= 21) {
                        aIl.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aHE();
        }
    }

    public static void cF(Context context) {
        p(context, !aln());
    }

    public static boolean aln() {
        return cKw;
    }

    public static void eU(boolean z) {
        cKw = z;
    }
}
