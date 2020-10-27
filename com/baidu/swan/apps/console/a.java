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
    private static boolean czj;

    public static void m(Context context, boolean z) {
        final e aEU = e.aEU();
        if (aEU != null) {
            b.ep(z);
            new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).rD(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).gi(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aEO = e.this.aEO();
                    if (aEO != null && Build.VERSION.SDK_INT >= 21) {
                        aEO.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aEB();
        }
    }

    public static void bS(Context context) {
        m(context, !aiV());
    }

    public static boolean aiV() {
        return czj;
    }

    public static void eo(boolean z) {
        czj = z;
    }
}
