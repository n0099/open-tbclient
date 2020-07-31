package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes5.dex */
public class DeleteRequest extends HttpCommonRequest<DeleteRequestBuilder> {
    public DeleteRequest(DeleteRequestBuilder deleteRequestBuilder) {
        super(deleteRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public DeleteRequestBuilder newBuilder() {
        return new DeleteRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public DeleteRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new DeleteRequestBuilder(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.delete(requestBody).build();
    }

    /* loaded from: classes5.dex */
    public static class DeleteRequestBuilder extends HttpCommonRequestBuilder<DeleteRequestBuilder> {
        public DeleteRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public DeleteRequestBuilder(DeleteRequest deleteRequest) {
            this(deleteRequest, null);
        }

        public DeleteRequestBuilder(DeleteRequest deleteRequest, AbstractHttpManager abstractHttpManager) {
            super(deleteRequest, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public DeleteRequest build() {
            return new DeleteRequest(this);
        }
    }
}
