package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] qM = {"ZTE-T U880", "U880"};

    public static boolean G(String str) {
        for (String str2 : qM) {
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
        return G(Build.MODEL) && dF() && NSGif.qI;
    }
}
