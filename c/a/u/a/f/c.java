package c.a.u.a.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static C1401c f30248a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30249a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30249a = dVar;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                String str = "HttpRequest error :" + iOException.toString();
                if (iOException instanceof SocketException) {
                    str = "HttpRequest SocketException :" + iOException.toString();
                }
                c.c(this.f30249a, 10003, str);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    if (response.code() != 200) {
                        c.c(this.f30249a, response.code(), response.message());
                    } else if (response.body() == null) {
                        c.c(this.f30249a, 10004, "response body empty");
                    } else {
                        byte[] bytes = response.body().bytes();
                        c.a.u.a.h.e.b("HttpExecutor", "onSuccess errorCode ：" + response.code() + ", errorMsg :" + new String(bytes));
                        this.f30249a.onSuccess(bytes);
                    }
                } catch (IOException e2) {
                    d dVar = this.f30249a;
                    c.c(dVar, 10001, "parse response exception ：" + e2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        Map<String, String> getHeaders();

        String getHost();

        String getMediaType();

        String getMethod();

        byte[] getRequestParameter();
    }

    /* renamed from: c.a.u.a.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1401c implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1401c() {
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
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, x509CertificateArr, str) == null) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
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

        public /* synthetic */ C1401c(a aVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void onFailure(int i2, String str);

        void onSuccess(byte[] bArr);
    }

    /* loaded from: classes4.dex */
    public static class e implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, sSLSession)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public static SSLSocketFactory b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            try {
                f30248a = new C1401c(null);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, new TrustManager[]{f30248a}, new SecureRandom());
                return sSLContext.getSocketFactory();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (SSLSocketFactory) invokeV.objValue;
    }

    public static void c(@NonNull d dVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, dVar, i2, str) == null) {
            dVar.onFailure(i2, str);
            c.a.u.a.h.e.b("HttpExecutor", "failedResponse errorCode ：" + i2 + ", errorMsg :" + str);
        }
    }

    public static Headers d(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
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

    public static void e(@NonNull b bVar, @NonNull d dVar) {
        Request build;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, dVar) == null) {
            try {
                String host = bVar.getHost();
                byte[] requestParameter = bVar.getRequestParameter();
                if (requestParameter != null && requestParameter.length > 0) {
                    OkHttpClient build2 = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).build();
                    if (bVar.getMethod().equals("POST")) {
                        build = new Request.Builder().url(host).post(RequestBody.create(MediaType.parse(bVar.getMediaType()), requestParameter)).build();
                    } else {
                        if (requestParameter != null && requestParameter.length > 0) {
                            host = host + "?" + new String(requestParameter);
                        }
                        build = new Request.Builder().url(host).build();
                    }
                    Map<String, String> headers = bVar.getHeaders();
                    Headers d2 = d(headers);
                    if (headers != null && d2 != null) {
                        build = build.newBuilder().headers(d2).build();
                        String str = headers.get("Host");
                        if (!TextUtils.isEmpty(str) && str.contains(IMHttpDnsUrlRequest.HTTP_DNS_HOST)) {
                            build2 = build2.newBuilder().sslSocketFactory(b(), f30248a).hostnameVerifier(new e(null)).build();
                        }
                    }
                    c.a.u.a.h.e.a("HttpExecutor", "request url :" + host + " , method :" + bVar.getMethod() + " , body :" + new String(bVar.getRequestParameter()));
                    build2.newCall(build).enqueue(new a(dVar));
                    return;
                }
                c(dVar, 10000, "request args exception");
            } catch (Exception e2) {
                c(dVar, 10004, "request exception :" + e2);
            }
        }
    }
}
