package com.baidu.mobstat;

import android.os.Build;
/* loaded from: classes2.dex */
public final class y {
    public static boolean a = true;
    public static final String b;
    public static final String c;
    public static String d;
    public static String e;
    public static String f;

    static {
        String str;
        String str2;
        if (Build.VERSION.SDK_INT < 9) {
            str = "http://datax.baidu.com/xs.gif";
        } else {
            str = "https://datax.baidu.com/xs.gif";
        }
        b = str;
        if (Build.VERSION.SDK_INT < 9) {
            str2 = "http://dxp.baidu.com/upgrade";
        } else {
            str2 = "https://dxp.baidu.com/upgrade";
        }
        c = str2;
        d = ".mtj_timestamp";
        f = "__send_log_data_";
        e = ".confd";
    }
}
