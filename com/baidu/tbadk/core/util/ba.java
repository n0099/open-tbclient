package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ba {
    private static String agx;
    private static String agy;
    private static final HashMap<String, String> agz = new HashMap<>();

    public static void dy(String str) {
        agy = str;
        if (TextUtils.isEmpty(str)) {
            agx = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (agz != null) {
            str2 = agz.get(str);
        }
        if (str2 == null) {
            str2 = dz(str);
            if (agz != null) {
                agz.put(str, str2);
            }
        }
        if (str2 != null) {
            agx = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dz(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vO() {
        return agx;
    }

    public static String vP() {
        return agy;
    }
}
