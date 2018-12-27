package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aw {
    private static String aCV;
    private static String aCW;
    private static final HashMap<String, String> aCX = new HashMap<>();

    public static void fM(String str) {
        aCW = str;
        if (TextUtils.isEmpty(str)) {
            aCV = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aCX != null) {
            str2 = aCX.get(str);
        }
        if (str2 == null) {
            str2 = fN(str);
            if (aCX != null) {
                aCX.put(str, str2);
            }
        }
        if (str2 != null) {
            aCV = str2 + System.currentTimeMillis();
        }
    }

    private static String fN(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String Ed() {
        return aCV;
    }

    public static String Ee() {
        return aCW;
    }
}
