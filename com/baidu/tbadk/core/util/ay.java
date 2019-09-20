package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ay {
    private static String bUU;
    private static String bUV;
    private static final HashMap<String, String> bUW = new HashMap<>();

    public static void oo(String str) {
        bUV = str;
        if (TextUtils.isEmpty(str)) {
            bUU = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (bUW != null) {
            str2 = bUW.get(str);
        }
        if (str2 == null) {
            str2 = op(str);
            if (bUW != null) {
                bUW.put(str, str2);
            }
        }
        if (str2 != null) {
            bUU = str2 + System.currentTimeMillis();
        }
    }

    private static String op(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String ajI() {
        return bUU;
    }

    public static String ajJ() {
        return bUV;
    }
}
