package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] sY = {"ZTE-T U880", "U880"};

    public static boolean M(String str) {
        for (String str2 : sY) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dP() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean dQ() {
        return M(Build.MODEL) && dP() && NSGif.sU;
    }
}
