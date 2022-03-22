package com.baidu.down.loopj.android.urlconnection;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.NameValuePair;
import com.baidu.down.loopj.android.http.ConnectManager;
import com.baidu.down.loopj.android.request.handler.HttpDns;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes3.dex */
public class ProxyURLConnection {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded; charset=UTF-8";
    public static final boolean DEBUG = false;
    public static final int DEFAULT_SOCKET_TIMEOUT = 30000;
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_HOST = "Host";
    public static final String REQUEST_METHOD_GET = "GET";
    public static final String REQUEST_METHOD_POST = "POST";
    public static final String TAG = "ProxyURLConnection";
    public static final int WAP_SOCKET_TIMEOUT = 60000;
    public static int mConnectionTimeout = 30000;
    public static int mSocketTimeout = 30000;
    public transient /* synthetic */ FieldHolder $fh;
    public ConnectManager mConnectManager;
    public Context mContext;
    public boolean mFollowRedirects;
    public String mHost;
    public HostnameVerifier mHostnameVerifier;
    public UrlConnectionRetryHandler mRetryHandler;
    public boolean mUsingDNSProxy;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-199265518, "Lcom/baidu/down/loopj/android/urlconnection/ProxyURLConnection;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-199265518, "Lcom/baidu/down/loopj/android/urlconnection/ProxyURLConnection;");
        }
    }

    public ProxyURLConnection(Context context, long[] jArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mFollowRedirects = true;
        this.mUsingDNSProxy = false;
        this.mHost = "";
        this.mContext = context.getApplicationContext();
        disableConnectionReuseIfNecessary();
        initProxyHttpClient();
        this.mRetryHandler = new UrlConnectionRetryHandler(jArr);
    }

    private boolean addContentBody(HttpURLConnection httpURLConnection, List<NameValuePair> list) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, httpURLConnection, list)) == null) {
            if (list == null) {
                return false;
            }
            String obtainParams = obtainParams(list, true);
            httpURLConnection.setFixedLengthStreamingMode(obtainParams.length());
            httpURLConnection.setDoOutput(true);
            if (TextUtils.isEmpty(httpURLConnection.getRequestProperty("Content-Type"))) {
                httpURLConnection.addRequestProperty("Content-Type", CONTENT_TYPE_VALUE);
            }
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(obtainParams.getBytes());
            dataOutputStream.close();
            return true;
        }
        return invokeLL.booleanValue;
    }

    private void disableConnectionReuseIfNecessary() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || Integer.parseInt(Build.VERSION.SDK) >= 8) {
            return;
        }
        System.setProperty("http.keepAlive", "false");
    }

    private String getRealUrl(String str) {
        InterceptResult invokeL;
        String str2;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65541, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String host = new URL(str).getHost();
            String[] ipByHost = HttpDns.getInstance().getIpByHost(host);
            if (ipByHost == null || ipByHost.length <= 0 || TextUtils.equals(ipByHost[0], host)) {
                return str;
            }
            str2 = str.replace(host, ipByHost[0]);
            try {
                new URL(str2);
                try {
                    this.mHost = host;
                    this.mHostnameVerifier = new HostnameVerifier(this) { // from class: com.baidu.down.loopj.android.urlconnection.ProxyURLConnection.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ProxyURLConnection this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str3, SSLSession sSLSession) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str3, sSLSession)) == null) {
                                return true;
                            }
                            return invokeLL.booleanValue;
                        }
                    };
                    return str2;
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return str2;
                }
            } catch (MalformedURLException unused) {
                setUsingDNSProxy(false);
                return str;
            }
        } catch (Exception e4) {
            str2 = str;
            e2 = e4;
        }
    }

    private String obtainParams(List<NameValuePair> list, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65542, this, list, z)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (NameValuePair nameValuePair : list) {
                stringBuffer.append('&');
                String name = nameValuePair.getName();
                if (z) {
                    name = Uri.encode(name);
                }
                stringBuffer.append(name);
                stringBuffer.append('=');
                stringBuffer.append(Uri.encode(nameValuePair.getValue()));
            }
            return stringBuffer.toString();
        }
        return (String) invokeLZ.objValue;
    }

    public HttpURLConnection getHttpURLConnection(String str, Map<String, String> map) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, map)) == null) ? getHttpURLConnection(str, map, "GET", null, false, true) : (HttpURLConnection) invokeLL.objValue;
    }

    public ConnectManager.NetWorkType getNetWorkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mConnectManager.getNetType() : (ConnectManager.NetWorkType) invokeV.objValue;
    }

    public UrlConnectionRetryHandler getRetryHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mRetryHandler : (UrlConnectionRetryHandler) invokeV.objValue;
    }

    public void initProxyHttpClient() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mConnectManager = new ConnectManager(this.mContext);
            if (isWap()) {
                mConnectionTimeout = 60000;
                mSocketTimeout = 60000;
            } else {
                mConnectionTimeout = 30000;
                mSocketTimeout = 30000;
            }
            setUsingDNSProxy(TextUtils.equals(DownPrefUtils.getString(this.mContext, DownPrefUtils.PREF_CONFI_HOST_TYPE, DownPrefUtils.HOST_TYPE_NAME), DownPrefUtils.HOST_TYPE_IP));
        }
    }

    public boolean isWap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mConnectManager.isWapNetwork() : invokeV.booleanValue;
    }

    public void setConnectTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            mConnectionTimeout = i;
        }
    }

    public void setFollowRedirects(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.mFollowRedirects = z;
        }
    }

    public void setSocketTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            mSocketTimeout = i;
        }
    }

    public void setUsingDNSProxy(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.mUsingDNSProxy = z;
        }
    }

    public boolean usingDNSProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mUsingDNSProxy : invokeV.booleanValue;
    }

    public HttpURLConnection getHttpURLConnection(String str, Map<String, String> map, boolean z) throws IOException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, map, z)) == null) ? getHttpURLConnection(str, map, "GET", null, z, true) : (HttpURLConnection) invokeLLZ.objValue;
    }

    public HttpURLConnection getHttpURLConnection(String str, Map<String, String> map, boolean z, boolean z2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, map, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? getHttpURLConnection(str, map, "GET", null, z, z2) : (HttpURLConnection) invokeCommon.objValue;
    }

    public HttpURLConnection getHttpURLConnection(String str, Map<String, String> map, String str2, List<NameValuePair> list, boolean z, boolean z2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, map, str2, list, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (usingDNSProxy()) {
                str = getRealUrl(str);
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(mConnectionTimeout);
            httpURLConnection.setReadTimeout(mSocketTimeout);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(this.mFollowRedirects);
            if (map != null) {
                for (String str3 : map.keySet()) {
                    httpURLConnection.addRequestProperty(str3, map.get(str3));
                }
            }
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (z) {
                    try {
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, new X509TrustManager[]{new X509TrustManager(this) { // from class: com.baidu.down.loopj.android.urlconnection.ProxyURLConnection.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ ProxyURLConnection this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // javax.net.ssl.X509TrustManager
                            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str4) throws CertificateException {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, x509CertificateArr, str4) == null) {
                                }
                            }

                            @Override // javax.net.ssl.X509TrustManager
                            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str4) throws CertificateException {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str4) == null) {
                                }
                            }

                            @Override // javax.net.ssl.X509TrustManager
                            public X509Certificate[] getAcceptedIssuers() {
                                InterceptResult invokeV;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                                    return null;
                                }
                                return (X509Certificate[]) invokeV.objValue;
                            }
                        }}, new SecureRandom());
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (usingDNSProxy() && this.mHostnameVerifier != null) {
                    httpURLConnection.addRequestProperty("Host", this.mHost);
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(this.mHostnameVerifier);
                    this.mHostnameVerifier = null;
                } else if (z2) {
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier(this) { // from class: com.baidu.down.loopj.android.urlconnection.ProxyURLConnection.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ProxyURLConnection this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // javax.net.ssl.HostnameVerifier
                        public boolean verify(String str4, SSLSession sSLSession) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str4, sSLSession)) == null) {
                                HttpsURLConnection.getDefaultHostnameVerifier();
                                return true;
                            }
                            return invokeLL.booleanValue;
                        }
                    });
                }
            }
            httpURLConnection.setRequestMethod(str2);
            if (str2.equals("POST") && !addContentBody(httpURLConnection, list)) {
                httpURLConnection.setFixedLengthStreamingMode(0);
            }
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeCommon.objValue;
    }

    public ProxyURLConnection(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mFollowRedirects = true;
        this.mUsingDNSProxy = false;
        this.mHost = "";
        this.mContext = context.getApplicationContext();
        disableConnectionReuseIfNecessary();
        this.mConnectManager = new ConnectManager(this.mContext);
        this.mUsingDNSProxy = z;
    }
}
