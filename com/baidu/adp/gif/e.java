package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] rh = {"ZTE-T U880", "U880"};

    public static boolean J(String str) {
        for (String str2 : rh) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean fo() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean fp() {
        return J(Build.MODEL) && fo() && NSGif.rb;
    }
}
