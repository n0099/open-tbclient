package com.baidu.c.a.e;

import android.graphics.Color;
/* loaded from: classes13.dex */
public class b {
    public static int cG(String str) {
        if (str == null || str.length() == 0) {
            return Integer.MAX_VALUE;
        }
        try {
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            return Color.parseColor(str);
        } catch (Throwable th) {
            return Integer.MAX_VALUE;
        }
    }
}
