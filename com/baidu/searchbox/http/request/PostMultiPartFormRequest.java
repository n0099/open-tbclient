package com.baidu.searchbox.http.request;

import android.text.TextUtils;
import com.baidu.searchbox.http.AbstractHttpManager;
import java.io.File;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
/* loaded from: classes2.dex */
public class PostMultiPartFormRequest extends HttpParaRequest<PostMultiPartFormRequestBuilder> {
    public List<PostBytes> bytes;
    public List<PostFile> files;

    /* loaded from: classes2.dex */
    public static class PostBytes {
        public byte[] bytes;
        public String contentType;
        public String fileName;
        public String key;

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

        public PostBytes(String str, String str2, byte[] bArr) {
            this(str, str2, null, bArr);
        }
    }

    /* loaded from: classes2.dex */
    public static class PostFile {
        public String contentType;
        public File file;
        public String fileName;
        public String key;

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

        public static String guessMimeType(String str) {
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str);
            if (TextUtils.isEmpty(contentTypeFor)) {
                return "application/octet-stream";
            }
            return contentTypeFor;
        }
    }

    /* loaded from: classes2.dex */
    public static class PostMultiPartFormRequestBuilder extends HttpRequestParasBuilder<PostMultiPartFormRequestBuilder> {
        public List<PostBytes> postBytes;
        public List<PostFile> postFiles;

        public PostMultiPartFormRequestBuilder(AbstractHttpManager abstractHttpManager) {
            super(abstractHttpManager);
        }

        public PostMultiPartFormRequestBuilder addBytes(PostBytes postBytes) {
            if (this.postBytes == null) {
                this.postBytes = new ArrayList();
            }
            this.postBytes.add(postBytes);
            return this;
        }

        public PostMultiPartFormRequestBuilder addFile(PostFile postFile) {
            if (this.postFiles == null) {
                this.postFiles = new ArrayList();
            }
            this.postFiles.add(postFile);
            return this;
        }

        public PostMultiPartFormRequestBuilder addFiles(List<PostFile> list) {
            List<PostFile> list2 = this.postFiles;
            if (list2 == null) {
                this.postFiles = new ArrayList(list);
            } else {
                list2.addAll(list);
            }
            return this;
        }

        public PostMultiPartFormRequestBuilder bytes(List<PostBytes> list) {
            this.postBytes = new ArrayList(list);
            return this;
        }

        public PostMultiPartFormRequestBuilder files(List<PostFile> list) {
            this.postFiles = new ArrayList(list);
            return this;
        }

        public PostMultiPartFormRequestBuilder(PostMultiPartFormRequest postMultiPartFormRequest) {
            this(postMultiPartFormRequest, null);
        }

        public PostMultiPartFormRequestBuilder addBytes(List<PostBytes> list) {
            List<PostBytes> list2 = this.postBytes;
            if (list2 == null) {
                this.postBytes = new ArrayList(list);
            } else {
                list2.addAll(list);
            }
            return this;
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

        public PostMultiPartFormRequestBuilder addBytes(String str, String str2, String str3, byte[] bArr) {
            return addBytes(new PostBytes(str, str2, str3, bArr));
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, String str3, File file) {
            return addFile(new PostFile(str, str2, str3, file));
        }

        public PostMultiPartFormRequestBuilder addBytes(String str, String str2, byte[] bArr) {
            return addBytes(new PostBytes(str, str2, bArr));
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, File file) {
            return addFile(new PostFile(str, str2, file));
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, String str3) {
            return addFile(new PostFile(str, str2, new File(str3)));
        }

        public PostMultiPartFormRequestBuilder addFile(String str, String str2, String str3, String str4) {
            return addFile(new PostFile(str, str2, str3, new File(str4)));
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
        public PostMultiPartFormRequest build() {
            return new PostMultiPartFormRequest(this);
        }
    }

    public PostMultiPartFormRequest(PostMultiPartFormRequestBuilder postMultiPartFormRequestBuilder) {
        super(postMultiPartFormRequestBuilder);
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public Request buildOkRequest(RequestBody requestBody) {
        return this.okRequestBuilder.post(requestBody).build();
    }

    @Override // com.baidu.searchbox.http.request.HttpRequest
    public RequestBody buildOkRequestBody() {
        List<PostFile> list;
        LinkedHashMap<String, String> linkedHashMap = this.params;
        if ((linkedHashMap != null && !linkedHashMap.isEmpty()) || ((list = this.files) != null && list.size() > 0)) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            LinkedHashMap<String, String> linkedHashMap2 = this.params;
            if (linkedHashMap2 != null && !linkedHashMap2.isEmpty()) {
                for (Map.Entry<String, String> entry : this.params.entrySet()) {
                    builder.addFormDataPart(entry.getKey(), entry.getValue());
                }
            }
            List<PostFile> list2 = this.files;
            if (list2 != null && list2.size() > 0) {
                for (PostFile postFile : this.files) {
                    builder.addFormDataPart(postFile.key, postFile.fileName, RequestBody.create(MediaType.parse(postFile.contentType), postFile.file));
                }
            }
            List<PostBytes> list3 = this.bytes;
            if (list3 != null && list3.size() > 0) {
                for (PostBytes postBytes : this.bytes) {
                    builder.addFormDataPart(postBytes.key, postBytes.fileName, RequestBody.create(MediaType.parse(postBytes.contentType), postBytes.bytes));
                }
            }
            return builder.build();
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostMultiPartFormRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
        return new PostMultiPartFormRequestBuilder(this, abstractHttpManager);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpParaRequest
    public void initExtraHttpRequest(PostMultiPartFormRequestBuilder postMultiPartFormRequestBuilder) {
        super.initExtraHttpRequest((PostMultiPartFormRequest) postMultiPartFormRequestBuilder);
        if (postMultiPartFormRequestBuilder.postFiles != null) {
            this.files = Util.immutableList(postMultiPartFormRequestBuilder.postFiles);
        }
        if (postMultiPartFormRequestBuilder.postBytes != null) {
            this.bytes = Util.immutableList(postMultiPartFormRequestBuilder.postBytes);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.request.HttpRequest
    public PostMultiPartFormRequestBuilder newBuilder() {
        return new PostMultiPartFormRequestBuilder(this);
    }
}
