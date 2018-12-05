package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aw {
    private static String aCU;
    private static String aCV;
    private static final HashMap<String, String> aCW = new HashMap<>();

    public static void fL(String str) {
        aCV = str;
        if (TextUtils.isEmpty(str)) {
            aCU = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aCW != null) {
            str2 = aCW.get(str);
        }
        if (str2 == null) {
            str2 = fM(str);
            if (aCW != null) {
                aCW.put(str, str2);
            }
        }
        if (str2 != null) {
            aCU = str2 + System.currentTimeMillis();
        }
    }

    private static String fM(String str) {
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
        return aCU;
    }

    public static String Ee() {
        return aCV;
    }
}
