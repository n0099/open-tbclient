package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.RequestBody;
/* loaded from: classes11.dex */
public abstract class HttpCommonRequestBuilder<T extends HttpCommonRequestBuilder> extends HttpRequestBuilder<T> {
    protected RequestBody requestBody;

    public HttpCommonRequestBuilder(AbstractHttpManager abstractHttpManager) {
        super(abstractHttpManager);
    }

    public HttpCommonRequestBuilder(HttpCommonRequest httpCommonRequest, AbstractHttpManager abstractHttpManager) {
        super(httpCommonRequest, abstractHttpManager);
        this.requestBody = httpCommonRequest.requestBody;
    }

    public T requestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }
}
