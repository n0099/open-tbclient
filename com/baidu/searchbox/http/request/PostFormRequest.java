package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes16.dex */
public class PostFormRequest extends HttpParaRequest<PostFormRequestBuilder> {
    public PostFormRequest(PostFormRequestBuilder postFormRequestBuilder) {
        super(postFormRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostFormRequestBuilder newBuilder() {
        return new PostFormRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostFormRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostFormRequestBuilder(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected RequestBody buildOkRequestBody() {
        if (this.params != null && !this.params.isEmpty()) {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : this.params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            return builder.build();
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    /* loaded from: classes16.dex */
    public static class PostFormRequestBuilder extends HttpRequestParasBuilder<PostFormRequestBuilder> {
        public PostFormRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostFormRequestBuilder(PostFormRequest postFormRequest) {
            this(postFormRequest, null);
        }

        public PostFormRequestBuilder(PostFormRequest postFormRequest, AbstractHttpManager abstractHttpManager) {
            super(postFormRequest, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostFormRequest build() {
            return new PostFormRequest(this);
        }
    }
}
