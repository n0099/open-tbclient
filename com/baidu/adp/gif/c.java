package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] wB = {"ZTE-T U880", "U880"};

    public static boolean Y(String str) {
        for (String str2 : wB) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean gq() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean gr() {
        return Y(Build.MODEL) && gq() && NSGif.wx;
    }
}
