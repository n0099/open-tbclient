package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class be {
    private static String Fn;
    private static String Fo;
    private static final HashMap<String, String> Fp = new HashMap<>();

    public static void bR(String str) {
        Fo = str;
        if (TextUtils.isEmpty(str)) {
            Fn = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (Fp != null) {
            str2 = Fp.get(str);
        }
        if (str2 == null) {
            str2 = bS(str);
            if (Fp != null) {
                Fp.put(str, str2);
            }
        }
        if (str2 != null) {
            Fn = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String bS(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String mO() {
        return Fn;
    }

    public static String mP() {
        return Fo;
    }
}
