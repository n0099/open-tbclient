package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import java.util.Map;
/* loaded from: classes4.dex */
public class PostBodyRequest extends HttpCommonRequest<PostBodyRequestBuilder> {

    /* loaded from: classes4.dex */
    public static class PostBodyRequestBuilder extends HttpCommonRequestBuilder<PostBodyRequestBuilder, PostBodyRequest> {
        public PostBodyRequestBuilder(PostBodyRequest postBodyRequest) {
            super(postBodyRequest);
        }

        public PostBodyRequestBuilder(Map<String, CallFactory> map) {
            super(map);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.support.request.HttpCommonRequestBuilder
        public PostBodyRequest buildRequest() {
            return new PostBodyRequest((PostBodyRequestBuilder) post(this.requestBody));
        }
    }

    public PostBodyRequest(PostBodyRequestBuilder postBodyRequestBuilder) {
        super(postBodyRequestBuilder);
    }
}
