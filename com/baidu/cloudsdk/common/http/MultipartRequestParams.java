package com.baidu.cloudsdk.common.http;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpEntity;
/* loaded from: classes.dex */
public class MultipartRequestParams extends RequestParams {
    protected HashMap<String, FileWrapper> mFileParams;

    public MultipartRequestParams() {
        this.mFileParams = new HashMap<>();
    }

    public MultipartRequestParams(String str, String str2) {
        super(str, str2);
        this.mFileParams = new HashMap<>();
    }

    public MultipartRequestParams(Map<String, String> map) {
        super(map);
        this.mFileParams = new HashMap<>();
    }

    public MultipartRequestParams(Object... objArr) {
        super(objArr);
        this.mFileParams = new HashMap<>();
    }

    public void put(String str, File file) {
        if (file != null) {
            put(str, new FileInputStream(file), file.getName());
        }
    }

    public void put(String str, InputStream inputStream) {
        put(str, inputStream, null);
    }

    public void put(String str, InputStream inputStream, String str2) {
        if (TextUtils.isEmpty(str2)) {
            put(str, inputStream, str2, "png");
        } else {
            put(str, inputStream, str2, URLConnection.getFileNameMap().getContentTypeFor(str2));
        }
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && inputStream != null) {
            this.mFileParams.put(str, new FileWrapper(inputStream, str2, str3));
        }
    }

    @Override // com.baidu.cloudsdk.common.http.RequestParams
    public void remove(String str) {
        super.remove(str);
        if (str != null) {
            this.mFileParams.remove(str);
        }
    }

    @Override // com.baidu.cloudsdk.common.http.RequestParams
    public HttpEntity getHttpEntity() {
        if (this.mFileParams.isEmpty()) {
            return super.getHttpEntity();
        }
        MultipartEntity multipartEntity = new MultipartEntity();
        for (Map.Entry<String, String> entry : this.mParams.entrySet()) {
            multipartEntity.addPart(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, ArrayList<String>> entry2 : this.mParamsWithArray.entrySet()) {
            String key = entry2.getKey();
            Iterator<String> it = entry2.getValue().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    multipartEntity.addPart(key, next);
                }
            }
        }
        int size = this.mFileParams.entrySet().size() - 1;
        int i = 0;
        for (Map.Entry<String, FileWrapper> entry3 : this.mFileParams.entrySet()) {
            FileWrapper value = entry3.getValue();
            multipartEntity.addPart(entry3.getKey(), value.getFileName(), value.mIn, value.mContentType, i == size);
            i++;
        }
        return multipartEntity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.RequestParams
    public StringBuilder getStringBuilder() {
        StringBuilder stringBuilder = super.getStringBuilder();
        for (Map.Entry<String, FileWrapper> entry : this.mFileParams.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(entry.getKey()).append("=").append("FILE");
        }
        return stringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class FileWrapper {
        public String mContentType;
        public String mFileName;
        public InputStream mIn;

        public FileWrapper(InputStream inputStream, String str, String str2) {
            this.mIn = inputStream;
            this.mFileName = str;
            this.mContentType = str2;
        }

        public String getFileName() {
            return this.mFileName != null ? this.mFileName : "nofilename";
        }
    }
}
