package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bg {
    private static String Yu;
    private static String Yv;
    private static final HashMap<String, String> Yw = new HashMap<>();

    public static void dC(String str) {
        Yv = str;
        if (TextUtils.isEmpty(str)) {
            Yu = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (Yw != null) {
            str2 = Yw.get(str);
        }
        if (str2 == null) {
            str2 = dD(str);
            if (Yw != null) {
                Yw.put(str, str2);
            }
        }
        if (str2 != null) {
            Yu = String.valueOf(str2) + System.currentTimeMillis();
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

    public static String uq() {
        return Yu;
    }

    public static String ur() {
        return Yv;
    }
}
