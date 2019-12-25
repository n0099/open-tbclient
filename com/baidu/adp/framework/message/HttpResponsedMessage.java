package com.baidu.adp.framework.message;

import com.baidu.adp.lib.network.http.f;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class HttpResponsedMessage extends ResponsedMessage<byte[]> {
    private String contentEncoding;
    private String contentLength;
    private String contentType;
    private Map<String, List<String>> mHeader;
    private int mStatusCode;

    public HttpResponsedMessage(int i) {
        super(i);
        this.mStatusCode = -1;
        this.mHeader = null;
        this.contentEncoding = "";
        this.contentType = "";
        this.contentLength = "";
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public String getContentLength() {
        return this.contentLength;
    }

    public void setContentLength(String str) {
        this.contentLength = str;
    }

    public synchronized void setHeader(Map<String, List<String>> map) {
        this.mHeader = map;
    }

    public synchronized List<String> getHeader(String str) {
        return this.mHeader != null ? Collections.unmodifiableList(this.mHeader.get(str)) : null;
    }

    public boolean isSuccess() {
        return this.mStatusCode == 200 || this.mStatusCode / 100 == 3;
    }

    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public boolean hasError() {
        return !isSuccess();
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setStatusCode(int i, String str) {
        this.mStatusCode = i;
        if (!isSuccess()) {
            setError(-1);
            setErrorString(str);
        }
    }

    public void logStatInBackground(int i, f fVar) {
    }
}
