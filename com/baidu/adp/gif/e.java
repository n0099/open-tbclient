package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] rN = {"ZTE-T U880", "U880"};

    public static boolean C(String str) {
        for (String str2 : rN) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dF() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean dG() {
        return C(Build.MODEL) && dF() && NSGif.rI;
    }
}
