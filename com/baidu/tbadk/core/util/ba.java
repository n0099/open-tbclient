package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ba {
    private static String afU;
    private static String afV;
    private static final HashMap<String, String> afW = new HashMap<>();

    public static void dz(String str) {
        afV = str;
        if (TextUtils.isEmpty(str)) {
            afU = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (afW != null) {
            str2 = afW.get(str);
        }
        if (str2 == null) {
            str2 = dA(str);
            if (afW != null) {
                afW.put(str, str2);
            }
        }
        if (str2 != null) {
            afU = String.valueOf(str2) + System.currentTimeMillis();
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

    public static String vw() {
        return afU;
    }

    public static String vx() {
        return afV;
    }
}
