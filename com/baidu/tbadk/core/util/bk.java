package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bk {
    private static String JN;
    private static String JO;
    private static final HashMap<String, String> JP = new HashMap<>();

    public static void cF(String str) {
        JO = str;
        if (TextUtils.isEmpty(str)) {
            JN = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (JP != null) {
            str2 = JP.get(str);
        }
        if (str2 == null) {
            str2 = cG(str);
            if (JP != null) {
                JP.put(str, str2);
            }
        }
        if (str2 != null) {
            JN = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String cG(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String pM() {
        return JN;
    }

    public static String pN() {
        return JO;
    }
}
