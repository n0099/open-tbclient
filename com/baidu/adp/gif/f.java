package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class f {
    public static final String[] rc = {"ZTE-T U880", "U880"};

    public static boolean N(String str) {
        for (String str2 : rc) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean fm() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean fn() {
        return N(Build.MODEL) && fm() && NSGif.qX;
    }
}
