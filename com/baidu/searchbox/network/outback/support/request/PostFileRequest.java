package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.core.CallFactory;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import java.io.File;
import java.util.Map;
/* loaded from: classes4.dex */
public class PostFileRequest extends Request {
    public PostFileRequest(PostFileRequestBuilder postFileRequestBuilder) {
        super(postFileRequestBuilder);
    }

    /* loaded from: classes4.dex */
    public static class PostFileRequestBuilder extends Request.Builder<PostFileRequestBuilder> {
        public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
        public File file;
        public MediaType mediaType;

        public PostFileRequestBuilder(PostFileRequest postFileRequest) {
            super(postFileRequest);
        }

        public PostFileRequestBuilder file(File file) {
            this.file = file;
            return this;
        }

        public PostFileRequestBuilder mediaType(MediaType mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public PostFileRequestBuilder(Map<String, CallFactory> map) {
            super(map);
        }

        public PostFileRequestBuilder file(String str) {
            this.file = new File(str);
            return this;
        }

        public PostFileRequestBuilder mediaType(String str) {
            this.mediaType = MediaType.parse(str);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.network.outback.core.Request.Builder
        public PostFileRequest build() {
            RequestBody create;
            if (this.file != null) {
                if (this.mediaType == null) {
                    this.mediaType = MEDIA_TYPE_STREAM;
                }
                create = RequestBody.create(this.mediaType, this.file);
            } else {
                create = RequestBody.create((MediaType) null, new byte[0]);
            }
            return new PostFileRequest(post(create));
        }
    }
}
