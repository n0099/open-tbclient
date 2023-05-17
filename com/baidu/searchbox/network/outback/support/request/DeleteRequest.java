package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import java.util.Map;
/* loaded from: classes3.dex */
public class DeleteRequest extends HttpCommonRequest<DeleteRequestBuilder> {

    /* loaded from: classes3.dex */
    public static class DeleteRequestBuilder extends HttpCommonRequestBuilder<DeleteRequestBuilder, DeleteRequest> {
        public DeleteRequestBuilder(DeleteRequest deleteRequest) {
            super(deleteRequest);
        }

        public DeleteRequestBuilder(Map<String, CallFactory> map) {
            super(map);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.searchbox.network.outback.support.request.HttpCommonRequestBuilder
        public DeleteRequest buildRequest() {
            return new DeleteRequest((DeleteRequestBuilder) delete(this.requestBody));
        }
    }

    public DeleteRequest(DeleteRequestBuilder deleteRequestBuilder) {
        super(deleteRequestBuilder);
    }
}
