package com.baidu.searchbox.http.request;

import android.text.TextUtils;
import com.baidu.searchbox.http.AbstractHttpManager;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
/* loaded from: classes13.dex */
public class PostMultiPartFormRequest extends HttpParaRequest<PostMultiPartFormRequestBuilder> {
    private List<PostBytes> bytes;
    private List<PostFile> files;

    public PostMultiPartFormRequest(PostMultiPartFormRequestBuilder postMultiPartFormRequestBuilder) {
        super(postMultiPartFormRequestBuilder);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostMultiPartFormRequestBuilder newBuilder() {
        return new PostMultiPartFormRequestBuilder(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostMultiPartFormRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostMultiPartFormRequestBuilder(this, abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.http.request.HttpParaRequest
    public void initExtraHttpRequest(PostMultiPartFormRequestBuilder postMultiPartFormRequestBuilder) {
        super.initExtraHttpRequest((PostMultiPartFormRequest) postMultiPartFormRequestBuilder);
        if (postMultiPartFormRequestBuilder.postFiles != null) {
            this.files = Util.immutableList(postMultiPartFormRequestBuilder.postFiles);
        }
        if (postMultiPartFormRequestBuilder.postBytes == null) {
            return;
        }
        this.bytes = Util.immutableList(postMultiPartFormRequestBuilder.postBytes);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected RequestBody buildOkRequestBody() {
        if ((this.params != null && !this.params.isEmpty()) || (this.files != null && this.files.size() > 0)) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            if (this.params != null && !this.params.isEmpty()) {
                for (Map.Entry<String, String> entry : this.params.entrySet()) {
                    builder.addFormDataPart(entry.getKey(), entry.getValue());
                }
            }
            if (this.files != null && this.files.size() > 0) {
                for (PostFile postFile : this.files) {
                    builder.addFormDataPart(postFile.key, postFile.fileName, RequestBody.create(MediaType.parse(postFile.contentType), postFile.file));
                }
            }
            if (this.bytes != null && this.bytes.size() > 0) {
                for (PostBytes postBytes : this.bytes) {
                    builder.addFormDataPart(postBytes.key, postBytes.fileName, RequestBody.create(MediaType.parse(postBytes.contentType), postBytes.bytes));
                }
            }
            return builder.build();
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    protected Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    /* loaded from: classes13.dex */
    public static class PostFile {
        private String contentType;
        private File file;
        private String fileName;
        private String key;

        public PostFile(String str, String str2, File file) {
            this(str, str2, null, file);
        }

        public PostFile(String str, String str2, String str3, File file) {
            this.key = str;
            this.fileName = str2;
            this.file = file;
            if (TextUtils.isEmpty(str3)) {
                this.contentType = guessMimeType(str2);
            } else {
                this.contentType = str3;
            }
        }

        static String guessMimeType(String str) {
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
            if (TextUtils.isEmpty(contentTypeFor)) {
                return "application/octet-stream";
            }
            return contentTypeFor;
        }
    }

    /* loaded from: classes13.dex */
    public static class PostBytes {
        private byte[] bytes;
        private String contentType;
        private String fileName;
        private String key;

        public PostBytes(String str, String str2, byte[] bArr) {
            this(str, str2, null, bArr);
        }

        public PostBytes(String str, String str2, String str3, byte[] bArr) {
            this.key = str;
            this.fileName = str2;
            this.bytes = bArr;
            if (TextUtils.isEmpty(str3)) {
                this.contentType = PostFile.guessMimeType(str2);
            } else {
                this.contentType = str3;
            }
        }
    }

    /* loaded from: classes13.dex */
    public static class PostMultiPartFormRequestBuilder extends HttpRequestParasBuilder<PostMultiPartFormRequestBuilder> {
        private List<PostBytes> postBytes;
        private List<PostFile> postFiles;

        public PostMultiPartFormRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostMultiPartFormRequestBuilder(PostMultiPartFormRequest postMultiPartFormRequest) {
            this(postMultiPartFormRequest, null);
        }

        public PostMultiPartFormRequestBuilder(PostMultiPartFormRequest postMultiPartFormRequest, AbstractHttpManager abstractHttpManager) {
            super(postMultiPartFormRequest, abstractHttpManager);
            if (postMultiPartFormRequest.files != null) {
                this.postFiles = new ArrayList(postMultiPartFormRequest.files);
            }
            if (postMultiPartFormRequest.bytes != null) {
                this.postBytes = new ArrayList(postMultiPartFormRequest.bytes);
            }
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, File file) {
            return addFile(new PostFile(str, str2, file));
        }

        public PostMultiPartFormRequestBuilder addBytes(String str, String str2, byte[] bArr) {
            return addBytes(new PostBytes(str, str2, bArr));
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, String str3) {
            return addFile(new PostFile(str, str2, new File(str3)));
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, String str3, File file) {
            return addFile(new PostFile(str, str2, str3, file));
        }

        public PostMultiPartFormRequestBuilder addBytes(String str, String str2, String str3, byte[] bArr) {
            return addBytes(new PostBytes(str, str2, str3, bArr));
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, String str3, String str4) {
            return addFile(new PostFile(str, str2, str3, new File(str4)));
        }

        public PostMultiPartFormRequestBuilder addFile(PostFile postFile) {
            if (this.postFiles == null) {
                this.postFiles = new ArrayList();
            }
            this.postFiles.add(postFile);
            return this;
        }

        public PostMultiPartFormRequestBuilder addBytes(PostBytes postBytes) {
            if (this.postBytes == null) {
                this.postBytes = new ArrayList();
            }
            this.postBytes.add(postBytes);
            return this;
        }

        public PostMultiPartFormRequestBuilder files(List<PostFile> list) {
            this.postFiles = new ArrayList(list);
            return this;
        }

        public PostMultiPartFormRequestBuilder bytes(List<PostBytes> list) {
            this.postBytes = new ArrayList(list);
            return this;
        }

        public PostMultiPartFormRequestBuilder addFiles(List<PostFile> list) {
            if (this.postFiles == null) {
                this.postFiles = new ArrayList(list);
            } else {
                this.postFiles.addAll(list);
            }
            return this;
        }

        public PostMultiPartFormRequestBuilder addBytes(List<PostBytes> list) {
            if (this.postBytes == null) {
                this.postBytes = new ArrayList(list);
            } else {
                this.postBytes.addAll(list);
            }
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostMultiPartFormRequest build() {
            return new PostMultiPartFormRequest(this);
        }
    }
}
