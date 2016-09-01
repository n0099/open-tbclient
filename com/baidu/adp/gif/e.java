package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] jX = {"ZTE-T U880", "U880"};

    public static boolean D(String str) {
        for (String str2 : jX) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean cy() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean cz() {
        return D(Build.MODEL) && cy() && NSGif.jS;
    }
}
