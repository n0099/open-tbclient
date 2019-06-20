package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ay {
    private static String bTk;
    private static String bTl;
    private static final HashMap<String, String> bTm = new HashMap<>();

    public static void nT(String str) {
        bTl = str;
        if (TextUtils.isEmpty(str)) {
            bTk = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (bTm != null) {
            str2 = bTm.get(str);
        }
        if (str2 == null) {
            str2 = nU(str);
            if (bTm != null) {
                bTm.put(str, str2);
            }
        }
        if (str2 != null) {
            bTk = str2 + System.currentTimeMillis();
        }
    }

    private static String nU(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String aix() {
        return bTk;
    }

    public static String aiy() {
        return bTl;
    }
}
