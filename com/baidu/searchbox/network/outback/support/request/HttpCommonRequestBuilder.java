package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.searchbox.network.outback.support.request.HttpCommonRequest;
import com.baidu.searchbox.network.outback.support.request.HttpCommonRequestBuilder;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class HttpCommonRequestBuilder<T extends HttpCommonRequestBuilder, R extends HttpCommonRequest<T>> extends Request.Builder<T> {
    public RequestBody requestBody;

    public abstract R buildRequest();

    public HttpCommonRequestBuilder(HttpCommonRequest httpCommonRequest) {
        super(httpCommonRequest);
        this.requestBody = httpCommonRequest.body();
    }

    public T requestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public HttpCommonRequestBuilder(Map<String, CallFactory> map) {
        super(map);
    }

    public void ensureBody() {
        if (this.requestBody == null) {
            this.requestBody = RequestBody.create((MediaType) null, new byte[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.outback.core.Request.Builder
    public final R build() {
        ensureBody();
        return buildRequest();
    }
}
