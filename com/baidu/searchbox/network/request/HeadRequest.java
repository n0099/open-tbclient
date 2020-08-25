package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
/* loaded from: classes14.dex */
public class HeadRequest extends HttpRequest<HeadRequestBuilder> {
    public HeadRequest(HeadRequestBuilder headRequestBuilder) {
        super(headRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public HeadRequestBuilder newBuilder() {
        return new HeadRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public HeadRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new HeadRequestBuilder(this, abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public void initExtraHttpRequest(HeadRequestBuilder headRequestBuilder) {
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected RequestBody buildOkRequestBody() {
        return null;
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.head().build();
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    public long getContentLength() {
        return 0L;
    }

    /* loaded from: classes14.dex */
    public static class HeadRequestBuilder extends HttpRequestBuilder<HeadRequestBuilder> {
        public HeadRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public HeadRequestBuilder(HeadRequest headRequest) {
            this(headRequest, null);
        }

        public HeadRequestBuilder(HeadRequest headRequest, AbstractHttpManager abstractHttpManager) {
            super(headRequest, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.request.HttpRequestBuilder
        public HeadRequest build() {
            return new HeadRequest(this);
        }
    }
}
