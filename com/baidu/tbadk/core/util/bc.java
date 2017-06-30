package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bc {
    private static String agD;
    private static String agE;
    private static final HashMap<String, String> agF = new HashMap<>();

    public static void dT(String str) {
        agE = str;
        if (TextUtils.isEmpty(str)) {
            agD = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (agF != null) {
            str2 = agF.get(str);
        }
        if (str2 == null) {
            str2 = dU(str);
            if (agF != null) {
                agF.put(str, str2);
            }
        }
        if (str2 != null) {
            agD = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dU(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vL() {
        return agD;
    }

    public static String vM() {
        return agE;
    }
}
