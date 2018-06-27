package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ax {
    private static String arU;
    private static String arV;
    private static final HashMap<String, String> arW = new HashMap<>();

    public static void eP(String str) {
        arV = str;
        if (TextUtils.isEmpty(str)) {
            arU = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (arW != null) {
            str2 = arW.get(str);
        }
        if (str2 == null) {
            str2 = eQ(str);
            if (arW != null) {
                arW.put(str, str2);
            }
        }
        if (str2 != null) {
            arU = str2 + System.currentTimeMillis();
        }
    }

    private static String eQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String zR() {
        return arU;
    }

    public static String zS() {
        return arV;
    }
}
