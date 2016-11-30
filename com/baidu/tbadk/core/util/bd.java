package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bd {
    private static String acD;
    private static String acE;
    private static final HashMap<String, String> acF = new HashMap<>();

    public static void dI(String str) {
        acE = str;
        if (TextUtils.isEmpty(str)) {
            acD = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (acF != null) {
            str2 = acF.get(str);
        }
        if (str2 == null) {
            str2 = dJ(str);
            if (acF != null) {
                acF.put(str, str2);
            }
        }
        if (str2 != null) {
            acD = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vN() {
        return acD;
    }

    public static String vO() {
        return acE;
    }
}
