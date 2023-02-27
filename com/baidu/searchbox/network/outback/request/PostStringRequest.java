package com.baidu.searchbox.network.outback.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.searchbox.network.outback.core.internal.Util;
import java.util.Map;
/* loaded from: classes2.dex */
public class PostStringRequest extends Request {
    public PostStringRequest(PostStringRequestBuilder postStringRequestBuilder) {
        super(postStringRequestBuilder);
    }

    /* loaded from: classes2.dex */
    public static class PostStringRequestBuilder extends Request.Builder<PostStringRequestBuilder> {
        public static final MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain");
        public String content;
        public MediaType mediaType;

        public PostStringRequestBuilder(PostStringRequest postStringRequest) {
            super(postStringRequest);
        }

        public PostStringRequestBuilder content(String str) {
            this.content = str;
            return this;
        }

        public PostStringRequestBuilder mediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public PostStringRequestBuilder(Map<String, CallFactory> map) {
            super(map);
        }

        public PostStringRequestBuilder mediaType(String str) {
            this.mediaType = MediaType.parse(str);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public PostStringRequest build() {
            RequestBody requestBody;
            if (this.mediaType == null) {
                this.mediaType = MEDIA_TYPE_PLAIN;
            }
            if (!Util.isTextEmpty(this.content)) {
                requestBody = RequestBody.create(this.mediaType, this.content);
            } else {
                requestBody = this.body;
                if (requestBody == null) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
            return new PostStringRequest(post(requestBody));
        }
    }
}
