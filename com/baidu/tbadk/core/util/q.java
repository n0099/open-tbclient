package com.baidu.tbadk.core.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class q {
    private static Toast a;
    private static Handler b = new Handler();
    private static String c = null;
    private static Runnable d = new r();

    public static void a(Context context, String str, int i) {
        if (str != null && str.length() > 0) {
            b.removeCallbacks(d);
            if (a != null) {
                if (!str.equals(c)) {
                    c = str;
                    a.setText(str);
                }
            } else {
                c = str;
                a = Toast.makeText(context, str, 0);
                a.setGravity(17, 0, com.baidu.adp.lib.util.h.a(context, 100.0f));
            }
            b.postDelayed(d, i);
            a.show();
        }
    }

    public static void a(Context context, String str) {
        a(context, str, TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI);
    }

    public static void a(Context context, int i) {
        a(context, context.getResources().getString(i));
    }
}
