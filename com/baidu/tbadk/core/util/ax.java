package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ax {
    private static String abx;
    private static String aby;
    private static final HashMap<String, String> abz = new HashMap<>();

    public static void dp(String str) {
        aby = str;
        if (TextUtils.isEmpty(str)) {
            abx = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (abz != null) {
            str2 = abz.get(str);
        }
        if (str2 == null) {
            str2 = dq(str);
            if (abz != null) {
                abz.put(str, str2);
            }
        }
        if (str2 != null) {
            abx = String.valueOf(str2) + System.currentTimeMillis();
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

    public static String uV() {
        return abx;
    }

    public static String uW() {
        return aby;
    }
}
