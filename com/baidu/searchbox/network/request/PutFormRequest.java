package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.core.FormBody;
import com.baidu.searchbox.network.core.MediaType;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
import java.util.Map;
/* loaded from: classes15.dex */
public class PutFormRequest extends HttpParaRequest<PutFormRequestBuilder> {
    public PutFormRequest(PutFormRequestBuilder putFormRequestBuilder) {
        super(putFormRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public PutFormRequestBuilder newBuilder() {
        return new PutFormRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public PutFormRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PutFormRequestBuilder(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
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

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.put(requestBody).build();
    }

    /* loaded from: classes15.dex */
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
        @Override // com.baidu.searchbox.network.request.HttpRequestBuilder
        public PutFormRequest build() {
            return new PutFormRequest(this);
        }
    }
}
