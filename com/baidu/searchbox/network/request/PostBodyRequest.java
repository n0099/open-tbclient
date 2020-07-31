package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
/* loaded from: classes5.dex */
public class PostBodyRequest extends HttpCommonRequest<PostBodyRequestBuilder> {
    public PostBodyRequest(PostBodyRequestBuilder postBodyRequestBuilder) {
        super(postBodyRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public PostBodyRequestBuilder newBuilder() {
        return new PostBodyRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public PostBodyRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostBodyRequestBuilder(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    /* loaded from: classes5.dex */
    public static class PostBodyRequestBuilder extends HttpCommonRequestBuilder<PostBodyRequestBuilder> {
        public PostBodyRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostBodyRequestBuilder(PostBodyRequest postBodyRequest) {
            this(postBodyRequest, null);
        }

        public PostBodyRequestBuilder(PostBodyRequest postBodyRequest, AbstractHttpManager abstractHttpManager) {
            super(postBodyRequest, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.request.HttpRequestBuilder
        public PostBodyRequest build() {
            return new PostBodyRequest(this);
        }
    }
}
