package com.baidu.pass.face.platform.stat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class NetUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final HostnameVerifier DO_NOT_VERIFY;
    public static final String TAG = "NetUtil";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static abstract class RequestAdapter<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CONNECT_TIMEOUT = 5000;
        public static final int READ_TIMEOUT = 5000;
        public static final String REQUEST_METHOD = "POST";
        public static final int RESPONSE_STATUS_ERROR_IO = 2;
        public static final int RESPONSE_STATUS_ERROR_PARSE_JSON = 3;
        public static final int RESPONSE_STATUS_ERROR_RESPONSE_CODE = 4;
        public static final int RESPONSE_STATUS_ERROR_TIMEOUT = 1;
        public static final int RESPONSE_STATUS_ERROR_UNKNOWN = 5;
        public static final int RESPONSE_STATUS_NORMAL = 0;
        public static final int RETRY_COUNT = 2;
        public transient /* synthetic */ FieldHolder $fh;

        public RequestAdapter() {
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

        public int getConnectTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 5000;
            }
            return invokeV.intValue;
        }

        public int getReadTimeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 5000;
            }
            return invokeV.intValue;
        }

        public String getRequestMethod() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "POST" : (String) invokeV.objValue;
        }

        public abstract String getRequestString();

        public int getRetryCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public abstract String getURL();

        public abstract void parseResponse(InputStream inputStream) throws IOException, JSONException;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1532862531, "Lcom/baidu/pass/face/platform/stat/NetUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1532862531, "Lcom/baidu/pass/face/platform/stat/NetUtil;");
                return;
            }
        }
        DO_NOT_VERIFY = new HostnameVerifier() { // from class: com.baidu.pass.face.platform.stat.NetUtil.2
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
        };
    }

    public NetUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        throw new RuntimeException("This class instance can not be created.");
    }

    public static boolean isConnected(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        }
        return invokeL.booleanValue;
    }

    public static void trustAllHosts() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.baidu.pass.face.platform.stat.NetUtil.1
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

                @Override // javax.net.ssl.X509TrustManager
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, x509CertificateArr, str) == null) {
                    }
                }

                @Override // javax.net.ssl.X509TrustManager
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) == null) {
                    }
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new X509Certificate[0] : (X509Certificate[]) invokeV.objValue;
                }
            }};
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, trustManagerArr, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0092, code lost:
        if (r6 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b6, code lost:
        if (r6 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00cd, code lost:
        if (r6 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e4, code lost:
        if (r6 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e6, code lost:
        r6.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e9, code lost:
        r1 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> void uploadData(RequestAdapter<T> requestAdapter) {
        HttpsURLConnection httpsURLConnection;
        Exception e2;
        JSONException e3;
        IOException e4;
        SocketTimeoutException e5;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, requestAdapter) != null) {
            return;
        }
        int retryCount = requestAdapter.getRetryCount();
        HttpsURLConnection httpsURLConnection2 = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        while (true) {
            boolean z = false;
            try {
                URL url = new URL(requestAdapter.getURL());
                trustAllHosts();
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                try {
                    try {
                        httpsURLConnection.setConnectTimeout(requestAdapter.getConnectTimeout());
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setRequestProperty("Content-Type", "application/json");
                        httpsURLConnection.setReadTimeout(requestAdapter.getReadTimeout());
                        httpsURLConnection.setRequestMethod(requestAdapter.getRequestMethod());
                        httpsURLConnection.setUseCaches(false);
                        httpsURLConnection.setHostnameVerifier(DO_NOT_VERIFY);
                        outputStream = httpsURLConnection.getOutputStream();
                        outputStream.write(requestAdapter.getRequestString().getBytes("UTF-8"));
                        outputStream.flush();
                        if (httpsURLConnection.getResponseCode() != 200) {
                            new IllegalStateException("ResponseCode: " + httpsURLConnection.getResponseCode());
                        } else {
                            inputStream = httpsURLConnection.getInputStream();
                            requestAdapter.parseResponse(inputStream);
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpsURLConnection2 = httpsURLConnection;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (SocketTimeoutException e6) {
                    e5 = e6;
                    e5.printStackTrace();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    httpsURLConnection2 = httpsURLConnection;
                    z = true;
                    if (!z) {
                        return;
                    }
                    i2 = retryCount - 1;
                    if (retryCount <= 0) {
                        return;
                    }
                    retryCount = i2;
                } catch (IOException e7) {
                    e4 = e7;
                    e4.printStackTrace();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused7) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused8) {
                        }
                    }
                } catch (JSONException e8) {
                    e3 = e8;
                    e3.printStackTrace();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused9) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused10) {
                        }
                    }
                } catch (Exception e9) {
                    e2 = e9;
                    e2.printStackTrace();
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException unused11) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused12) {
                        }
                    }
                }
            } catch (SocketTimeoutException e10) {
                httpsURLConnection = httpsURLConnection2;
                e5 = e10;
            } catch (IOException e11) {
                httpsURLConnection = httpsURLConnection2;
                e4 = e11;
            } catch (JSONException e12) {
                httpsURLConnection = httpsURLConnection2;
                e3 = e12;
            } catch (Exception e13) {
                httpsURLConnection = httpsURLConnection2;
                e2 = e13;
            } catch (Throwable th2) {
                th = th2;
            }
            retryCount = i2;
        }
    }
}
