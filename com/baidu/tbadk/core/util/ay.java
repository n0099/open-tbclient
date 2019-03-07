package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ay {
    private static String bLt;
    private static String bLu;
    private static final HashMap<String, String> bLv = new HashMap<>();

    public static void mL(String str) {
        bLu = str;
        if (TextUtils.isEmpty(str)) {
            bLt = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (bLv != null) {
            str2 = bLv.get(str);
        }
        if (str2 == null) {
            str2 = mM(str);
            if (bLv != null) {
                bLv.put(str, str2);
            }
        }
        if (str2 != null) {
            bLt = str2 + System.currentTimeMillis();
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
        return bLt;
    }

    public static String adC() {
        return bLu;
    }
}
