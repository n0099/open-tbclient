package com.baidu.android.pushservice.e;

import android.content.Context;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends SSLSocketFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HostnameVerifier f37220a;

        /* renamed from: b  reason: collision with root package name */
        public HttpsURLConnection f37221b;

        public a(HttpsURLConnection httpsURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {httpsURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37220a = HttpsURLConnection.getDefaultHostnameVerifier();
            this.f37221b = httpsURLConnection;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (Socket) invokeV.objValue;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
                return null;
            }
            return (Socket) invokeLI.objValue;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i2), inetAddress, Integer.valueOf(i3)})) == null) {
                return null;
            }
            return (Socket) invokeCommon.objValue;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, inetAddress, i2)) == null) {
                return null;
            }
            return (Socket) invokeLI.objValue;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{inetAddress, Integer.valueOf(i2), inetAddress2, Integer.valueOf(i3)})) == null) {
                return null;
            }
            return (Socket) invokeCommon.objValue;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{socket, str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                String requestProperty = this.f37221b.getRequestProperty("Host");
                if (!TextUtils.isEmpty(requestProperty)) {
                    str = requestProperty;
                }
                InetAddress inetAddress = socket.getInetAddress();
                if (z) {
                    socket.close();
                }
                SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
                SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i2);
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                if (Build.VERSION.SDK_INT >= 17) {
                    sSLCertificateSocketFactory.setHostname(sSLSocket, str);
                } else {
                    try {
                        sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, str);
                    } catch (Throwable unused) {
                    }
                }
                if (this.f37220a.verify(str, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
            }
            return (Socket) invokeCommon.objValue;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-677019132, "Lcom/baidu/android/pushservice/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-677019132, "Lcom/baidu/android/pushservice/e/c;");
                return;
            }
        }
        if (Build.VERSION.SDK_INT <= 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r0 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(Context context, String str, String str2, String str3, HashMap<String, String> hashMap, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, str3, hashMap, str4})) != null) {
            return (b) invokeCommon.objValue;
        }
        try {
            return com.baidu.android.pushservice.e.a.a().a(str, str2, str3, hashMap, str4);
        } catch (Throwable th) {
            th.printStackTrace();
            HttpURLConnection httpURLConnection = null;
            b bVar = new b();
            try {
                httpURLConnection = a(str, str2, hashMap, str4);
                a(context, str2, str3, httpURLConnection);
                bVar = a(context, httpURLConnection);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        }
    }

    public static b a(Context context, String str, String str2, HashMap<String, String> hashMap) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, hashMap)) == null) ? b(context, str, str2, hashMap, null, null) : (b) invokeLLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r1 == null) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (r1 != null) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
        r1.disconnect();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(Context context, String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, hashMap, str3, str4})) != null) {
            return (b) invokeCommon.objValue;
        }
        b bVar = new b();
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = a(str, str2, str3, str4);
            a(context, str2, a(hashMap), httpURLConnection);
            bVar = a(context, httpURLConnection);
        } catch (Exception unused) {
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static b a(Context context, HttpURLConnection httpURLConnection) {
        InterceptResult invokeLL;
        int i2;
        InputStream inputStream;
        BufferedInputStream bufferedInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, httpURLConnection)) == null) {
            b bVar = new b();
            GZIPInputStream gZIPInputStream = null;
            try {
                i2 = httpURLConnection.getResponseCode();
                try {
                    bufferedInputStream = new BufferedInputStream(a(i2) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream());
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                i2 = 0;
            }
            try {
                gZIPInputStream = a(httpURLConnection) ? new GZIPInputStream(bufferedInputStream) : bufferedInputStream;
                inputStream = new ByteArrayInputStream(a(context, gZIPInputStream));
            } catch (Exception unused3) {
                gZIPInputStream = bufferedInputStream;
                inputStream = gZIPInputStream;
                bVar.a(i2);
                bVar.a(inputStream);
                return bVar;
            }
            bVar.a(i2);
            bVar.a(inputStream);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public static String a(HashMap<String, String> hashMap) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, hashMap)) == null) {
            if (hashMap == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                if (i2 != 0) {
                    stringBuffer.append("&");
                }
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    stringBuffer.append(key);
                    stringBuffer.append("=");
                    String value = entry.getValue();
                    stringBuffer.append(!TextUtils.isEmpty(value) ? URLEncoder.encode(value, "UTF-8") : URLEncoder.encode("", "UTF-8"));
                }
                i2++;
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0062 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:4:0x0004, B:6:0x0021, B:9:0x002a, B:11:0x0032, B:16:0x004b, B:18:0x0062, B:19:0x0067, B:21:0x006d, B:22:0x0072, B:24:0x0076, B:25:0x0092, B:12:0x0036, B:14:0x003e, B:15:0x0042), top: B:33:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:4:0x0004, B:6:0x0021, B:9:0x002a, B:11:0x0032, B:16:0x004b, B:18:0x0062, B:19:0x0067, B:21:0x006d, B:22:0x0072, B:24:0x0076, B:25:0x0092, B:12:0x0036, B:14:0x003e, B:15:0x0042), top: B:33:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:4:0x0004, B:6:0x0021, B:9:0x002a, B:11:0x0032, B:16:0x004b, B:18:0x0062, B:19:0x0067, B:21:0x006d, B:22:0x0072, B:24:0x0076, B:25:0x0092, B:12:0x0036, B:14:0x003e, B:15:0x0042), top: B:33:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpURLConnection a(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2, str3, str4)) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                if (!"POST".equals(str2) && !HttpPut.METHOD_NAME.equals(str2)) {
                    if (HttpDelete.METHOD_NAME.equals(str2)) {
                        httpURLConnection.setDoOutput(true);
                    } else if ("GET".equals(str2)) {
                        httpURLConnection.setDoOutput(false);
                    }
                    httpURLConnection.setRequestMethod(str2);
                    httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
                    httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnection.setRequestProperty("User-Agent", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        httpURLConnection.setRequestProperty("Host", str4);
                    }
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        httpURLConnection.setInstanceFollowRedirects(false);
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new a((HttpsURLConnection) httpURLConnection));
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier(httpURLConnection) { // from class: com.baidu.android.pushservice.e.c.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ HttpURLConnection f37218a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {httpURLConnection};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f37218a = httpURLConnection;
                            }

                            @Override // javax.net.ssl.HostnameVerifier
                            public boolean verify(String str5, SSLSession sSLSession) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str5, sSLSession)) == null) {
                                    String requestProperty = this.f37218a.getRequestProperty("Host");
                                    if (!TextUtils.isEmpty(requestProperty)) {
                                        str5 = requestProperty;
                                    }
                                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str5, sSLSession);
                                }
                                return invokeLL.booleanValue;
                            }
                        });
                    }
                    httpURLConnection.connect();
                    return httpURLConnection;
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
                httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                if (!TextUtils.isEmpty(str3)) {
                }
                if (!TextUtils.isEmpty(str4)) {
                }
                if (httpURLConnection instanceof HttpsURLConnection) {
                }
                httpURLConnection.connect();
                return httpURLConnection;
            } catch (Exception unused) {
                return null;
            }
        }
        return (HttpURLConnection) invokeLLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[Catch: Exception -> 0x00a2, LOOP:0: B:17:0x0062->B:19:0x0068, LOOP_END, TryCatch #0 {Exception -> 0x00a2, blocks: (B:4:0x0004, B:6:0x0021, B:9:0x002a, B:11:0x0032, B:16:0x004b, B:17:0x0062, B:19:0x0068, B:20:0x007e, B:22:0x0082, B:23:0x009e, B:12:0x0036, B:14:0x003e, B:15:0x0042), top: B:31:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0082 A[Catch: Exception -> 0x00a2, TryCatch #0 {Exception -> 0x00a2, blocks: (B:4:0x0004, B:6:0x0021, B:9:0x002a, B:11:0x0032, B:16:0x004b, B:17:0x0062, B:19:0x0068, B:20:0x007e, B:22:0x0082, B:23:0x009e, B:12:0x0036, B:14:0x003e, B:15:0x0042), top: B:31:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpURLConnection a(String str, String str2, HashMap<String, String> hashMap, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65543, null, str, str2, hashMap, str3)) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                if (!"POST".equals(str2) && !HttpPut.METHOD_NAME.equals(str2)) {
                    if (HttpDelete.METHOD_NAME.equals(str2)) {
                        httpURLConnection.setDoOutput(true);
                    } else if ("GET".equals(str2)) {
                        httpURLConnection.setDoOutput(false);
                    }
                    httpURLConnection.setRequestMethod(str2);
                    httpURLConnection.setRequestProperty("Content-type", str3);
                    httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                    for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        httpURLConnection.setInstanceFollowRedirects(false);
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new a((HttpsURLConnection) httpURLConnection));
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier(httpURLConnection) { // from class: com.baidu.android.pushservice.e.c.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ HttpURLConnection f37219a;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {httpURLConnection};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f37219a = httpURLConnection;
                            }

                            @Override // javax.net.ssl.HostnameVerifier
                            public boolean verify(String str4, SSLSession sSLSession) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str4, sSLSession)) == null) {
                                    String requestProperty = this.f37219a.getRequestProperty("Host");
                                    if (!TextUtils.isEmpty(requestProperty)) {
                                        str4 = requestProperty;
                                    }
                                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(str4, sSLSession);
                                }
                                return invokeLL.booleanValue;
                            }
                        });
                    }
                    httpURLConnection.connect();
                    return httpURLConnection;
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod(str2);
                httpURLConnection.setRequestProperty("Content-type", str3);
                httpURLConnection.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                while (r5.hasNext()) {
                }
                if (httpURLConnection instanceof HttpsURLConnection) {
                }
                httpURLConnection.connect();
                return httpURLConnection;
            } catch (Exception unused) {
                return null;
            }
        }
        return (HttpURLConnection) invokeLLLL.objValue;
    }

    public static void a(Context context, String str, String str2, HttpURLConnection httpURLConnection) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65544, null, context, str, str2, httpURLConnection) == null) {
            if (("POST".equals(str) || HttpPut.METHOD_NAME.equals(str) || HttpDelete.METHOD_NAME.equals(str)) && !a(context, httpURLConnection, str2)) {
                throw new IOException("failed to writeRequestParams");
            }
        }
    }

    public static void a(Context context, Closeable... closeableArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, context, closeableArr) == null) || closeableArr == null) {
            return;
        }
        try {
            if (closeableArr.length > 0) {
                for (Closeable closeable : closeableArr) {
                    if (closeable != null) {
                        closeable.close();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            int i3 = i2 / 100;
            return i3 == 4 || i3 == 5 || i3 == 6;
        }
        return invokeI.booleanValue;
    }

    public static boolean a(Context context, HttpURLConnection httpURLConnection, String str) {
        InterceptResult invokeLLL;
        OutputStream outputStream;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLL = interceptable.invokeLLL(65547, null, context, httpURLConnection, str)) != null) {
            return invokeLLL.booleanValue;
        }
        boolean z = !TextUtils.isEmpty(str);
        DataOutputStream dataOutputStream2 = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                dataOutputStream = new DataOutputStream(outputStream);
            } catch (Exception unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.write(str.getBytes("UTF-8"));
                dataOutputStream.flush();
                a(context, dataOutputStream, outputStream);
                return z;
            } catch (Exception unused2) {
                dataOutputStream2 = dataOutputStream;
                a(context, dataOutputStream2, outputStream);
                return false;
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                a(context, dataOutputStream2, outputStream);
                throw th;
            }
        } catch (Exception unused3) {
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public static boolean a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, httpURLConnection)) == null) {
            String headerField = httpURLConnection.getHeaderField("Content-Encoding");
            return !TextUtils.isEmpty(headerField) && headerField.contains("zip");
        }
        return invokeL.booleanValue;
    }

    public static byte[] a(Context context, InputStream inputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } catch (Exception unused) {
                    a(context, byteArrayOutputStream, inputStream);
                } catch (Throwable th) {
                    a(context, byteArrayOutputStream, inputStream);
                    throw th;
                }
            }
            a(context, byteArrayOutputStream, inputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
        if (r0 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b b(Context context, String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{context, str, str2, hashMap, str3, str4})) != null) {
            return (b) invokeCommon.objValue;
        }
        try {
            return com.baidu.android.pushservice.e.a.a().a(str, str2, hashMap, str3, str4);
        } catch (Throwable th) {
            th.printStackTrace();
            HttpURLConnection httpURLConnection = null;
            b bVar = new b();
            try {
                httpURLConnection = a(str, str2, str3, str4);
                a(context, str2, a(hashMap), httpURLConnection);
                bVar = a(context, httpURLConnection);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        }
    }
}
