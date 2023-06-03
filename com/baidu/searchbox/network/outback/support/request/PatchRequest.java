package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import java.util.Map;
/* loaded from: classes4.dex */
public class PatchRequest extends HttpCommonRequest<PatchRequestBuilder> {

    /* loaded from: classes4.dex */
    public static class PatchRequestBuilder extends HttpCommonRequestBuilder<PatchRequestBuilder, PatchRequest> {
        public PatchRequestBuilder(PatchRequest patchRequest) {
            super(patchRequest);
        }

        public PatchRequestBuilder(Map<String, CallFactory> map) {
            super(map);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.support.request.HttpCommonRequestBuilder
        public PatchRequest buildRequest() {
            return new PatchRequest((PatchRequestBuilder) patch(this.requestBody));
        }
    }

    public PatchRequest(PatchRequestBuilder patchRequestBuilder) {
        super(patchRequestBuilder);
    }
}
