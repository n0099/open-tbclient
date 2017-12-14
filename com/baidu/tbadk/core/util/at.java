package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static String ahR;
    private static String ahS;
    private static final HashMap<String, String> ahT = new HashMap<>();

    public static void dY(String str) {
        ahS = str;
        if (TextUtils.isEmpty(str)) {
            ahR = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ahT != null) {
            str2 = ahT.get(str);
        }
        if (str2 == null) {
            str2 = dZ(str);
            if (ahT != null) {
                ahT.put(str, str2);
            }
        }
        if (str2 != null) {
            ahR = str2 + System.currentTimeMillis();
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
        return ahR;
    }

    public static String vF() {
        return ahS;
    }
}
