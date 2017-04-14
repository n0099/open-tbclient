package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ba {
    private static String agL;
    private static String agM;
    private static final HashMap<String, String> agN = new HashMap<>();

    public static void dE(String str) {
        agM = str;
        if (TextUtils.isEmpty(str)) {
            agL = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (agN != null) {
            str2 = agN.get(str);
        }
        if (str2 == null) {
            str2 = dF(str);
            if (agN != null) {
                agN.put(str, str2);
            }
        }
        if (str2 != null) {
            agL = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dF(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String wl() {
        return agL;
    }

    public static String wm() {
        return agM;
    }
}
