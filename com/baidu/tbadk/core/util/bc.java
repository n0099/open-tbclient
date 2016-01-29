package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bc {
    private static String adq;
    private static String adr;
    private static final HashMap<String, String> ads = new HashMap<>();

    public static void dz(String str) {
        adr = str;
        if (TextUtils.isEmpty(str)) {
            adq = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ads != null) {
            str2 = ads.get(str);
        }
        if (str2 == null) {
            str2 = dA(str);
            if (ads != null) {
                ads.put(str, str2);
            }
        }
        if (str2 != null) {
            adq = String.valueOf(str2) + System.currentTimeMillis();
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

    public static String wr() {
        return adq;
    }

    public static String ws() {
        return adr;
    }
}
