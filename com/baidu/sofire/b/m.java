package com.baidu.sofire.b;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
import java.util.HashMap;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.protocol.HTTP;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class m {
    byte[] a;
    private Context b;
    private String c;
    private String d;
    private int e;
    private int f;
    private boolean g;

    public m(Context context, Handler handler) {
        this.a = new byte[8192];
        this.e = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        this.f = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        this.g = false;
        this.b = context;
    }

    public m(Context context) {
        this.a = new byte[8192];
        this.e = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        this.f = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        this.g = false;
        this.b = context;
    }

    private void a(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[Catch: Throwable -> 0x00aa, TRY_LEAVE, TryCatch #6 {Throwable -> 0x00aa, blocks: (B:13:0x0023, B:15:0x003d, B:8:0x0010, B:10:0x0019), top: B:40:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0010 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(HttpsURLConnection httpsURLConnection) {
        KeyStore keyStore;
        KeyStore keyStore2;
        X509TrustManager x509TrustManager = null;
        try {
            keyStore = KeyStore.getInstance("AndroidCAStore");
        } catch (Throwable th) {
            keyStore = null;
        }
        try {
            keyStore.load(null, null);
            keyStore2 = keyStore;
        } catch (Throwable th2) {
            try {
                String property = System.getProperty("javax.net.ssl.trustStore");
                String property2 = System.getProperty("javax.net.ssl.trustStorePassword");
                char[] charArray = property2 == null ? null : property2.toCharArray();
                keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(property));
                keyStore.load(bufferedInputStream, charArray);
                bufferedInputStream.close();
                keyStore2 = keyStore;
            } catch (Throwable th3) {
                keyStore2 = keyStore;
            }
            if (keyStore2 != null) {
            }
            if (x509TrustManager == null) {
            }
        }
        if (keyStore2 != null) {
            try {
                Class<?> cls = Class.forName("com.android.org.conscrypt.TrustManagerImpl");
                Class<?> cls2 = cls == null ? Class.forName("org.apache.harmony.xnet.provider.jsse.TrustManagerImpl") : cls;
                if (cls2 != null) {
                    x509TrustManager = (X509TrustManager) cls2.getDeclaredConstructor(KeyStore.class).newInstance(keyStore2);
                }
            } catch (Throwable th4) {
                e.a(th4);
                return;
            }
        }
        if (x509TrustManager == null) {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new a(x509TrustManager)}, new SecureRandom());
            httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.HttpURLConnection] */
    private HttpURLConnection a() {
        String str;
        HttpsURLConnection httpsURLConnection;
        int i = -1;
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
            throw new IllegalArgumentException();
        }
        if (!this.c.equals("POST") && !this.c.equals("GET")) {
            this.c = "POST";
        }
        URL url = new URL(this.d);
        if (e.f(this.b)) {
            i = 80;
            str = null;
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
            str = Proxy.getHost(this.b);
            i = Proxy.getPort(this.b);
        }
        if (str != null && i > 0) {
            httpsURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
        } else {
            httpsURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (httpsURLConnection instanceof HttpsURLConnection) {
            a(httpsURLConnection);
        }
        httpsURLConnection.setRequestMethod(this.c);
        httpsURLConnection.setDoInput(true);
        if ("POST".equals(this.c)) {
            httpsURLConnection.setDoOutput(true);
        }
        httpsURLConnection.setInstanceFollowRedirects(true);
        httpsURLConnection.setConnectTimeout(this.e);
        httpsURLConnection.setReadTimeout(this.f);
        String str2 = e.h(this.b)[0];
        String str3 = "sofire";
        if ("1".equals("1")) {
            str3 = "eos";
        }
        httpsURLConnection.setRequestProperty(HTTP.USER_AGENT, str3 + "/" + str2 + "/" + t.a(this.b) + "/3.1.8");
        httpsURLConnection.setRequestProperty("Pragma", "no-cache");
        httpsURLConnection.setRequestProperty("Accept", "*/*");
        httpsURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
        httpsURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry());
        httpsURLConnection.setRequestProperty("x-device-id", o.a(g.a(this.b)));
        return httpsURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) {
        Throwable th;
        Throwable th2;
        BufferedOutputStream bufferedOutputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
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
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (0 != 0) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable th3) {
                        }
                    }
                    return inputStream;
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
                    InputStream inputStream2 = httpURLConnection.getInputStream();
                    if (bufferedOutputStream3 == null) {
                        return inputStream2;
                    }
                    try {
                        bufferedOutputStream3.close();
                        return inputStream2;
                    } catch (Throwable th4) {
                        return inputStream2;
                    }
                } catch (NetworkErrorException e) {
                    throw e;
                } catch (IOException e2) {
                    throw e2;
                } catch (Throwable th5) {
                    th = th5;
                    e.a(th);
                    throw new IOException();
                }
            } catch (Throwable th6) {
                th2 = th6;
                if (0 != 0) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable th7) {
                    }
                }
                throw th2;
            }
        } catch (NetworkErrorException e3) {
            throw e3;
        } catch (IOException e4) {
            throw e4;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        if (!e.g(this.b) || httpURLConnection == null || httpURLConnection == null) {
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
            e.a(e);
            return inputStream;
        }
    }

    private String a(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("InputStream");
        }
        try {
            byte[] b = b(inputStream);
            if (b == null) {
                throw new NullPointerException("responseBytes");
            }
            if (this.g) {
                b = j.b(b);
            }
            if (b != null) {
                return new String(b);
            }
            throw new IOException();
        } catch (Throwable th) {
            e.a(th);
            throw new IOException();
        }
    }

    public String a(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        s.a();
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
            s.b();
        }
    }

    private byte[] b(InputStream inputStream) {
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

    public String a(String str) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        s.a();
        try {
            com.baidu.sofire.b.a("u=" + str);
            try {
                a("GET", str);
                httpURLConnection = a();
            } catch (Throwable th) {
                th = th;
                httpURLConnection = null;
            }
            try {
                inputStream = a((byte[]) null, httpURLConnection);
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
            s.b();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [512=8] */
    public boolean a(String str, File file) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        s.a();
        try {
            com.baidu.sofire.b.a("u=" + str);
            if (e.g(this.b)) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                com.baidu.sofire.b.a("f= " + file);
                try {
                    a("GET", str);
                    httpURLConnection = a();
                } catch (Throwable th) {
                    th = th;
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
                } catch (Throwable th2) {
                    th = th2;
                    e.a(th);
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
        } finally {
            s.b();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [545=4, 546=4, 547=4, 543=5] */
    private boolean a(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        boolean z = false;
        BufferedOutputStream bufferedOutputStream2 = null;
        if (this.g) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException e) {
                e.a(e);
            }
        }
        if (inputStream != null) {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                        bufferedOutputStream.flush();
                    }
                    z = true;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e2) {
                            e.a(e2);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        e.a(th);
                        return z;
                    } finally {
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e3) {
                                e.a(e3);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } else if (0 != 0) {
            try {
                bufferedOutputStream2.close();
            } catch (IOException e4) {
                e.a(e4);
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements X509TrustManager {
        private X509TrustManager b;

        a(X509TrustManager x509TrustManager) {
            this.b = null;
            this.b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            com.baidu.sofire.b.a("checkClientTrusted");
            this.b.checkClientTrusted(x509CertificateArr, str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            com.baidu.sofire.b.a("checkServerTrusted");
            try {
                this.b.checkServerTrusted(x509CertificateArr, str);
                com.baidu.sofire.b.a("after checkServerTrusted");
            } catch (Throwable th) {
                e.a(th);
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        e.a(m.this.b.getApplicationContext(), "1003121", hashMap);
                        return;
                    }
                }
                if (th != null && (th instanceof CertificateException)) {
                    throw ((CertificateException) th);
                }
                throw new CertificateException();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            com.baidu.sofire.b.a("getAcceptedIssuers");
            return this.b.getAcceptedIssuers();
        }
    }
}
