package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public class GetRequest extends HttpRequest<GetRequestBuilder> {

    /* loaded from: classes2.dex */
    public static class GetRequestBuilder extends HttpRequestBuilder<GetRequestBuilder> {
        public GetRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public GetRequestBuilder(GetRequest getRequest) {
            this(getRequest, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public GetRequest build() {
            return new GetRequest(this);
        }

        public GetRequestBuilder(GetRequest getRequest, AbstractHttpManager abstractHttpManager) {
            super(getRequest, abstractHttpManager);
        }
    }

    public GetRequest(GetRequestBuilder getRequestBuilder) {
        super(getRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.get().build();
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
    public void initExtraHttpRequest(GetRequestBuilder getRequestBuilder) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public GetRequestBuilder newBuilder() {
        return new GetRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public GetRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new GetRequestBuilder(this, abstractHttpManager);
    }
}
