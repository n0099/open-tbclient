package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes12.dex */
public abstract class HttpCommonRequest<T extends HttpCommonRequestBuilder> extends HttpRequest<T> {
    protected RequestBody requestBody;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.http.request.HttpCommonRequest<T extends com.baidu.searchbox.http.request.HttpCommonRequestBuilder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected /* bridge */ /* synthetic */ void initExtraHttpRequest(HttpRequestBuilder httpRequestBuilder) {
        initExtraHttpRequest((HttpCommonRequest<T>) ((HttpCommonRequestBuilder) httpRequestBuilder));
    }

    public HttpCommonRequest(T t) {
        super(t);
    }

    protected void initExtraHttpRequest(T t) {
        this.requestBody = t.requestBody;
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected RequestBody buildOkRequestBody() {
        return this.requestBody != null ? this.requestBody : RequestBody.create((MediaType) null, new byte[0]);
    }
}
