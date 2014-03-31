package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
/* loaded from: classes.dex */
public final class p {
    private static Toast a;
    private static Handler b = new Handler();
    private static String c = null;
    private static Runnable d = new q();

    public static void a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        b.removeCallbacks(d);
        if (a == null) {
            c = str;
            a = Toast.makeText(context, str, 0);
            a.setGravity(17, 0, com.baidu.adp.lib.util.i.a(context, 100.0f));
        } else if (!str.equals(c)) {
            c = str;
            a.setText(str);
        }
        b.postDelayed(d, 2000L);
        a.show();
    }

    public static void a(Context context, int i) {
        a(context, context.getResources().getString(i));
    }
}
