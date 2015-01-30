package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bk {
    private static String JQ;
    private static String JR;
    private static final HashMap<String, String> JS = new HashMap<>();

    public static void cI(String str) {
        JR = str;
        if (TextUtils.isEmpty(str)) {
            JQ = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (JS != null) {
            str2 = JS.get(str);
        }
        if (str2 == null) {
            str2 = cJ(str);
            if (JS != null) {
                JS.put(str, str2);
            }
        }
        if (str2 != null) {
            JQ = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String cJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String pT() {
        return JQ;
    }

    public static String pU() {
        return JR;
    }
}
