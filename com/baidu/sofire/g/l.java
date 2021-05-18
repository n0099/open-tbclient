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
    public static SSLSocketFactory f10334h;

    /* renamed from: a  reason: collision with root package name */
    public Context f10335a;

    /* renamed from: c  reason: collision with root package name */
    public String f10337c;

    /* renamed from: d  reason: collision with root package name */
    public String f10338d;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f10336b = new byte[8192];

    /* renamed from: e  reason: collision with root package name */
    public int f10339e = 120000;

    /* renamed from: f  reason: collision with root package name */
    public int f10340f = 120000;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10341g = false;

    /* loaded from: classes2.dex */
    public class a implements X509TrustManager {

        /* renamed from: b  reason: collision with root package name */
        public X509TrustManager f10343b;

        public a(X509TrustManager x509TrustManager) {
            this.f10343b = null;
            this.f10343b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            this.f10343b.checkClientTrusted(x509CertificateArr, str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            try {
                this.f10343b.checkServerTrusted(x509CertificateArr, str);
                com.baidu.sofire.b.a();
            } catch (Throwable th) {
                d.a();
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        d.a(l.this.f10335a.getApplicationContext(), "1003121", (Map<String, Object>) hashMap, true);
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
            return this.f10343b.getAcceptedIssuers();
        }
    }

    public l(Context context) {
        this.f10335a = context;
    }

    private void a(String str, String str2) {
        this.f10337c = str;
        this.f10338d = str2;
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
        if (!TextUtils.isEmpty(this.f10337c) && !TextUtils.isEmpty(this.f10338d)) {
            if (!this.f10337c.equals("POST") && !this.f10337c.equals("GET")) {
                this.f10337c = "POST";
            }
            URL url = new URL(this.f10338d);
            int i2 = -1;
            if (d.f(this.f10335a)) {
                str = null;
                i2 = 0;
            } else if (Build.VERSION.SDK_INT >= 13) {
                str = System.getProperties().getProperty("http.proxyHost");
                String property = System.getProperties().getProperty("http.proxyPort");
                if (!TextUtils.isEmpty(property)) {
                    try {
                        i2 = Integer.parseInt(property);
                    } catch (Throwable unused) {
                    }
                }
            } else {
                str = Proxy.getHost(this.f10335a);
                i2 = Proxy.getPort(this.f10335a);
            }
            if (str != null && i2 > 0) {
                httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i2)));
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            if ("https".equals(url.getProtocol())) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
                try {
                    if (f10334h != null) {
                        httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        httpsURLConnection.setSSLSocketFactory(f10334h);
                    } else {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                        if (trustManagers.length > 0 && (trustManagers[0] instanceof X509TrustManager)) {
                            sSLContext.init(null, new TrustManager[]{new a((X509TrustManager) trustManagers[0])}, new SecureRandom());
                            f10334h = sSLContext.getSocketFactory();
                            httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                            httpsURLConnection.setSSLSocketFactory(f10334h);
                        } else {
                            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                        }
                    }
                } catch (Throwable unused2) {
                    d.a();
                }
            }
            httpURLConnection.setRequestMethod(this.f10337c);
            httpURLConnection.setDoInput(true);
            if ("POST".equals(this.f10337c)) {
                httpURLConnection.setDoOutput(true);
            }
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setConnectTimeout(this.f10339e);
            httpURLConnection.setReadTimeout(this.f10340f);
            httpURLConnection.setRequestProperty("User-Agent", "eos/" + d.h(this.f10335a)[0] + "/" + v.a(this.f10335a) + "/3.5.7.3");
            httpURLConnection.setRequestProperty("Pragma", "no-cache");
            httpURLConnection.setRequestProperty("Accept", "*/*");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
            httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
            httpURLConnection.setRequestProperty("x-device-id", n.a(f.b(this.f10335a)));
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
                            this.f10341g = true;
                        } else {
                            this.f10341g = false;
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
                            this.f10341g = true;
                        } else {
                            this.f10341g = false;
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
        if (d.g(this.f10335a) && httpURLConnection != null && httpURLConnection != null) {
            try {
                if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                    this.f10341g = true;
                } else {
                    this.f10341g = false;
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
                if (this.f10341g) {
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
            if (r.m(this.f10335a)) {
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
            if (d.g(this.f10335a)) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                if (r.m(this.f10335a)) {
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
        if (this.f10341g) {
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
