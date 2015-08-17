package com.baidu.location;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.util.Log;
import java.io.File;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
/* loaded from: classes.dex */
abstract class t implements a0, n {
    private static int c0 = 4;
    private static String c5 = "10.0.0.172";
    private static int c7 = 80;
    protected static int c6 = 0;
    private boolean c1 = false;
    public String cX = null;
    public int c8 = 3;
    public HttpEntity cY = null;
    public List cZ = null;
    public String c4 = null;
    public byte[] c3 = null;
    public String c2 = null;

    /* loaded from: classes.dex */
    public static class a extends SSLSocketFactory {
        final SSLContext a;

        public a(KeyStore keyStore) {
            super(keyStore);
            this.a = SSLContext.getInstance("TLS");
            this.a.init(null, new TrustManager[]{new X509TrustManager() { // from class: com.baidu.location.t.a.1
                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }}, null);
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
        public Socket createSocket() {
            return this.a.getSocketFactory().createSocket();
        }

        @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) {
            return this.a.getSocketFactory().createSocket(socket, str, i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        c0 = T();
    }

    private int T() {
        Context serviceContext = f.getServiceContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 4;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return 4;
            }
            if (activeNetworkInfo.getType() == 1) {
                return 3;
            }
            return m338if(serviceContext, activeNetworkInfo);
        } catch (Exception e) {
            return 4;
        }
    }

    /* renamed from: if  reason: not valid java name */
    private static int m338if(Context context, NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo != null && networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase()) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                String defaultHost = Proxy.getDefaultHost();
                c5 = (defaultHost == null || defaultHost.equals("") || defaultHost.equals("null")) ? "10.0.0.172" : "10.0.0.172";
                return 1;
            } else if (lowerCase.startsWith("ctwap")) {
                String defaultHost2 = Proxy.getDefaultHost();
                c5 = (defaultHost2 == null || defaultHost2.equals("") || defaultHost2.equals("null")) ? "10.0.0.200" : "10.0.0.200";
                return 1;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                return 2;
            }
        }
        String defaultHost3 = Proxy.getDefaultHost();
        if (defaultHost3 == null || defaultHost3.length() <= 0) {
            return 2;
        }
        if ("10.0.0.172".equals(defaultHost3.trim())) {
            c5 = "10.0.0.172";
            return 1;
        } else if ("10.0.0.200".equals(defaultHost3.trim())) {
            c5 = "10.0.0.200";
            return 1;
        } else {
            return 2;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static HttpClient m339if(HttpParams httpParams) {
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            a aVar = new a(keyStore);
            aVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(httpParams, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", aVar, 443));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
        } catch (Exception e) {
            return new DefaultHttpClient(httpParams);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static boolean m341if(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager.getActiveNetworkInfo() != null) {
                return connectivityManager.getActiveNetworkInfo().isAvailable();
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.t$4] */
    public void P() {
        new Thread() { // from class: com.baidu.location.t.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int i;
                HttpPost httpPost;
                boolean z;
                HttpPost httpPost2;
                HttpResponse execute;
                t.this.cX = c.m265for();
                t.this.X();
                int i2 = t.this.c8;
                t.this.O();
                if (t.c0 == 1) {
                    i = i2;
                    httpPost = null;
                    z = true;
                } else {
                    i = i2;
                    httpPost = null;
                    z = false;
                }
                while (i > 0) {
                    try {
                        httpPost2 = new HttpPost(t.this.cX);
                        try {
                            ByteArrayEntity byteArrayEntity = new ByteArrayEntity(t.this.c3);
                            httpPost2.setHeader(MIME.CONTENT_TYPE, "application/octet-stream");
                            httpPost2.setHeader("Accept-Charset", "UTF-8;");
                            httpPost2.setEntity(byteArrayEntity);
                            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                            defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf((int) a0.F));
                            defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf((int) a0.F));
                            HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                            if (z) {
                                defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(t.c5, t.c7, "http"));
                            }
                            z = !z;
                            execute = defaultHttpClient.execute(httpPost2);
                        } catch (Exception e) {
                            httpPost2.abort();
                            Log.d(a0.i, "NetworkCommunicationException!");
                            i--;
                            httpPost = httpPost2;
                        }
                    } catch (Exception e2) {
                        httpPost2 = httpPost;
                    }
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        t.this.cY = execute.getEntity();
                        t.this.mo112do(true);
                        break;
                    }
                    httpPost2.abort();
                    i--;
                    httpPost = httpPost2;
                }
                if (i <= 0) {
                    t.c6++;
                    t.this.cY = null;
                    t.this.mo112do(false);
                } else {
                    t.c6 = 0;
                }
                t.this.c3 = null;
                t.this.c1 = false;
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.t$2] */
    public void R() {
        new Thread() { // from class: com.baidu.location.t.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int i;
                HttpPost httpPost;
                boolean z;
                HttpPost httpPost2;
                HttpResponse execute;
                t.this.cX = c.m265for();
                t.this.X();
                int i2 = t.this.c8;
                t.this.O();
                if (t.c0 == 1) {
                    i = i2;
                    httpPost = null;
                    z = true;
                } else {
                    i = i2;
                    httpPost = null;
                    z = false;
                }
                while (i > 0) {
                    try {
                        httpPost2 = new HttpPost(t.this.cX);
                    } catch (Exception e) {
                        httpPost2 = httpPost;
                    }
                    try {
                        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(t.this.cZ, "utf-8");
                        httpPost2.setHeader(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");
                        httpPost2.setHeader("Accept-Charset", "UTF-8;");
                        httpPost2.setEntity(urlEncodedFormEntity);
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf((int) a0.F));
                        defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf((int) a0.F));
                        HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                        if (z) {
                            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(t.c5, t.c7, "http"));
                        }
                        z = !z;
                        execute = defaultHttpClient.execute(httpPost2);
                    } catch (Exception e2) {
                        httpPost2.abort();
                        Log.d(a0.i, "NetworkCommunicationException!");
                        i--;
                        httpPost = httpPost2;
                    }
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        t.this.cY = execute.getEntity();
                        t.this.mo112do(true);
                        break;
                    }
                    httpPost2.abort();
                    i--;
                    httpPost = httpPost2;
                }
                if (i <= 0) {
                    t.c6++;
                    t.this.cY = null;
                    t.this.mo112do(false);
                } else {
                    t.c6 = 0;
                }
                t.this.c1 = false;
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.t$1] */
    public void U() {
        new Thread() { // from class: com.baidu.location.t.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int i;
                boolean z;
                HttpGet httpGet;
                HttpResponse execute;
                t.this.cX = c.m265for();
                t.this.X();
                int i2 = t.this.c8;
                t.this.O();
                if (t.c0 == 1) {
                    i = i2;
                    z = true;
                } else {
                    i = i2;
                    z = false;
                }
                while (i > 0) {
                    try {
                        httpGet = new HttpGet(t.this.cX);
                        httpGet.setHeader(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");
                        httpGet.setHeader("Accept-Charset", "UTF-8;");
                        DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                        defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf((int) a0.F));
                        defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf((int) a0.F));
                        HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                        if (z) {
                            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(t.c5, t.c7, "http"));
                        }
                        z = !z;
                        execute = defaultHttpClient.execute(httpGet);
                    } catch (Exception e) {
                        Log.d(a0.i, "NetworkCommunicationException!");
                    }
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        t.this.cY = execute.getEntity();
                        t.this.mo112do(true);
                        break;
                    }
                    httpGet.abort();
                    i--;
                }
                if (i <= 0) {
                    t.c6++;
                    t.this.cY = null;
                    t.this.mo112do(false);
                } else {
                    t.c6 = 0;
                }
                t.this.c1 = false;
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.t$3] */
    public void V() {
        new Thread() { // from class: com.baidu.location.t.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                HttpPost httpPost;
                HttpResponse execute;
                t.this.cX = c.m265for();
                t.this.X();
                int i = t.this.c8;
                t.this.O();
                int i2 = i;
                HttpPost httpPost2 = null;
                while (i2 > 0) {
                    try {
                        httpPost = new HttpPost(t.this.cX);
                        try {
                            FileEntity fileEntity = new FileEntity(new File(t.this.c4), "binary/octet-stream");
                            httpPost.setHeader(MIME.CONTENT_TYPE, "application/octet-stream");
                            httpPost.setHeader("Accept-Charset", "UTF-8;");
                            httpPost.setEntity(fileEntity);
                            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                            defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf((int) a0.F));
                            defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf((int) a0.F));
                            HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                            if ((t.c0 == 1 || t.c0 == 4) && (t.this.c8 - i2) % 2 == 0) {
                                defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(t.c5, t.c7, "http"));
                            }
                            execute = defaultHttpClient.execute(httpPost);
                        } catch (Exception e) {
                            httpPost.abort();
                            Log.d(a0.i, "NetworkCommunicationException!");
                            i2--;
                            httpPost2 = httpPost;
                        }
                    } catch (Exception e2) {
                        httpPost = httpPost2;
                    }
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        t.this.cY = execute.getEntity();
                        t.this.mo112do(true);
                        break;
                    }
                    httpPost.abort();
                    i2--;
                    httpPost2 = httpPost;
                }
                if (i2 <= 0) {
                    t.c6++;
                    t.this.cY = null;
                    t.this.mo112do(false);
                } else {
                    t.c6 = 0;
                }
                t.this.c1 = false;
            }
        }.start();
    }

    abstract void X();

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.location.t$5] */
    public void Y() {
        new Thread() { // from class: com.baidu.location.t.5
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                int i;
                HttpPost httpPost;
                boolean z;
                HttpPost httpPost2;
                HttpResponse execute;
                t.this.cX = c.m275int();
                t.this.X();
                int i2 = t.this.c8;
                t.this.O();
                if (t.c0 == 1) {
                    i = i2;
                    httpPost = null;
                    z = true;
                } else {
                    i = i2;
                    httpPost = null;
                    z = false;
                }
                while (i > 0) {
                    try {
                        httpPost2 = new HttpPost(t.this.cX);
                        try {
                            StringEntity stringEntity = new StringEntity(t.this.c2, "UTF-8");
                            httpPost2.setHeader(MIME.CONTENT_TYPE, "text/xml");
                            httpPost2.setEntity(stringEntity);
                            BasicHttpParams basicHttpParams = new BasicHttpParams();
                            HttpConnectionParams.setConnectionTimeout(basicHttpParams, a0.F);
                            HttpConnectionParams.setSoTimeout(basicHttpParams, a0.F);
                            HttpClient m339if = t.m339if((HttpParams) basicHttpParams);
                            HttpProtocolParams.setUseExpectContinue(m339if.getParams(), false);
                            if (z) {
                                m339if.getParams().setParameter("http.route.default-proxy", new HttpHost(t.c5, t.c7, "http"));
                            }
                            z = !z;
                            execute = m339if.execute(httpPost2);
                        } catch (Exception e) {
                            httpPost2.abort();
                            Log.d(a0.i, "NetworkCommunicationException!");
                            i--;
                            httpPost = httpPost2;
                        }
                    } catch (Exception e2) {
                        httpPost2 = httpPost;
                    }
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        t.this.cY = execute.getEntity();
                        t.this.mo112do(true);
                        break;
                    }
                    httpPost2.abort();
                    i--;
                    httpPost = httpPost2;
                }
                if (i <= 0) {
                    t.c6++;
                    t.this.cY = null;
                    t.this.mo112do(false);
                } else {
                    t.c6 = 0;
                }
                t.this.c1 = false;
            }
        }.start();
    }

    /* renamed from: do */
    abstract void mo112do(boolean z);
}
