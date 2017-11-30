package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static String ahX;
    private static String ahY;
    private static final HashMap<String, String> ahZ = new HashMap<>();

    public static void dY(String str) {
        ahY = str;
        if (TextUtils.isEmpty(str)) {
            ahX = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ahZ != null) {
            str2 = ahZ.get(str);
        }
        if (str2 == null) {
            str2 = dZ(str);
            if (ahZ != null) {
                ahZ.put(str, str2);
            }
        }
        if (str2 != null) {
            ahX = str2 + System.currentTimeMillis();
        }
    }

    private static String dZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vH() {
        return ahX;
    }

    public static String vI() {
        return ahY;
    }
}
