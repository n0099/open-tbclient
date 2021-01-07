package com.baidu.android.common.others.url;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
/* loaded from: classes4.dex */
public final class CookieUtils {
    private CookieUtils() {
    }

    public static String getCookieStr(String str, String str2, String str3, long j) {
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;max-age=" + j + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR;
    }
}
