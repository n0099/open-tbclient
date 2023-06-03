package com.baidu.searchbox.network.outback.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.Request;
import java.util.Map;
/* loaded from: classes4.dex */
public class GetRequest extends Request {

    /* loaded from: classes4.dex */
    public static class GetRequestBuilder extends Request.Builder<GetRequestBuilder> {
        public GetRequestBuilder(GetRequest getRequest) {
            super(getRequest);
        }

        public GetRequestBuilder(Map<String, CallFactory> map) {
            super(map);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public GetRequest build() {
            return new GetRequest(get());
        }
    }

    public GetRequest(GetRequestBuilder getRequestBuilder) {
        super(getRequestBuilder);
    }
}
