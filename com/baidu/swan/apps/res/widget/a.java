package com.baidu.swan.apps.res.widget;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.Window;
import com.baidu.swan.apps.an.r;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.c;
/* loaded from: classes2.dex */
public class a {
    private static boolean DEBUG = c.DEBUG;
    public static final int aKU = Color.parseColor("#80000000");
    public static final boolean aKV = Il();
    private static int aKW;

    static {
        aKW = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            aKW = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            aKW = 2;
        }
    }

    private static boolean Il() {
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (DEBUG) {
            return z & r.getBoolean("sp_key_immersion_switch", z);
        }
        return z;
    }

    public static void a(Dialog dialog) {
        if (Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(b.c.aiapps_dialog_immersion_status_bar_color);
            Window window = dialog.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
        }
    }

    public static boolean b(Dialog dialog) {
        return ((dialog.getWindow().getAttributes().systemUiVisibility | dialog.getWindow().getDecorView().getSystemUiVisibility()) & 2) != 0;
    }
}
