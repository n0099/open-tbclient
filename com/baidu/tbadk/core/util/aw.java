package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aw {
    private static String arr;
    private static String ars;
    private static final HashMap<String, String> art = new HashMap<>();

    public static void eM(String str) {
        ars = str;
        if (TextUtils.isEmpty(str)) {
            arr = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (art != null) {
            str2 = art.get(str);
        }
        if (str2 == null) {
            str2 = eN(str);
            if (art != null) {
                art.put(str, str2);
            }
        }
        if (str2 != null) {
            arr = str2 + System.currentTimeMillis();
        }
    }

    private static String eN(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String zC() {
        return arr;
    }

    public static String zD() {
        return ars;
    }
}
