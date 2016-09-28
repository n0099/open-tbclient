package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bf {
    private static String acf;
    private static String acg;
    private static final HashMap<String, String> ach = new HashMap<>();

    public static void dG(String str) {
        acg = str;
        if (TextUtils.isEmpty(str)) {
            acf = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ach != null) {
            str2 = ach.get(str);
        }
        if (str2 == null) {
            str2 = dH(str);
            if (ach != null) {
                ach.put(str, str2);
            }
        }
        if (str2 != null) {
            acf = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dH(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vJ() {
        return acf;
    }

    public static String vK() {
        return acg;
    }
}
