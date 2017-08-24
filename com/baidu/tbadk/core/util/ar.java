package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ar {
    private static String aiu;
    private static String aiv;
    private static final HashMap<String, String> aiw = new HashMap<>();

    public static void eg(String str) {
        aiv = str;
        if (TextUtils.isEmpty(str)) {
            aiu = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aiw != null) {
            str2 = aiw.get(str);
        }
        if (str2 == null) {
            str2 = eh(str);
            if (aiw != null) {
                aiw.put(str, str2);
            }
        }
        if (str2 != null) {
            aiu = str2 + System.currentTimeMillis();
        }
    }

    private static String eh(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith("activity") || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String wc() {
        return aiu;
    }

    public static String wd() {
        return aiv;
    }
}
