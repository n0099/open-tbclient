package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class be {
    private static String Yc;
    private static String Yd;
    private static final HashMap<String, String> Ye = new HashMap<>();

    public static void dz(String str) {
        Yd = str;
        if (TextUtils.isEmpty(str)) {
            Yc = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (Ye != null) {
            str2 = Ye.get(str);
        }
        if (str2 == null) {
            str2 = dA(str);
            if (Ye != null) {
                Ye.put(str, str2);
            }
        }
        if (str2 != null) {
            Yc = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dA(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String uq() {
        return Yc;
    }

    public static String ur() {
        return Yd;
    }
}
