package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] qN = {"ZTE-T U880", "U880"};

    public static boolean G(String str) {
        for (String str2 : qN) {
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
        return G(Build.MODEL) && dE() && NSGif.qJ;
    }
}
