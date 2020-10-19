package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.core.RequestBody;
import com.baidu.searchbox.network.request.HttpCommonRequestBuilder;
/* loaded from: classes15.dex */
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
