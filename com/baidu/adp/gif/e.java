package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] rl = {"ZTE-T U880", "U880"};

    public static boolean z(String str) {
        for (String str2 : rl) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dE() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean dF() {
        return z(Build.MODEL) && dE() && NSGif.rg;
    }
}
