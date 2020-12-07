package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] Kz = {"ZTE-T U880", "U880"};

    public static boolean bA(String str) {
        for (String str2 : Kz) {
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
        return bA(Build.MODEL) && lJ() && NSGif.Kv;
    }
}
