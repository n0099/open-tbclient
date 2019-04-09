package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ay {
    private static String bLx;
    private static String bLy;
    private static final HashMap<String, String> bLz = new HashMap<>();

    public static void mM(String str) {
        bLy = str;
        if (TextUtils.isEmpty(str)) {
            bLx = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (bLz != null) {
            str2 = bLz.get(str);
        }
        if (str2 == null) {
            str2 = mN(str);
            if (bLz != null) {
                bLz.put(str, str2);
            }
        }
        if (str2 != null) {
            bLx = str2 + System.currentTimeMillis();
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
        return bLx;
    }

    public static String adz() {
        return bLy;
    }
}
