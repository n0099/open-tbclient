package com.baidu.android.imsdk.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.android.imsdk.utils.HttpHelper;
import java.io.IOException;
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
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes.dex */
public class HttpExecutor {
    public static final long CONNECTION_TIMEOUT = 15;
    public static final long READ_TIMEOUT = 15;
    public static final String TAG = "HttpExecutor";
    public static volatile HttpExecutor mInstance;
    public OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpExecutorLogger()).connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).build();

    /* loaded from: classes.dex */
    public class HttpExecutorLogger implements Interceptor {
        public HttpExecutorLogger() {
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            try {
                Request request = chain.request();
                long currentTimeMillis = System.currentTimeMillis();
                Response proceed = chain.proceed(request);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (Constants.isDebugMode()) {
                    LogUtils.d("HttpExecutor", ">>>>>request time=" + (currentTimeMillis2 - currentTimeMillis) + ", url=" + request.url().toString());
                    return proceed;
                }
                return proceed;
            } catch (Exception e2) {
                e2.printStackTrace();
                return chain.proceed(chain.request());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MyTrustManager implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* loaded from: classes.dex */
    public class TrustAllHostnameVerifier implements HostnameVerifier {
        public TrustAllHostnameVerifier() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    private SSLSocketFactory createSSLSocketFactory() {
        try {
            MyTrustManager myTrustManager = new MyTrustManager();
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{myTrustManager}, new SecureRandom());
            return sSLContext.getSocketFactory();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private Headers getHeaders(Map<String, String> map) {
        try {
            Headers.Builder builder = new Headers.Builder();
            if (map != null && map.size() > 0) {
                for (String str : map.keySet()) {
                    String str2 = str.toString();
                    builder.add(str2, map.get(str2));
                }
            }
            return builder.build();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static HttpExecutor getInstance() {
        if (mInstance == null) {
            synchronized (HttpExecutor.class) {
                if (mInstance == null) {
                    mInstance = new HttpExecutor();
                }
            }
        }
        return mInstance;
    }

    public void execute(int i2, String str, byte[] bArr, Map<String, String> map, String str2, HttpHelper.ResponseHandler responseHandler) {
        Request build;
        try {
            if (i2 == 16) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "application/x-www-form-urlencoded";
                }
                build = new Request.Builder().url(str).headers(getHeaders(map)).post(RequestBody.create(MediaType.parse(str2), bArr)).build();
            } else {
                if (bArr != null && bArr.length > 0) {
                    str = str + "?" + new String(bArr);
                }
                build = new Request.Builder().url(str).headers(getHeaders(map)).build();
            }
            String str3 = map.get("Host");
            if (!TextUtils.isEmpty(str3) && str3.contains(IMHttpDnsUrlRequest.HTTP_DNS_HOST)) {
                this.okHttpClient = this.okHttpClient.newBuilder().sslSocketFactory(createSSLSocketFactory(), new MyTrustManager()).hostnameVerifier(new TrustAllHostnameVerifier()).build();
            }
            try {
                Response execute = this.okHttpClient.newCall(build).execute();
                byte[] bytes = execute.body().bytes();
                LogUtils.i("HttpExecutor", "requestUrl:" + str + "\nrequest method: " + i2 + "\nrequest contentType: " + str2 + "\nrequest param: " + new String(bArr) + "\n response : " + new String(bytes));
                responseHandler.onSuccess(execute.code(), bytes);
            } catch (IOException e2) {
                LogUtils.e("HttpExecutor", "exception :", e2);
                responseHandler.onSuccess(1011, e2.getMessage().getBytes());
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (responseHandler != null) {
                responseHandler.onFailure(-1003, "Http Unknown exception".getBytes(), e3);
            }
        }
    }
}
