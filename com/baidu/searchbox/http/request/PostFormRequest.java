package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class PostFormRequest extends HttpParaRequest<PostFormRequestBuilder> {

    /* loaded from: classes3.dex */
    public static class PostFormRequestBuilder extends HttpRequestParasBuilder<PostFormRequestBuilder> {
        public PostFormRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostFormRequestBuilder(PostFormRequest postFormRequest) {
            this(postFormRequest, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostFormRequest build() {
            return new PostFormRequest(this);
        }

        public PostFormRequestBuilder(PostFormRequest postFormRequest, AbstractHttpManager abstractHttpManager) {
            super(postFormRequest, abstractHttpManager);
        }
    }

    public PostFormRequest(PostFormRequestBuilder postFormRequestBuilder) {
        super(postFormRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        LinkedHashMap<String, String> linkedHashMap = this.params;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : this.params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            return builder.build();
        }
        return RequestBody.create((MediaType) null, new byte[0]);
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
}
