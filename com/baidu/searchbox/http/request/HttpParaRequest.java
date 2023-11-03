package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.request.HttpRequestParasBuilder;
import java.util.LinkedHashMap;
/* loaded from: classes4.dex */
public abstract class HttpParaRequest<T extends HttpRequestParasBuilder> extends HttpRequest<T> {
    public LinkedHashMap<String, String> params;

    public HttpParaRequest(T t) {
        super(t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.http.request.HttpParaRequest<T extends com.baidu.searchbox.http.request.HttpRequestParasBuilder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public /* bridge */ /* synthetic */ void initExtraHttpRequest(HttpRequestBuilder httpRequestBuilder) {
        initExtraHttpRequest((HttpParaRequest<T>) ((HttpRequestParasBuilder) httpRequestBuilder));
    }

    public void initExtraHttpRequest(T t) {
        if (t.params != null) {
            this.params = new LinkedHashMap<>(t.params);
        }
    }
}
