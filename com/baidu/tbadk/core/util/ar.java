package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ar {
    private static String agZ;
    private static String aha;
    private static final HashMap<String, String> ahb = new HashMap<>();

    public static void dW(String str) {
        aha = str;
        if (TextUtils.isEmpty(str)) {
            agZ = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ahb != null) {
            str2 = ahb.get(str);
        }
        if (str2 == null) {
            str2 = dX(str);
            if (ahb != null) {
                ahb.put(str, str2);
            }
        }
        if (str2 != null) {
            agZ = str2 + System.currentTimeMillis();
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

    public static String vR() {
        return agZ;
    }

    public static String vS() {
        return aha;
    }
}
