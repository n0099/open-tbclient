package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class f {
    public static final String[] fC = {"ZTE-T U880", "U880"};

    public static boolean D(String str) {
        for (String str2 : fC) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean bL() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean bM() {
        return D(Build.MODEL) && bL() && NSGif.fx;
    }
}
