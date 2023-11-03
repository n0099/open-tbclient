package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes4.dex */
public class HeadRequest extends HttpRequest<HeadRequestBuilder> {
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        return null;
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public long getContentLength() {
        return 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public void initExtraHttpRequest(HeadRequestBuilder headRequestBuilder) {
    }

    /* loaded from: classes4.dex */
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
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public HeadRequest build() {
            return new HeadRequest(this);
        }
    }

    public HeadRequest(HeadRequestBuilder headRequestBuilder) {
        super(headRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.head().build();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public HeadRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new HeadRequestBuilder(this, abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public HeadRequestBuilder newBuilder() {
        return new HeadRequestBuilder(this);
    }
}
