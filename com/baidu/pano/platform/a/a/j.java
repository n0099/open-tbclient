package com.baidu.pano.platform.a.a;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
/* loaded from: classes4.dex */
public class j implements i {

    /* renamed from: a  reason: collision with root package name */
    private final a f3861a;

    /* renamed from: b  reason: collision with root package name */
    private final SSLSocketFactory f3862b;

    /* loaded from: classes4.dex */
    public interface a {
        String a(String str);
    }

    public j() {
        this(null);
    }

    public j(a aVar) {
        this(aVar, null);
    }

    public j(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.f3861a = aVar;
        this.f3862b = sSLSocketFactory;
    }

    @Override // com.baidu.pano.platform.a.a.i
    public HttpResponse a(com.baidu.pano.platform.a.n<?> nVar, Map<String, String> map) throws IOException, com.baidu.pano.platform.a.a {
        String str;
        String c = nVar.c();
        HashMap hashMap = new HashMap();
        hashMap.putAll(nVar.i());
        hashMap.putAll(map);
        if (this.f3861a != null) {
            str = this.f3861a.a(c);
            if (str == null) {
                throw new IOException("URL blocked by rewriter: " + c);
            }
        } else {
            str = c;
        }
        HttpURLConnection a2 = a(new URL(str), nVar);
        for (String str2 : hashMap.keySet()) {
            a2.addRequestProperty(str2, (String) hashMap.get(str2));
        }
        a(a2, nVar);
        ProtocolVersion protocolVersion = new ProtocolVersion(HttpVersion.HTTP, 1, 1);
        if (a2.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a2.getResponseCode(), a2.getResponseMessage()));
        basicHttpResponse.setEntity(a(a2));
        for (Map.Entry<String, List<String>> entry : a2.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
            }
        }
        return basicHttpResponse;
    }

    private static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException e) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength(httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    protected HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private HttpURLConnection a(URL url, com.baidu.pano.platform.a.n<?> nVar) throws IOException {
        HttpURLConnection a2 = a(url);
        int t = nVar.t();
        a2.setConnectTimeout(t);
        a2.setReadTimeout(t);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && this.f3862b != null) {
            ((HttpsURLConnection) a2).setSSLSocketFactory(this.f3862b);
        }
        return a2;
    }

    static void a(HttpURLConnection httpURLConnection, com.baidu.pano.platform.a.n<?> nVar) throws IOException, com.baidu.pano.platform.a.a {
        switch (nVar.a()) {
            case -1:
                byte[] m = nVar.m();
                if (m != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.addRequestProperty("Content-Type", nVar.l());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(m);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, nVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                b(httpURLConnection, nVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod(HttpDelete.METHOD_NAME);
                return;
            case 4:
                httpURLConnection.setRequestMethod(HttpHead.METHOD_NAME);
                return;
            case 5:
                httpURLConnection.setRequestMethod(HttpOptions.METHOD_NAME);
                return;
            case 6:
                httpURLConnection.setRequestMethod(HttpTrace.METHOD_NAME);
                return;
            case 7:
                httpURLConnection.setRequestMethod("PATCH");
                b(httpURLConnection, nVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    private static void b(HttpURLConnection httpURLConnection, com.baidu.pano.platform.a.n<?> nVar) throws IOException, com.baidu.pano.platform.a.a {
        byte[] q = nVar.q();
        if (q != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", nVar.p());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(q);
            dataOutputStream.close();
        }
    }
}
