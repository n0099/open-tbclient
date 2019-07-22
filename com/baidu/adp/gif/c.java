package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] wD = {"ZTE-T U880", "U880"};

    public static boolean Y(String str) {
        for (String str2 : wD) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean gz() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean gA() {
        return Y(Build.MODEL) && gz() && NSGif.wz;
    }
}
