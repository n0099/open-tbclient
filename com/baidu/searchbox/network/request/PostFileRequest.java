package com.baidu.searchbox.network.request;

import com.baidu.searchbox.network.AbstractHttpManager;
import com.baidu.searchbox.network.core.MediaType;
import com.baidu.searchbox.network.core.Request;
import com.baidu.searchbox.network.core.RequestBody;
import java.io.File;
/* loaded from: classes11.dex */
public class PostFileRequest extends HttpRequest<PostFileRequestBuilder> {
    private static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    private File file;
    private MediaType mediaType;

    public PostFileRequest(PostFileRequestBuilder postFileRequestBuilder) {
        super(postFileRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public PostFileRequestBuilder newBuilder() {
        return new PostFileRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public PostFileRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostFileRequestBuilder(this, abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.network.request.HttpRequest
    public void initExtraHttpRequest(PostFileRequestBuilder postFileRequestBuilder) {
        this.file = postFileRequestBuilder.file;
        this.mediaType = postFileRequestBuilder.mediaType;
        if (this.mediaType == null) {
            this.mediaType = MEDIA_TYPE_STREAM;
        }
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected RequestBody buildOkRequestBody() {
        if (this.file != null) {
            return RequestBody.create(this.mediaType, this.file);
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    @Override // com.baidu.searchbox.network.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    /* loaded from: classes11.dex */
    public static class PostFileRequestBuilder extends HttpRequestBuilder<PostFileRequestBuilder> {
        private File file;
        private MediaType mediaType;

        public PostFileRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostFileRequestBuilder(PostFileRequest postFileRequest) {
            this(postFileRequest, null);
        }

        public PostFileRequestBuilder(PostFileRequest postFileRequest, AbstractHttpManager abstractHttpManager) {
            super(postFileRequest, abstractHttpManager);
            this.file = postFileRequest.file;
            this.mediaType = postFileRequest.mediaType;
        }

        public PostFileRequestBuilder file(File file) {
            this.file = file;
            return this;
        }

        public PostFileRequestBuilder file(String str) {
            this.file = new File(str);
            return this;
        }

        public PostFileRequestBuilder mediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public PostFileRequestBuilder mediaType(String str) {
            this.mediaType = MediaType.parse(str);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.request.HttpRequestBuilder
        public PostFileRequest build() {
            return new PostFileRequest(this);
        }
    }
}
