package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.request.HttpRequestParasBuilder;
import java.util.LinkedHashMap;
/* loaded from: classes5.dex */
public abstract class HttpParaRequest<T extends HttpRequestParasBuilder> extends HttpRequest<T> {
    protected LinkedHashMap<String, String> params;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.searchbox.network.request.HttpParaRequest<T extends com.baidu.searchbox.network.request.HttpRequestParasBuilder> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected /* bridge */ /* synthetic */ void initExtraHttpRequest(HttpRequestBuilder httpRequestBuilder) {
        initExtraHttpRequest((HttpParaRequest<T>) ((HttpRequestParasBuilder) httpRequestBuilder));
    }

    public HttpParaRequest(T t) {
        super(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initExtraHttpRequest(T t) {
        if (t.params != null) {
            this.params = new LinkedHashMap<>(t.params);
        }
    }
}
