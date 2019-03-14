package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ay {
    private static String bLu;
    private static String bLv;
    private static final HashMap<String, String> bLw = new HashMap<>();

    public static void mL(String str) {
        bLv = str;
        if (TextUtils.isEmpty(str)) {
            bLu = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (bLw != null) {
            str2 = bLw.get(str);
        }
        if (str2 == null) {
            str2 = mM(str);
            if (bLw != null) {
                bLw.put(str, str2);
            }
        }
        if (str2 != null) {
            bLu = str2 + System.currentTimeMillis();
        }
    }

    private static String mM(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String adB() {
        return bLu;
    }

    public static String adC() {
        return bLv;
    }
}
