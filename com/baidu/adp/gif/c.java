package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] oD = {"ZTE-T U880", "U880"};

    public static boolean Y(String str) {
        for (String str2 : oD) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean fh() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean fi() {
        return Y(Build.MODEL) && fh() && NSGif.oz;
    }
}
