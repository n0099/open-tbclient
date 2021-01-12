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
/* loaded from: classes14.dex */
public final class n {
    private static SSLSocketFactory h;

    /* renamed from: a  reason: collision with root package name */
    Context f5269a;
    private String c;
    private String d;

    /* renamed from: b  reason: collision with root package name */
    byte[] f5270b = new byte[8192];
    private int e = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private int f = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    private boolean g = false;

    public n(Context context) {
        this.f5269a = context;
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
        if (e.e(this.f5269a)) {
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
            str = Proxy.getHost(this.f5269a);
            i = Proxy.getPort(this.f5269a);
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
        httpURLConnection.setRequestProperty("User-Agent", "eos/" + e.g(this.f5269a)[0] + "/" + y.a(this.f5269a) + "/3.4.4.1");
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty(Headers.ACCEPT_ENCODING, "gzip,deflate");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry());
        httpURLConnection.setRequestProperty("x-device-id", p.a(h.b(this.f5269a)));
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) throws IOException, NetworkErrorException {
        BufferedOutputStream bufferedOutputStream;
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
                    } catch (Throwable th) {
                        return inputStream;
                    }
                } catch (NetworkErrorException e) {
                    throw e;
                } catch (IOException e2) {
                    throw e2;
                } catch (Throwable th2) {
                    bufferedOutputStream2 = bufferedOutputStream3;
                    try {
                        e.a();
                        throw new IOException();
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (Throwable th4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                if (bufferedOutputStream != null) {
                }
                throw th;
            }
        } catch (NetworkErrorException e3) {
            throw e3;
        } catch (IOException e4) {
            throw e4;
        } catch (Throwable th6) {
        }
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        if (!e.f(this.f5269a) || httpURLConnection == null || httpURLConnection == null) {
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
            byte[] b2 = b(inputStream);
            if (b2 == null) {
                throw new IOException("responseBytes");
            }
            if (this.g) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b2);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                k.b(byteArrayInputStream, byteArrayOutputStream);
                b2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
            }
            if (b2 != null) {
                return new String(b2);
            }
            throw new IOException();
        } catch (Throwable th) {
            e.a();
            throw new IOException();
        }
    }

    public final String a(String str, byte[] bArr) throws IOException, InterruptedException, NetworkErrorException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        InputStream a2;
        x.a();
        try {
            a("POST", str);
            try {
                httpURLConnection = a();
                try {
                    a2 = a(bArr, httpURLConnection);
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = null;
                inputStream = null;
            }
            try {
                String a3 = a(a2);
                if (a2 != null) {
                    a2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a3;
            } catch (Throwable th3) {
                th = th3;
                inputStream = a2;
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

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [485=5] */
    public final boolean a(java.lang.String r5, java.io.File r6) {
        /*
            r4 = this;
            r2 = 0
            r0 = 0
            com.baidu.sofire.i.x.a()
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L51
            android.content.Context r1 = r4.f5269a     // Catch: java.lang.Throwable -> L51
            boolean r1 = com.baidu.sofire.i.e.f(r1)     // Catch: java.lang.Throwable -> L51
            if (r1 != 0) goto L14
            com.baidu.sofire.i.x.b()
        L13:
            return r0
        L14:
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L51
            if (r1 == 0) goto L1e
            com.baidu.sofire.i.x.b()
            goto L13
        L1e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51
            java.lang.String r3 = "f= "
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L51
            r1.append(r6)     // Catch: java.lang.Throwable -> L51
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = "GET"
            r4.a(r1, r5)     // Catch: java.lang.Throwable -> L56
            java.net.HttpURLConnection r1 = r4.a()     // Catch: java.lang.Throwable -> L56
            java.io.InputStream r2 = r4.a(r1)     // Catch: java.lang.Throwable -> L8a
            boolean r0 = r4.a(r2, r6)     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L43
            r2.close()     // Catch: java.lang.Throwable -> L4c
        L43:
            if (r1 == 0) goto L48
            r1.disconnect()     // Catch: java.lang.Throwable -> L4c
        L48:
            com.baidu.sofire.i.x.b()
            goto L13
        L4c:
            r1 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L51
            goto L48
        L51:
            r0 = move-exception
            com.baidu.sofire.i.x.b()
            throw r0
        L56:
            r1 = move-exception
            r1 = r2
            r3 = r2
        L59:
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L88
            if (r3 == 0) goto L61
            r3.close()     // Catch: java.lang.Throwable -> L6a
        L61:
            if (r1 == 0) goto L66
            r1.disconnect()     // Catch: java.lang.Throwable -> L6a
        L66:
            com.baidu.sofire.i.x.b()
            goto L13
        L6a:
            r1 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L51
            goto L66
        L6f:
            r0 = move-exception
            r1 = r2
            r3 = r2
        L72:
            if (r3 == 0) goto L77
            r3.close()     // Catch: java.lang.Throwable -> L7d
        L77:
            if (r1 == 0) goto L7c
            r1.disconnect()     // Catch: java.lang.Throwable -> L7d
        L7c:
            throw r0     // Catch: java.lang.Throwable -> L51
        L7d:
            r1 = move-exception
            com.baidu.sofire.i.e.a()     // Catch: java.lang.Throwable -> L51
            goto L7c
        L82:
            r0 = move-exception
            r3 = r2
            goto L72
        L85:
            r0 = move-exception
            r3 = r2
            goto L72
        L88:
            r0 = move-exception
            goto L72
        L8a:
            r3 = move-exception
            r3 = r2
            goto L59
        L8d:
            r3 = move-exception
            r3 = r2
            goto L59
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.i.n.a(java.lang.String, java.io.File):boolean");
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
    /* loaded from: classes14.dex */
    public class a implements X509TrustManager {

        /* renamed from: b  reason: collision with root package name */
        private X509TrustManager f5272b;

        a(X509TrustManager x509TrustManager) {
            this.f5272b = null;
            this.f5272b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            this.f5272b.checkClientTrusted(x509CertificateArr, str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            try {
                this.f5272b.checkServerTrusted(x509CertificateArr, str);
                com.baidu.sofire.b.a();
            } catch (Throwable th) {
                e.a();
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        e.a(n.this.f5269a.getApplicationContext(), "1003121", hashMap);
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
            return this.f5272b.getAcceptedIssuers();
        }
    }
}
