package com.baidu.helios.a.a;

import org.json.JSONObject;
/* loaded from: classes10.dex */
class l {
    public static JSONObject a(String str) {
        if (b(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean b(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
