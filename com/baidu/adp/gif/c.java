package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] afp = {"ZTE-T U880", "U880"};

    public static boolean O(String str) {
        for (String str2 : afp) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean li() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean lj() {
        return O(Build.MODEL) && li() && NSGif.afl;
    }
}
