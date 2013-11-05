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
    protected HashMap mFileParams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f819a;
        public String b;
        public InputStream c;

        public a(InputStream inputStream, String str, String str2) {
            this.c = inputStream;
            this.f819a = str;
            this.b = str2;
        }

        public String a() {
            return this.f819a != null ? this.f819a : "nofilename";
        }
    }

    public MultipartRequestParams() {
        this.mFileParams = new HashMap();
    }

    public MultipartRequestParams(String str, String str2) {
        super(str, str2);
        this.mFileParams = new HashMap();
    }

    public MultipartRequestParams(Map map) {
        super(map);
        this.mFileParams = new HashMap();
    }

    public MultipartRequestParams(Object... objArr) {
        super(objArr);
        this.mFileParams = new HashMap();
    }

    @Override // com.baidu.cloudsdk.common.http.RequestParams
    public HttpEntity getHttpEntity() {
        if (this.mFileParams.isEmpty()) {
            return super.getHttpEntity();
        }
        bj bjVar = new bj();
        for (Map.Entry entry : this.mParams.entrySet()) {
            bjVar.a((String) entry.getKey(), (String) entry.getValue());
        }
        for (Map.Entry entry2 : this.mParamsWithArray.entrySet()) {
            String str = (String) entry2.getKey();
            Iterator it = ((ArrayList) entry2.getValue()).iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!TextUtils.isEmpty(str2)) {
                    bjVar.a(str, str2);
                }
            }
        }
        int size = this.mFileParams.entrySet().size() - 1;
        int i = 0;
        for (Map.Entry entry3 : this.mFileParams.entrySet()) {
            a aVar = (a) entry3.getValue();
            bjVar.a((String) entry3.getKey(), aVar.a(), aVar.c, aVar.b, i == size);
            i++;
        }
        return bjVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.cloudsdk.common.http.RequestParams
    public StringBuilder getStringBuilder() {
        StringBuilder stringBuilder = super.getStringBuilder();
        for (Map.Entry entry : this.mFileParams.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append((String) entry.getKey()).append("=").append("FILE");
        }
        return stringBuilder;
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
        if (TextUtils.isEmpty(str) || inputStream == null) {
            return;
        }
        this.mFileParams.put(str, new a(inputStream, str2, str3));
    }

    @Override // com.baidu.cloudsdk.common.http.RequestParams
    public void remove(String str) {
        super.remove(str);
        if (str != null) {
            this.mFileParams.remove(str);
        }
    }
}
