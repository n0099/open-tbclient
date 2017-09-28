package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static String ahp;
    private static String ahq;
    private static final HashMap<String, String> ahr = new HashMap<>();

    public static void dR(String str) {
        ahq = str;
        if (TextUtils.isEmpty(str)) {
            ahp = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ahr != null) {
            str2 = ahr.get(str);
        }
        if (str2 == null) {
            str2 = dS(str);
            if (ahr != null) {
                ahr.put(str, str2);
            }
        }
        if (str2 != null) {
            ahp = str2 + System.currentTimeMillis();
        }
    }

    private static String dS(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vD() {
        return ahp;
    }

    public static String vE() {
        return ahq;
    }
}
