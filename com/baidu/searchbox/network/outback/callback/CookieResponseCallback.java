package com.baidu.searchbox.network.outback.callback;

import com.baidu.searchbox.network.outback.core.Response;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class CookieResponseCallback<T> extends ResponseCallback<T> {
    public abstract void handleCookies(List<String> list) throws Exception;

    public abstract T parseResponseAfterHandleCookie(Response response, int i) throws Exception;

    @Override // com.baidu.searchbox.network.outback.callback.ResponseCallback
    public T parseResponse(Response response, int i) throws Exception {
        handleCookies(response.headers("Set-Cookie"));
        return parseResponseAfterHandleCookie(response, i);
    }
}
