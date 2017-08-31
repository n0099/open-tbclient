package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class as {
    private static String ahO;
    private static String ahP;
    private static final HashMap<String, String> ahQ = new HashMap<>();

    public static void dY(String str) {
        ahP = str;
        if (TextUtils.isEmpty(str)) {
            ahO = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ahQ != null) {
            str2 = ahQ.get(str);
        }
        if (str2 == null) {
            str2 = dZ(str);
            if (ahQ != null) {
                ahQ.put(str, str2);
            }
        }
        if (str2 != null) {
            ahO = str2 + System.currentTimeMillis();
        }
    }

    private static String dZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vZ() {
        return ahO;
    }

    public static String wa() {
        return ahP;
    }
}
