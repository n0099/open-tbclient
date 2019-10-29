package com.baidu.swan.apps.x.a;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.an.z;
/* loaded from: classes2.dex */
public class d {
    public static int B(String str, int i) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.console.c.w("map", "color string is empty, use default " + Integer.toHexString(i));
            return i;
        }
        try {
            if (str.charAt(0) == '#') {
                String substring = str.substring(1);
                if (substring.length() != 6 && substring.length() != 8) {
                    throw new IllegalArgumentException("char count not right");
                }
                if (substring.length() == 6) {
                    i2 = (int) (Long.parseLong(substring, 16) | (-16777216));
                } else {
                    i2 = (int) Long.parseLong(substring.substring(6) + substring.substring(0, 6), 16);
                }
            } else {
                i2 = Color.parseColor(str);
            }
        } catch (IllegalArgumentException e) {
            com.baidu.swan.apps.console.c.w("map", "parse color error, use default " + Integer.toHexString(i));
            i2 = i;
        }
        return i2;
    }

    public static float e(double d) {
        return (float) (z.getDensity(AppRuntime.getAppContext()) * d);
    }
}
