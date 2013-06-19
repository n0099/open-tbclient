package com.baidu.cyberplayer.sdk.internal;
/* loaded from: classes.dex */
public class RequestWriter {
    public static String addVersion(String str, String str2, String str3) {
        String replace = GlobalConstants.INNER_VERSION.replace(".", "-");
        if (str2 != null) {
            return a(str, "ver", str3 + "_" + str2 + "_" + replace);
        }
        return str;
    }

    private static String a(String str, String str2, String str3) {
        if (str.indexOf("?") < 0) {
            return str + "?" + str2 + "=" + str3;
        }
        if (str.endsWith("?") || str.endsWith("&")) {
            return str + str2 + "=" + str3;
        }
        return str + "&" + str2 + "=" + str3;
    }
}
