package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public final class f {
    public static final String[] a = {"ZTE-T U880", "U880"};

    private static boolean a(String str) {
        for (String str2 : a) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a() {
        String str = Build.MODEL;
        com.baidu.adp.lib.util.e.e("NSGifCompat", "shouldUseNSGif", "model: " + str);
        if (a(str)) {
            if ((Build.VERSION.SDK_INT > 7) && NSGif.a) {
                return true;
            }
        }
        return false;
    }
}
