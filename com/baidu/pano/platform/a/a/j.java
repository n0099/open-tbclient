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
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
/* loaded from: classes2.dex */
public class j implements i {

    /* renamed from: a  reason: collision with root package name */
    public final a f9225a;

    /* renamed from: b  reason: collision with root package name */
    public final SSLSocketFactory f9226b;

    /* loaded from: classes2.dex */
    public interface a {
        String a(String str);
    }

    public j() {
        this(null);
    }

    public static void b(HttpURLConnection httpURLConnection, com.baidu.pano.platform.a.n<?> nVar) throws IOException, com.baidu.pano.platform.a.a {
        byte[] q = nVar.q();
        if (q != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", nVar.p());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(q);
            dataOutputStream.close();
        }
    }

    @Override // com.baidu.pano.platform.a.a.i
    public HttpResponse a(com.baidu.pano.platform.a.n<?> nVar, Map<String, String> map) throws IOException, com.baidu.pano.platform.a.a {
        String c2 = nVar.c();
        HashMap hashMap = new HashMap();
        hashMap.putAll(nVar.i());
        hashMap.putAll(map);
        a aVar = this.f9225a;
        if (aVar != null) {
            String a2 = aVar.a(c2);
            if (a2 == null) {
                throw new IOException("URL blocked by rewriter: " + c2);
            }
            c2 = a2;
        }
        HttpURLConnection a3 = a(new URL(c2), nVar);
        for (String str : hashMap.keySet()) {
            a3.addRequestProperty(str, (String) hashMap.get(str));
        }
        a(a3, nVar);
        ProtocolVersion protocolVersion = new ProtocolVersion(HttpVersion.HTTP, 1, 1);
        if (a3.getResponseCode() != -1) {
            BasicHttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(protocolVersion, a3.getResponseCode(), a3.getResponseMessage()));
            basicHttpResponse.setEntity(a(a3));
            for (Map.Entry<String, List<String>> entry : a3.getHeaderFields().entrySet()) {
                if (entry.getKey() != null) {
                    basicHttpResponse.addHeader(new BasicHeader(entry.getKey(), entry.getValue().get(0)));
                }
            }
            return basicHttpResponse;
        }
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
    }

    public j(a aVar) {
        this(aVar, null);
    }

    public j(a aVar, SSLSocketFactory sSLSocketFactory) {
        this.f9225a = aVar;
        this.f9226b = sSLSocketFactory;
    }

    public static HttpEntity a(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        basicHttpEntity.setContent(errorStream);
        basicHttpEntity.setContentLength(httpURLConnection.getContentLength());
        basicHttpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        basicHttpEntity.setContentType(httpURLConnection.getContentType());
        return basicHttpEntity;
    }

    public HttpURLConnection a(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    private HttpURLConnection a(URL url, com.baidu.pano.platform.a.n<?> nVar) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection a2 = a(url);
        int t = nVar.t();
        a2.setConnectTimeout(t);
        a2.setReadTimeout(t);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f9226b) != null) {
            ((HttpsURLConnection) a2).setSSLSocketFactory(sSLSocketFactory);
        }
        return a2;
    }

    public static void a(HttpURLConnection httpURLConnection, com.baidu.pano.platform.a.n<?> nVar) throws IOException, com.baidu.pano.platform.a.a {
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
                httpURLConnection.setRequestMethod("HEAD");
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
}
