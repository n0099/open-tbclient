package com.baidu.searchbox.http.callback;

import java.util.List;
import okhttp3.Response;
import org.apache.http.cookie.SM;
/* loaded from: classes5.dex */
public abstract class CookieResponseCallback<T> extends ResponseCallback<T> {
    public abstract void handleCookies(List<String> list) throws Exception;

    public abstract T parseResponseAfterHandleCookie(Response response, int i) throws Exception;

    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public T parseResponse(Response response, int i) throws Exception {
        handleCookies(response.headers(SM.SET_COOKIE));
        return parseResponseAfterHandleCookie(response, i);
    }
}
