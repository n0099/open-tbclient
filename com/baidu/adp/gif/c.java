package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] vM = {"ZTE-T U880", "U880"};

    public static boolean Y(String str) {
        for (String str2 : vM) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean ga() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean gb() {
        return Y(Build.MODEL) && ga() && NSGif.vI;
    }
}
