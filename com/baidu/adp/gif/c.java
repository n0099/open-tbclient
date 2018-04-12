package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class c {
    public static final String[] pH = {"ZTE-T U880", "U880"};

    public static boolean L(String str) {
        for (String str2 : pH) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dm() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean dn() {
        return L(Build.MODEL) && dm() && NSGif.pD;
    }
}
