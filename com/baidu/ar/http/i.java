package com.baidu.ar.http;

import com.baidu.ar.ihttp.IHttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class i implements IHttpResponse {
    public Charset qI;
    public HttpURLConnection qL;
    public int rj;
    public String rk;
    public String rl;

    public i(HttpURLConnection httpURLConnection, Charset charset) {
        this.qL = httpURLConnection;
        this.qI = charset;
        this.rj = httpURLConnection.getResponseCode();
        this.rk = httpURLConnection.getResponseMessage();
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public int getCode() {
        return this.rj;
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public String getContent() {
        String str = this.rl;
        if (str != null) {
            return str;
        }
        InputStream stream = getStream();
        if (stream != null) {
            String name = this.qI.name();
            InputStreamReader inputStreamReader = new InputStreamReader(stream, name);
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[4096];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            String stringWriter2 = stringWriter.toString();
            inputStreamReader.close();
            stringWriter.close();
            if ("utf-8".equalsIgnoreCase(name)) {
                stringWriter2 = j.as(stringWriter2);
            }
            this.rl = stringWriter2;
            return stringWriter2;
        }
        throw new IOException("Http请求响应输入流已不可访问，请不要在关闭输入流后再调用该方法");
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public int getContentLength() {
        return this.qL.getContentLength();
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public String getHeader(String str) {
        return this.qL.getHeaderField(str);
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public String getMessage() {
        return this.rk;
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public InputStream getStream() {
        return this.qL.getInputStream();
    }

    @Override // com.baidu.ar.ihttp.IHttpResponse
    public boolean isSuccess() {
        int code = getCode();
        return code >= 200 && code < 300;
    }
}
