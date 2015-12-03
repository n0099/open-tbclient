package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bd {
    private static String aco;
    private static String acp;
    private static final HashMap<String, String> acq = new HashMap<>();

    public static void dz(String str) {
        acp = str;
        if (TextUtils.isEmpty(str)) {
            aco = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (acq != null) {
            str2 = acq.get(str);
        }
        if (str2 == null) {
            str2 = dA(str);
            if (acq != null) {
                acq.put(str, str2);
            }
        }
        if (str2 != null) {
            aco = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String dA(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String vB() {
        return aco;
    }

    public static String vC() {
        return acp;
    }
}
