package com.baidu.adp.gif;

import android.os.Build;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class d {
    public static final String[] a = {"ZTE-T U880", "U880"};

    public static boolean a(String str) {
        for (String str2 : a) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT > 7;
    }

    public static boolean a() {
        String str = Build.MODEL;
        BdLog.d("NSGifCompat", "shouldUseNSGif", "model: " + str);
        return a(str) && b() && NSGif.a;
    }
}
