package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class f {
    public static final String[] a = {"ZTE-T U880", "U880"};

    public static boolean a(String str) {
        for (String str2 : a) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean a() {
        String str = Build.MODEL;
        com.baidu.adp.lib.util.f.e("NSGifCompat", "shouldUseNSGif", "model: " + str);
        return a(str) && b() && NSGif.a;
    }
}
