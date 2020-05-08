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
    private static boolean bIh;

    public static void i(Context context, boolean z) {
        final e akM = e.akM();
        if (akM != null) {
            b.dd(z);
            new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).lV(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).eA(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity akI = e.this.akI();
                    if (akI != null && Build.VERSION.SDK_INT >= 21) {
                        akI.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).akw();
        }
    }

    public static void bs(Context context) {
        i(context, !Th());
    }

    public static boolean Th() {
        return bIh;
    }

    public static void dc(boolean z) {
        bIh = z;
    }
}
