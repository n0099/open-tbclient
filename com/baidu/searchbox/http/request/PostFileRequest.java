package com.baidu.searchbox.http.request;

import com.baidu.searchbox.http.AbstractHttpManager;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public class PostFileRequest extends HttpRequest<PostFileRequestBuilder> {
    public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    public File file;
    public MediaType mediaType;

    /* loaded from: classes2.dex */
    public static class PostFileRequestBuilder extends HttpRequestBuilder<PostFileRequestBuilder> {
        public File file;
        public MediaType mediaType;

        public PostFileRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostFileRequestBuilder file(File file) {
            this.file = file;
            return this;
        }

        public PostFileRequestBuilder mediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public PostFileRequestBuilder(PostFileRequest postFileRequest) {
            this(postFileRequest, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostFileRequest build() {
            return new PostFileRequest(this);
        }

        public PostFileRequestBuilder file(String str) {
            this.file = new File(str);
            return this;
        }

        public PostFileRequestBuilder mediaType(String str) {
            this.mediaType = MediaType.parse(str);
            return this;
        }

        public PostFileRequestBuilder(PostFileRequest postFileRequest, AbstractHttpManager abstractHttpManager) {
            super(postFileRequest, abstractHttpManager);
            this.file = postFileRequest.file;
            this.mediaType = postFileRequest.mediaType;
        }
    }

    public PostFileRequest(PostFileRequestBuilder postFileRequestBuilder) {
        super(postFileRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        File file = this.file;
        if (file != null) {
            return RequestBody.create(this.mediaType, file);
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public void initExtraHttpRequest(PostFileRequestBuilder postFileRequestBuilder) {
        this.file = postFileRequestBuilder.file;
        MediaType mediaType = postFileRequestBuilder.mediaType;
        this.mediaType = mediaType;
        if (mediaType == null) {
            this.mediaType = MEDIA_TYPE_STREAM;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostFileRequestBuilder newBuilder() {
        return new PostFileRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostFileRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostFileRequestBuilder(this, abstractHttpManager);
    }
}
