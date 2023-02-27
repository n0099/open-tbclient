package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import java.util.Map;
/* loaded from: classes2.dex */
public class PutBodyRequest extends HttpCommonRequest<PutBodyRequestBuilder> {

    /* loaded from: classes2.dex */
    public static class PutBodyRequestBuilder extends HttpCommonRequestBuilder<PutBodyRequestBuilder, PutBodyRequest> {
        public PutBodyRequestBuilder(PutBodyRequest putBodyRequest) {
            super(putBodyRequest);
        }

        public PutBodyRequestBuilder(Map<String, CallFactory> map) {
            super(map);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.support.request.HttpCommonRequestBuilder
        public PutBodyRequest buildRequest() {
            return new PutBodyRequest((PutBodyRequestBuilder) put(this.requestBody));
        }
    }

    public PutBodyRequest(PutBodyRequestBuilder putBodyRequestBuilder) {
        super(putBodyRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.outback.core.Request
    public PutBodyRequestBuilder newBuilder() {
        return new PutBodyRequestBuilder(this);
    }
}
