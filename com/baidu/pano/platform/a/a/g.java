package com.baidu.pano.platform.a.a;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
/* loaded from: classes3.dex */
public class g implements i {

    /* renamed from: a  reason: collision with root package name */
    protected final HttpClient f3895a;

    public g(HttpClient httpClient) {
        this.f3895a = httpClient;
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    @Override // com.baidu.pano.platform.a.a.i
    public HttpResponse a(com.baidu.pano.platform.a.n<?> nVar, Map<String, String> map) throws IOException, com.baidu.pano.platform.a.a {
        HttpUriRequest b2 = b(nVar, map);
        a(b2, map);
        a(b2, nVar.i());
        a(b2);
        HttpParams params = b2.getParams();
        int t = nVar.t();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, t);
        return this.f3895a.execute(b2);
    }

    static HttpUriRequest b(com.baidu.pano.platform.a.n<?> nVar, Map<String, String> map) throws com.baidu.pano.platform.a.a {
        switch (nVar.a()) {
            case -1:
                byte[] m = nVar.m();
                if (m != null) {
                    HttpPost httpPost = new HttpPost(nVar.c());
                    httpPost.addHeader("Content-Type", nVar.l());
                    httpPost.setEntity(new ByteArrayEntity(m));
                    return httpPost;
                }
                return new HttpGet(nVar.c());
            case 0:
                return new HttpGet(nVar.c());
            case 1:
                HttpPost httpPost2 = new HttpPost(nVar.c());
                httpPost2.addHeader("Content-Type", nVar.p());
                a(httpPost2, nVar);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(nVar.c());
                httpPut.addHeader("Content-Type", nVar.p());
                a(httpPut, nVar);
                return httpPut;
            case 3:
                return new HttpDelete(nVar.c());
            case 4:
                return new HttpHead(nVar.c());
            case 5:
                return new HttpOptions(nVar.c());
            case 6:
                return new HttpTrace(nVar.c());
            case 7:
                a aVar = new a(nVar.c());
                aVar.addHeader("Content-Type", nVar.p());
                a(aVar, nVar);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, com.baidu.pano.platform.a.n<?> nVar) throws com.baidu.pano.platform.a.a {
        byte[] q = nVar.q();
        if (q != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(q));
        }
    }

    protected void a(HttpUriRequest httpUriRequest) throws IOException {
    }

    /* loaded from: classes3.dex */
    public static final class a extends HttpEntityEnclosingRequestBase {
        public a() {
        }

        public a(String str) {
            setURI(URI.create(str));
        }

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return "PATCH";
        }
    }
}
