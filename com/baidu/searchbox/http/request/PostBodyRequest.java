package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public class PostBodyRequest extends HttpCommonRequest<PostBodyRequestBuilder> {

    /* loaded from: classes2.dex */
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
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostBodyRequest build() {
            return new PostBodyRequest(this);
        }
    }

    public PostBodyRequest(PostBodyRequestBuilder postBodyRequestBuilder) {
        super(postBodyRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostBodyRequestBuilder newBuilder() {
        return new PostBodyRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostBodyRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostBodyRequestBuilder(this, abstractHttpManager);
    }
}
