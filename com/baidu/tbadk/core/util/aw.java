package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class aw {
    private static String azu;
    private static String azv;
    private static final HashMap<String, String> azw = new HashMap<>();

    public static void ft(String str) {
        azv = str;
        if (TextUtils.isEmpty(str)) {
            azu = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (azw != null) {
            str2 = azw.get(str);
        }
        if (str2 == null) {
            str2 = fu(str);
            if (azw != null) {
                azw.put(str, str2);
            }
        }
        if (str2 != null) {
            azu = str2 + System.currentTimeMillis();
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

    public static String CZ() {
        return azu;
    }

    public static String Da() {
        return azv;
    }
}
