package com.baidu.sofire.rp.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.Proxy;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.sofire.rp.f.b;
import com.baidu.sofire.rp.f.d;
import com.baidu.sofire.rp.f.g;
import com.baidu.sofire.rp.f.i;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
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
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.MIME;
/* loaded from: classes.dex */
public final class a {
    private HttpURLConnection PY;
    private Context c;
    private String e;
    private String f;
    byte[] a = new byte[1024];
    byte[] b = new byte[8192];
    private int g = 120000;
    private int h = 120000;
    private boolean j = false;
    private boolean k = false;
    private Handler i = null;

    public a(Context context) {
        this.c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.sofire.rp.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0039a implements X509TrustManager {
        private X509TrustManager Py;

        C0039a(X509TrustManager x509TrustManager) {
            this.Py = null;
            this.Py = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.Py.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.Py.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
                for (Throwable th = e; th != null; th = th.getCause()) {
                    if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
                        return;
                    }
                }
                throw e;
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            return this.Py.getAcceptedIssuers();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd A[Catch: Exception -> 0x01f3, TRY_LEAVE, TryCatch #7 {Exception -> 0x01f3, blocks: (B:36:0x00a4, B:72:0x01fe, B:38:0x00bd, B:65:0x01ee, B:33:0x009a, B:57:0x01bb, B:60:0x01cc, B:61:0x01e7), top: B:83:0x01bb, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private HttpURLConnection nn() throws Exception {
        String str;
        HttpURLConnection httpURLConnection;
        KeyStore keyStore;
        KeyStore keyStore2;
        String[] au;
        String string;
        Class<?> cls;
        int i = -1;
        X509TrustManager x509TrustManager = null;
        if (this.k) {
            return null;
        }
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.f)) {
            return null;
        }
        if (!this.e.equals("POST") && !this.e.equals("GET")) {
            this.e = "POST";
        }
        URL url = new URL(this.f);
        if (2 == b.a(this.c)) {
            i = 0;
            str = null;
        } else if (Build.VERSION.SDK_INT >= 13) {
            str = System.getProperties().getProperty("http.proxyHost");
            String property = System.getProperties().getProperty("http.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                try {
                    i = Integer.parseInt(property);
                } catch (Exception e) {
                }
            }
        } else {
            str = Proxy.getHost(this.c);
            i = Proxy.getPort(this.c);
        }
        if (str != null && i > 0) {
            httpURLConnection = (HttpURLConnection) url.openConnection(new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i)));
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        try {
            keyStore = KeyStore.getInstance("AndroidCAStore");
            try {
                keyStore.load(null, null);
                keyStore2 = keyStore;
            } catch (Exception e2) {
                try {
                    try {
                        String property2 = System.getProperty("javax.net.ssl.trustStore");
                        String property3 = System.getProperty("javax.net.ssl.trustStorePassword");
                        char[] charArray = property3 == null ? null : property3.toCharArray();
                        keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(property2));
                        keyStore.load(bufferedInputStream, charArray);
                        bufferedInputStream.close();
                        keyStore2 = keyStore;
                    } catch (Exception e3) {
                        keyStore2 = keyStore;
                        b.a();
                    }
                    if (keyStore2 != null) {
                    }
                    if (x509TrustManager != null) {
                    }
                } catch (Exception e4) {
                    b.a();
                }
                httpURLConnection.setRequestMethod(this.e);
                httpURLConnection.setDoInput(true);
                if ("POST".equals(this.e)) {
                }
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setConnectTimeout(this.g);
                httpURLConnection.setReadTimeout(this.h);
                httpURLConnection.setRequestProperty("x-device-id", i.a(d.a(this.c)));
                httpURLConnection.setRequestProperty("Pragma", "no-cache");
                String str2 = "";
                au = b.au(this.c);
                if (au != null) {
                }
                string = new com.baidu.sofire.rp.a.a(this.c).b.getString("ssv", "");
                if (TextUtils.isEmpty(string)) {
                }
                httpURLConnection.setRequestProperty("User-Agent", "eos/" + str2 + "/" + b.d(this.c) + "/" + string);
                httpURLConnection.setRequestProperty("Accept", "/");
                httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "application/octet-stream");
                return httpURLConnection;
            }
        } catch (Exception e5) {
            keyStore = null;
        }
        if (keyStore2 != null) {
            try {
                cls = Class.forName("com.android.org.conscrypt.TrustManagerImpl");
            } catch (Exception e6) {
                cls = null;
            }
            if (cls == null) {
                try {
                    cls = Class.forName("org.apache.harmony.xnet.provider.jsse.TrustManagerImpl");
                } catch (Exception e7) {
                    b.a();
                }
            }
            if (cls != null) {
                x509TrustManager = (X509TrustManager) cls.getDeclaredConstructor(KeyStore.class).newInstance(keyStore2);
            }
        }
        if (x509TrustManager != null) {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new C0039a(x509TrustManager)}, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        }
        httpURLConnection.setRequestMethod(this.e);
        httpURLConnection.setDoInput(true);
        if ("POST".equals(this.e)) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setConnectTimeout(this.g);
        httpURLConnection.setReadTimeout(this.h);
        httpURLConnection.setRequestProperty("x-device-id", i.a(d.a(this.c)));
        httpURLConnection.setRequestProperty("Pragma", "no-cache");
        String str22 = "";
        au = b.au(this.c);
        if (au != null) {
            try {
                if (au.length == 2) {
                    str22 = au[0];
                }
            } catch (Throwable th) {
                b.a();
            }
        }
        string = new com.baidu.sofire.rp.a.a(this.c).b.getString("ssv", "");
        if (TextUtils.isEmpty(string)) {
            string = b.a(this.c, "my.cfg", "self_version");
        }
        httpURLConnection.setRequestProperty("User-Agent", "eos/" + str22 + "/" + b.d(this.c) + "/" + string);
        httpURLConnection.setRequestProperty("Accept", "/");
        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "application/octet-stream");
        return httpURLConnection;
    }

    private String a(InputStream inputStream) throws Exception {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(this.a);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(this.a, 0, read);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (byteArray != null) {
            if (this.j) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                g.f(byteArrayInputStream, byteArrayOutputStream2);
                byteArray = byteArrayOutputStream2.toByteArray();
                byteArrayOutputStream2.flush();
                byteArrayOutputStream2.close();
                byteArrayInputStream.close();
            }
            if (byteArray != null) {
                return new String(byteArray);
            }
            return null;
        }
        return null;
    }

    public final String g(String str, byte[] bArr) throws Exception {
        InputStream inputStream;
        this.e = "POST";
        this.f = str;
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.setThreadStatsTag(155648);
            }
            if (b.a(this.c) == 0) {
                throw new NetworkErrorException("requestFromServerStreamByte no network");
            }
            this.PY = nn();
            if (this.PY == null) {
                inputStream = null;
            } else if (bArr == null) {
                if ("gzip".equalsIgnoreCase(this.PY.getContentEncoding())) {
                    this.j = true;
                } else {
                    this.j = false;
                }
                inputStream = this.PY.getInputStream();
            } else {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.PY.getOutputStream());
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                int responseCode = this.PY.getResponseCode();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("code:" + responseCode);
                stringBuffer.append(",content:" + this.PY.getContent());
                stringBuffer.append("response:" + this.PY.getResponseMessage());
                if ("gzip".equalsIgnoreCase(this.PY.getContentEncoding())) {
                    this.j = true;
                } else {
                    this.j = false;
                }
                inputStream = this.PY.getInputStream();
            }
            if (inputStream == null) {
                try {
                    if (Build.VERSION.SDK_INT >= 15) {
                        TrafficStats.clearThreadStatsTag();
                    }
                } catch (Throwable th) {
                    b.a();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.PY != null) {
                    this.PY.disconnect();
                    this.PY = null;
                    return null;
                }
                return null;
            }
            try {
                String a = a(inputStream);
                try {
                    if (Build.VERSION.SDK_INT >= 15) {
                        TrafficStats.clearThreadStatsTag();
                    }
                } catch (Throwable th2) {
                    b.a();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.PY != null) {
                    this.PY.disconnect();
                    this.PY = null;
                }
                return a;
            } catch (Throwable th3) {
                th = th3;
                try {
                    if (Build.VERSION.SDK_INT >= 15) {
                        TrafficStats.clearThreadStatsTag();
                    }
                } catch (Throwable th4) {
                    b.a();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (this.PY != null) {
                    this.PY.disconnect();
                    this.PY = null;
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [606=4] */
    public final String a(String str) throws Exception {
        InputStream inputStream;
        try {
            if (Build.VERSION.SDK_INT >= 15) {
                TrafficStats.setThreadStatsTag(155648);
            }
            this.e = "GET";
            this.f = str;
            if (b.a(this.c) == 0) {
                throw new NetworkErrorException("requestFromServerStream no network");
            }
            this.PY = nn();
            if (this.PY == null) {
                inputStream = null;
            } else {
                if ("gzip".equalsIgnoreCase(this.PY.getContentEncoding())) {
                    this.j = true;
                } else {
                    this.j = false;
                }
                inputStream = this.PY.getInputStream();
            }
            if (inputStream == null) {
                try {
                    if (Build.VERSION.SDK_INT >= 15) {
                        TrafficStats.clearThreadStatsTag();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (this.PY != null) {
                        this.PY.disconnect();
                        this.PY = null;
                        return null;
                    }
                    return null;
                } catch (Exception e) {
                    b.a();
                    return null;
                }
            }
            try {
                String a = a(inputStream);
                try {
                    if (Build.VERSION.SDK_INT >= 15) {
                        TrafficStats.clearThreadStatsTag();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (this.PY != null) {
                        this.PY.disconnect();
                        this.PY = null;
                    }
                    return a;
                } catch (Exception e2) {
                    b.a();
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    if (Build.VERSION.SDK_INT >= 15) {
                        TrafficStats.clearThreadStatsTag();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (this.PY != null) {
                        this.PY.disconnect();
                        this.PY = null;
                    }
                    throw th;
                } catch (Exception e3) {
                    b.a();
                    return null;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }
}
