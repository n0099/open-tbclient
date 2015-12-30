package com.baidu.adp.gif;

import android.os.Build;
/* loaded from: classes.dex */
public class e {
    public static final String[] ra = {"ZTE-T U880", "U880"};

    public static boolean K(String str) {
        for (String str2 : ra) {
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
        return K(Build.MODEL) && fg() && NSGif.qV;
    }
}
