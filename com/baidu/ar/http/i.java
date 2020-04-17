package com.baidu.ar.http;

import com.baidu.ar.ihttp.IHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
class i implements IHttpResponse {
    private int pP;
    private String pQ;
    private String pR;
    private Charset po;
    private HttpURLConnection pr;

    public i(HttpURLConnection httpURLConnection, Charset charset) {
        this.pr = httpURLConnection;
        this.po = charset;
        this.pP = httpURLConnection.getResponseCode();
        this.pQ = httpURLConnection.getResponseMessage();
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public int getCode() {
        return this.pP;
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public String getContent() {
        if (this.pR != null) {
            return this.pR;
        }
        InputStream stream = getStream();
        if (stream == null) {
            throw new IOException("Http请求响应输入流已不可访问，请不要在关闭输入流后再调用该方法");
        }
        String name = this.po.name();
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
            stringWriter2 = j.ak(stringWriter2);
        }
        this.pR = stringWriter2;
        return stringWriter2;
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public int getContentLength() {
        return this.pr.getContentLength();
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public String getHeader(String str) {
        return this.pr.getHeaderField(str);
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public String getMessage() {
        return this.pQ;
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public InputStream getStream() {
        return this.pr.getInputStream();
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public boolean isSuccess() {
        int code = getCode();
        return code >= 200 && code < 300;
    }
}
