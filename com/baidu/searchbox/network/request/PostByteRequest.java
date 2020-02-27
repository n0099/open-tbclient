package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.core.MediaType;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
/* loaded from: classes13.dex */
public class PostByteRequest extends HttpRequest<PostByteRequestBuilder> {
    private static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    private byte[] content;
    private MediaType mediaType;

    public PostByteRequest(PostByteRequestBuilder postByteRequestBuilder) {
        super(postByteRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public PostByteRequestBuilder newBuilder() {
        return new PostByteRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public PostByteRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostByteRequestBuilder(this, abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public void initExtraHttpRequest(PostByteRequestBuilder postByteRequestBuilder) {
        this.content = postByteRequestBuilder.contentBuffer;
        this.mediaType = postByteRequestBuilder.mediaType;
        if (this.mediaType == null) {
            this.mediaType = MEDIA_TYPE_STREAM;
        }
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected RequestBody buildOkRequestBody() {
        if (this.content != null && this.content.length > 0) {
            return RequestBody.create(this.mediaType, this.content);
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    /* loaded from: classes13.dex */
    public static class PostByteRequestBuilder extends HttpRequestBuilder<PostByteRequestBuilder> {
        private byte[] contentBuffer;
        private MediaType mediaType;

        public PostByteRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostByteRequestBuilder(PostByteRequest postByteRequest) {
            this(postByteRequest, null);
        }

        public PostByteRequestBuilder(PostByteRequest postByteRequest, AbstractHttpManager abstractHttpManager) {
            super(postByteRequest, abstractHttpManager);
            this.contentBuffer = postByteRequest.content;
            this.mediaType = postByteRequest.mediaType;
        }

        public PostByteRequestBuilder content(byte[] bArr) {
            this.contentBuffer = bArr;
            return this;
        }

        public PostByteRequestBuilder mediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public PostByteRequestBuilder mediaType(String str) {
            this.mediaType = MediaType.parse(str);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.request.HttpRequestBuilder
        public PostByteRequest build() {
            return new PostByteRequest(this);
        }
    }
}
