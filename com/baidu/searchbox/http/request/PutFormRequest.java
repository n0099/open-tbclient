package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes4.dex */
public class PutFormRequest extends HttpParaRequest<PutFormRequestBuilder> {

    /* loaded from: classes4.dex */
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

    public PutFormRequest(PutFormRequestBuilder putFormRequestBuilder) {
        super(putFormRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.put(requestBody).build();
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
    public PutFormRequestBuilder newBuilder() {
        return new PutFormRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PutFormRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PutFormRequestBuilder(this, abstractHttpManager);
    }
}
