package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bg {
    private static String abS;
    private static String abT;
    private static final HashMap<String, String> abU = new HashMap<>();

    public static void dD(String str) {
        abT = str;
        if (TextUtils.isEmpty(str)) {
            abS = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (abU != null) {
            str2 = abU.get(str);
        }
        if (str2 == null) {
            str2 = dE(str);
            if (abU != null) {
                abU.put(str, str2);
            }
        }
        if (str2 != null) {
            abS = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dE(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vv() {
        return abS;
    }

    public static String vw() {
        return abT;
    }
}
