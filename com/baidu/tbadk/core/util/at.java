package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static String aWd;
    private static String aWe;
    private static final HashMap<String, String> aWf = new HashMap<>();

    public static void ef(String str) {
        aWe = str;
        if (TextUtils.isEmpty(str)) {
            aWd = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aWf != null) {
            str2 = aWf.get(str);
        }
        if (str2 == null) {
            str2 = eg(str);
            if (aWf != null) {
                aWf.put(str, str2);
            }
        }
        if (str2 != null) {
            aWd = str2 + System.currentTimeMillis();
        }
    }

    private static String eg(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String CV() {
        return aWd;
    }

    public static String CW() {
        return aWe;
    }
}
