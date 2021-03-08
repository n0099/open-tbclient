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
    private static boolean cOk;

    public static void q(Context context, boolean z) {
        final e aIN = e.aIN();
        if (aIN != null) {
            b.eX(z);
            new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).rE(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).gT(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aIH = e.this.aIH();
                    if (aIH != null && Build.VERSION.SDK_INT >= 21) {
                        aIH.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aIa();
        }
    }

    public static void cD(Context context) {
        q(context, !alO());
    }

    public static boolean alO() {
        return cOk;
    }

    public static void eW(boolean z) {
        cOk = z;
    }
}
