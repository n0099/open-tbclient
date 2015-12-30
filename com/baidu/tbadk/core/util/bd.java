package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bd {
    private static String acT;
    private static String acU;
    private static final HashMap<String, String> acV = new HashMap<>();

    public static void dC(String str) {
        acU = str;
        if (TextUtils.isEmpty(str)) {
            acT = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (acV != null) {
            str2 = acV.get(str);
        }
        if (str2 == null) {
            str2 = dD(str);
            if (acV != null) {
                acV.put(str, str2);
            }
        }
        if (str2 != null) {
            acT = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dD(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vl() {
        return acT;
    }

    public static String vm() {
        return acU;
    }
}
