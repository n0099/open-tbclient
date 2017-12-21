package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static String ahU;
    private static String ahV;
    private static final HashMap<String, String> ahW = new HashMap<>();

    public static void dY(String str) {
        ahV = str;
        if (TextUtils.isEmpty(str)) {
            ahU = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ahW != null) {
            str2 = ahW.get(str);
        }
        if (str2 == null) {
            str2 = dZ(str);
            if (ahW != null) {
                ahW.put(str, str2);
            }
        }
        if (str2 != null) {
            ahU = str2 + System.currentTimeMillis();
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

    public static String vE() {
        return ahU;
    }

    public static String vF() {
        return ahV;
    }
}
