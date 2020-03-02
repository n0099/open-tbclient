package com.baidu.swan.apps.console;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class a {
    private static boolean bjG;

    public static void i(Context context, boolean z) {
        final e acF = e.acF();
        if (acF != null) {
            b.cg(z);
            new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).kJ(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).dD(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity acB = e.this.acB();
                    if (acB != null && Build.VERSION.SDK_INT >= 21) {
                        acB.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).acp();
        }
    }

    public static void bR(Context context) {
        i(context, !Lr());
    }

    public static boolean Lr() {
        return bjG;
    }

    public static void cf(boolean z) {
        bjG = z;
    }
}
