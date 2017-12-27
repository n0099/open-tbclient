package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class at {
    private static String aWe;
    private static String aWf;
    private static final HashMap<String, String> aWg = new HashMap<>();

    public static void ef(String str) {
        aWf = str;
        if (TextUtils.isEmpty(str)) {
            aWe = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aWg != null) {
            str2 = aWg.get(str);
        }
        if (str2 == null) {
            str2 = eg(str);
            if (aWg != null) {
                aWg.put(str, str2);
            }
        }
        if (str2 != null) {
            aWe = str2 + System.currentTimeMillis();
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

    public static String De() {
        return aWe;
    }

    public static String Df() {
        return aWf;
    }
}
