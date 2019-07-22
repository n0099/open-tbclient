package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class az {
    private static String bUl;
    private static String bUm;
    private static final HashMap<String, String> bUn = new HashMap<>();

    public static void ol(String str) {
        bUm = str;
        if (TextUtils.isEmpty(str)) {
            bUl = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (bUn != null) {
            str2 = bUn.get(str);
        }
        if (str2 == null) {
            str2 = om(str);
            if (bUn != null) {
                bUn.put(str, str2);
            }
        }
        if (str2 != null) {
            bUl = str2 + System.currentTimeMillis();
        }
    }

    private static String om(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String ajA() {
        return bUl;
    }

    public static String ajB() {
        return bUm;
    }
}
