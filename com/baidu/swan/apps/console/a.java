package com.baidu.swan.apps.console;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
/* loaded from: classes2.dex */
public class a {
    private static boolean amY;

    public static void h(Context context, boolean z) {
        final com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            b.aS(z);
            new g.a(context).d(context.getString(a.h.aiapps_debug_switch_title)).gx(context.getString(z ? a.h.aiapps_open_debug : a.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.b.a()).cb(false).b(a.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Activity activity = com.baidu.swan.apps.ae.b.this.getActivity();
                    if (activity != null && Build.VERSION.SDK_INT >= 21) {
                        activity.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).KK();
        }
    }

    public static void aO(Context context) {
        h(context, !xz());
    }

    public static boolean xz() {
        return amY;
    }

    public static void aR(boolean z) {
        amY = z;
    }
}
