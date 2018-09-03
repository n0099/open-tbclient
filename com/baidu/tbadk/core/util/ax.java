package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ax {
    private static final HashMap<String, String> arA = new HashMap<>();
    private static String ary;
    private static String arz;

    public static void eN(String str) {
        arz = str;
        if (TextUtils.isEmpty(str)) {
            ary = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (arA != null) {
            str2 = arA.get(str);
        }
        if (str2 == null) {
            str2 = eO(str);
            if (arA != null) {
                arA.put(str, str2);
            }
        }
        if (str2 != null) {
            ary = str2 + System.currentTimeMillis();
        }
    }

    private static String eO(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String zG() {
        return ary;
    }

    public static String zH() {
        return arz;
    }
}
