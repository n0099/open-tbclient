package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] mi = {"ZTE-T U880", "U880"};

    public static boolean T(String str) {
        for (String str2 : mi) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean eN() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean eO() {
        return T(Build.MODEL) && eN() && NSGif.md;
    }
}
