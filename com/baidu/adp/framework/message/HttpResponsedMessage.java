package com.baidu.adp.framework.message;

import d.a.c.e.j.a.e;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class HttpResponsedMessage extends ResponsedMessage<byte[]> {
    public String contentEncoding;
    public String contentLength;
    public String contentType;
    public Map<String, List<String>> mHeader;
    public int mStatusCode;

    public HttpResponsedMessage(int i2) {
        super(i2);
        this.mStatusCode = -1;
        this.mHeader = null;
        this.contentEncoding = "";
        this.contentType = "";
        this.contentLength = "";
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public abstract /* synthetic */ void decodeInBackGround(int i2, T t) throws Exception;

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public String getContentLength() {
        return this.contentLength;
    }

    public String getContentType() {
        return this.contentType;
    }

    public synchronized List<String> getHeader(String str) {
        if (this.mHeader != null) {
            return Collections.unmodifiableList(this.mHeader.get(str));
        }
        return null;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return !isSuccess();
    }

    public boolean isSuccess() {
        int i2 = this.mStatusCode;
        return i2 == 200 || i2 / 100 == 3;
    }

    public void logStatInBackground(int i2, e eVar) {
    }

    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public void setContentLength(String str) {
        this.contentLength = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public synchronized void setHeader(Map<String, List<String>> map) {
        this.mHeader = map;
    }

    public void setStatusCode(int i2, String str) {
        this.mStatusCode = i2;
        if (isSuccess()) {
            return;
        }
        setError(-1);
        setErrorString(str);
    }
}
