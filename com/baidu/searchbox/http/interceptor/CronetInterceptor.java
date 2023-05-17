package com.baidu.searchbox.http.interceptor;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.cronet.CronetRuntime;
import com.baidu.searchbox.http.cronet.ICronet;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.hiidostatis.defs.obj.ParamableElem;
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
/* loaded from: classes3.dex */
public class CronetInterceptor implements Interceptor {
    public static final boolean DEBUG = false;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int MAX_ERROR_CONTENT = 16384;
    public static final String TAG = "CronetInterceptor";
    public static Method sEnableSslRedirectMethod;
    public OkHttpClient mOkHttpClient;

    /* loaded from: classes3.dex */
    public class RobustInputStream extends FilterInputStream {
        public volatile HttpURLConnection conn;
        public volatile boolean readComplete;

        public RobustInputStream(InputStream inputStream, HttpURLConnection httpURLConnection) {
            super(inputStream);
            this.readComplete = false;
            this.conn = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = ((FilterInputStream) this).in.read(bArr, i, i2);
            if (read < 0) {
                this.readComplete = true;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ((FilterInputStream) this).in.close();
            if (!this.readComplete && this.conn != null) {
                this.conn.disconnect();
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = ((FilterInputStream) this).in.read();
            if (read < 0) {
                this.readComplete = true;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int read = read(bArr, 0, bArr.length);
            if (read < 0) {
                this.readComplete = true;
            }
            return read;
        }
    }

    private String cookieHeader(String str, List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str.trim());
            if (!str.trim().endsWith(ParamableElem.DIVIDE_PARAM)) {
                sb.append("; ");
            } else {
                sb.append(" ");
            }
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Cookie cookie = list.get(i);
            if (sb.indexOf(cookie.name() + '=') < 0) {
                if (i > 0) {
                    sb.append("; ");
                }
                sb.append(cookie.name());
                sb.append('=');
                sb.append(cookie.value());
            }
        }
        return sb.toString();
    }

    private String errHeader(Response response) {
        Headers headers = response.headers();
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            sb.append(headers.name(i));
            sb.append(":");
            sb.append(headers.value(i));
            sb.append(ParamableElem.DIVIDE_PARAM);
        }
        return sb.toString();
    }

    private byte[] readInputStream(InputStream inputStream) throws IOException {
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

    private long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public void setClient(OkHttpClient okHttpClient) {
        this.mOkHttpClient = okHttpClient;
    }

    private ResponseBody getErrorResponseBody(String str, long j, HttpURLConnection httpURLConnection) throws IOException {
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

    private void parseCronetProperties(Headers headers, NetworkStatRecord networkStatRecord) {
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

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        NetworkStatRecord networkStatRecord;
        String str;
        Protocol protocol;
        long contentLength;
        List<Cookie> loadForRequest;
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
            if (openHttpURLConnection != null) {
                openHttpURLConnection.setInstanceFollowRedirects(this.mOkHttpClient.followRedirects());
            }
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
                    networkStatRecord.bindMobileStatus = build2.header("bd-frame-bind4gstatus");
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

    public ResponseBody openResponseBody(Response response, Headers headers, HttpURLConnection httpURLConnection) throws IOException {
        final String str = headers.get(android.net.http.Headers.CONTENT_TYPE);
        final long stringToLong = stringToLong(headers.get(android.net.http.Headers.CONTENT_LEN));
        final boolean z = !TextUtils.isEmpty(headers.get("Origin-Content-Encoding"));
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
            final byte[] readInputStream = readInputStream(inputStream2);
            return new ResponseBody() { // from class: com.baidu.searchbox.http.interceptor.CronetInterceptor.1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    if (z) {
                        return -1L;
                    }
                    return stringToLong;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    String str2 = str;
                    if (str2 != null) {
                        return MediaType.parse(str2);
                    }
                    return null;
                }

                @Override // okhttp3.ResponseBody
                public BufferedSource source() {
                    return new Buffer().write(readInputStream);
                }
            };
        } else {
            BufferedSource buffer = Okio.buffer(Okio.source(new RobustInputStream(inputStream2, httpURLConnection)));
            if (z) {
                stringToLong = -1;
            }
            return new RealResponseBody(str, stringToLong, buffer);
        }
    }
}
