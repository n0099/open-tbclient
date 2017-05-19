package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] rs = {"ZTE-T U880", "U880"};

    public static boolean z(String str) {
        for (String str2 : rs) {
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
        return z(Build.MODEL) && dF() && NSGif.rm;
    }
}
