package com.baidu.sofire.b;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
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
public final class k {
    Context a;
    byte[] b;
    private String c;
    private String d;
    private int e;
    private int f;
    private boolean g;

    public k(Context context) {
        this.b = new byte[8192];
        this.e = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        this.f = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        this.g = false;
        this.a = context;
    }

    public k(Context context, byte b) {
        this.b = new byte[8192];
        this.e = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        this.f = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
        this.g = false;
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf A[Catch: Throwable -> 0x021b, TRY_LEAVE, TryCatch #7 {Throwable -> 0x021b, blocks: (B:35:0x00a5, B:37:0x00bf, B:30:0x0092, B:32:0x009b), top: B:78:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpURLConnection vD() throws IOException {
        String str;
        HttpURLConnection httpURLConnection;
        KeyStore keyStore;
        KeyStore keyStore2;
        int i = -1;
        X509TrustManager x509TrustManager = null;
        if (TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
            throw new IllegalArgumentException();
        }
        if (!this.c.equals("POST") && !this.c.equals("GET")) {
            this.c = "POST";
        }
        URL url = new URL(this.d);
        if (d.c(this.a)) {
            i = 0;
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
            str = Proxy.getHost(this.a);
            i = Proxy.getPort(this.a);
        }
        if (str != null && i > 0) {
            httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                keyStore = KeyStore.getInstance("AndroidCAStore");
                try {
                    keyStore.load(null, null);
                    keyStore2 = keyStore;
                } catch (Throwable th2) {
                    try {
                        String property2 = System.getProperty("javax.net.ssl.trustStore");
                        String property3 = System.getProperty("javax.net.ssl.trustStorePassword");
                        char[] charArray = property3 == null ? null : property3.toCharArray();
                        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(property2));
                        keyStore.load(bufferedInputStream, charArray);
                        bufferedInputStream.close();
                        keyStore2 = keyStore;
                    } catch (Throwable th3) {
                        keyStore2 = keyStore;
                    }
                    if (keyStore2 != null) {
                    }
                    if (x509TrustManager != null) {
                    }
                    httpURLConnection.setRequestMethod(this.c);
                    httpURLConnection.setDoInput(true);
                    if ("POST".equals(this.c)) {
                    }
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setConnectTimeout(this.e);
                    httpURLConnection.setReadTimeout(this.f);
                    String str2 = d.e(this.a)[0];
                    String str3 = "sofire";
                    if ("sofire".equals("sofire")) {
                    }
                    httpURLConnection.setRequestProperty(HTTP.USER_AGENT, str3 + "/" + str2 + "/" + q.a(this.a) + "/3.1.0");
                    httpURLConnection.setRequestProperty("Pragma", "no-cache");
                    httpURLConnection.setRequestProperty("Accept", "*/*");
                    httpURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                    httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry());
                    httpURLConnection.setRequestProperty("x-device-id", l.a(f.a(this.a)));
                    return httpURLConnection;
                }
            } catch (Throwable th4) {
                keyStore = null;
            }
            if (keyStore2 != null) {
                try {
                    Class<?> cls = Class.forName("com.android.org.conscrypt.TrustManagerImpl");
                    Class<?> cls2 = cls == null ? Class.forName("org.apache.harmony.xnet.provider.jsse.TrustManagerImpl") : cls;
                    if (cls2 != null) {
                        x509TrustManager = (X509TrustManager) cls2.getDeclaredConstructor(KeyStore.class).newInstance(keyStore2);
                    }
                } catch (Throwable th5) {
                    d.a(th5);
                }
            }
            if (x509TrustManager != null) {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{new a(x509TrustManager)}, new SecureRandom());
                httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
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
        String str22 = d.e(this.a)[0];
        String str32 = "sofire";
        if ("sofire".equals("sofire")) {
            str32 = "eos";
        }
        httpURLConnection.setRequestProperty(HTTP.USER_AGENT, str32 + "/" + str22 + "/" + q.a(this.a) + "/3.1.0");
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry());
        httpURLConnection.setRequestProperty("x-device-id", l.a(f.a(this.a)));
        return httpURLConnection;
    }

    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) throws IOException, NetworkErrorException {
        if (httpURLConnection == null) {
            return null;
        }
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
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            int responseCode2 = httpURLConnection.getResponseCode();
            if (responseCode2 != 200) {
                throw new NetworkErrorException(String.valueOf(responseCode2));
            }
            if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                this.g = true;
            } else {
                this.g = false;
            }
            return httpURLConnection.getInputStream();
        } catch (NetworkErrorException e) {
            throw e;
        } catch (IOException e2) {
            throw e2;
        } catch (Throwable th) {
            d.a(th);
            throw new IOException();
        }
    }

    private InputStream g(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        if (!d.d(this.a) || httpURLConnection == null || httpURLConnection == null) {
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
            d.a(e);
            return inputStream;
        }
    }

    private String a(InputStream inputStream) throws IOException, InterruptedException {
        if (inputStream == null) {
            throw new NullPointerException("InputStream");
        }
        try {
            byte[] b = b(inputStream);
            if (b == null) {
                throw new NullPointerException("responseBytes");
            }
            if (this.g) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                i.f(byteArrayInputStream, byteArrayOutputStream);
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
            d.a(th);
            throw new IOException();
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

    private boolean b(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream;
        if (this.g) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException e) {
                d.a(e);
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
                            d.a(e2);
                        }
                    }
                }
                bufferedOutputStream.close();
                return true;
            } catch (Throwable th) {
                th = th;
                try {
                    d.a(th);
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                            return false;
                        } catch (IOException e3) {
                            d.a(e3);
                            return false;
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e4) {
                            d.a(e4);
                        }
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements X509TrustManager {
        private X509TrustManager aGm;

        a(X509TrustManager x509TrustManager) {
            this.aGm = null;
            this.aGm = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.aGm.checkClientTrusted(x509CertificateArr, str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.aGm.checkServerTrusted(x509CertificateArr, str);
            } catch (Throwable th) {
                d.a(th);
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        d.a(k.this.a.getApplicationContext(), "1003121", hashMap);
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
            return this.aGm.getAcceptedIssuers();
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IF, SGET, INVOKE, MOVE_EXCEPTION] complete} */
    public final String g(String str, byte[] bArr) throws IOException, InterruptedException, NetworkErrorException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.setThreadStatsTag(155648);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        try {
            this.c = "POST";
            this.d = str;
            try {
                httpURLConnection = vD();
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
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
        } finally {
            try {
                if (Build.VERSION.SDK_INT >= 15) {
                    TrafficStats.clearThreadStatsTag();
                }
            } catch (Throwable th4) {
                d.a(th4);
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, IF, SGET, INVOKE, MOVE_EXCEPTION] complete} */
    public final String a(String str) throws IOException, InterruptedException, NetworkErrorException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.setThreadStatsTag(155648);
            }
        } catch (Throwable th) {
            d.a(th);
        }
        try {
            try {
                this.c = "GET";
                this.d = str;
                httpURLConnection = vD();
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
                try {
                    if (Build.VERSION.SDK_INT >= 15) {
                        TrafficStats.clearThreadStatsTag();
                    }
                } catch (Throwable th3) {
                    d.a(th3);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [504=4] */
    public final boolean a(java.lang.String r7, java.io.File r8) {
        /*
            r6 = this;
            r3 = 0
            r0 = 0
            r4 = 15
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1e
            if (r1 < r4) goto Le
            r1 = 155648(0x26000, float:2.1811E-40)
            android.net.TrafficStats.setThreadStatsTag(r1)     // Catch: java.lang.Throwable -> L1e
        Le:
            android.content.Context r1 = r6.a     // Catch: java.lang.Throwable -> Lbe
            boolean r1 = com.baidu.sofire.b.d.d(r1)     // Catch: java.lang.Throwable -> Lbe
            if (r1 != 0) goto L28
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L23
            if (r1 < r4) goto L1d
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> L23
        L1d:
            return r0
        L1e:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto Le
        L23:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1d
        L28:
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Lbe
            if (r1 == 0) goto L3b
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L36
            if (r1 < r4) goto L1d
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> L36
            goto L1d
        L36:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1d
        L3b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r2 = "f= "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lbe
            r1.append(r8)     // Catch: java.lang.Throwable -> Lbe
            java.lang.String r1 = "GET"
            r6.c = r1     // Catch: java.lang.Throwable -> L82
            r6.d = r7     // Catch: java.lang.Throwable -> L82
            java.net.HttpURLConnection r2 = r6.vD()     // Catch: java.lang.Throwable -> L82
            java.io.InputStream r3 = r6.g(r2)     // Catch: java.lang.Throwable -> Le9
            boolean r1 = r6.b(r3, r8)     // Catch: java.lang.Throwable -> Le9
            if (r3 == 0) goto L5e
            r3.close()     // Catch: java.lang.Throwable -> L6c
        L5e:
            if (r2 == 0) goto L63
            r2.disconnect()     // Catch: java.lang.Throwable -> L6c
        L63:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L7d
            if (r0 < r4) goto L6a
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> L7d
        L6a:
            r0 = r1
            goto L1d
        L6c:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> Lbe
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L78
            if (r1 < r4) goto L1d
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> L78
            goto L1d
        L78:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1d
        L7d:
            r0 = move-exception
            com.baidu.sofire.b.d.a(r0)
            goto L6a
        L82:
            r1 = move-exception
            r2 = r3
        L84:
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> Le4
            if (r3 == 0) goto L8c
            r3.close()     // Catch: java.lang.Throwable -> L9e
        L8c:
            if (r2 == 0) goto L91
            r2.disconnect()     // Catch: java.lang.Throwable -> L9e
        L91:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L99
            if (r1 < r4) goto L1d
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> L99
            goto L1d
        L99:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1d
        L9e:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> Lbe
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lab
            if (r1 < r4) goto L1d
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> Lab
            goto L1d
        Lab:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1d
        Lb1:
            r1 = move-exception
            r2 = r3
        Lb3:
            if (r2 == 0) goto Lb8
            r2.close()     // Catch: java.lang.Throwable -> Lc7
        Lb8:
            if (r3 == 0) goto Lbd
            r3.disconnect()     // Catch: java.lang.Throwable -> Lc7
        Lbd:
            throw r1     // Catch: java.lang.Throwable -> Lbe
        Lbe:
            r0 = move-exception
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lda
            if (r1 < r4) goto Lc6
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> Lda
        Lc6:
            throw r0
        Lc7:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> Lbe
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Ld4
            if (r1 < r4) goto L1d
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> Ld4
            goto L1d
        Ld4:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L1d
        Lda:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto Lc6
        Ldf:
            r1 = move-exception
            r5 = r2
            r2 = r3
            r3 = r5
            goto Lb3
        Le4:
            r1 = move-exception
            r5 = r2
            r2 = r3
            r3 = r5
            goto Lb3
        Le9:
            r1 = move-exception
            goto L84
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.k.a(java.lang.String, java.io.File):boolean");
    }
}
