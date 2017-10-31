package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static String ahA;
    private static String ahB;
    private static final HashMap<String, String> ahC = new HashMap<>();

    public static void dW(String str) {
        ahB = str;
        if (TextUtils.isEmpty(str)) {
            ahA = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ahC != null) {
            str2 = ahC.get(str);
        }
        if (str2 == null) {
            str2 = dX(str);
            if (ahC != null) {
                ahC.put(str, str2);
            }
        }
        if (str2 != null) {
            ahA = str2 + System.currentTimeMillis();
        }
    }

    private static String dX(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vE() {
        return ahA;
    }

    public static String vF() {
        return ahB;
    }
}
