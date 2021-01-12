package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] JX = {"ZTE-T U880", "U880"};

    public static boolean bu(String str) {
        for (String str2 : JX) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean lf() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean lg() {
        return bu(Build.MODEL) && lf() && NSGif.JT;
    }
}
