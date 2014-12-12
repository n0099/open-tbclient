package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bf {
    private static String Jx;
    private static String Jy;
    private static final HashMap<String, String> Jz = new HashMap<>();

    public static void cJ(String str) {
        Jy = str;
        if (TextUtils.isEmpty(str)) {
            Jx = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (Jz != null) {
            str2 = Jz.get(str);
        }
        if (str2 == null) {
            str2 = cK(str);
            if (Jz != null) {
                Jz.put(str, str2);
            }
        }
        if (str2 != null) {
            Jx = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String cK(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String pI() {
        return Jx;
    }

    public static String pJ() {
        return Jy;
    }
}
