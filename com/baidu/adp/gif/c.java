package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] IB = {"ZTE-T U880", "U880"};

    public static boolean bq(String str) {
        for (String str2 : IB) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean kf() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean kg() {
        return bq(Build.MODEL) && kf() && NSGif.Iw;
    }
}
