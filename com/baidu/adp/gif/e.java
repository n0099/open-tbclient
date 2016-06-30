package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] hc = {"ZTE-T U880", "U880"};

    public static boolean A(String str) {
        for (String str2 : hc) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean bE() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean bF() {
        return A(Build.MODEL) && bE() && NSGif.gX;
    }
}
