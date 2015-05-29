package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bg {
    private static String Wi;
    private static String Wj;
    private static final HashMap<String, String> Wk = new HashMap<>();

    public static void dc(String str) {
        Wj = str;
        if (TextUtils.isEmpty(str)) {
            Wi = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (Wk != null) {
            str2 = Wk.get(str);
        }
        if (str2 == null) {
            str2 = dd(str);
            if (Wk != null) {
                Wk.put(str, str2);
            }
        }
        if (str2 != null) {
            Wi = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dd(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String tM() {
        return Wi;
    }

    public static String tN() {
        return Wj;
    }
}
