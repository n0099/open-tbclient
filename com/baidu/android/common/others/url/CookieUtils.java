package com.baidu.android.common.others.url;
/* loaded from: classes.dex */
public final class CookieUtils {
    public static String getCookieStr(String str, String str2, String str3, long j) {
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;max-age=" + j + ";";
    }
}
