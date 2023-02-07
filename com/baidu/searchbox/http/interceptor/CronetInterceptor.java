package com.baidu.searchbox.http.interceptor;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.cronet.CronetRuntime;
import com.baidu.searchbox.http.cronet.ICronet;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CronetInterceptor implements Interceptor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int MAX_ERROR_CONTENT = 16384;
    public static final String TAG = "CronetInterceptor";
    public static Method sEnableSslRedirectMethod;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient mOkHttpClient;

    /* loaded from: classes2.dex */
    public class RobustInputStream extends FilterInputStream {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile HttpURLConnection conn;
        public volatile boolean readComplete;
        public final /* synthetic */ CronetInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RobustInputStream(CronetInterceptor cronetInterceptor, InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetInterceptor, inputStream, httpURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((InputStream) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cronetInterceptor;
            this.readComplete = false;
            this.conn = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((FilterInputStream) this).in.close();
                if (!this.readComplete && this.conn != null) {
                    this.conn.disconnect();
                }
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int read = ((FilterInputStream) this).in.read();
                if (read < 0) {
                    this.readComplete = true;
                }
                return read;
            }
            return invokeV.intValue;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
                int read = read(bArr, 0, bArr.length);
                if (read < 0) {
                    this.readComplete = true;
                }
                return read;
            }
            return invokeL.intValue;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
                int read = ((FilterInputStream) this).in.read(bArr, i, i2);
                if (read < 0) {
                    this.readComplete = true;
                }
                return read;
            }
            return invokeLII.intValue;
        }
    }

    public CronetInterceptor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String cookieHeader(String str, List<Cookie> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, list)) == null) {
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append(str.trim());
                if (!str.trim().endsWith(";")) {
                    sb.append("; ");
                } else {
                    sb.append(" ");
                }
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Cookie cookie = list.get(i);
                if (sb.indexOf(cookie.name() + a.h) < 0) {
                    if (i > 0) {
                        sb.append("; ");
                    }
                    sb.append(cookie.name());
                    sb.append(a.h);
                    sb.append(cookie.value());
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    private String errHeader(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, response)) == null) {
            Headers headers = response.headers();
            StringBuilder sb = new StringBuilder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                sb.append(headers.name(i));
                sb.append(":");
                sb.append(headers.value(i));
                sb.append(";");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    private byte[] readInputStream(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (byteArray == null) {
                    return new byte[0];
                }
                return byteArray;
            } finally {
                Util.closeQuietly(inputStream);
                Util.closeQuietly(byteArrayOutputStream);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private ResponseBody getErrorResponseBody(String str, long j, HttpURLConnection httpURLConnection) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{str, Long.valueOf(j), httpURLConnection})) == null) {
            MediaType mediaType = null;
            if (j > 16384) {
                httpURLConnection.disconnect();
                if (str != null) {
                    mediaType = MediaType.parse(str);
                }
                return ResponseBody.create(mediaType, new byte[0]);
            }
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream == null) {
                httpURLConnection.disconnect();
                if (str != null) {
                    mediaType = MediaType.parse(str);
                }
                return ResponseBody.create(mediaType, new byte[0]);
            }
            if (str != null) {
                mediaType = MediaType.parse(str);
            }
            return ResponseBody.create(mediaType, readInputStream(errorStream));
        }
        return (ResponseBody) invokeCommon.objValue;
    }

    private void parseCronetProperties(Headers headers, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, headers, networkStatRecord) == null) {
            try {
                String str = headers.get("dns_start");
                String str2 = headers.get("dns_end");
                String str3 = headers.get("connect_start");
                String str4 = headers.get("ssl_start");
                String str5 = headers.get("ssl_end");
                String str6 = headers.get("connect_end");
                String str7 = headers.get("send_start");
                String str8 = headers.get("send_end");
                String str9 = headers.get("receive_headers_start");
                String str10 = headers.get("receive_headers_end");
                if (!TextUtils.isEmpty(str)) {
                    networkStatRecord.dnsStartTs = Long.parseLong(str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    networkStatRecord.dnsEndTs = Long.parseLong(str2);
                }
                if (networkStatRecord.dnsStartTs > 0 && networkStatRecord.dnsEndTs > 0) {
                    networkStatRecord.dnsTs = networkStatRecord.dnsStartTs - networkStatRecord.dnsEndTs;
                }
                if (!TextUtils.isEmpty(str3)) {
                    networkStatRecord.tcpStartTs = Long.parseLong(str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    networkStatRecord.sslStartTs = Long.parseLong(str4);
                }
                if (!TextUtils.isEmpty(str5)) {
                    networkStatRecord.sslEndTs = Long.parseLong(str5);
                }
                if (!TextUtils.isEmpty(str6)) {
                    networkStatRecord.connTs = Long.parseLong(str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    networkStatRecord.sendHeaderStartTs = Long.parseLong(str7);
                }
                if (!TextUtils.isEmpty(str8)) {
                    networkStatRecord.sendHeaderTs = Long.parseLong(str8);
                }
                if (!TextUtils.isEmpty(str9)) {
                    networkStatRecord.receiveHeaderStartTs = Long.parseLong(str9);
                }
                if (!TextUtils.isEmpty(str10)) {
                    networkStatRecord.receiveHeaderTs = Long.parseLong(str10);
                }
                networkStatRecord.isConnReused = TextUtils.equals(headers.get("socket-reused"), "1");
            } catch (Exception unused) {
            }
        }
    }

    private long stringToLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, str)) == null) {
            if (str == null) {
                return -1L;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return invokeL.longValue;
    }

    public void setClient(OkHttpClient okHttpClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, okHttpClient) == null) {
            this.mOkHttpClient = okHttpClient;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        InterceptResult invokeL;
        NetworkStatRecord networkStatRecord;
        String str;
        Protocol protocol;
        long contentLength;
        List<Cookie> loadForRequest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
            Request request = chain.request();
            ICronet cronet = CronetRuntime.getCronet();
            if (cronet != null && cronet.isCronetInited()) {
                String str2 = null;
                if (chain.call().request().tag() instanceof HttpRequest) {
                    networkStatRecord = ((HttpRequest) chain.call().request().tag()).getRequestNetStat();
                    if (networkStatRecord != null) {
                        networkStatRecord.netEngine = 3;
                    }
                } else {
                    networkStatRecord = null;
                }
                HttpURLConnection openHttpURLConnection = cronet.openHttpURLConnection(request.url().url());
                if (chain.call().isCanceled()) {
                    openHttpURLConnection.disconnect();
                    return chain.proceed(request);
                }
                openHttpURLConnection.setInstanceFollowRedirects(this.mOkHttpClient.followRedirects());
                if (this.mOkHttpClient.followSslRedirects()) {
                    Method method = sEnableSslRedirectMethod;
                    if (method == null) {
                        try {
                            Method declaredMethod = openHttpURLConnection.getClass().getDeclaredMethod("enableRedirectForDifferentProtocols", new Class[0]);
                            sEnableSslRedirectMethod = declaredMethod;
                            if (declaredMethod != null) {
                                declaredMethod.invoke(openHttpURLConnection, new Object[0]);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchMethodException e2) {
                            e2.printStackTrace();
                        } catch (InvocationTargetException e3) {
                            e3.printStackTrace();
                        }
                    } else {
                        try {
                            method.invoke(openHttpURLConnection, new Object[0]);
                        } catch (IllegalAccessException e4) {
                            e4.printStackTrace();
                        } catch (InvocationTargetException e5) {
                            e5.printStackTrace();
                        }
                    }
                }
                if (this.mOkHttpClient.connectTimeoutMillis() > 0) {
                    openHttpURLConnection.setConnectTimeout(this.mOkHttpClient.connectTimeoutMillis());
                }
                if (this.mOkHttpClient.readTimeoutMillis() > 0) {
                    openHttpURLConnection.setReadTimeout(this.mOkHttpClient.readTimeoutMillis());
                }
                Headers headers = request.headers();
                for (String str3 : headers.names()) {
                    if (str3.equalsIgnoreCase("Cookie")) {
                        str2 = headers.get(str3);
                    } else {
                        openHttpURLConnection.addRequestProperty(str3, headers.get(str3));
                    }
                }
                CookieJar cookieJar = this.mOkHttpClient.cookieJar();
                if (cookieJar != null && (loadForRequest = cookieJar.loadForRequest(request.url())) != null && !loadForRequest.isEmpty()) {
                    str2 = cookieHeader(str2, loadForRequest);
                }
                if (str2 != null) {
                    openHttpURLConnection.addRequestProperty("Cookie", str2);
                }
                openHttpURLConnection.addRequestProperty("Lib-Http-Req", "1");
                openHttpURLConnection.setRequestMethod(request.method());
                try {
                    if (request.body() != null) {
                        if (request.body().contentType() != null) {
                            openHttpURLConnection.setRequestProperty("Content-Type", request.body().contentType().toString());
                        }
                        openHttpURLConnection.setDoOutput(true);
                        OutputStream outputStream = openHttpURLConnection.getOutputStream();
                        BufferedSink buffer = Okio.buffer(Okio.sink(outputStream));
                        request.body().writeTo(buffer);
                        buffer.flush();
                        outputStream.close();
                    }
                    int responseCode = openHttpURLConnection.getResponseCode();
                    if (chain.call().isCanceled()) {
                        openHttpURLConnection.disconnect();
                        return chain.proceed(request);
                    }
                    request.headers();
                    List<String> list = openHttpURLConnection.getHeaderFields().get(ProbeTB.PROTOCOL);
                    String str4 = "";
                    if (list == null) {
                        str = "";
                    } else {
                        str = list.get(0);
                    }
                    try {
                        protocol = Protocol.get(str);
                    } catch (IOException unused) {
                        Log.e(TAG, "Unexpected protocol: " + str);
                        protocol = Protocol.HTTP_1_1;
                    }
                    Response.Builder builder = new Response.Builder();
                    builder.request(request).protocol(protocol).code(responseCode).message(openHttpURLConnection.getResponseMessage());
                    Headers.Builder builder2 = new Headers.Builder();
                    for (Map.Entry<String, List<String>> entry : openHttpURLConnection.getHeaderFields().entrySet()) {
                        for (String str5 : entry.getValue()) {
                            if (entry.getKey() != null && !entry.getKey().isEmpty() && entry.getValue() != null) {
                                try {
                                    builder.addHeader(entry.getKey(), str5);
                                    builder2.add(entry.getKey(), str5);
                                } catch (IllegalArgumentException unused2) {
                                    if (networkStatRecord != null) {
                                        JSONObject jSONObject = networkStatRecord.unexpectedResHeader;
                                        if (jSONObject == null) {
                                            jSONObject = new JSONObject();
                                        }
                                        try {
                                            jSONObject.put(entry.getKey(), str5);
                                        } catch (JSONException unused3) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Headers build = builder2.build();
                    if (cookieJar != CookieJar.NO_COOKIES) {
                        List<Cookie> parseAll = Cookie.parseAll(request.url(), build);
                        if (!parseAll.isEmpty()) {
                            cookieJar.saveFromResponse(request.url(), parseAll);
                        }
                    }
                    String responseMessage = openHttpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "";
                    }
                    Response build2 = builder.body(openResponseBody(builder.message(responseMessage).build(), build, openHttpURLConnection)).build();
                    if (networkStatRecord != null) {
                        if (request.body() == null) {
                            contentLength = 0;
                        } else {
                            contentLength = request.body().contentLength();
                        }
                        networkStatRecord.requestBodyLength = contentLength;
                        networkStatRecord.statusCode = responseCode;
                        networkStatRecord.protocol = protocol.toString();
                        String str6 = build.get("X-Bfe-Svbbrers");
                        if (!TextUtils.isEmpty(str6)) {
                            networkStatRecord.clientIP = str6;
                        } else {
                            networkStatRecord.clientIP = AbstractHttpManager.getClientIP();
                        }
                        parseCronetProperties(build, networkStatRecord);
                        long currentTimeMillis = System.currentTimeMillis();
                        networkStatRecord.responseTs = currentTimeMillis;
                        networkStatRecord.responseLength = build2.body().contentLength();
                        MediaType contentType = build2.body().contentType();
                        if (contentType != null) {
                            networkStatRecord.contentType = contentType.toString();
                        }
                        builder.headers(build).receivedResponseAtMillis(currentTimeMillis);
                        if (build2.isRedirect()) {
                            String header = build2.header("Location");
                            if (!TextUtils.isEmpty(header)) {
                                networkStatRecord.url = header;
                            }
                        }
                        if (responseCode >= 400) {
                            str4 = errHeader(build2);
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            networkStatRecord.errheaders = str4;
                        }
                    }
                    return build2;
                } catch (IOException e6) {
                    Log.e(TAG, "Write data or build connection caught exception: " + e6.toString());
                    openHttpURLConnection.disconnect();
                    throw e6;
                }
            }
            return chain.proceed(request);
        }
        return (Response) invokeL.objValue;
    }

    public ResponseBody openResponseBody(Response response, Headers headers, HttpURLConnection httpURLConnection) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, headers, httpURLConnection)) == null) {
            String str = headers.get("content-type");
            long stringToLong = stringToLong(headers.get(android.net.http.Headers.CONTENT_LEN));
            boolean z = !TextUtils.isEmpty(headers.get("Origin-Content-Encoding"));
            if (response.code() >= 300) {
                return getErrorResponseBody(str, stringToLong, httpURLConnection);
            }
            MediaType mediaType = null;
            if (!HttpHeaders.hasBody(response)) {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    inputStream.read();
                }
                if (str != null) {
                    mediaType = MediaType.parse(str);
                }
                return ResponseBody.create(mediaType, new byte[0]);
            }
            InputStream inputStream2 = httpURLConnection.getInputStream();
            if (inputStream2 == null) {
                if (str != null) {
                    mediaType = MediaType.parse(str);
                }
                return ResponseBody.create(mediaType, new byte[0]);
            } else if (stringToLong >= 0 && stringToLong <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                return new ResponseBody(this, str, z, stringToLong, readInputStream(inputStream2)) { // from class: com.baidu.searchbox.http.interceptor.CronetInterceptor.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CronetInterceptor this$0;
                    public final /* synthetic */ long val$contentLength;
                    public final /* synthetic */ String val$contentType;
                    public final /* synthetic */ byte[] val$data;
                    public final /* synthetic */ boolean val$hasContentEncoding;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Boolean.valueOf(z), Long.valueOf(stringToLong), r11};
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
                        this.val$contentType = str;
                        this.val$hasContentEncoding = z;
                        this.val$contentLength = stringToLong;
                        this.val$data = r11;
                    }

                    @Override // okhttp3.ResponseBody
                    public long contentLength() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            if (this.val$hasContentEncoding) {
                                return -1L;
                            }
                            return this.val$contentLength;
                        }
                        return invokeV.longValue;
                    }

                    @Override // okhttp3.ResponseBody
                    public MediaType contentType() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            String str2 = this.val$contentType;
                            if (str2 != null) {
                                return MediaType.parse(str2);
                            }
                            return null;
                        }
                        return (MediaType) invokeV.objValue;
                    }

                    @Override // okhttp3.ResponseBody
                    public BufferedSource source() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return new Buffer().write(this.val$data);
                        }
                        return (BufferedSource) invokeV.objValue;
                    }
                };
            } else {
                BufferedSource buffer = Okio.buffer(Okio.source(new RobustInputStream(this, inputStream2, httpURLConnection)));
                if (z) {
                    stringToLong = -1;
                }
                return new RealResponseBody(str, stringToLong, buffer);
            }
        }
        return (ResponseBody) invokeLLL.objValue;
    }
}
