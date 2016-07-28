package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] hF = {"ZTE-T U880", "U880"};

    public static boolean C(String str) {
        for (String str2 : hF) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean bD() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean bE() {
        return C(Build.MODEL) && bD() && NSGif.hA;
    }
}
