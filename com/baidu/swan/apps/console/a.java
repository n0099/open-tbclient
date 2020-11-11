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
    private static boolean cFc;

    public static void n(Context context, boolean z) {
        final e aHu = e.aHu();
        if (aHu != null) {
            b.ey(z);
            new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).rR(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.c.a()).gr(false).c(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    SwanAppActivity aHo = e.this.aHo();
                    if (aHo != null && Build.VERSION.SDK_INT >= 21) {
                        aHo.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).aHb();
        }
    }

    public static void bS(Context context) {
        n(context, !alv());
    }

    public static boolean alv() {
        return cFc;
    }

    public static void ex(boolean z) {
        cFc = z;
    }
}
