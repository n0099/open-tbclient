package com.baidu.swan.apps.console;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.dialog.e;
/* loaded from: classes2.dex */
public class a {
    private static boolean amG;

    public static void j(Context context, boolean z) {
        final com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            b.aQ(z);
            new e.a(context).d(context.getString(b.h.aiapps_debug_switch_title)).gd(context.getString(z ? b.h.aiapps_open_debug : b.h.aiapps_close_debug)).a(new com.baidu.swan.apps.view.b.a()).bR(false).b(b.h.aiapps_confirm, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.apps.console.a.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Activity activity = com.baidu.swan.apps.ae.b.this.getActivity();
                    if (activity != null && Build.VERSION.SDK_INT >= 21) {
                        activity.finishAndRemoveTask();
                    }
                    System.exit(0);
                }
            }).Iu();
        }
    }

    public static void bv(Context context) {
        j(context, !wI());
    }

    public static boolean wI() {
        return amG;
    }

    public static void aP(boolean z) {
        amG = z;
    }
}
