package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ax {
    private static String abr;
    private static String abt;
    private static final HashMap<String, String> abu = new HashMap<>();

    public static void dp(String str) {
        abt = str;
        if (TextUtils.isEmpty(str)) {
            abr = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (abu != null) {
            str2 = abu.get(str);
        }
        if (str2 == null) {
            str2 = dq(str);
            if (abu != null) {
                abu.put(str, str2);
            }
        }
        if (str2 != null) {
            abr = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dq(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String uU() {
        return abr;
    }

    public static String uV() {
        return abt;
    }
}
