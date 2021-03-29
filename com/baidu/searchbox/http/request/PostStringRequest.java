package com.baidu.searchbox.http.request;

import android.text.TextUtils;
import com.baidu.searchbox.http.AbstractHttpManager;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
/* loaded from: classes2.dex */
public class PostStringRequest extends HttpRequest<PostStringRequestBuilder> {
    public static final MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain");
    public String content;
    public MediaType mediaType;

    /* loaded from: classes2.dex */
    public static class PostStringRequestBuilder extends HttpRequestBuilder<PostStringRequestBuilder> {
        public String content;
        public MediaType mediaType;

        public PostStringRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public HttpRequest build() {
            return new PostStringRequest(this);
        }

        public PostStringRequestBuilder content(String str) {
            this.content = str;
            return this;
        }

        public PostStringRequestBuilder mediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public PostStringRequestBuilder(PostStringRequest postStringRequest) {
            this(postStringRequest, null);
        }

        public PostStringRequestBuilder mediaType(String str) {
            this.mediaType = MediaType.parse(str);
            return this;
        }

        public PostStringRequestBuilder(PostStringRequest postStringRequest, AbstractHttpManager abstractHttpManager) {
            super(postStringRequest, abstractHttpManager);
            this.content = postStringRequest.content;
            this.mediaType = postStringRequest.mediaType;
        }
    }

    public PostStringRequest(PostStringRequestBuilder postStringRequestBuilder) {
        super(postStringRequestBuilder);
        this.content = postStringRequestBuilder.content;
        MediaType mediaType = postStringRequestBuilder.mediaType;
        this.mediaType = mediaType;
        if (mediaType == null) {
            this.mediaType = MEDIA_TYPE_PLAIN;
        }
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        if (!TextUtils.isEmpty(this.content)) {
            return RequestBody.create(this.mediaType, this.content);
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public void initExtraHttpRequest(PostStringRequestBuilder postStringRequestBuilder) {
        this.content = postStringRequestBuilder.content;
        MediaType mediaType = postStringRequestBuilder.mediaType;
        this.mediaType = mediaType;
        if (mediaType == null) {
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
}
