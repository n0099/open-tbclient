package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] vV = {"ZTE-T U880", "U880"};

    public static boolean X(String str) {
        for (String str2 : vV) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean gb() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean gd() {
        return X(Build.MODEL) && gb() && NSGif.vR;
    }
}
