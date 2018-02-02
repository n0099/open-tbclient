package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static String aWg;
    private static String aWh;
    private static final HashMap<String, String> aWi = new HashMap<>();

    public static void ek(String str) {
        aWh = str;
        if (TextUtils.isEmpty(str)) {
            aWg = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aWi != null) {
            str2 = aWi.get(str);
        }
        if (str2 == null) {
            str2 = el(str);
            if (aWi != null) {
                aWi.put(str, str2);
            }
        }
        if (str2 != null) {
            aWg = str2 + System.currentTimeMillis();
        }
    }

    private static String el(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String CW() {
        return aWg;
    }

    public static String CX() {
        return aWh;
    }
}
