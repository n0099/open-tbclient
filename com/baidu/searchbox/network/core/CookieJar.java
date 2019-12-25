package com.baidu.searchbox.network.core;

import java.util.Collections;
import java.util.List;
/* loaded from: classes11.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new CookieJar() { // from class: com.baidu.searchbox.network.core.CookieJar.1
        @Override // com.baidu.searchbox.network.core.CookieJar
        public void saveFromResponse(Request request, List<Cookie> list) {
        }

        @Override // com.baidu.searchbox.network.core.CookieJar
        public List<Cookie> loadForRequest(Request request) {
            return Collections.emptyList();
        }
    };

    List<Cookie> loadForRequest(Request request);

    void saveFromResponse(Request request, List<Cookie> list);
}
