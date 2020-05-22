package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] Ia = {"ZTE-T U880", "U880"};

    public static boolean bp(String str) {
        for (String str2 : Ia) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean jP() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean jQ() {
        return bp(Build.MODEL) && jP() && NSGif.HW;
    }
}
