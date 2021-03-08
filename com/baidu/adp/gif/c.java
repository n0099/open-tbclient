package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] Lp = {"ZTE-T U880", "U880"};

    public static boolean by(String str) {
        for (String str2 : Lp) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean le() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean lf() {
        return by(Build.MODEL) && le() && NSGif.Ll;
    }
}
