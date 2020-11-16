package com.baidu.minivideo.arface.utils;

import android.util.Log;
/* loaded from: classes14.dex */
public final class h {
    public static void d(String str, String str2) {
        if (str2.length() > 2001) {
            for (int i = 0; i < str2.length(); i += 2001) {
                if (i + 2001 < str2.length()) {
                    d(3, str, str2.substring(i, i + 2001));
                } else {
                    d(3, str, str2.substring(i));
                }
            }
            return;
        }
        d(3, str, str2);
    }

    private static void d(int i, String str, String str2) {
        switch (i) {
            case 2:
                Log.v(str, str2);
                return;
            case 3:
                Log.d(str, str2);
                return;
            case 4:
                Log.i(str, str2);
                return;
            case 5:
                Log.w(str, str2);
                return;
            case 6:
                Log.e(str, str2);
                return;
            default:
                Log.d(str, str2);
                return;
        }
    }
}
