package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static String ahd;
    private static String ahe;
    private static final HashMap<String, String> ahf = new HashMap<>();

    public static void dQ(String str) {
        ahe = str;
        if (TextUtils.isEmpty(str)) {
            ahd = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ahf != null) {
            str2 = ahf.get(str);
        }
        if (str2 == null) {
            str2 = dR(str);
            if (ahf != null) {
                ahf.put(str, str2);
            }
        }
        if (str2 != null) {
            ahd = str2 + System.currentTimeMillis();
        }
    }

    private static String dR(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vw() {
        return ahd;
    }

    public static String vx() {
        return ahe;
    }
}
