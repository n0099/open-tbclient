package com.baidu.sofire.g;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: h  reason: collision with root package name */
    public static SSLSocketFactory f11443h;

    /* renamed from: a  reason: collision with root package name */
    public Context f11444a;

    /* renamed from: c  reason: collision with root package name */
    public String f11446c;

    /* renamed from: d  reason: collision with root package name */
    public String f11447d;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f11445b = new byte[8192];

    /* renamed from: e  reason: collision with root package name */
    public int f11448e = 120000;

    /* renamed from: f  reason: collision with root package name */
    public int f11449f = 120000;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11450g = false;

    /* loaded from: classes2.dex */
    public class a implements X509TrustManager {

        /* renamed from: b  reason: collision with root package name */
        public X509TrustManager f11452b;

        public a(X509TrustManager x509TrustManager) {
            this.f11452b = null;
            this.f11452b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            this.f11452b.checkClientTrusted(x509CertificateArr, str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            try {
                this.f11452b.checkServerTrusted(x509CertificateArr, str);
                com.baidu.sofire.b.a();
            } catch (Throwable th) {
                d.a();
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        d.a(l.this.f11444a.getApplicationContext(), "1003121", (Map<String, Object>) hashMap, true);
                        return;
                    }
                }
                if (th instanceof CertificateException) {
                    throw th;
                }
                throw new CertificateException();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            com.baidu.sofire.b.a();
            return this.f11452b.getAcceptedIssuers();
        }
    }

    public l(Context context) {
        this.f11444a = context;
    }

    private void a(String str, String str2) {
        this.f11446c = str;
        this.f11447d = str2;
    }

    public static byte[] b(InputStream inputStream) throws IOException, InterruptedException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    private HttpURLConnection a() throws IOException {
        String str;
        HttpURLConnection httpURLConnection;
        if (!TextUtils.isEmpty(this.f11446c) && !TextUtils.isEmpty(this.f11447d)) {
            if (!this.f11446c.equals("POST") && !this.f11446c.equals("GET")) {
                this.f11446c = "POST";
            }
            URL url = new URL(this.f11447d);
            int i = -1;
            if (d.f(this.f11444a)) {
                str = null;
                i = 0;
            } else if (Build.VERSION.SDK_INT >= 13) {
                str = System.getProperties().getProperty("http.proxyHost");
                String property = System.getProperties().getProperty("http.proxyPort");
                if (!TextUtils.isEmpty(property)) {
                    try {
                        i = Integer.parseInt(property);
                    } catch (Throwable unused) {
                    }
                }
            } else {
                str = Proxy.getHost(this.f11444a);
                i = Proxy.getPort(this.f11444a);
            }
            if (str != null && i > 0) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if ("https".equals(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                try {
                    if (f11443h != null) {
                        httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        httpsURLConnection.setSSLSocketFactory(f11443h);
                    } else {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                        if (trustManagers.length > 0 && (trustManagers[0] instanceof X509TrustManager)) {
                            sSLContext.init(null, new TrustManager[]{new a((X509TrustManager) trustManagers[0])}, new SecureRandom());
                            f11443h = sSLContext.getSocketFactory();
                            httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                            httpsURLConnection.setSSLSocketFactory(f11443h);
                        } else {
                            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                        }
                    }
                } catch (Throwable unused2) {
                    d.a();
                }
            }
            httpURLConnection.setRequestMethod(this.f11446c);
            httpURLConnection.setDoInput(true);
            if ("POST".equals(this.f11446c)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(this.f11448e);
            httpURLConnection.setReadTimeout(this.f11449f);
            httpURLConnection.setRequestProperty("User-Agent", "eos/" + d.h(this.f11444a)[0] + "/" + v.a(this.f11444a) + "/3.5.7.3");
            httpURLConnection.setRequestProperty("Pragma", "no-cache");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
            httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
            httpURLConnection.setRequestProperty("x-device-id", n.a(f.b(this.f11444a)));
            return httpURLConnection;
        }
        throw new IllegalArgumentException();
    }

    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) throws IOException, NetworkErrorException {
        BufferedOutputStream bufferedOutputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            try {
                if (bArr == null) {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        String contentEncoding = httpURLConnection.getContentEncoding();
                        if (!TextUtils.isEmpty(contentEncoding) && AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(contentEncoding)) {
                            this.f11450g = true;
                        } else {
                            this.f11450g = false;
                        }
                        return httpURLConnection.getInputStream();
                    }
                    throw new NetworkErrorException(String.valueOf(responseCode));
                }
                BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                try {
                    bufferedOutputStream2.write(bArr);
                    bufferedOutputStream2.flush();
                    int responseCode2 = httpURLConnection.getResponseCode();
                    if (responseCode2 == 200) {
                        if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                            this.f11450g = true;
                        } else {
                            this.f11450g = false;
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable unused) {
                        }
                        return inputStream;
                    }
                    throw new NetworkErrorException(String.valueOf(responseCode2));
                } catch (NetworkErrorException e2) {
                    throw e2;
                } catch (IOException e3) {
                    throw e3;
                } catch (Throwable unused2) {
                    d.a();
                    throw new IOException();
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
        } catch (NetworkErrorException e4) {
            throw e4;
        } catch (IOException e5) {
            throw e5;
        } catch (Throwable unused4) {
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        if (d.g(this.f11444a) && httpURLConnection != null && httpURLConnection != null) {
            try {
                if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    this.f11450g = true;
                } else {
                    this.f11450g = false;
                }
                return httpURLConnection.getInputStream();
            } catch (IOException unused) {
                d.a();
            }
        }
        return null;
    }

    private String a(InputStream inputStream) throws IOException, InterruptedException {
        if (inputStream != null) {
            byte[] b2 = b(inputStream);
            if (b2 != null) {
                if (this.f11450g) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b2);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    i.b(byteArrayInputStream, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                    b2 = byteArray;
                }
                if (b2 != null) {
                    return new String(b2);
                }
                throw new IOException();
            }
            throw new IOException("responseBytes");
        }
        throw new IOException("InputStream");
    }

    public final String a(String str, byte[] bArr) throws IOException, InterruptedException, NetworkErrorException {
        HttpURLConnection httpURLConnection;
        u.a();
        try {
            if (r.m(this.f11444a)) {
                a("POST", str);
                InputStream inputStream = null;
                try {
                    httpURLConnection = a();
                    try {
                        inputStream = a(bArr, httpURLConnection);
                        String a2 = a(inputStream);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return a2;
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = null;
                }
            } else {
                throw new NetworkErrorException("Not allow background connect.");
            }
        } finally {
            u.b();
        }
    }

    public final boolean a(String str, File file) {
        HttpURLConnection httpURLConnection;
        u.a();
        try {
            com.baidu.sofire.b.a();
            if (d.g(this.f11444a)) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (r.m(this.f11444a)) {
                    new StringBuilder("f= ").append(file);
                    com.baidu.sofire.b.a();
                    InputStream inputStream = null;
                    try {
                        a("GET", str);
                        httpURLConnection = a();
                    } catch (Throwable unused) {
                        httpURLConnection = null;
                    }
                    try {
                        inputStream = a(httpURLConnection);
                        boolean a2 = a(inputStream, file);
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return a2;
                    } catch (Throwable unused2) {
                        d.a();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return false;
                    }
                }
                return false;
            }
            return false;
        } finally {
            u.b();
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.f11450g) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
                d.a();
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        } catch (Throwable unused2) {
            bufferedOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    try {
                        bufferedOutputStream.close();
                        return true;
                    } catch (IOException unused3) {
                        d.a();
                        return true;
                    }
                }
            }
        } catch (Throwable unused4) {
            try {
                d.a();
                return false;
            } finally {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused5) {
                        d.a();
                    }
                }
            }
        }
    }
}
