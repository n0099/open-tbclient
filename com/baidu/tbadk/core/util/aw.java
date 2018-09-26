package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aw {
    private static String atW;
    private static String atX;
    private static final HashMap<String, String> atY = new HashMap<>();

    public static void ff(String str) {
        atX = str;
        if (TextUtils.isEmpty(str)) {
            atW = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (atY != null) {
            str2 = atY.get(str);
        }
        if (str2 == null) {
            str2 = fg(str);
            if (atY != null) {
                atY.put(str, str2);
            }
        }
        if (str2 != null) {
            atW = str2 + System.currentTimeMillis();
        }
    }

    private static String fg(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String AL() {
        return atW;
    }

    public static String AM() {
        return atX;
    }
}
