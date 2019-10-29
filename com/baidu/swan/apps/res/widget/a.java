package com.baidu.swan.apps.res.widget;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.Window;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.t;
import com.baidu.swan.apps.b;
/* loaded from: classes2.dex */
public class a {
    private static boolean DEBUG = b.DEBUG;
    public static final int bhh = Color.parseColor("#80000000");
    public static final boolean bhi = Qj();
    private static int bhj;

    static {
        bhj = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            bhj = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            bhj = 2;
        }
    }

    private static boolean Qj() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (DEBUG) {
            return z & t.getBoolean("sp_key_immersion_switch", z);
        }
        return z;
    }

    public static void b(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(a.c.aiapps_dialog_immersion_status_bar_color);
            Window window = dialog.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
        }
    }

    public static boolean c(Dialog dialog) {
        return ((dialog.getWindow().getAttributes().systemUiVisibility | dialog.getWindow().getDecorView().getSystemUiVisibility()) & 2) != 0;
    }
}
