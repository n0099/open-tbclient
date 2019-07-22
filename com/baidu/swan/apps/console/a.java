package com.baidu.swan.apps.console;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes2.dex */
public class a {
    private static boolean anB;

    public static void h(Context context, boolean z) {
        final com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            b.aV(z);
            new g.a(context).d(context.getString(a.h.aiapps_debug_switch_title)).gC(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.b.a()).ce(false).b(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Activity activity = com.baidu.swan.apps.ae.b.this.getActivity();
                    if (activity != null && Build.VERSION.SDK_INT >= 21) {
                        activity.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).Lx();
        }
    }

    public static void aO(Context context) {
        h(context, !yd());
    }

    public static boolean yd() {
        return anB;
    }

    public static void aU(boolean z) {
        anB = z;
    }
}
