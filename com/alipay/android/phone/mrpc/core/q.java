package com.alipay.android.phone.mrpc.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes.dex */
public final class q implements Callable<u> {

    /* renamed from: e  reason: collision with root package name */
    public static final HttpRequestRetryHandler f1715e = new ad();

    /* renamed from: a  reason: collision with root package name */
    public l f1716a;

    /* renamed from: b  reason: collision with root package name */
    public Context f1717b;

    /* renamed from: c  reason: collision with root package name */
    public o f1718c;

    /* renamed from: d  reason: collision with root package name */
    public String f1719d;

    /* renamed from: f  reason: collision with root package name */
    public HttpUriRequest f1720f;
    public CookieManager i;
    public AbstractHttpEntity j;
    public HttpHost k;
    public URL l;
    public String q;

    /* renamed from: g  reason: collision with root package name */
    public HttpContext f1721g = new BasicHttpContext();

    /* renamed from: h  reason: collision with root package name */
    public CookieStore f1722h = new BasicCookieStore();
    public int m = 0;
    public boolean n = false;
    public boolean o = false;
    public String p = null;

    public q(l lVar, o oVar) {
        this.f1716a = lVar;
        this.f1717b = lVar.f1693a;
        this.f1718c = oVar;
    }

    public static long a(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (ClientCookie.MAX_AGE_ATTR.equalsIgnoreCase(strArr[i])) {
                int i2 = i + 1;
                if (strArr[i2] != null) {
                    try {
                        return Long.parseLong(strArr[i2]);
                    } catch (Exception unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return 0L;
    }

    public static HttpUrlHeader a(HttpResponse httpResponse) {
        Header[] allHeaders;
        HttpUrlHeader httpUrlHeader = new HttpUrlHeader();
        for (Header header : httpResponse.getAllHeaders()) {
            httpUrlHeader.setHead(header.getName(), header.getValue());
        }
        return httpUrlHeader;
    }

    private u a(HttpResponse httpResponse, int i, String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        new StringBuilder("开始handle，handleResponse-1,").append(Thread.currentThread().getId());
        HttpEntity entity = httpResponse.getEntity();
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        String str3 = null;
        if (entity == null || httpResponse.getStatusLine().getStatusCode() != 200) {
            if (entity == null) {
                httpResponse.getStatusLine().getStatusCode();
                return null;
            }
            return null;
        }
        new StringBuilder("200，开始处理，handleResponse-2,threadid = ").append(Thread.currentThread().getId());
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
            th = th;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(entity, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.o = false;
            this.f1716a.c(System.currentTimeMillis() - currentTimeMillis);
            this.f1716a.a(byteArray.length);
            new StringBuilder("res:").append(byteArray.length);
            p pVar = new p(a(httpResponse), i, str, byteArray);
            long b2 = b(httpResponse);
            Header contentType = httpResponse.getEntity().getContentType();
            if (contentType != null) {
                HashMap<String, String> a2 = a(contentType.getValue());
                str3 = a2.get("Content-Type");
                str2 = a2.get("charset");
            } else {
                str2 = null;
            }
            pVar.b(str3);
            pVar.a(str2);
            pVar.a(System.currentTimeMillis());
            pVar.b(b2);
            try {
                byteArrayOutputStream.close();
                return pVar;
            } catch (IOException e2) {
                throw new RuntimeException("ArrayOutputStream close error!", e2.getCause());
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e3) {
                    throw new RuntimeException("ArrayOutputStream close error!", e3.getCause());
                }
            }
            throw th;
        }
    }

    public static HashMap<String, String> a(String str) {
        String[] split;
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : str.split(";")) {
            String[] split2 = str2.indexOf(61) == -1 ? new String[]{"Content-Type", str2} : str2.split("=");
            hashMap.put(split2[0], split2[1]);
        }
        return hashMap;
    }

    private void a(HttpEntity httpEntity, OutputStream outputStream) {
        InputStream a2 = b.a(httpEntity);
        long contentLength = httpEntity.getContentLength();
        try {
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = a2.read(bArr);
                    if (read == -1 || this.f1718c.h()) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                    if (this.f1718c.f() != null) {
                        int i = (contentLength > 0L ? 1 : (contentLength == 0L ? 0 : -1));
                    }
                }
                outputStream.flush();
            } catch (Exception e2) {
                e2.getCause();
                throw new IOException("HttpWorker Request Error!" + e2.getLocalizedMessage());
            }
        } finally {
            r.a(a2);
        }
    }

    public static long b(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Cache-Control");
        if (firstHeader != null) {
            String[] split = firstHeader.getValue().split("=");
            if (split.length >= 2) {
                try {
                    return a(split);
                } catch (NumberFormatException unused) {
                }
            }
        }
        Header firstHeader2 = httpResponse.getFirstHeader("Expires");
        if (firstHeader2 != null) {
            return b.b(firstHeader2.getValue()) - System.currentTimeMillis();
        }
        return 0L;
    }

    private URI b() {
        String a2 = this.f1718c.a();
        String str = this.f1719d;
        if (str != null) {
            a2 = str;
        }
        if (a2 != null) {
            return new URI(a2);
        }
        throw new RuntimeException("url should not be null");
    }

    private HttpUriRequest c() {
        HttpUriRequest httpUriRequest = this.f1720f;
        if (httpUriRequest != null) {
            return httpUriRequest;
        }
        if (this.j == null) {
            byte[] b2 = this.f1718c.b();
            String b3 = this.f1718c.b(AsyncHttpClient.ENCODING_GZIP);
            if (b2 != null) {
                if (TextUtils.equals(b3, "true")) {
                    this.j = b.a(b2);
                } else {
                    this.j = new ByteArrayEntity(b2);
                }
                this.j.setContentType(this.f1718c.c());
            }
        }
        AbstractHttpEntity abstractHttpEntity = this.j;
        if (abstractHttpEntity != null) {
            HttpPost httpPost = new HttpPost(b());
            httpPost.setEntity(abstractHttpEntity);
            this.f1720f = httpPost;
        } else {
            this.f1720f = new HttpGet(b());
        }
        return this.f1720f;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0106 A[Catch: Exception -> 0x0262, NullPointerException -> 0x0284, IOException -> 0x02a8, UnknownHostException -> 0x02d2, HttpHostConnectException -> 0x02fe, NoHttpResponseException -> 0x0322, SocketTimeoutException -> 0x034d, ConnectTimeoutException -> 0x0378, ConnectionPoolTimeoutException -> 0x03a2, SSLException -> 0x03cc, SSLPeerUnverifiedException -> 0x03f6, SSLHandshakeException -> 0x0420, URISyntaxException -> 0x044a, HttpException -> 0x0457, TryCatch #3 {HttpException -> 0x0457, NullPointerException -> 0x0284, SocketTimeoutException -> 0x034d, URISyntaxException -> 0x044a, UnknownHostException -> 0x02d2, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, NoHttpResponseException -> 0x0322, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, HttpHostConnectException -> 0x02fe, IOException -> 0x02a8, Exception -> 0x0262, blocks: (B:4:0x0006, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x00d0, B:30:0x00d6, B:32:0x00e0, B:35:0x00e9, B:37:0x00f5, B:41:0x00ff, B:43:0x0106, B:45:0x0121, B:47:0x0129, B:48:0x0136, B:50:0x015c, B:51:0x0163, B:53:0x0169, B:54:0x016d, B:56:0x0173, B:58:0x017f, B:62:0x01ae, B:63:0x01ca, B:71:0x01e7, B:72:0x0200, B:73:0x0201, B:75:0x0209, B:77:0x020f, B:81:0x021b, B:83:0x021f, B:85:0x022f, B:87:0x0237, B:89:0x0241, B:44:0x0109, B:91:0x0256, B:92:0x0261, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d), top: B:177:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0109 A[Catch: Exception -> 0x0262, NullPointerException -> 0x0284, IOException -> 0x02a8, UnknownHostException -> 0x02d2, HttpHostConnectException -> 0x02fe, NoHttpResponseException -> 0x0322, SocketTimeoutException -> 0x034d, ConnectTimeoutException -> 0x0378, ConnectionPoolTimeoutException -> 0x03a2, SSLException -> 0x03cc, SSLPeerUnverifiedException -> 0x03f6, SSLHandshakeException -> 0x0420, URISyntaxException -> 0x044a, HttpException -> 0x0457, TryCatch #3 {HttpException -> 0x0457, NullPointerException -> 0x0284, SocketTimeoutException -> 0x034d, URISyntaxException -> 0x044a, UnknownHostException -> 0x02d2, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, NoHttpResponseException -> 0x0322, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, HttpHostConnectException -> 0x02fe, IOException -> 0x02a8, Exception -> 0x0262, blocks: (B:4:0x0006, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x00d0, B:30:0x00d6, B:32:0x00e0, B:35:0x00e9, B:37:0x00f5, B:41:0x00ff, B:43:0x0106, B:45:0x0121, B:47:0x0129, B:48:0x0136, B:50:0x015c, B:51:0x0163, B:53:0x0169, B:54:0x016d, B:56:0x0173, B:58:0x017f, B:62:0x01ae, B:63:0x01ca, B:71:0x01e7, B:72:0x0200, B:73:0x0201, B:75:0x0209, B:77:0x020f, B:81:0x021b, B:83:0x021f, B:85:0x022f, B:87:0x0237, B:89:0x0241, B:44:0x0109, B:91:0x0256, B:92:0x0261, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d), top: B:177:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129 A[Catch: Exception -> 0x0262, NullPointerException -> 0x0284, IOException -> 0x02a8, UnknownHostException -> 0x02d2, HttpHostConnectException -> 0x02fe, NoHttpResponseException -> 0x0322, SocketTimeoutException -> 0x034d, ConnectTimeoutException -> 0x0378, ConnectionPoolTimeoutException -> 0x03a2, SSLException -> 0x03cc, SSLPeerUnverifiedException -> 0x03f6, SSLHandshakeException -> 0x0420, URISyntaxException -> 0x044a, HttpException -> 0x0457, TryCatch #3 {HttpException -> 0x0457, NullPointerException -> 0x0284, SocketTimeoutException -> 0x034d, URISyntaxException -> 0x044a, UnknownHostException -> 0x02d2, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, NoHttpResponseException -> 0x0322, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, HttpHostConnectException -> 0x02fe, IOException -> 0x02a8, Exception -> 0x0262, blocks: (B:4:0x0006, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x00d0, B:30:0x00d6, B:32:0x00e0, B:35:0x00e9, B:37:0x00f5, B:41:0x00ff, B:43:0x0106, B:45:0x0121, B:47:0x0129, B:48:0x0136, B:50:0x015c, B:51:0x0163, B:53:0x0169, B:54:0x016d, B:56:0x0173, B:58:0x017f, B:62:0x01ae, B:63:0x01ca, B:71:0x01e7, B:72:0x0200, B:73:0x0201, B:75:0x0209, B:77:0x020f, B:81:0x021b, B:83:0x021f, B:85:0x022f, B:87:0x0237, B:89:0x0241, B:44:0x0109, B:91:0x0256, B:92:0x0261, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d), top: B:177:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015c A[Catch: Exception -> 0x0262, NullPointerException -> 0x0284, IOException -> 0x02a8, UnknownHostException -> 0x02d2, HttpHostConnectException -> 0x02fe, NoHttpResponseException -> 0x0322, SocketTimeoutException -> 0x034d, ConnectTimeoutException -> 0x0378, ConnectionPoolTimeoutException -> 0x03a2, SSLException -> 0x03cc, SSLPeerUnverifiedException -> 0x03f6, SSLHandshakeException -> 0x0420, URISyntaxException -> 0x044a, HttpException -> 0x0457, TryCatch #3 {HttpException -> 0x0457, NullPointerException -> 0x0284, SocketTimeoutException -> 0x034d, URISyntaxException -> 0x044a, UnknownHostException -> 0x02d2, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, NoHttpResponseException -> 0x0322, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, HttpHostConnectException -> 0x02fe, IOException -> 0x02a8, Exception -> 0x0262, blocks: (B:4:0x0006, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x00d0, B:30:0x00d6, B:32:0x00e0, B:35:0x00e9, B:37:0x00f5, B:41:0x00ff, B:43:0x0106, B:45:0x0121, B:47:0x0129, B:48:0x0136, B:50:0x015c, B:51:0x0163, B:53:0x0169, B:54:0x016d, B:56:0x0173, B:58:0x017f, B:62:0x01ae, B:63:0x01ca, B:71:0x01e7, B:72:0x0200, B:73:0x0201, B:75:0x0209, B:77:0x020f, B:81:0x021b, B:83:0x021f, B:85:0x022f, B:87:0x0237, B:89:0x0241, B:44:0x0109, B:91:0x0256, B:92:0x0261, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d), top: B:177:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0169 A[Catch: Exception -> 0x0262, NullPointerException -> 0x0284, IOException -> 0x02a8, UnknownHostException -> 0x02d2, HttpHostConnectException -> 0x02fe, NoHttpResponseException -> 0x0322, SocketTimeoutException -> 0x034d, ConnectTimeoutException -> 0x0378, ConnectionPoolTimeoutException -> 0x03a2, SSLException -> 0x03cc, SSLPeerUnverifiedException -> 0x03f6, SSLHandshakeException -> 0x0420, URISyntaxException -> 0x044a, HttpException -> 0x0457, TryCatch #3 {HttpException -> 0x0457, NullPointerException -> 0x0284, SocketTimeoutException -> 0x034d, URISyntaxException -> 0x044a, UnknownHostException -> 0x02d2, SSLHandshakeException -> 0x0420, SSLPeerUnverifiedException -> 0x03f6, SSLException -> 0x03cc, NoHttpResponseException -> 0x0322, ConnectionPoolTimeoutException -> 0x03a2, ConnectTimeoutException -> 0x0378, HttpHostConnectException -> 0x02fe, IOException -> 0x02a8, Exception -> 0x0262, blocks: (B:4:0x0006, B:18:0x0032, B:20:0x003a, B:22:0x0040, B:23:0x0044, B:25:0x004a, B:26:0x0058, B:28:0x00d0, B:30:0x00d6, B:32:0x00e0, B:35:0x00e9, B:37:0x00f5, B:41:0x00ff, B:43:0x0106, B:45:0x0121, B:47:0x0129, B:48:0x0136, B:50:0x015c, B:51:0x0163, B:53:0x0169, B:54:0x016d, B:56:0x0173, B:58:0x017f, B:62:0x01ae, B:63:0x01ca, B:71:0x01e7, B:72:0x0200, B:73:0x0201, B:75:0x0209, B:77:0x020f, B:81:0x021b, B:83:0x021f, B:85:0x022f, B:87:0x0237, B:89:0x0241, B:44:0x0109, B:91:0x0256, B:92:0x0261, B:7:0x0017, B:9:0x001b, B:11:0x001f, B:13:0x0025, B:16:0x002d), top: B:177:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01de  */
    @Override // java.util.concurrent.Callable
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public u call() {
        boolean z;
        HttpHost httpHost;
        HttpHost httpHost2;
        List<Cookie> cookies;
        int statusCode;
        u a2;
        String a3;
        while (true) {
            try {
                NetworkInfo[] allNetworkInfo = ((ConnectivityManager) this.f1717b.getSystemService("connectivity")).getAllNetworkInfo();
                boolean z2 = true;
                if (allNetworkInfo != null) {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting()) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    ArrayList<Header> d2 = this.f1718c.d();
                    if (d2 != null && !d2.isEmpty()) {
                        Iterator<Header> it = d2.iterator();
                        while (it.hasNext()) {
                            c().addHeader(it.next());
                        }
                    }
                    b.a((HttpRequest) c());
                    b.b((HttpRequest) c());
                    c().addHeader("cookie", i().getCookie(this.f1718c.a()));
                    this.f1721g.setAttribute(ClientContext.COOKIE_STORE, this.f1722h);
                    this.f1716a.a().a(f1715e);
                    long currentTimeMillis = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder("By Http/Https to request. operationType=");
                    sb.append(f());
                    sb.append(" url=");
                    sb.append(this.f1720f.getURI().toString());
                    HttpParams params = this.f1716a.a().getParams();
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f1717b.getSystemService("connectivity")).getActiveNetworkInfo();
                    HttpHost httpHost3 = null;
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                        String defaultHost = Proxy.getDefaultHost();
                        int defaultPort = Proxy.getDefaultPort();
                        if (defaultHost != null) {
                            httpHost = new HttpHost(defaultHost, defaultPort);
                            if (httpHost != null || !TextUtils.equals(httpHost.getHostName(), "127.0.0.1") || httpHost.getPort() != 8087) {
                                httpHost3 = httpHost;
                            }
                            params.setParameter(ConnRoutePNames.DEFAULT_PROXY, httpHost3);
                            if (this.k == null) {
                                httpHost2 = this.k;
                            } else {
                                URL h2 = h();
                                HttpHost httpHost4 = new HttpHost(h2.getHost(), g(), h2.getProtocol());
                                this.k = httpHost4;
                                httpHost2 = httpHost4;
                            }
                            if (g() == 80) {
                                httpHost2 = new HttpHost(h().getHost());
                            }
                            HttpResponse execute = this.f1716a.a().execute(httpHost2, this.f1720f, this.f1721g);
                            this.f1716a.b(System.currentTimeMillis() - currentTimeMillis);
                            cookies = this.f1722h.getCookies();
                            if (this.f1718c.e()) {
                                i().removeAllCookie();
                            }
                            if (!cookies.isEmpty()) {
                                for (Cookie cookie : cookies) {
                                    if (cookie.getDomain() != null) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append(cookie.getName());
                                        sb2.append("=");
                                        sb2.append(cookie.getValue());
                                        sb2.append("; domain=");
                                        sb2.append(cookie.getDomain());
                                        sb2.append(cookie.isSecure() ? "; Secure" : "");
                                        i().setCookie(this.f1718c.a(), sb2.toString());
                                        CookieSyncManager.getInstance().sync();
                                    }
                                }
                            }
                            statusCode = execute.getStatusLine().getStatusCode();
                            String reasonPhrase = execute.getStatusLine().getReasonPhrase();
                            if (statusCode != 200) {
                                if (statusCode != 304) {
                                    z2 = false;
                                }
                                if (!z2) {
                                    throw new HttpException(Integer.valueOf(execute.getStatusLine().getStatusCode()), execute.getStatusLine().getReasonPhrase());
                                }
                            }
                            a2 = a(execute, statusCode, reasonPhrase);
                            if (((a2 != null || a2.b() == null) ? -1L : a2.b().length) == -1 && (a2 instanceof p)) {
                                try {
                                    Long.parseLong(((p) a2).a().getHead("Content-Length"));
                                } catch (Exception unused) {
                                }
                            }
                            a3 = this.f1718c.a();
                            if (a3 != null && !TextUtils.isEmpty(f())) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append(a3);
                                sb3.append("#");
                                sb3.append(f());
                            }
                            return a2;
                        }
                    }
                    httpHost = null;
                    if (httpHost != null) {
                    }
                    httpHost3 = httpHost;
                    params.setParameter(ConnRoutePNames.DEFAULT_PROXY, httpHost3);
                    if (this.k == null) {
                    }
                    if (g() == 80) {
                    }
                    HttpResponse execute2 = this.f1716a.a().execute(httpHost2, this.f1720f, this.f1721g);
                    this.f1716a.b(System.currentTimeMillis() - currentTimeMillis);
                    cookies = this.f1722h.getCookies();
                    if (this.f1718c.e()) {
                    }
                    if (!cookies.isEmpty()) {
                    }
                    statusCode = execute2.getStatusLine().getStatusCode();
                    String reasonPhrase2 = execute2.getStatusLine().getReasonPhrase();
                    if (statusCode != 200) {
                    }
                    a2 = a(execute2, statusCode, reasonPhrase2);
                    if (((a2 != null || a2.b() == null) ? -1L : a2.b().length) == -1) {
                        Long.parseLong(((p) a2).a().getHead("Content-Length"));
                    }
                    a3 = this.f1718c.a();
                    if (a3 != null) {
                        StringBuilder sb32 = new StringBuilder();
                        sb32.append(a3);
                        sb32.append("#");
                        sb32.append(f());
                    }
                    return a2;
                }
                throw new HttpException(1, "The network is not available");
            } catch (HttpException e2) {
                e();
                if (this.f1718c.f() != null) {
                    e2.getCode();
                    e2.getMsg();
                }
                new StringBuilder().append(e2);
                throw e2;
            } catch (NullPointerException e3) {
                e();
                int i = this.m;
                if (i > 0) {
                    new StringBuilder().append(e3);
                    throw new HttpException(0, String.valueOf(e3));
                }
                this.m = i + 1;
            } catch (SocketTimeoutException e4) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e4);
                }
                new StringBuilder().append(e4);
                throw new HttpException(4, String.valueOf(e4));
            } catch (URISyntaxException e5) {
                throw new RuntimeException("Url parser error!", e5.getCause());
            } catch (UnknownHostException e6) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e6);
                }
                new StringBuilder().append(e6);
                throw new HttpException(9, String.valueOf(e6));
            } catch (SSLHandshakeException e7) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e7);
                }
                new StringBuilder().append(e7);
                throw new HttpException(2, String.valueOf(e7));
            } catch (SSLPeerUnverifiedException e8) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e8);
                }
                new StringBuilder().append(e8);
                throw new HttpException(2, String.valueOf(e8));
            } catch (SSLException e9) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e9);
                }
                new StringBuilder().append(e9);
                throw new HttpException(6, String.valueOf(e9));
            } catch (NoHttpResponseException e10) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e10);
                }
                new StringBuilder().append(e10);
                throw new HttpException(5, String.valueOf(e10));
            } catch (ConnectionPoolTimeoutException e11) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e11);
                }
                new StringBuilder().append(e11);
                throw new HttpException(3, String.valueOf(e11));
            } catch (ConnectTimeoutException e12) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e12);
                }
                new StringBuilder().append(e12);
                throw new HttpException(3, String.valueOf(e12));
            } catch (HttpHostConnectException e13) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e13);
                }
                throw new HttpException(8, String.valueOf(e13));
            } catch (IOException e14) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e14);
                }
                new StringBuilder().append(e14);
                throw new HttpException(6, String.valueOf(e14));
            } catch (Exception e15) {
                e();
                if (this.f1718c.f() != null) {
                    new StringBuilder().append(e15);
                }
                throw new HttpException(0, String.valueOf(e15));
            }
        }
    }

    private void e() {
        HttpUriRequest httpUriRequest = this.f1720f;
        if (httpUriRequest != null) {
            httpUriRequest.abort();
        }
    }

    private String f() {
        if (TextUtils.isEmpty(this.q)) {
            String b2 = this.f1718c.b("operationType");
            this.q = b2;
            return b2;
        }
        return this.q;
    }

    private int g() {
        URL h2 = h();
        return h2.getPort() == -1 ? h2.getDefaultPort() : h2.getPort();
    }

    private URL h() {
        URL url = this.l;
        if (url != null) {
            return url;
        }
        URL url2 = new URL(this.f1718c.a());
        this.l = url2;
        return url2;
    }

    private CookieManager i() {
        CookieManager cookieManager = this.i;
        if (cookieManager != null) {
            return cookieManager;
        }
        CookieManager cookieManager2 = CookieManager.getInstance();
        this.i = cookieManager2;
        return cookieManager2;
    }

    public final o a() {
        return this.f1718c;
    }
}
