package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ay {
    private static String bLw;
    private static String bLx;
    private static final HashMap<String, String> bLy = new HashMap<>();

    public static void mM(String str) {
        bLx = str;
        if (TextUtils.isEmpty(str)) {
            bLw = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (bLy != null) {
            str2 = bLy.get(str);
        }
        if (str2 == null) {
            str2 = mN(str);
            if (bLy != null) {
                bLy.put(str, str2);
            }
        }
        if (str2 != null) {
            bLw = str2 + System.currentTimeMillis();
        }
    }

    private static String mN(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String ady() {
        return bLw;
    }

    public static String adz() {
        return bLx;
    }
}
