package com.baidu.tbadk.core.util;

import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
/* loaded from: classes.dex */
public class ay {
    private static String bTj;
    private static String bTk;
    private static final HashMap<String, String> bTl = new HashMap<>();

    public static void nU(String str) {
        bTk = str;
        if (TextUtils.isEmpty(str)) {
            bTj = str;
            return;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf != -1 && lastIndexOf + 1 < str.length()) {
            str = str.substring(lastIndexOf + 1, str.length());
        }
        String str2 = "";
        if (bTl != null) {
            str2 = bTl.get(str);
        }
        if (str2 == null) {
            str2 = nV(str);
            if (bTl != null) {
                bTl.put(str, str2);
            }
        }
        if (str2 != null) {
            bTj = str2 + System.currentTimeMillis();
        }
    }

    private static String nV(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            if ((str.toLowerCase().endsWith(PushConstants.INTENT_ACTIVITY_NAME) || str.toLowerCase().endsWith("fragment")) && length - 8 >= 0) {
                return str.substring(0, length - 8);
            }
            return str;
        }
        return str;
    }

    public static String aix() {
        return bTj;
    }

    public static String aiy() {
        return bTk;
    }
}
