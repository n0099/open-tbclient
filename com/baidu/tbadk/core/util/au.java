package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.ar.util.Constants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class au {
    private static String aXP;
    private static String aXQ;
    private static final HashMap<String, String> aXR = new HashMap<>();

    public static void ev(String str) {
        aXQ = str;
        if (TextUtils.isEmpty(str)) {
            aXP = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(Constants.DOT);
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aXR != null) {
            str2 = aXR.get(str);
        }
        if (str2 == null) {
            str2 = ew(str);
            if (aXR != null) {
                aXR.put(str, str2);
            }
        }
        if (str2 != null) {
            aXP = str2 + System.currentTimeMillis();
        }
    }

    private static String ew(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String Dq() {
        return aXP;
    }

    public static String Dr() {
        return aXQ;
    }
}
