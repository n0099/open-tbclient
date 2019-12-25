package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.core.MediaType;
import com.baidu.searchbox.network.core.RequestBody;
import com.baidu.searchbox.network.request.HttpCommonRequestBuilder;
/* loaded from: classes11.dex */
public abstract class HttpCommonRequest<T extends HttpCommonRequestBuilder> extends HttpRequest<T> {
    protected RequestBody requestBody;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.network.request.HttpCommonRequest<T extends com.baidu.searchbox.network.request.HttpCommonRequestBuilder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected /* bridge */ /* synthetic */ void initExtraHttpRequest(HttpRequestBuilder httpRequestBuilder) {
        initExtraHttpRequest((HttpCommonRequest<T>) ((HttpCommonRequestBuilder) httpRequestBuilder));
    }

    public HttpCommonRequest(T t) {
        super(t);
    }

    protected void initExtraHttpRequest(T t) {
        this.requestBody = t.requestBody;
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected RequestBody buildOkRequestBody() {
        return this.requestBody != null ? this.requestBody : RequestBody.create((MediaType) null, new byte[0]);
    }
}
