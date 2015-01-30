package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class f {
    public static final String[] fE = {"ZTE-T U880", "U880"};

    public static boolean D(String str) {
        for (String str2 : fE) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean bJ() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean bK() {
        return D(Build.MODEL) && bJ() && NSGif.fz;
    }
}
