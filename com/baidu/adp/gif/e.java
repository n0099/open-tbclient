package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] qX = {"ZTE-T U880", "U880"};

    public static boolean M(String str) {
        for (String str2 : qX) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean fg() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean fh() {
        return M(Build.MODEL) && fg() && NSGif.qS;
    }
}
