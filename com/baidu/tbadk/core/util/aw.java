package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aw {
    private static String ayH;
    private static String ayI;
    private static final HashMap<String, String> ayJ = new HashMap<>();

    public static void ft(String str) {
        ayI = str;
        if (TextUtils.isEmpty(str)) {
            ayH = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ayJ != null) {
            str2 = ayJ.get(str);
        }
        if (str2 == null) {
            str2 = fu(str);
            if (ayJ != null) {
                ayJ.put(str, str2);
            }
        }
        if (str2 != null) {
            ayH = str2 + System.currentTimeMillis();
        }
    }

    private static String fu(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String CS() {
        return ayH;
    }

    public static String CT() {
        return ayI;
    }
}
