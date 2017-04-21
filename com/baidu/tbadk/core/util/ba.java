package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ba {
    private static String agM;
    private static String agN;
    private static final HashMap<String, String> agO = new HashMap<>();

    public static void dE(String str) {
        agN = str;
        if (TextUtils.isEmpty(str)) {
            agM = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (agO != null) {
            str2 = agO.get(str);
        }
        if (str2 == null) {
            str2 = dF(str);
            if (agO != null) {
                agO.put(str, str2);
            }
        }
        if (str2 != null) {
            agM = String.valueOf(str2) + System.currentTimeMillis();
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
        return agM;
    }

    public static String wm() {
        return agN;
    }
}
