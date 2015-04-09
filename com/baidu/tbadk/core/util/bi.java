package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class bi {
    private static String VB;
    private static String VC;
    private static final HashMap<String, String> VD = new HashMap<>();

    public static void cO(String str) {
        VC = str;
        if (TextUtils.isEmpty(str)) {
            VB = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (VD != null) {
            str2 = VD.get(str);
        }
        if (str2 == null) {
            str2 = cP(str);
            if (VD != null) {
                VD.put(str, str2);
            }
        }
        if (str2 != null) {
            VB = String.valueOf(str2) + System.currentTimeMillis();
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
        return VB;
    }

    public static String tk() {
        return VC;
    }
}
