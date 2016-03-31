package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] rr = {"ZTE-T U880", "U880"};

    public static boolean J(String str) {
        for (String str2 : rr) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean fp() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean fq() {
        return J(Build.MODEL) && fp() && NSGif.rl;
    }
}
