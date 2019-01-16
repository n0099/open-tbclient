package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aw {
    private static String aDx;
    private static String aDy;
    private static final HashMap<String, String> aDz = new HashMap<>();

    public static void fZ(String str) {
        aDy = str;
        if (TextUtils.isEmpty(str)) {
            aDx = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (aDz != null) {
            str2 = aDz.get(str);
        }
        if (str2 == null) {
            str2 = ga(str);
            if (aDz != null) {
                aDz.put(str, str2);
            }
        }
        if (str2 != null) {
            aDx = str2 + System.currentTimeMillis();
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
        return aDx;
    }

    public static String Er() {
        return aDy;
    }
}
