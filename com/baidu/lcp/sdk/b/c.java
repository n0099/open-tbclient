package com.baidu.lcp.sdk.b;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import java.io.IOException;
import java.net.SocketException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes14.dex */
public class c {
    private static b aAl;

    /* loaded from: classes14.dex */
    public interface a {
        Map<String, String> getHeaders();

        String getHost();

        String getMediaType();

        String getMethod();

        byte[] getRequestParameter();
    }

    /* renamed from: com.baidu.lcp.sdk.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC0167c {
        void onFailure(int i, String str);

        void onSuccess(byte[] bArr);
    }

    public static void a(@NonNull a aVar, @NonNull final InterfaceC0167c interfaceC0167c) {
        String str;
        Request build;
        Request request;
        OkHttpClient okHttpClient;
        try {
            String host = aVar.getHost();
            byte[] requestParameter = aVar.getRequestParameter();
            if (requestParameter == null || requestParameter.length <= 0) {
                a(interfaceC0167c, 10000, "request args exception");
                return;
            }
            OkHttpClient build2 = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).build();
            if (aVar.getMethod().equals("POST")) {
                str = host;
                build = new Request.Builder().url(host).post(RequestBody.create(MediaType.parse(aVar.getMediaType()), requestParameter)).build();
            } else {
                if (requestParameter != null && requestParameter.length > 0) {
                    host = host + "?" + new String(requestParameter);
                }
                str = host;
                build = new Request.Builder().url(host).build();
            }
            Map<String, String> headers = aVar.getHeaders();
            Headers headers2 = getHeaders(headers);
            if (headers == null || headers2 == null) {
                request = build;
                okHttpClient = build2;
            } else {
                Request build3 = build.newBuilder().headers(headers2).build();
                String str2 = headers.get("Host");
                if (TextUtils.isEmpty(str2) || !str2.contains(IMHttpDnsUrlRequest.HTTP_DNS_HOST)) {
                    okHttpClient = build2;
                    request = build3;
                } else {
                    okHttpClient = build2.newBuilder().sslSocketFactory(createSSLSocketFactory(), aAl).hostnameVerifier(new d()).build();
                    request = build3;
                }
            }
            com.baidu.lcp.sdk.d.d.d("HttpExecutor", "request url :" + str + " , method :" + aVar.getMethod() + " , body :" + new String(aVar.getRequestParameter()));
            okHttpClient.newCall(request).enqueue(new Callback() { // from class: com.baidu.lcp.sdk.b.c.1
                @Override // okhttp3.Callback
                public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
                    String str3 = "HttpRequest error :" + iOException.toString();
                    if (iOException instanceof SocketException) {
                        str3 = "HttpRequest SocketException :" + iOException.toString();
                    }
                    c.a(InterfaceC0167c.this, 10003, str3);
                }

                @Override // okhttp3.Callback
                public void onResponse(@NonNull Call call, @NonNull Response response) {
                    try {
                        if (response.code() != 200) {
                            c.a(InterfaceC0167c.this, response.code(), response.message());
                        } else if (response.body() == null) {
                            c.a(InterfaceC0167c.this, 10004, "response body empty");
                        } else {
                            byte[] bytes = response.body().bytes();
                            com.baidu.lcp.sdk.d.d.e("HttpExecutor", "onSuccess errorCode ：" + response.code() + ", errorMsg :" + new String(bytes));
                            InterfaceC0167c.this.onSuccess(bytes);
                        }
                    } catch (IOException e) {
                        c.a(InterfaceC0167c.this, 10001, "parse response exception ：" + e);
                    }
                }
            });
        } catch (Exception e) {
            a(interfaceC0167c, 10004, "request exception :" + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(@NonNull InterfaceC0167c interfaceC0167c, int i, String str) {
        interfaceC0167c.onFailure(i, str);
        com.baidu.lcp.sdk.d.d.e("HttpExecutor", "failedResponse errorCode ：" + i + ", errorMsg :" + str);
    }

    private static SSLSocketFactory createSSLSocketFactory() {
        try {
            aAl = new b();
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{aAl}, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static class b implements X509TrustManager {
        private b() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* loaded from: classes14.dex */
    private static class d implements HostnameVerifier {
        private d() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    private static Headers getHeaders(Map<String, String> map) {
        try {
            Headers.Builder builder = new Headers.Builder();
            if (map != null && map.size() > 0) {
                for (String str : map.keySet()) {
                    String str2 = str.toString();
                    builder.add(str2, map.get(str2));
                }
            }
            return builder.build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
