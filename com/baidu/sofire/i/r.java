package com.baidu.sofire.i;

import android.accounts.NetworkErrorException;
import android.content.Context;
import com.baidu.webkit.internal.GlobalConstants;
import com.xiaomi.mipush.sdk.Constants;
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
/* loaded from: classes9.dex */
public final class r {
    private static SSLSocketFactory b;
    private static final byte[] c = new byte[1024];

    /* renamed from: a  reason: collision with root package name */
    private Context f3644a;

    public r(Context context) {
        this.f3644a = context;
    }

    private OkHttpClient a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            if (b != null) {
                builder.hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                builder.sslSocketFactory(b);
            } else {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length <= 0 || !(trustManagers[0] instanceof X509TrustManager)) {
                    throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
                }
                sSLContext.init(null, new TrustManager[]{new a((X509TrustManager) trustManagers[0])}, new SecureRandom());
                b = sSLContext.getSocketFactory();
                builder.hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                builder.sslSocketFactory(b);
            }
        } catch (Throwable th) {
            e.a();
        }
        builder.connectTimeout(120000L, TimeUnit.MILLISECONDS);
        builder.addInterceptor(new Interceptor() { // from class: com.baidu.sofire.i.r.1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) throws IOException {
                long currentTimeMillis = System.currentTimeMillis();
                Request request = chain.request();
                Response proceed = chain.proceed(request);
                new StringBuilder("okhttp request time:").append(request.url()).append(" : ").append(System.currentTimeMillis() - currentTimeMillis);
                com.baidu.sofire.b.a();
                return proceed;
            }
        });
        return builder.build();
    }

    private Request b(String str, byte[] bArr) {
        try {
            MediaType parse = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
            String str2 = e.g(this.f3644a)[0];
            Request.Builder url = new Request.Builder().url(str);
            if (bArr != null) {
                url.post(RequestBody.create(parse, bArr));
            }
            return url.addHeader("User-Agent", "eos/" + str2 + "/" + y.a(this.f3644a) + "/3.4.4.1").addHeader("Pragma", "no-cache").addHeader("Accept", "*/*").addHeader("Accept-Language", Locale.getDefault().getLanguage() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Locale.getDefault().getCountry()).addHeader("x-device-id", p.a(h.b(this.f3644a))).build();
        } catch (Throwable th) {
            e.a();
            return null;
        }
    }

    public final String a(String str, byte[] bArr) {
        try {
            Response execute = a().newCall(b(str, bArr)).execute();
            int code = execute.code();
            if (code != 200) {
                throw new NetworkErrorException(String.valueOf(code));
            }
            return execute.body().string();
        } catch (Throwable th) {
            e.a();
            return "";
        }
    }

    public final boolean a(String str, File file) {
        try {
            Response execute = a().newCall(new Request.Builder().url(str).build()).execute();
            int code = execute.code();
            if (code != 200) {
                throw new NetworkErrorException(String.valueOf(code));
            }
            InputStream byteStream = execute.body().byteStream();
            boolean a2 = a(byteStream, file);
            byteStream.close();
            return a2;
        } catch (Throwable th) {
            e.a();
            return false;
        }
    }

    private static boolean a(InputStream inputStream, File file) {
        if (inputStream == null) {
            return false;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            while (true) {
                int read = inputStream.read(c);
                if (read != -1) {
                    bufferedOutputStream.write(c, 0, read);
                    bufferedOutputStream.flush();
                } else {
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable th) {
            e.a();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements X509TrustManager {
        private X509TrustManager b;

        a(X509TrustManager x509TrustManager) {
            this.b = null;
            this.b = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
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
                        e.a(r.this.f3644a.getApplicationContext(), "1003121", hashMap);
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
            return this.b.getAcceptedIssuers();
        }
    }

    public static boolean a(Context context) {
        return context.getPackageName().contains(GlobalConstants.SEARCHBOX_PACKAGE_NAME) && b();
    }

    private static boolean b() {
        try {
            new StringBuilder("okht").append(OkHttpClient.class);
            com.baidu.sofire.b.a();
            return true;
        } catch (Throwable th) {
            e.a();
            return false;
        }
    }
}
