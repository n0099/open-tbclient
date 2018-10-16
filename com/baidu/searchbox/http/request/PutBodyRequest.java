package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public class PutBodyRequest extends HttpCommonRequest<PutBodyRequestBuilder> {
    public PutBodyRequest(PutBodyRequestBuilder putBodyRequestBuilder) {
        super(putBodyRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PutBodyRequestBuilder newBuilder() {
        return new PutBodyRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PutBodyRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PutBodyRequestBuilder(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.put(requestBody).build();
    }

    /* loaded from: classes2.dex */
    public static class PutBodyRequestBuilder extends HttpCommonRequestBuilder<PutBodyRequestBuilder> {
        public PutBodyRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PutBodyRequestBuilder(PutBodyRequest putBodyRequest) {
            this(putBodyRequest, null);
        }

        public PutBodyRequestBuilder(PutBodyRequest putBodyRequest, AbstractHttpManager abstractHttpManager) {
            super(putBodyRequest, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PutBodyRequest build() {
            return new PutBodyRequest(this);
        }
    }
}
