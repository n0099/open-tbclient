package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes4.dex */
public class PutBodyRequest extends HttpCommonRequest<PutBodyRequestBuilder> {

    /* loaded from: classes4.dex */
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

    public PutBodyRequest(PutBodyRequestBuilder putBodyRequestBuilder) {
        super(putBodyRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.put(requestBody).build();
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
}
