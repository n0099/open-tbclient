package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes6.dex */
public class PatchRequest extends HttpCommonRequest<PatchRequestBuilder> {
    public PatchRequest(PatchRequestBuilder patchRequestBuilder) {
        super(patchRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PatchRequestBuilder newBuilder() {
        return new PatchRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PatchRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PatchRequestBuilder(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.patch(requestBody).build();
    }

    /* loaded from: classes6.dex */
    public static class PatchRequestBuilder extends HttpCommonRequestBuilder<PatchRequestBuilder> {
        public PatchRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PatchRequestBuilder(PatchRequest patchRequest) {
            this(patchRequest, null);
        }

        public PatchRequestBuilder(PatchRequest patchRequest, AbstractHttpManager abstractHttpManager) {
            super(patchRequest, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PatchRequest build() {
            return new PatchRequest(this);
        }
    }
}
