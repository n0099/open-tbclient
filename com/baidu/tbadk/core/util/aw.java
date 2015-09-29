package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aw {
    private static String abo;
    private static String abp;
    private static final HashMap<String, String> abq = new HashMap<>();

    public static void dn(String str) {
        abp = str;
        if (TextUtils.isEmpty(str)) {
            abo = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (abq != null) {
            str2 = abq.get(str);
        }
        if (str2 == null) {
            str2 = dp(str);
            if (abq != null) {
                abq.put(str, str2);
            }
        }
        if (str2 != null) {
            abo = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dp(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String uT() {
        return abo;
    }

    public static String uU() {
        return abp;
    }
}
