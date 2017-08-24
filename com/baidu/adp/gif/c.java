package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] sZ = {"ZTE-T U880", "U880"};

    public static boolean N(String str) {
        for (String str2 : sZ) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dP() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean dQ() {
        return N(Build.MODEL) && dP() && NSGif.sV;
    }
}
