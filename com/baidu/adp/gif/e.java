package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] qZ = {"ZTE-T U880", "U880"};

    public static boolean M(String str) {
        for (String str2 : qZ) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean fj() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean fk() {
        return M(Build.MODEL) && fj() && NSGif.qU;
    }
}
