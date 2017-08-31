package com.baidu.sofire.b;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.Proxy;
import android.net.TrafficStats;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
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
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.MIME;
/* loaded from: classes.dex */
public final class i {
    Context a;
    byte[] b;
    private String c;
    private String d;
    private int e;
    private int f;
    private boolean g;

    public i(Context context) {
        this.b = new byte[8192];
        this.e = 120000;
        this.f = 120000;
        this.g = false;
        this.a = context;
    }

    public i(Context context, byte b) {
        this.b = new byte[8192];
        this.e = 120000;
        this.f = 120000;
        this.g = false;
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf A[Catch: Throwable -> 0x0212, TRY_LEAVE, TryCatch #5 {Throwable -> 0x0212, blocks: (B:35:0x00a5, B:37:0x00bf, B:32:0x009b, B:30:0x0092), top: B:83:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpURLConnection nn() throws IOException {
        String str;
        HttpURLConnection httpURLConnection;
        String[] e;
        String str2;
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
            } catch (Throwable th2) {
                keyStore = null;
            }
            try {
                keyStore.load(null, null);
                keyStore2 = keyStore;
            } catch (Throwable th3) {
                try {
                    String property2 = System.getProperty("javax.net.ssl.trustStore");
                    String property3 = System.getProperty("javax.net.ssl.trustStorePassword");
                    char[] charArray = property3 == null ? null : property3.toCharArray();
                    keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(property2));
                    keyStore.load(bufferedInputStream, charArray);
                    bufferedInputStream.close();
                    keyStore2 = keyStore;
                } catch (Throwable th4) {
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
                e = d.e(this.a);
                if (e == null) {
                }
                str2 = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
                httpURLConnection.setRequestProperty("User-Agent", "eos/" + str2 + "/" + l.a(this.a) + "/2.0.8");
                httpURLConnection.setRequestProperty("Pragma", "no-cache");
                httpURLConnection.setRequestProperty("Accept", "*/*");
                httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry());
                httpURLConnection.setRequestProperty("x-device-id", j.a(e.a(this.a)));
                return httpURLConnection;
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
        e = d.e(this.a);
        if (e == null && e.length == 2 && !TextUtils.isEmpty(e[0])) {
            str2 = e[0];
        } else {
            str2 = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        }
        httpURLConnection.setRequestProperty("User-Agent", "eos/" + str2 + "/" + l.a(this.a) + "/2.0.8");
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry());
        httpURLConnection.setRequestProperty("x-device-id", j.a(e.a(this.a)));
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
                h.f(byteArrayInputStream, byteArrayOutputStream);
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
                httpURLConnection = nn();
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
            String str2 = "u=" + str;
            com.baidu.sofire.b.a();
            try {
                this.c = "GET";
                this.d = str;
                httpURLConnection = nn();
                try {
                    inputStream = a(null, httpURLConnection);
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

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [501=7] */
    public final boolean b(java.lang.String r7, java.io.File r8) {
        /*
            r6 = this;
            r3 = 0
            r0 = 0
            r4 = 15
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L30
            if (r1 < r4) goto Le
            r1 = 155648(0x26000, float:2.1811E-40)
            android.net.TrafficStats.setThreadStatsTag(r1)     // Catch: java.lang.Throwable -> L30
        Le:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = "u="
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.StringBuilder r1 = r1.append(r7)     // Catch: java.lang.Throwable -> Ld9
            r1.toString()     // Catch: java.lang.Throwable -> Ld9
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> Ld9
            android.content.Context r1 = r6.a     // Catch: java.lang.Throwable -> Ld9
            boolean r1 = com.baidu.sofire.b.d.d(r1)     // Catch: java.lang.Throwable -> Ld9
            if (r1 != 0) goto L3a
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L35
            if (r1 < r4) goto L2f
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> L35
        L2f:
            return r0
        L30:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto Le
        L35:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L2f
        L3a:
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> Ld9
            if (r1 == 0) goto L4d
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L48
            if (r1 < r4) goto L2f
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> L48
            goto L2f
        L48:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L2f
        L4d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r2 = "f= "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Ld9
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch: java.lang.Throwable -> Ld9
            r1.toString()     // Catch: java.lang.Throwable -> Ld9
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> Ld9
            java.lang.String r1 = "GET"
            r6.c = r1     // Catch: java.lang.Throwable -> L9b
            r6.d = r7     // Catch: java.lang.Throwable -> L9b
            java.net.HttpURLConnection r2 = r6.nn()     // Catch: java.lang.Throwable -> L9b
            java.io.InputStream r3 = r6.g(r2)     // Catch: java.lang.Throwable -> L104
            boolean r1 = r6.b(r3, r8)     // Catch: java.lang.Throwable -> L104
            if (r3 == 0) goto L77
            r3.close()     // Catch: java.lang.Throwable -> L85
        L77:
            if (r2 == 0) goto L7c
            r2.disconnect()     // Catch: java.lang.Throwable -> L85
        L7c:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L96
            if (r0 < r4) goto L83
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> L96
        L83:
            r0 = r1
            goto L2f
        L85:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> Ld9
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L91
            if (r1 < r4) goto L2f
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> L91
            goto L2f
        L91:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L2f
        L96:
            r0 = move-exception
            com.baidu.sofire.b.d.a(r0)
            goto L83
        L9b:
            r1 = move-exception
            r2 = r3
        L9d:
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> Lff
            if (r3 == 0) goto La5
            r3.close()     // Catch: java.lang.Throwable -> Lb9
        La5:
            if (r2 == 0) goto Laa
            r2.disconnect()     // Catch: java.lang.Throwable -> Lb9
        Laa:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lb3
            if (r1 < r4) goto L2f
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> Lb3
            goto L2f
        Lb3:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L2f
        Lb9:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> Ld9
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lc6
            if (r1 < r4) goto L2f
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> Lc6
            goto L2f
        Lc6:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L2f
        Lcc:
            r1 = move-exception
            r2 = r3
        Lce:
            if (r2 == 0) goto Ld3
            r2.close()     // Catch: java.lang.Throwable -> Le2
        Ld3:
            if (r3 == 0) goto Ld8
            r3.disconnect()     // Catch: java.lang.Throwable -> Le2
        Ld8:
            throw r1     // Catch: java.lang.Throwable -> Ld9
        Ld9:
            r0 = move-exception
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lf5
            if (r1 < r4) goto Le1
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> Lf5
        Le1:
            throw r0
        Le2:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)     // Catch: java.lang.Throwable -> Ld9
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lef
            if (r1 < r4) goto L2f
            android.net.TrafficStats.clearThreadStatsTag()     // Catch: java.lang.Throwable -> Lef
            goto L2f
        Lef:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto L2f
        Lf5:
            r1 = move-exception
            com.baidu.sofire.b.d.a(r1)
            goto Le1
        Lfa:
            r1 = move-exception
            r5 = r2
            r2 = r3
            r3 = r5
            goto Lce
        Lff:
            r1 = move-exception
            r5 = r2
            r2 = r3
            r3 = r5
            goto Lce
        L104:
            r1 = move-exception
            goto L9d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.i.b(java.lang.String, java.io.File):boolean");
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
        private X509TrustManager Py;

        a(X509TrustManager x509TrustManager) {
            this.Py = null;
            this.Py = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            this.Py.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            try {
                this.Py.checkServerTrusted(x509CertificateArr, str);
                com.baidu.sofire.b.a();
            } catch (CertificateException e) {
                d.a(e);
                for (Throwable th = e; th != null; th = th.getCause()) {
                    if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        d.a(i.this.a.getApplicationContext(), "1003121", hashMap);
                        return;
                    }
                }
                throw e;
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            com.baidu.sofire.b.a();
            return this.Py.getAcceptedIssuers();
        }
    }
}
