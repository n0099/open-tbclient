package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import okhttp3.MediaType;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public abstract class HttpCommonRequest<T extends HttpCommonRequestBuilder> extends HttpRequest<T> {
    public RequestBody requestBody;

    public HttpCommonRequest(T t) {
        super(t);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        RequestBody requestBody = this.requestBody;
        return requestBody != null ? requestBody : RequestBody.create((MediaType) null, new byte[0]);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.http.request.HttpCommonRequest<T extends com.baidu.searchbox.http.request.HttpCommonRequestBuilder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public /* bridge */ /* synthetic */ void initExtraHttpRequest(HttpRequestBuilder httpRequestBuilder) {
        initExtraHttpRequest((HttpCommonRequest<T>) ((HttpCommonRequestBuilder) httpRequestBuilder));
    }

    public void initExtraHttpRequest(T t) {
        this.requestBody = t.requestBody;
    }
}
