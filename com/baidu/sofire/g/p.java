package com.baidu.sofire.g;

import android.accounts.NetworkErrorException;
import android.content.Context;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class p {

    /* renamed from: b  reason: collision with root package name */
    public static SSLSocketFactory f10310b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f10311c = new byte[1024];

    /* renamed from: d  reason: collision with root package name */
    public static OkHttpClient f10312d;

    /* renamed from: a  reason: collision with root package name */
    public Context f10313a;

    /* loaded from: classes2.dex */
    public class a implements X509TrustManager {

        /* renamed from: b  reason: collision with root package name */
        public X509TrustManager f10316b;

        public a(X509TrustManager x509TrustManager) {
            this.f10316b = null;
            this.f10316b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.f10316b.checkClientTrusted(x509CertificateArr, str);
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            com.baidu.sofire.b.a();
            try {
                this.f10316b.checkServerTrusted(x509CertificateArr, str);
                com.baidu.sofire.b.a();
            } catch (Throwable th) {
                d.a();
                for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                    if ((th2 instanceof CertificateExpiredException) || (th2 instanceof CertificateNotYetValidException)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
                        d.a(p.this.f10313a.getApplicationContext(), "1003121", (Map<String, Object>) hashMap, true);
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
            return this.f10316b.getAcceptedIssuers();
        }
    }

    public p(Context context) {
        this.f10313a = context;
    }

    private Request b(String str, byte[] bArr) {
        try {
            MediaType parse = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
            String str2 = d.h(this.f10313a)[0];
            Request.Builder url = new Request.Builder().url(str);
            if (bArr != null) {
                url.post(RequestBody.create(parse, bArr));
            }
            Request.Builder addHeader = url.addHeader("User-Agent", "eos/" + str2 + "/" + v.a(this.f10313a) + "/3.5.7.3").addHeader("Pragma", "no-cache").addHeader("Accept", "*/*");
            return addHeader.addHeader("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry()).addHeader("x-device-id", n.a(f.b(this.f10313a))).build();
        } catch (Throwable unused) {
            d.a();
            return null;
        }
    }

    private OkHttpClient a() {
        if (f10312d == null) {
            synchronized (p.class) {
                if (f10312d == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    if (f10310b != null) {
                        builder.hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        builder.sslSocketFactory(f10310b);
                    } else {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory.init((KeyStore) null);
                        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                        if (trustManagers.length > 0 && (trustManagers[0] instanceof X509TrustManager)) {
                            sSLContext.init(null, new TrustManager[]{new a((X509TrustManager) trustManagers[0])}, new SecureRandom());
                            f10310b = sSLContext.getSocketFactory();
                            builder.hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                            builder.sslSocketFactory(f10310b);
                        } else {
                            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                        }
                    }
                    builder.connectTimeout(AppConfig.TIMESTAMP_AVAILABLE_DURATION, TimeUnit.MILLISECONDS);
                    builder.addInterceptor(new Interceptor() { // from class: com.baidu.sofire.g.p.1
                        @Override // okhttp3.Interceptor
                        public final Response intercept(Interceptor.Chain chain) throws IOException {
                            long currentTimeMillis = System.currentTimeMillis();
                            Request request = chain.request();
                            Response proceed = chain.proceed(request);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            StringBuilder sb = new StringBuilder("okhttp request time:");
                            sb.append(request.url());
                            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
                            sb.append(currentTimeMillis2 - currentTimeMillis);
                            com.baidu.sofire.b.a();
                            return proceed;
                        }
                    });
                    f10312d = builder.build();
                }
            }
        }
        return f10312d;
    }

    public static boolean b() {
        try {
            new StringBuilder("okht").append(OkHttpClient.class);
            com.baidu.sofire.b.a();
            return true;
        } catch (Throwable unused) {
            d.a();
            return false;
        }
    }

    public final String a(String str, byte[] bArr) {
        try {
            if (r.m(this.f10313a)) {
                Response execute = a().newCall(b(str, bArr)).execute();
                int code = execute.code();
                if (code == 200) {
                    return execute.body().string();
                }
                throw new NetworkErrorException(String.valueOf(code));
            }
            throw new NetworkErrorException("Not allow background connect.");
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    public final boolean a(String str, File file) {
        try {
            if (r.m(this.f10313a)) {
                Response execute = a().newCall(new Request.Builder().url(str).build()).execute();
                int code = execute.code();
                if (code == 200) {
                    InputStream byteStream = execute.body().byteStream();
                    boolean a2 = a(byteStream, file);
                    byteStream.close();
                    return a2;
                }
                throw new NetworkErrorException(String.valueOf(code));
            }
            throw new NetworkErrorException("Not allow background connect.");
        } catch (Throwable unused) {
            d.a();
            return false;
        }
    }

    public static boolean a(InputStream inputStream, File file) {
        if (inputStream == null) {
            return false;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            while (true) {
                int read = inputStream.read(f10311c);
                if (read != -1) {
                    bufferedOutputStream.write(f10311c, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable unused) {
            d.a();
            return false;
        }
    }

    public static boolean a(Context context) {
        return context.getPackageName().contains("com.baidu.searchbox") && b();
    }
}
