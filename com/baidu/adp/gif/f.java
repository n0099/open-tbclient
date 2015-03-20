package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class f {
    public static final String[] qX = {"ZTE-T U880", "U880"};

    public static boolean L(String str) {
        for (String str2 : qX) {
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
        return L(Build.MODEL) && fh() && NSGif.qS;
    }
}
