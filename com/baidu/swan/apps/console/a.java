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
    private static boolean bVM;

    public static void k(Context context, boolean z) {
        final e apM = e.apM();
        if (apM != null) {
            b.dv(z);
            new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).ny(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).eY(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity apG = e.this.apG();
                    if (apG != null && Build.VERSION.SDK_INT >= 21) {
                        apG.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).apu();
        }
    }

    public static void bD(Context context) {
        k(context, !WU());
    }

    public static boolean WU() {
        return bVM;
    }

    public static void du(boolean z) {
        bVM = z;
    }
}
