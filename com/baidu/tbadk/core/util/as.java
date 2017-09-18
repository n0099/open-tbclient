package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class as {
    private static String ahN;
    private static String ahO;
    private static final HashMap<String, String> ahP = new HashMap<>();

    public static void dY(String str) {
        ahO = str;
        if (TextUtils.isEmpty(str)) {
            ahN = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ahP != null) {
            str2 = ahP.get(str);
        }
        if (str2 == null) {
            str2 = dZ(str);
            if (ahP != null) {
                ahP.put(str, str2);
            }
        }
        if (str2 != null) {
            ahN = str2 + System.currentTimeMillis();
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
        return ahN;
    }

    public static String wa() {
        return ahO;
    }
}
