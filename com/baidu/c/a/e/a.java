package com.baidu.c.a.e;

import android.graphics.Color;
/* loaded from: classes3.dex */
public class a {
    public static int cE(String str) {
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
