package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
/* loaded from: classes15.dex */
public class GetRequest extends HttpRequest<GetRequestBuilder> {
    public GetRequest(GetRequestBuilder getRequestBuilder) {
        super(getRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public GetRequestBuilder newBuilder() {
        return new GetRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public GetRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new GetRequestBuilder(this, abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public void initExtraHttpRequest(GetRequestBuilder getRequestBuilder) {
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected RequestBody buildOkRequestBody() {
        return null;
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.get().build();
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    public long getContentLength() {
        return 0L;
    }

    /* loaded from: classes15.dex */
    public static class GetRequestBuilder extends HttpRequestBuilder<GetRequestBuilder> {
        public GetRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public GetRequestBuilder(GetRequest getRequest) {
            this(getRequest, null);
        }

        public GetRequestBuilder(GetRequest getRequest, AbstractHttpManager abstractHttpManager) {
            super(getRequest, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.request.HttpRequestBuilder
        public GetRequest build() {
            return new GetRequest(this);
        }
    }
}
