package com.baidu.searchbox.network.support.cookie;

import com.baidu.searchbox.network.outback.core.UrlWrapper;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new CookieJar() { // from class: com.baidu.searchbox.network.support.cookie.CookieJar.1
        @Override // com.baidu.searchbox.network.support.cookie.CookieJar
        public void saveFromResponse(UrlWrapper urlWrapper, List<Cookie> list) {
        }

        @Override // com.baidu.searchbox.network.support.cookie.CookieJar
        public List<Cookie> loadForRequest(UrlWrapper urlWrapper) {
            return Collections.emptyList();
        }
    };

    List<Cookie> loadForRequest(UrlWrapper urlWrapper);

    void saveFromResponse(UrlWrapper urlWrapper, List<Cookie> list);
}
