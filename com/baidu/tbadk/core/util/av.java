package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class av {
    private static String abp;
    private static String abq;
    private static final HashMap<String, String> abr = new HashMap<>();

    public static void dj(String str) {
        abq = str;
        if (TextUtils.isEmpty(str)) {
            abp = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (abr != null) {
            str2 = abr.get(str);
        }
        if (str2 == null) {
            str2 = dk(str);
            if (abr != null) {
                abr.put(str, str2);
            }
        }
        if (str2 != null) {
            abp = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dk(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String uV() {
        return abp;
    }

    public static String uW() {
        return abq;
    }
}
