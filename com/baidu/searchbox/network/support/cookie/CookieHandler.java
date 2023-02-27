package com.baidu.searchbox.network.support.cookie;

import com.baidu.searchbox.network.outback.core.Headers;
import com.baidu.searchbox.network.outback.core.Request;
import java.util.List;
/* loaded from: classes2.dex */
public class CookieHandler {
    public static void receiveHeaders(CookieJar cookieJar, Request request, Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> parseAll = Cookie.parseAll(request.url(), headers);
        if (parseAll.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(request.url(), parseAll);
    }
}
