package com.baidu.sofire.b;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
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
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public final class n {
    private static SSLSocketFactory h;
    Context a;
    private String c;
    private String d;
    byte[] b = new byte[8192];
    private int e = 120000;
    private int f = 120000;
    private boolean g = false;

    public n(Context context) {
        this.a = context;
    }

    private void a(String str, String str2) {
        this.c = str;
        this.d = str2;
    }

    private HttpURLConnection a() {
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
        if (e.e(this.a)) {
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
            str = Proxy.getHost(this.a);
            i = Proxy.getPort(this.a);
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
        httpURLConnection.setRequestProperty(HTTP.USER_AGENT, "eos/" + e.g(this.a)[0] + "/" + x.a(this.a) + "/3.3.9");
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        httpURLConnection.setRequestProperty("Accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
        httpURLConnection.setRequestProperty("Accept-Language", Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry());
        httpURLConnection.setRequestProperty("x-device-id", p.a(h.a(this.a)));
        return httpURLConnection;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0020 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private InputStream a(byte[] bArr, HttpURLConnection httpURLConnection) {
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
        if (!e.f(this.a) || httpURLConnection == null || httpURLConnection == null) {
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

    public final String a(String str, byte[] bArr) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        w.a();
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
            w.b();
        }
    }

    private static byte[] b(InputStream inputStream) {
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
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [488=8] */
    public final boolean a(java.lang.String r6, java.io.File r7) {
        /*
            r5 = this;
            r1 = 0
            r0 = 0
            com.baidu.sofire.b.w.a()
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L80
            android.content.Context r2 = r5.a     // Catch: java.lang.Throwable -> L80
            boolean r2 = com.baidu.sofire.b.e.f(r2)     // Catch: java.lang.Throwable -> L80
            if (r2 != 0) goto L14
            com.baidu.sofire.b.w.b()
        L13:
            return r0
        L14:
            boolean r2 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L80
            if (r2 == 0) goto L1e
            com.baidu.sofire.b.w.b()
            goto L13
        L1e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "f= "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L80
            r2.append(r7)     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.b.a()     // Catch: java.lang.Throwable -> L80
            java.lang.String r2 = "GET"
            r5.a(r2, r6)     // Catch: java.lang.Throwable -> L55
            java.net.HttpURLConnection r2 = r5.a()     // Catch: java.lang.Throwable -> L55
            java.io.InputStream r3 = r5.a(r2)     // Catch: java.lang.Throwable -> L9a
            boolean r1 = r5.a(r3, r7)     // Catch: java.lang.Throwable -> L9f
            if (r3 == 0) goto L43
            r3.close()     // Catch: java.lang.Throwable -> L4d
        L43:
            if (r2 == 0) goto L48
            r2.disconnect()     // Catch: java.lang.Throwable -> L4d
        L48:
            com.baidu.sofire.b.w.b()
            r0 = r1
            goto L13
        L4d:
            r1 = move-exception
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.b.w.b()
            goto L13
        L55:
            r2 = move-exception
            r2 = r1
        L57:
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L94
            if (r2 == 0) goto L5f
            r2.close()     // Catch: java.lang.Throwable -> L68
        L5f:
            if (r1 == 0) goto L64
            r1.disconnect()     // Catch: java.lang.Throwable -> L68
        L64:
            com.baidu.sofire.b.w.b()
            goto L13
        L68:
            r1 = move-exception
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.b.w.b()
            goto L13
        L70:
            r2 = move-exception
            r3 = r1
            r4 = r1
            r1 = r2
            r2 = r4
        L75:
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.lang.Throwable -> L85
        L7a:
            if (r2 == 0) goto L7f
            r2.disconnect()     // Catch: java.lang.Throwable -> L85
        L7f:
            throw r1     // Catch: java.lang.Throwable -> L80
        L80:
            r0 = move-exception
            com.baidu.sofire.b.w.b()
            throw r0
        L85:
            r1 = move-exception
            com.baidu.sofire.b.e.a()     // Catch: java.lang.Throwable -> L80
            com.baidu.sofire.b.w.b()
            goto L13
        L8d:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L75
        L92:
            r1 = move-exception
            goto L75
        L94:
            r3 = move-exception
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r4
            goto L75
        L9a:
            r3 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
            goto L57
        L9f:
            r1 = move-exception
            r1 = r2
            r2 = r3
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sofire.b.n.a(java.lang.String, java.io.File):boolean");
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
    /* loaded from: classes2.dex */
    public class a implements X509TrustManager {
        private X509TrustManager b;

        a(X509TrustManager x509TrustManager) {
            this.b = null;
            this.b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            com.baidu.sofire.b.a();
            this.b.checkClientTrusted(x509CertificateArr, str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
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
                        e.a(n.this.a.getApplicationContext(), "1003121", hashMap);
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
