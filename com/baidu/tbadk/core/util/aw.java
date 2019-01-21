package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aw {
    private static final HashMap<String, String> aDA = new HashMap<>();
    private static String aDy;
    private static String aDz;

    public static void fZ(String str) {
        aDz = str;
        if (TextUtils.isEmpty(str)) {
            aDy = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aDA != null) {
            str2 = aDA.get(str);
        }
        if (str2 == null) {
            str2 = ga(str);
            if (aDA != null) {
                aDA.put(str, str2);
            }
        }
        if (str2 != null) {
            aDy = str2 + System.currentTimeMillis();
        }
    }

    private static String ga(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String Eq() {
        return aDy;
    }

    public static String Er() {
        return aDz;
    }
}
