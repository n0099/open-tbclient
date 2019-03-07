package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] yR = {"ZTE-T U880", "U880"};

    public static boolean ap(String str) {
        for (String str2 : yR) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hw() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean hx() {
        return ap(Build.MODEL) && hw() && NSGif.yN;
    }
}
