package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] JH = {"ZTE-T U880", "U880"};

    public static boolean bx(String str) {
        for (String str2 : JH) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean lJ() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean lK() {
        return bx(Build.MODEL) && lJ() && NSGif.JD;
    }
}
