package com.baidu.searchbox.network.outback.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import java.util.Map;
/* loaded from: classes4.dex */
public class PostByteRequest extends Request {
    public PostByteRequest(PostByteRequestBuilder postByteRequestBuilder) {
        super(postByteRequestBuilder);
    }

    /* loaded from: classes4.dex */
    public static class PostByteRequestBuilder extends Request.Builder<PostByteRequestBuilder> {
        public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
        public byte[] contentBuffer;
        public MediaType mediaType;

        public PostByteRequestBuilder(PostByteRequest postByteRequest) {
            super(postByteRequest);
        }

        public PostByteRequestBuilder content(byte[] bArr) {
            this.contentBuffer = bArr;
            return this;
        }

        public PostByteRequestBuilder mediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public PostByteRequestBuilder(Map<String, CallFactory> map) {
            super(map);
        }

        public PostByteRequestBuilder mediaType(String str) {
            this.mediaType = MediaType.parse(str);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public PostByteRequest build() {
            RequestBody requestBody;
            byte[] bArr = this.contentBuffer;
            if (bArr != null && bArr.length > 0) {
                if (this.mediaType == null) {
                    this.mediaType = MEDIA_TYPE_STREAM;
                }
                requestBody = RequestBody.create(this.mediaType, this.contentBuffer);
            } else {
                requestBody = this.body;
                if (requestBody == null) {
                    requestBody = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
            return new PostByteRequest(post(requestBody));
        }
    }
}
