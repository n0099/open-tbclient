package com.baidu.ar.http;

import com.baidu.ar.ihttp.IHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
/* loaded from: classes11.dex */
class i implements IHttpResponse {
    private int qT;
    private String qU;
    private String qV;
    private Charset qs;
    private HttpURLConnection qv;

    public i(HttpURLConnection httpURLConnection, Charset charset) {
        this.qv = httpURLConnection;
        this.qs = charset;
        this.qT = httpURLConnection.getResponseCode();
        this.qU = httpURLConnection.getResponseMessage();
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public int getCode() {
        return this.qT;
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public String getContent() {
        if (this.qV != null) {
            return this.qV;
        }
        InputStream stream = getStream();
        if (stream == null) {
            throw new IOException("Http请求响应输入流已不可访问，请不要在关闭输入流后再调用该方法");
        }
        String name = this.qs.name();
        InputStreamReader inputStreamReader = new InputStreamReader(stream, name);
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[4096];
        for (int read = inputStreamReader.read(cArr); read > 0; read = inputStreamReader.read(cArr)) {
            stringWriter.write(cArr, 0, read);
        }
        String stringWriter2 = stringWriter.toString();
        inputStreamReader.close();
        stringWriter.close();
        if ("utf-8".equalsIgnoreCase(name)) {
            stringWriter2 = j.ap(stringWriter2);
        }
        this.qV = stringWriter2;
        return stringWriter2;
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public int getContentLength() {
        return this.qv.getContentLength();
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public String getHeader(String str) {
        return this.qv.getHeaderField(str);
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public String getMessage() {
        return this.qU;
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public InputStream getStream() {
        return this.qv.getInputStream();
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public boolean isSuccess() {
        int code = getCode();
        return code >= 200 && code < 300;
    }
}
