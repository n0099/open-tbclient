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
    private static boolean bWD;

    public static void k(Context context, boolean z) {
        final e arv = e.arv();
        if (arv != null) {
            b.dy(z);
            new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).og(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).fh(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity arp = e.this.arp();
                    if (arp != null && Build.VERSION.SDK_INT >= 21) {
                        arp.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).ard();
        }
    }

    public static void bG(Context context) {
        k(context, !XA());
    }

    public static boolean XA() {
        return bWD;
    }

    public static void dx(boolean z) {
        bWD = z;
    }
}
