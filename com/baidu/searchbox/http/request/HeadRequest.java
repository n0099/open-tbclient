package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public class HeadRequest extends HttpRequest<HeadRequestBuilder> {

    /* loaded from: classes2.dex */
    public static class HeadRequestBuilder extends HttpRequestBuilder<HeadRequestBuilder> {
        public HeadRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public HeadRequestBuilder(HeadRequest headRequest) {
            this(headRequest, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public HeadRequest build() {
            return new HeadRequest(this);
        }

        public HeadRequestBuilder(HeadRequest headRequest, AbstractHttpManager abstractHttpManager) {
            super(headRequest, abstractHttpManager);
        }
    }

    public HeadRequest(HeadRequestBuilder headRequestBuilder) {
        super(headRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.head().build();
    }

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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public HeadRequestBuilder newBuilder() {
        return new HeadRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public HeadRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new HeadRequestBuilder(this, abstractHttpManager);
    }
}
