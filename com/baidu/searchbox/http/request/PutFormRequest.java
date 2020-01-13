package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes12.dex */
public class PutFormRequest extends HttpParaRequest<PutFormRequestBuilder> {
    public PutFormRequest(PutFormRequestBuilder putFormRequestBuilder) {
        super(putFormRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PutFormRequestBuilder newBuilder() {
        return new PutFormRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PutFormRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PutFormRequestBuilder(this, abstractHttpManager);
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
        return this.okRequestBuilder.put(requestBody).build();
    }

    /* loaded from: classes12.dex */
    public static class PutFormRequestBuilder extends HttpRequestParasBuilder<PutFormRequestBuilder> {
        public PutFormRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PutFormRequestBuilder(PutFormRequest putFormRequest) {
            this(putFormRequest, null);
        }

        public PutFormRequestBuilder(PutFormRequest putFormRequest, AbstractHttpManager abstractHttpManager) {
            super(putFormRequest, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PutFormRequest build() {
            return new PutFormRequest(this);
        }
    }
}
