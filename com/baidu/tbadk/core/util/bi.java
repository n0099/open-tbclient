package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bi {
    private static String VA;
    private static final HashMap<String, String> VB = new HashMap<>();
    private static String Vz;

    public static void cO(String str) {
        VA = str;
        if (TextUtils.isEmpty(str)) {
            Vz = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (VB != null) {
            str2 = VB.get(str);
        }
        if (str2 == null) {
            str2 = cP(str);
            if (VB != null) {
                VB.put(str, str2);
            }
        }
        if (str2 != null) {
            Vz = String.valueOf(str2) + System.currentTimeMillis();
        }
    }

    private static String cP(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String tj() {
        return Vz;
    }

    public static String tk() {
        return VA;
    }
}
