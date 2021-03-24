package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes3.dex */
public class PostByteRequest extends HttpRequest<PostByteRequestBuilder> {
    public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    public byte[] content;
    public MediaType mediaType;

    /* loaded from: classes3.dex */
    public static class PostByteRequestBuilder extends HttpRequestBuilder<PostByteRequestBuilder> {
        public byte[] contentBuffer;
        public MediaType mediaType;

        public PostByteRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostByteRequestBuilder content(byte[] bArr) {
            this.contentBuffer = bArr;
            return this;
        }

        public PostByteRequestBuilder mediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public PostByteRequestBuilder(PostByteRequest postByteRequest) {
            this(postByteRequest, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostByteRequest build() {
            return new PostByteRequest(this);
        }

        public PostByteRequestBuilder mediaType(String str) {
            this.mediaType = MediaType.parse(str);
            return this;
        }

        public PostByteRequestBuilder(PostByteRequest postByteRequest, AbstractHttpManager abstractHttpManager) {
            super(postByteRequest, abstractHttpManager);
            this.contentBuffer = postByteRequest.content;
            this.mediaType = postByteRequest.mediaType;
        }
    }

    public PostByteRequest(PostByteRequestBuilder postByteRequestBuilder) {
        super(postByteRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        byte[] bArr = this.content;
        if (bArr != null && bArr.length > 0) {
            return RequestBody.create(this.mediaType, bArr);
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public void initExtraHttpRequest(PostByteRequestBuilder postByteRequestBuilder) {
        this.content = postByteRequestBuilder.contentBuffer;
        MediaType mediaType = postByteRequestBuilder.mediaType;
        this.mediaType = mediaType;
        if (mediaType == null) {
            this.mediaType = MEDIA_TYPE_STREAM;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostByteRequestBuilder newBuilder() {
        return new PostByteRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostByteRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostByteRequestBuilder(this, abstractHttpManager);
    }
}
