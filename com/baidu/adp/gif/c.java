package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] HL = {"ZTE-T U880", "U880"};

    public static boolean bo(String str) {
        for (String str2 : HL) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean jN() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean jO() {
        return bo(Build.MODEL) && jN() && NSGif.HH;
    }
}
