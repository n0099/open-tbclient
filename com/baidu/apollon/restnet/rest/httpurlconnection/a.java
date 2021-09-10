package com.baidu.apollon.restnet.rest.httpurlconnection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes5.dex */
public class a implements X509TrustManager {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final X509Certificate[] f38139a;

    /* renamed from: b  reason: collision with root package name */
    public static TrustManager[] f38140b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-223662469, "Lcom/baidu/apollon/restnet/rest/httpurlconnection/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-223662469, "Lcom/baidu/apollon/restnet/rest/httpurlconnection/a;");
                return;
            }
        }
        f38139a = new X509Certificate[0];
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        SSLContext sSLContext;
        NoSuchAlgorithmException e2;
        KeyManagementException e3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() { // from class: com.baidu.apollon.restnet.rest.httpurlconnection.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str, sSLSession)) == null) {
                        return true;
                    }
                    return invokeLL.booleanValue;
                }
            });
            if (f38140b == null) {
                f38140b = new TrustManager[]{new a()};
            }
            try {
                sSLContext = SSLContext.getInstance("TLS");
            } catch (KeyManagementException e4) {
                sSLContext = null;
                e3 = e4;
            } catch (NoSuchAlgorithmException e5) {
                sSLContext = null;
                e2 = e5;
            }
            try {
                sSLContext.init(null, f38140b, null);
            } catch (KeyManagementException e6) {
                e3 = e6;
                e3.printStackTrace();
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (NoSuchAlgorithmException e7) {
                e2 = e7;
                e2.printStackTrace();
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            }
            HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
        }
    }

    public boolean a(X509Certificate[] x509CertificateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x509CertificateArr)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean b(X509Certificate[] x509CertificateArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, x509CertificateArr, str) == null) {
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, x509CertificateArr, str) == null) {
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? f38139a : (X509Certificate[]) invokeV.objValue;
    }
}
