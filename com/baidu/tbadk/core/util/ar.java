package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ar {
    private static String ais;
    private static String ait;
    private static final HashMap<String, String> aiu = new HashMap<>();

    public static void ec(String str) {
        ait = str;
        if (TextUtils.isEmpty(str)) {
            ais = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aiu != null) {
            str2 = aiu.get(str);
        }
        if (str2 == null) {
            str2 = ed(str);
            if (aiu != null) {
                aiu.put(str, str2);
            }
        }
        if (str2 != null) {
            ais = str2 + System.currentTimeMillis();
        }
    }

    private static String ed(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String wb() {
        return ais;
    }

    public static String wc() {
        return ait;
    }
}
