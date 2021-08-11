package com.baidu.android.imsdk.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class HttpExecutor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long CONNECTION_TIMEOUT = 15;
    public static final long READ_TIMEOUT = 15;
    public static final String TAG = "HttpExecutor";
    public static volatile HttpExecutor mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient okHttpClient;

    /* renamed from: com.baidu.android.imsdk.utils.HttpExecutor$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public class HttpExecutorLogger implements Interceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpExecutor this$0;

        public HttpExecutorLogger(HttpExecutor httpExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpExecutor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpExecutor;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
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
            return (Response) invokeL.objValue;
        }

        public /* synthetic */ HttpExecutorLogger(HttpExecutor httpExecutor, AnonymousClass1 anonymousClass1) {
            this(httpExecutor);
        }
    }

    /* loaded from: classes4.dex */
    public static class MyTrustManager implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public MyTrustManager() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, x509CertificateArr, str) == null) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) == null) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new X509Certificate[0] : (X509Certificate[]) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class TrustAllHostnameVerifier implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HttpExecutor this$0;

        public TrustAllHostnameVerifier(HttpExecutor httpExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpExecutor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = httpExecutor;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ TrustAllHostnameVerifier(HttpExecutor httpExecutor, AnonymousClass1 anonymousClass1) {
            this(httpExecutor);
        }
    }

    public HttpExecutor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpExecutorLogger(this, null)).connectTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).build();
    }

    private SSLSocketFactory createSSLSocketFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
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
        return (SSLSocketFactory) invokeV.objValue;
    }

    private Headers getHeaders(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, map)) == null) {
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
        return (Headers) invokeL.objValue;
    }

    public static HttpExecutor getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (mInstance == null) {
                synchronized (HttpExecutor.class) {
                    if (mInstance == null) {
                        mInstance = new HttpExecutor();
                    }
                }
            }
            return mInstance;
        }
        return (HttpExecutor) invokeV.objValue;
    }

    public void execute(int i2, String str, byte[] bArr, Map<String, String> map, String str2, HttpHelper.ResponseHandler responseHandler) {
        Request build;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, bArr, map, str2, responseHandler}) == null) {
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
                    this.okHttpClient = this.okHttpClient.newBuilder().sslSocketFactory(createSSLSocketFactory(), new MyTrustManager()).hostnameVerifier(new TrustAllHostnameVerifier(this, null)).build();
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
}
