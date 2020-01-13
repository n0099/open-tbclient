package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
/* loaded from: classes12.dex */
public class DeleteRequest extends HttpCommonRequest<DeleteRequestBuilder> {
    public DeleteRequest(DeleteRequestBuilder deleteRequestBuilder) {
        super(deleteRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public DeleteRequestBuilder newBuilder() {
        return new DeleteRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public DeleteRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new DeleteRequestBuilder(this, abstractHttpManager);
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.delete(requestBody).build();
    }

    /* loaded from: classes12.dex */
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
        @Override // com.baidu.searchbox.network.request.HttpRequestBuilder
        public DeleteRequest build() {
            return new DeleteRequest(this);
        }
    }
}
