package com.baidu.searchbox.http.cookie;

import java.util.List;
/* loaded from: classes2.dex */
public interface CookieManager {
    String getCookie(String str);

    boolean shouldAcceptCookie(String str, String str2);

    boolean shouldSendCookie(String str, String str2);

    void storeCookie(String str, List<String> list);
}
