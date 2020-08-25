package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] Jj = {"ZTE-T U880", "U880"};

    public static boolean bv(String str) {
        for (String str2 : Jj) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean lE() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean lF() {
        return bv(Build.MODEL) && lE() && NSGif.Jf;
    }
}
