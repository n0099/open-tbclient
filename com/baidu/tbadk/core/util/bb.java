package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bb {
    private static String abV;
    private static String abW;
    private static final HashMap<String, String> abX = new HashMap<>();

    public static void dG(String str) {
        abW = str;
        if (TextUtils.isEmpty(str)) {
            abV = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (abX != null) {
            str2 = abX.get(str);
        }
        if (str2 == null) {
            str2 = dH(str);
            if (abX != null) {
                abX.put(str, str2);
            }
        }
        if (str2 != null) {
            abV = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dH(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vx() {
        return abV;
    }

    public static String vy() {
        return abW;
    }
}
