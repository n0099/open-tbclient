package com.baidu.sapi2.a;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
/* loaded from: classes.dex */
public class a {
    private static final int a = 10;
    private static final int b = 30000;
    private static final int c = 5;
    private static final int d = 8192;
    private static final String e = "Accept-Encoding";
    private static final String f = "gzip";
    private final DefaultHttpClient g;
    private final HttpContext h;
    private ThreadPoolExecutor i;
    private final Map<Context, List<WeakReference<Future<?>>>> j;
    private final Map<String, String> k;

    public a() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, 30000L);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, b);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, b);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ThreadSafeClientConnManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.h = new SyncBasicHttpContext(new BasicHttpContext());
        this.g = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.g.addRequestInterceptor(new b());
        this.g.addResponseInterceptor(new c());
        this.g.setHttpRequestRetryHandler(new com.baidu.sapi2.a.c(5));
        this.i = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.j = new WeakHashMap();
        this.k = new HashMap();
    }

    /* loaded from: classes.dex */
    class b implements HttpRequestInterceptor {
        b() {
        }

        public void process(HttpRequest httpRequest, HttpContext httpContext) {
            if (!httpRequest.containsHeader(a.e)) {
                httpRequest.addHeader(a.e, a.f);
            }
            for (String str : a.this.k.keySet()) {
                httpRequest.addHeader(str, (String) a.this.k.get(str));
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements HttpResponseInterceptor {
        c() {
        }

        public void process(HttpResponse httpResponse, HttpContext httpContext) {
            Header contentEncoding;
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null && (contentEncoding = entity.getContentEncoding()) != null) {
                HeaderElement[] elements = contentEncoding.getElements();
                for (HeaderElement headerElement : elements) {
                    if (headerElement.getName().equalsIgnoreCase(a.f)) {
                        httpResponse.setEntity(new C0009a(httpResponse.getEntity()));
                        return;
                    }
                }
            }
        }
    }

    public void a(CookieStore cookieStore) {
        this.h.setAttribute("http.cookie-store", cookieStore);
    }

    public void a(String str) {
        HttpProtocolParams.setUserAgent(this.g.getParams(), str);
    }

    public void a(String str, i iVar) {
        a((Context) null, str, (com.baidu.sapi2.a.b) null, iVar);
    }

    public void a(String str, com.baidu.sapi2.a.b bVar, i iVar) {
        a((Context) null, str, bVar, iVar);
    }

    public void a(Context context, String str, i iVar) {
        a(context, str, (com.baidu.sapi2.a.b) null, iVar);
    }

    public void a(Context context, String str, com.baidu.sapi2.a.b bVar, i iVar) {
        a(this.g, this.h, (HttpUriRequest) new HttpGet(a(str, bVar)), (String) null, iVar, context);
    }

    public void a(Context context, String str, Header[] headerArr, com.baidu.sapi2.a.b bVar, i iVar) {
        HttpGet httpGet = new HttpGet(a(str, bVar));
        if (headerArr != null) {
            httpGet.setHeaders(headerArr);
        }
        a(this.g, this.h, (HttpUriRequest) httpGet, (String) null, iVar, context);
    }

    public void b(String str, i iVar) {
        b(null, str, null, iVar);
    }

    public void b(String str, com.baidu.sapi2.a.b bVar, i iVar) {
        b(null, str, bVar, iVar);
    }

    public void b(Context context, String str, com.baidu.sapi2.a.b bVar, i iVar) {
        a(context, str, a(bVar), (String) null, iVar);
    }

    public void a(Context context, String str, HttpEntity httpEntity, String str2, i iVar) {
        a(this.g, this.h, (HttpUriRequest) a((HttpEntityEnclosingRequestBase) new HttpPost(str), httpEntity), str2, iVar, context);
    }

    public void a(Context context, String str, Header[] headerArr, com.baidu.sapi2.a.b bVar, String str2, i iVar) {
        HttpPost httpPost = new HttpPost(str);
        if (bVar != null) {
            httpPost.setEntity(a(bVar));
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        a(this.g, this.h, (HttpUriRequest) httpPost, str2, iVar, context);
    }

    public void a(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, i iVar) {
        HttpEntityEnclosingRequestBase a2 = a((HttpEntityEnclosingRequestBase) new HttpPost(str), httpEntity);
        if (headerArr != null) {
            a2.setHeaders(headerArr);
        }
        a(this.g, this.h, (HttpUriRequest) a2, str2, iVar, context);
    }

    public void c(String str, i iVar) {
        c(null, str, null, iVar);
    }

    public void c(String str, com.baidu.sapi2.a.b bVar, i iVar) {
        c(null, str, bVar, iVar);
    }

    public void c(Context context, String str, com.baidu.sapi2.a.b bVar, i iVar) {
        b(context, str, a(bVar), null, iVar);
    }

    public void b(Context context, String str, HttpEntity httpEntity, String str2, i iVar) {
        a(this.g, this.h, (HttpUriRequest) a((HttpEntityEnclosingRequestBase) new HttpPut(str), httpEntity), str2, iVar, context);
    }

    public void b(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, i iVar) {
        HttpEntityEnclosingRequestBase a2 = a((HttpEntityEnclosingRequestBase) new HttpPut(str), httpEntity);
        if (headerArr != null) {
            a2.setHeaders(headerArr);
        }
        a(this.g, this.h, (HttpUriRequest) a2, str2, iVar, context);
    }

    public void d(String str, i iVar) {
        b((Context) null, str, iVar);
    }

    public void b(Context context, String str, i iVar) {
        a(this.g, this.h, (HttpUriRequest) new HttpDelete(str), (String) null, iVar, context);
    }

    public void a(Context context, String str, Header[] headerArr, i iVar) {
        HttpDelete httpDelete = new HttpDelete(str);
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        a(this.g, this.h, (HttpUriRequest) httpDelete, (String) null, iVar, context);
    }

    protected void a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, i iVar, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        Future<?> submit = this.i.submit(new f(defaultHttpClient, httpContext, httpUriRequest, iVar));
        if (context != null) {
            List<WeakReference<Future<?>>> list = this.j.get(context);
            if (list == null) {
                list = new LinkedList<>();
                this.j.put(context, list);
            }
            list.add(new WeakReference<>(submit));
        }
    }

    public static String a(String str, com.baidu.sapi2.a.b bVar) {
        if (bVar != null) {
            String c2 = bVar.c();
            if (!str.contains("?")) {
                return str + "?" + c2;
            }
            return str + "&" + c2;
        }
        return str;
    }

    private HttpEntity a(com.baidu.sapi2.a.b bVar) {
        if (bVar == null) {
            return null;
        }
        return bVar.a();
    }

    private HttpEntityEnclosingRequestBase a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    /* renamed from: com.baidu.sapi2.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0009a extends HttpEntityWrapper {
        public C0009a(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public InputStream getContent() {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }

        public long getContentLength() {
            return -1L;
        }
    }
}
