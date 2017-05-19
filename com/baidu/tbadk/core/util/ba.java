package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ba {
    private static String agd;
    private static String agf;
    private static final HashMap<String, String> agg = new HashMap<>();

    public static void dC(String str) {
        agf = str;
        if (TextUtils.isEmpty(str)) {
            agd = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (agg != null) {
            str2 = agg.get(str);
        }
        if (str2 == null) {
            str2 = dD(str);
            if (agg != null) {
                agg.put(str, str2);
            }
        }
        if (str2 != null) {
            agd = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dD(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vz() {
        return agd;
    }

    public static String vA() {
        return agf;
    }
}
