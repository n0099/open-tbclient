package com.baidu.searchbox.network.callback;

import com.baidu.searchbox.network.core.Response;
import java.util.List;
import org.apache.http.cookie.SM;
/* loaded from: classes15.dex */
public abstract class CookieResponseCallback<T> extends ResponseCallback<T> {
    public abstract void handleCookies(List<String> list) throws Exception;

    public abstract T parseResponseAfterHandleCookie(Response response, int i) throws Exception;

    @Override // com.baidu.searchbox.network.callback.ResponseCallback
    public T parseResponse(Response response, int i) throws Exception {
        handleCookies(response.headers(SM.SET_COOKIE));
        return parseResponseAfterHandleCookie(response, i);
    }
}
