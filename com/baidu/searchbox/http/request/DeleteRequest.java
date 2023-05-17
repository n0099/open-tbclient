package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class DeleteRequest extends HttpCommonRequest<DeleteRequestBuilder> {

    /* loaded from: classes3.dex */
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

    public DeleteRequest(DeleteRequestBuilder deleteRequestBuilder) {
        super(deleteRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.delete(requestBody).build();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public DeleteRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new DeleteRequestBuilder(this, abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public DeleteRequestBuilder newBuilder() {
        return new DeleteRequestBuilder(this);
    }
}
