package com.baidu.tbadk.core.util.https;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbSingleton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.Domains;
import d.a.r0.s.c.z;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes4.dex */
public class HttpsUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.tbadk.core.util.https.HttpsUtil$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class MyHostnameVerifier implements HostnameVerifier {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public MyHostnameVerifier() {
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
                if (str == null || !HttpsUtil.verifySafeHostname(str)) {
                    return str != null && HttpsUtil.checkHostnameInWhiteList(str);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ MyHostnameVerifier(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public static class MyTrustManager implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public X509TrustManager defaultTrustManager;
        public X509TrustManager localTrustManager;

        public MyTrustManager(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x509TrustManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            this.defaultTrustManager = HttpsUtil.chooseTrustManager(trustManagerFactory.getTrustManagers());
            this.localTrustManager = x509TrustManager;
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
                try {
                    this.defaultTrustManager.checkServerTrusted(x509CertificateArr, str);
                } catch (CertificateException unused) {
                    this.localTrustManager.checkServerTrusted(x509CertificateArr, str);
                }
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
    public static class SSLParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SSLSocketFactory sSLSocketFactory;
        public X509TrustManager trustManager;

        public SSLParams() {
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
    }

    /* loaded from: classes4.dex */
    public static class UnSafeTrustManager implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public UnSafeTrustManager() {
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
    }

    public HttpsUtil() {
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

    public static MyHostnameVerifier buildMyHostnameVerifier() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? new MyHostnameVerifier(null) : (MyHostnameVerifier) invokeV.objValue;
    }

    public static boolean checkHostnameInWhiteList(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (z.a(str)) {
                return true;
            }
            List<String> hostWhiteList = TbSingleton.getInstance().getHostWhiteList();
            if (hostWhiteList != null) {
                for (String str2 : hostWhiteList) {
                    if (str != null && str2 != null && str.toLowerCase().indexOf(str2.toLowerCase()) != -1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, trustManagerArr)) == null) {
            for (TrustManager trustManager : trustManagerArr) {
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            return null;
        }
        return (X509TrustManager) invokeL.objValue;
    }

    public static SSLParams getSslSocketFactory(InputStream[] inputStreamArr, InputStream inputStream, String str) {
        InterceptResult invokeLLL;
        X509TrustManager unSafeTrustManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, inputStreamArr, inputStream, str)) == null) {
            SSLParams sSLParams = new SSLParams();
            try {
                TrustManager[] prepareTrustManager = prepareTrustManager(inputStreamArr);
                KeyManager[] prepareKeyManager = prepareKeyManager(inputStream, str);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                if (prepareTrustManager != null) {
                    unSafeTrustManager = new MyTrustManager(chooseTrustManager(prepareTrustManager));
                } else {
                    unSafeTrustManager = new UnSafeTrustManager();
                }
                sSLContext.init(prepareKeyManager, new TrustManager[]{unSafeTrustManager}, null);
                sSLParams.sSLSocketFactory = sSLContext.getSocketFactory();
                sSLParams.trustManager = unSafeTrustManager;
                return sSLParams;
            } catch (KeyManagementException e2) {
                throw new AssertionError(e2);
            } catch (KeyStoreException e3) {
                throw new AssertionError(e3);
            } catch (NoSuchAlgorithmException e4) {
                throw new AssertionError(e4);
            }
        }
        return (SSLParams) invokeLLL.objValue;
    }

    public static void initHttpsURLConnection() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            try {
                SSLParams sslSocketFactory = getSslSocketFactory(null, null, null);
                if (sslSocketFactory == null || sslSocketFactory.sSLSocketFactory == null) {
                    return;
                }
                HttpsURLConnection.setDefaultSSLSocketFactory(new Tls12SocketFactory(sslSocketFactory.sSLSocketFactory));
                HttpsURLConnection.setDefaultHostnameVerifier(buildMyHostnameVerifier());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static KeyManager[] prepareKeyManager(InputStream inputStream, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, inputStream, str)) == null) {
            if (inputStream != null && str != null) {
                try {
                    KeyStore keyStore = KeyStore.getInstance("BKS");
                    keyStore.load(inputStream, str.toCharArray());
                    KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                    keyManagerFactory.init(keyStore, str.toCharArray());
                    return keyManagerFactory.getKeyManagers();
                } catch (IOException e2) {
                    e2.printStackTrace();
                } catch (KeyStoreException e3) {
                    e3.printStackTrace();
                } catch (NoSuchAlgorithmException e4) {
                    e4.printStackTrace();
                } catch (UnrecoverableKeyException e5) {
                    e5.printStackTrace();
                } catch (CertificateException e6) {
                    e6.printStackTrace();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            return null;
        }
        return (KeyManager[]) invokeLL.objValue;
    }

    public static TrustManager[] prepareTrustManager(InputStream... inputStreamArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, inputStreamArr)) == null) {
            if (inputStreamArr != null && inputStreamArr.length > 0) {
                try {
                    CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    keyStore.load(null);
                    int length = inputStreamArr.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < length) {
                        InputStream inputStream = inputStreamArr[i2];
                        int i4 = i3 + 1;
                        keyStore.setCertificateEntry(Integer.toString(i3), certificateFactory.generateCertificate(inputStream));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        i2++;
                        i3 = i4;
                    }
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory.init(keyStore);
                    return trustManagerFactory.getTrustManagers();
                } catch (KeyStoreException e2) {
                    e2.printStackTrace();
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                } catch (CertificateException e4) {
                    e4.printStackTrace();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        }
        return (TrustManager[]) invokeL.objValue;
    }

    public static boolean verifySafeHostname(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (str == null || str.toLowerCase().indexOf(Domains.BAIDU) == -1) {
                if (str == null || str.toLowerCase().indexOf(Domains.NUOMI) == -1) {
                    if (str == null || str.toLowerCase().indexOf(Domains.BAIFUBAO) == -1) {
                        return (str == null || str.toLowerCase().indexOf(".hao123.com") == -1) ? false : true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
