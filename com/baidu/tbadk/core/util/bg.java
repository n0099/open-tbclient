package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bg {
    private static String Zd;
    private static String Ze;
    private static final HashMap<String, String> Zf = new HashMap<>();

    public static void dB(String str) {
        Ze = str;
        if (TextUtils.isEmpty(str)) {
            Zd = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (Zf != null) {
            str2 = Zf.get(str);
        }
        if (str2 == null) {
            str2 = dC(str);
            if (Zf != null) {
                Zf.put(str, str2);
            }
        }
        if (str2 != null) {
            Zd = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dC(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String uq() {
        return Zd;
    }

    public static String ur() {
        return Ze;
    }
}
