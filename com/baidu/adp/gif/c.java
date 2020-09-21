package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] Jr = {"ZTE-T U880", "U880"};

    public static boolean bx(String str) {
        for (String str2 : Jr) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean lI() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean lJ() {
        return bx(Build.MODEL) && lI() && NSGif.Jn;
    }
}
