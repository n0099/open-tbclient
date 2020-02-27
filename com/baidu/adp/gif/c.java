package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] oH = {"ZTE-T U880", "U880"};

    public static boolean Z(String str) {
        for (String str2 : oH) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean fi() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean fj() {
        return Z(Build.MODEL) && fi() && NSGif.oD;
    }
}
