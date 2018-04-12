package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.baidu.ar.util.Constants;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class av {
    private static String ajj;
    private static String ajk;
    private static final HashMap<String, String> ajl = new HashMap<>();

    public static void en(String str) {
        ajk = str;
        if (TextUtils.isEmpty(str)) {
            ajj = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(Constants.DOT);
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (ajl != null) {
            str2 = ajl.get(str);
        }
        if (str2 == null) {
            str2 = eo(str);
            if (ajl != null) {
                ajl.put(str, str2);
            }
        }
        if (str2 != null) {
            ajj = str2 + System.currentTimeMillis();
        }
    }

    private static String eo(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String wc() {
        return ajj;
    }

    public static String wd() {
        return ajk;
    }
}
