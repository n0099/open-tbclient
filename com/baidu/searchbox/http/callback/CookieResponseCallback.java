package com.baidu.searchbox.http.callback;

import java.util.List;
import okhttp3.Response;
/* loaded from: classes4.dex */
public abstract class CookieResponseCallback<T> extends ResponseCallback<T> {
    public abstract void handleCookies(List<String> list) throws Exception;

    public abstract T parseResponseAfterHandleCookie(Response response, int i) throws Exception;

    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public T parseResponse(Response response, int i) throws Exception {
        handleCookies(response.headers("Set-Cookie"));
        return parseResponseAfterHandleCookie(response, i);
    }
}
