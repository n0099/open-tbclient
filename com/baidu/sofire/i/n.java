package com.baidu.sofire.i;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
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
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
@SuppressLint({"NewApi"})
/* loaded from: classes15.dex */
public final class n {
    private static SSLSocketFactory h;

    /* renamed from: a  reason: collision with root package name */
    Context f3639a;
    private String c;
    private String d;
    byte[] b = new byte[8192];
    private int e = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int f = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private boolean g = false;

    public n(Context context) {
        this.f3639a = context;
    }

    private void a(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    private HttpURLConnection a() throws IOException {
        HttpURLConnection httpURLConnection;
        int i = -1;
        String str = null;
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
            throw new IllegalArgumentException();
        }
        if (!this.c.equals("POST") && !this.c.equals("GET")) {
            this.c = "POST";
        }
        URL url = new URL(this.d);
        if (e.e(this.f3639a)) {
            i = 0;
        } else if (Build.VERSION.SDK_INT >= 13) {
            str = System.getProperties().getProperty("http.proxyHost");
            String property = System.getProperties().getProperty("http.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                try {
                    i = Integer.parseInt(property);
                } catch (Throwable th) {
                }
            }
        } else {
            str = Proxy.getHost(this.f3639a);
            i = Proxy.getPort(this.f3639a);
        }
        if (str != null && i > 0) {
            httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if ("https".equals(url.getProtocol())) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                if (h != null) {
                    httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    httpsURLConnection.setSSLSocketFactory(h);
                } else {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init((KeyStore) null);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    if (trustManagers.length <= 0 || !(trustManagers[0] instanceof X509TrustManager)) {
                        throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                    }
                    sSLContext.init(null, new TrustManager[]{new a((X509TrustManager) trustManagers[0])}, new SecureRandom());
                    h = sSLContext.getSocketFactory();
                    httpsURLConnection.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    httpsURLConnection.setSSLSocketFactory(h);
                }
            } catch (Throwable th2) {
                e.a();
            }
        }
        httpURLConnection.setRequestMethod(this.c);
        httpURLConnection.setDoInput(true);
        if ("POST".equals(this.c)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(this.e);
        httpURLConnection.setReadTimeout(this.f);
        httpURLConnection.setRequestProperty("User-Agent", "eos/" + e.g(this.f3639a)[0] + "/" + y.a(this.f3639a) + "/3.4.4.1");
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip,deflate");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry());
        httpURLConnection.setRequestProperty("x-device-id", p.a(h.b(this.f3639a)));
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) throws IOException, NetworkErrorException {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2 = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            try {
                if (bArr == null) {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 200) {
                        throw new NetworkErrorException(String.valueOf(responseCode));
                    }
                    String contentEncoding = httpURLConnection.getContentEncoding();
                    if (!TextUtils.isEmpty(contentEncoding) && "gzip".equalsIgnoreCase(contentEncoding)) {
                        this.g = true;
                    } else {
                        this.g = false;
                    }
                    return httpURLConnection.getInputStream();
                }
                BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(httpURLConnection.getOutputStream());
                try {
                    bufferedOutputStream3.write(bArr);
                    bufferedOutputStream3.flush();
                    int responseCode2 = httpURLConnection.getResponseCode();
                    if (responseCode2 != 200) {
                        throw new NetworkErrorException(String.valueOf(responseCode2));
                    }
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        this.g = true;
                    } else {
                        this.g = false;
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        bufferedOutputStream3.close();
                        return inputStream;
                    } catch (Throwable th2) {
                        return inputStream;
                    }
                } catch (NetworkErrorException e) {
                    throw e;
                } catch (IOException e2) {
                    throw e2;
                } catch (Throwable th3) {
                    bufferedOutputStream2 = bufferedOutputStream3;
                    try {
                        e.a();
                        throw new IOException();
                    } catch (Throwable th4) {
                        bufferedOutputStream = bufferedOutputStream2;
                        th = th4;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable th5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (NetworkErrorException e3) {
            throw e3;
        } catch (IOException e4) {
            throw e4;
        } catch (Throwable th7) {
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        if (!e.f(this.f3639a) || httpURLConnection == null || httpURLConnection == null) {
            return null;
        }
        try {
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                this.g = true;
            } else {
                this.g = false;
            }
            inputStream = httpURLConnection.getInputStream();
            return inputStream;
        } catch (IOException e) {
            e.a();
            return inputStream;
        }
    }

    private String a(InputStream inputStream) throws IOException, InterruptedException {
        if (inputStream == null) {
            throw new IOException("InputStream");
        }
        try {
            byte[] b = b(inputStream);
            if (b == null) {
                throw new IOException("responseBytes");
            }
            if (this.g) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                k.b(byteArrayInputStream, byteArrayOutputStream);
                b = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
            }
            if (b != null) {
                return new String(b);
            }
            throw new IOException();
        } catch (Throwable th) {
            e.a();
            throw new IOException();
        }
    }

    public final String a(String str, byte[] bArr) throws IOException, InterruptedException, NetworkErrorException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        x.a();
        try {
            a("POST", str);
            try {
                httpURLConnection = a();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
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
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } finally {
            x.b();
        }
    }

    private static byte[] b(InputStream inputStream) throws IOException, InterruptedException {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [485=5] */
    public final boolean a(String str, File file) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        boolean z = false;
        x.a();
        try {
            com.baidu.sofire.b.a();
            if (e.f(this.f3639a)) {
                if (!TextUtils.isEmpty(str)) {
                    new StringBuilder("f= ").append(file);
                    com.baidu.sofire.b.a();
                    try {
                        a("GET", str);
                        httpURLConnection = a();
                        try {
                            inputStream = a(httpURLConnection);
                            z = a(inputStream, file);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        } catch (Throwable th) {
                            e.a();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return z;
                        }
                    } catch (Throwable th2) {
                        httpURLConnection = null;
                    }
                }
            }
            return z;
        } finally {
            x.b();
        }
    }

    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.g) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException e) {
                e.a();
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        bufferedOutputStream.write(bArr, 0, read);
                        bufferedOutputStream.flush();
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e.a();
                        }
                    }
                }
                bufferedOutputStream.close();
                return true;
            } catch (Throwable th) {
                try {
                    e.a();
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                            return false;
                        } catch (IOException e3) {
                            e.a();
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            e.a();
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            bufferedOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a implements X509TrustManager {
        private X509TrustManager b;

        a(X509TrustManager x509TrustManager) {
            this.b = null;
            this.b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            this.b.checkClientTrusted(x509CertificateArr, str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            try {
                this.b.checkServerTrusted(x509CertificateArr, str);
                com.baidu.sofire.b.a();
            } catch (Throwable th) {
                e.a();
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        e.a(n.this.f3639a.getApplicationContext(), "1003121", hashMap);
                        return;
                    }
                }
                if (th instanceof CertificateException) {
                    throw ((CertificateException) th);
                }
                throw new CertificateException();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            com.baidu.sofire.b.a();
            return this.b.getAcceptedIssuers();
        }
    }
}
