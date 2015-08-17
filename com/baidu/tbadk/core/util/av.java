package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class av {
    private static String abg;
    private static String abh;
    private static final HashMap<String, String> abi = new HashMap<>();

    public static void dd(String str) {
        abh = str;
        if (TextUtils.isEmpty(str)) {
            abg = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (abi != null) {
            str2 = abi.get(str);
        }
        if (str2 == null) {
            str2 = de(str);
            if (abi != null) {
                abi.put(str, str2);
            }
        }
        if (str2 != null) {
            abg = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String de(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String uP() {
        return abg;
    }

    public static String uQ() {
        return abh;
    }
}
