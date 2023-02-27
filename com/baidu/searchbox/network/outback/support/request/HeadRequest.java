package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.Request;
import java.util.Map;
/* loaded from: classes2.dex */
public class HeadRequest extends Request {

    /* loaded from: classes2.dex */
    public static class HeadRequestBuilder extends Request.Builder<HeadRequestBuilder> {
        public HeadRequestBuilder(HeadRequest headRequest) {
            super(headRequest);
        }

        public HeadRequestBuilder(Map<String, CallFactory> map) {
            super(map);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public HeadRequest build() {
            return new HeadRequest(head());
        }
    }

    public HeadRequest(HeadRequestBuilder headRequestBuilder) {
        super(headRequestBuilder);
    }
}
