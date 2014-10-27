package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class f {
    public static final String[] dx = {"ZTE-T U880", "U880"};

    public static boolean o(String str) {
        for (String str2 : dx) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean bk() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean bl() {
        return o(Build.MODEL) && bk() && NSGif.ds;
    }
}
