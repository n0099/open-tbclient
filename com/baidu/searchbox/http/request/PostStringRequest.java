package com.baidu.searchbox.http.request;

import android.text.TextUtils;
import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes14.dex */
public class PostStringRequest extends HttpRequest<PostStringRequestBuilder> {
    private static final MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain");
    private String content;
    private MediaType mediaType;

    public PostStringRequest(PostStringRequestBuilder postStringRequestBuilder) {
        super(postStringRequestBuilder);
        this.content = postStringRequestBuilder.content;
        this.mediaType = postStringRequestBuilder.mediaType;
        if (this.mediaType == null) {
            this.mediaType = MEDIA_TYPE_PLAIN;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostStringRequestBuilder newBuilder() {
        return new PostStringRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostStringRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostStringRequestBuilder(this, abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public void initExtraHttpRequest(PostStringRequestBuilder postStringRequestBuilder) {
        this.content = postStringRequestBuilder.content;
        this.mediaType = postStringRequestBuilder.mediaType;
        if (this.mediaType == null) {
            this.mediaType = MEDIA_TYPE_PLAIN;
        }
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected RequestBody buildOkRequestBody() {
        if (!TextUtils.isEmpty(this.content)) {
            return RequestBody.create(this.mediaType, this.content);
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    /* loaded from: classes14.dex */
    public static class PostStringRequestBuilder extends HttpRequestBuilder<PostStringRequestBuilder> {
        private String content;
        private MediaType mediaType;

        public PostStringRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostStringRequestBuilder(PostStringRequest postStringRequest) {
            this(postStringRequest, null);
        }

        public PostStringRequestBuilder(PostStringRequest postStringRequest, AbstractHttpManager abstractHttpManager) {
            super(postStringRequest, abstractHttpManager);
            this.content = postStringRequest.content;
            this.mediaType = postStringRequest.mediaType;
        }

        public PostStringRequestBuilder content(String str) {
            this.content = str;
            return this;
        }

        public PostStringRequestBuilder mediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public PostStringRequestBuilder mediaType(String str) {
            this.mediaType = MediaType.parse(str);
            return this;
        }

        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public HttpRequest build() {
            return new PostStringRequest(this);
        }
    }
}
