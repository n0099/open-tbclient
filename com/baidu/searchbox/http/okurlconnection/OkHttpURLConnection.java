package com.baidu.searchbox.http.okurlconnection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes2.dex */
public final class OkHttpURLConnection extends HttpURLConnection implements Callback {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> METHODS;
    public static final String RESPONSE_SOURCE;
    public static final String SELECTED_PROTOCOL;
    public transient /* synthetic */ FieldHolder $fh;
    public Call call;
    public Throwable callFailure;
    public OkHttpClient client;
    public boolean connectPending;
    public boolean executed;
    public long fixedLongContentLength;
    public Handshake handshake;
    public final Object lock;
    public final NetworkInterceptor networkInterceptor;
    public Response networkResponse;
    public Proxy proxy;
    public Headers.Builder requestHeaders;
    public Response response;
    public Headers responseHeaders;
    public URLFilter urlFilter;

    /* loaded from: classes2.dex */
    public final class NetworkInterceptor implements Interceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean proceed;
        public final /* synthetic */ OkHttpURLConnection this$0;

        public NetworkInterceptor(OkHttpURLConnection okHttpURLConnection) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {okHttpURLConnection};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = okHttpURLConnection;
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
                Request request = chain.request();
                URLFilter uRLFilter = this.this$0.urlFilter;
                if (uRLFilter != null) {
                    uRLFilter.checkURLPermitted(request.url().url());
                }
                synchronized (this.this$0.lock) {
                    this.this$0.connectPending = false;
                    this.this$0.proxy = chain.connection().route().proxy();
                    this.this$0.handshake = chain.connection().handshake();
                    this.this$0.lock.notifyAll();
                    while (!this.proceed) {
                        try {
                            this.this$0.lock.wait();
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    }
                }
                if (request.body() instanceof OutputStreamRequestBody) {
                    request = ((OutputStreamRequestBody) request.body()).prepareToSendRequest(request);
                }
                Response proceed = chain.proceed(request);
                synchronized (this.this$0.lock) {
                    this.this$0.networkResponse = proceed;
                    ((HttpURLConnection) this.this$0).url = proceed.request().url().url();
                }
                return proceed;
            }
            return (Response) invokeL.objValue;
        }

        public void proceed() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            synchronized (this.this$0.lock) {
                this.proceed = true;
                this.this$0.lock.notifyAll();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class UnexpectedException extends IOException {
        public static /* synthetic */ Interceptable $ic;
        public static final Interceptor INTERCEPTOR;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1379421571, "Lcom/baidu/searchbox/http/okurlconnection/OkHttpURLConnection$UnexpectedException;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1379421571, "Lcom/baidu/searchbox/http/okurlconnection/OkHttpURLConnection$UnexpectedException;");
                    return;
                }
            }
            INTERCEPTOR = new Interceptor() { // from class: com.baidu.searchbox.http.okurlconnection.OkHttpURLConnection.UnexpectedException.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, chain)) == null) {
                        try {
                            return chain.proceed(chain.request());
                        } catch (Error | RuntimeException e) {
                            throw new UnexpectedException(e);
                        }
                    }
                    return (Response) invokeL.objValue;
                }
            };
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnexpectedException(Throwable th) {
            super(th);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Throwable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1441171587, "Lcom/baidu/searchbox/http/okurlconnection/OkHttpURLConnection;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1441171587, "Lcom/baidu/searchbox/http/okurlconnection/OkHttpURLConnection;");
                return;
            }
        }
        SELECTED_PROTOCOL = Platform.get().getPrefix() + "-Selected-Protocol";
        RESPONSE_SOURCE = Platform.get().getPrefix() + "-Response-Source";
        METHODS = new LinkedHashSet(Arrays.asList(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "PATCH"));
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public Permission getPermission() throws IOException {
        InterceptResult invokeV;
        int defaultPort;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            URL url = getURL();
            String host = url.getHost();
            if (url.getPort() != -1) {
                defaultPort = url.getPort();
            } else {
                defaultPort = HttpUrl.defaultPort(url.getProtocol());
            }
            if (usingProxy()) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) this.client.proxy().address();
                host = inetSocketAddress.getHostName();
                defaultPort = inetSocketAddress.getPort();
            }
            return new SocketPermission(host + ":" + defaultPort, "connect, resolve");
        }
        return (Permission) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient) {
        super(url);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, okHttpClient};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((URL) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.networkInterceptor = new NetworkInterceptor(this);
        this.requestHeaders = new Headers.Builder();
        this.fixedLongContentLength = -1L;
        this.lock = new Object();
        this.connectPending = true;
        this.client = okHttpClient;
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (!((HttpURLConnection) this).connected) {
                if (str != null) {
                    if (str2 == null) {
                        Platform platform = Platform.get();
                        platform.log(5, "Ignoring header " + str + " because its value was null.", null);
                        return;
                    }
                    this.requestHeaders.add(str, str2);
                    return;
                }
                throw new NullPointerException("field == null");
            }
            throw new IllegalStateException("Cannot add request property after connection is made");
        }
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, str, str2) == null) {
            if (!((HttpURLConnection) this).connected) {
                if (str != null) {
                    if (str2 == null) {
                        Platform platform = Platform.get();
                        platform.log(5, "Ignoring header " + str + " because its value was null.", null);
                        return;
                    }
                    this.requestHeaders.set(str, str2);
                    return;
                }
                throw new NullPointerException("field == null");
            }
            throw new IllegalStateException("Cannot set request property after connection is made");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient, URLFilter uRLFilter) {
        this(url, okHttpClient);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {url, okHttpClient, uRLFilter};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URL) objArr2[0], (OkHttpClient) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.urlFilter = uRLFilter;
    }

    public static IOException propagate(Throwable th) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, th)) == null) {
            if (!(th instanceof IOException)) {
                if (!(th instanceof Error)) {
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    throw new AssertionError();
                }
                throw ((Error) th);
            }
            throw ((IOException) th);
        }
        return (IOException) invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderField(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            try {
                Headers headers = getHeaders();
                if (i >= 0 && i < headers.size()) {
                    return headers.value(i);
                }
            } catch (IOException unused) {
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public String getHeaderFieldKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            try {
                Headers headers = getHeaders();
                if (i >= 0 && i < headers.size()) {
                    return headers.name(i);
                }
            } catch (IOException unused) {
            }
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // java.net.URLConnection
    public String getRequestProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return this.requestHeaders.get(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.client = this.client.newBuilder().connectTimeout(i, TimeUnit.MILLISECONDS).build();
        }
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            setFixedLengthStreamingMode(i);
        }
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.client = this.client.newBuilder().followRedirects(z).build();
        }
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.client = this.client.newBuilder().readTimeout(i, TimeUnit.MILLISECONDS).build();
        }
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, call, iOException) == null) {
            synchronized (this.lock) {
                boolean z = iOException instanceof UnexpectedException;
                Throwable th = iOException;
                if (z) {
                    th = iOException.getCause();
                }
                this.callFailure = th;
                this.lock.notifyAll();
            }
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, call, response) == null) {
            synchronized (this.lock) {
                this.response = response;
                this.handshake = response.handshake();
                ((HttpURLConnection) this).url = response.request().url().url();
                this.lock.notifyAll();
            }
        }
    }

    private Call buildCall() throws IOException {
        InterceptResult invokeV;
        OutputStreamRequestBody outputStreamRequestBody;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Call call = this.call;
            if (call != null) {
                return call;
            }
            boolean z = true;
            ((HttpURLConnection) this).connected = true;
            if (((HttpURLConnection) this).doOutput) {
                if ("GET".equals(((HttpURLConnection) this).method)) {
                    ((HttpURLConnection) this).method = "POST";
                } else if (!HttpMethod.permitsRequestBody(((HttpURLConnection) this).method)) {
                    throw new ProtocolException(((HttpURLConnection) this).method + " does not support writing");
                }
            }
            if (this.requestHeaders.get("User-Agent") == null) {
                this.requestHeaders.add("User-Agent", defaultUserAgent());
            }
            if (HttpMethod.permitsRequestBody(((HttpURLConnection) this).method)) {
                if (this.requestHeaders.get("Content-Type") == null) {
                    this.requestHeaders.add("Content-Type", "application/x-www-form-urlencoded");
                }
                long j = -1;
                if (this.fixedLongContentLength == -1 && ((HttpURLConnection) this).chunkLength <= 0) {
                    z = false;
                }
                String str = this.requestHeaders.get("Content-Length");
                long j2 = this.fixedLongContentLength;
                if (j2 != -1) {
                    j = j2;
                } else if (str != null) {
                    j = Long.parseLong(str);
                }
                if (z) {
                    outputStreamRequestBody = new StreamedRequestBody(j);
                } else {
                    outputStreamRequestBody = new BufferedRequestBody(j);
                }
                outputStreamRequestBody.timeout().timeout(this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
            } else {
                outputStreamRequestBody = null;
            }
            try {
                Request build = new Request.Builder().url(HttpUrl.get(getURL().toString())).headers(this.requestHeaders.build()).method(((HttpURLConnection) this).method, outputStreamRequestBody).build();
                URLFilter uRLFilter = this.urlFilter;
                if (uRLFilter != null) {
                    uRLFilter.checkURLPermitted(build.url().url());
                }
                OkHttpClient.Builder newBuilder = this.client.newBuilder();
                newBuilder.interceptors().clear();
                newBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
                newBuilder.networkInterceptors().clear();
                newBuilder.networkInterceptors().add(this.networkInterceptor);
                newBuilder.dispatcher(new Dispatcher(this.client.dispatcher().executorService()));
                if (!getUseCaches()) {
                    newBuilder.cache(null);
                }
                Call newCall = newBuilder.build().newCall(build);
                this.call = newCall;
                return newCall;
            } catch (IllegalArgumentException e) {
                if (Internal.instance.isInvalidHttpUrlHost(e)) {
                    UnknownHostException unknownHostException = new UnknownHostException();
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
                MalformedURLException malformedURLException = new MalformedURLException();
                malformedURLException.initCause(e);
                throw malformedURLException;
            }
        }
        return (Call) invokeV.objValue;
    }

    private String defaultUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            String property = System.getProperty("http.agent");
            if (property != null) {
                return toHumanReadableAscii(property);
            }
            return Version.userAgent();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.call == null) {
            return;
        }
        this.networkInterceptor.proceed();
        this.call.cancel();
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.client.connectTimeoutMillis();
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public InputStream getErrorStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                Response response = getResponse(true);
                if (HttpHeaders.hasBody(response) && response.code() >= 400) {
                    return response.body().byteStream();
                }
            } catch (IOException unused) {
            }
            return null;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getHeaderFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return JavaNetHeaders.toMultimap(getHeaders(), StatusLine.get(getResponse(true)).toString());
            } catch (IOException unused) {
                return Collections.emptyMap();
            }
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.client.followRedirects();
        }
        return invokeV.booleanValue;
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.client.readTimeoutMillis();
        }
        return invokeV.intValue;
    }

    @Override // java.net.URLConnection
    public Map<String, List<String>> getRequestProperties() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (!((HttpURLConnection) this).connected) {
                return JavaNetHeaders.toMultimap(this.requestHeaders.build(), null);
            }
            throw new IllegalStateException("Cannot access request header fields after connection is set");
        }
        return (Map) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return getResponse(true).code();
        }
        return invokeV.intValue;
    }

    @Override // java.net.HttpURLConnection
    public String getResponseMessage() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return getResponse(true).message();
        }
        return (String) invokeV.objValue;
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.proxy != null) {
                return true;
            }
            Proxy proxy = this.client.proxy();
            if (proxy != null && proxy.type() != Proxy.Type.DIRECT) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private Headers getHeaders() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.responseHeaders == null) {
                Response response = getResponse(true);
                this.responseHeaders = response.headers().newBuilder().add(SELECTED_PROTOCOL, response.protocol().toString()).add(RESPONSE_SOURCE, responseSourceHeader(response)).build();
            }
            return this.responseHeaders;
        }
        return (Headers) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public InputStream getInputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (((HttpURLConnection) this).doInput) {
                Response response = getResponse(false);
                if (response.code() < 400) {
                    return response.body().byteStream();
                }
                throw new FileNotFoundException(((HttpURLConnection) this).url.toString());
            }
            throw new ProtocolException("This protocol does not support input");
        }
        return (InputStream) invokeV.objValue;
    }

    private Response getResponse(boolean z) throws IOException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65544, this, z)) == null) {
            synchronized (this.lock) {
                if (this.response != null) {
                    return this.response;
                }
                if (this.callFailure != null) {
                    if (z && this.networkResponse != null) {
                        return this.networkResponse;
                    }
                    throw propagate(this.callFailure);
                }
                Call buildCall = buildCall();
                this.networkInterceptor.proceed();
                OutputStreamRequestBody outputStreamRequestBody = (OutputStreamRequestBody) buildCall.request().body();
                if (outputStreamRequestBody != null) {
                    outputStreamRequestBody.outputStream().close();
                }
                if (this.executed) {
                    synchronized (this.lock) {
                        while (this.response == null && this.callFailure == null) {
                            try {
                                try {
                                    this.lock.wait();
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                    throw new InterruptedIOException();
                                }
                            } finally {
                            }
                        }
                    }
                } else {
                    this.executed = true;
                    try {
                        onResponse(buildCall, buildCall.execute());
                    } catch (IOException e) {
                        onFailure(buildCall, e);
                    }
                }
                synchronized (this.lock) {
                    if (this.callFailure == null) {
                        if (this.response != null) {
                            return this.response;
                        }
                        throw new AssertionError();
                    }
                    throw propagate(this.callFailure);
                }
            }
        }
        return (Response) invokeZ.objValue;
    }

    public static String responseSourceHeader(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, response)) == null) {
            if (response.networkResponse() == null) {
                if (response.cacheResponse() == null) {
                    return HlsPlaylistParser.METHOD_NONE;
                }
                return "CACHE " + response.code();
            } else if (response.cacheResponse() == null) {
                return "NETWORK " + response.code();
            } else {
                return "CONDITIONAL_CACHE " + response.networkResponse().code();
            }
        }
        return (String) invokeL.objValue;
    }

    public static String toHumanReadableAscii(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                int codePointAt = str.codePointAt(i2);
                if (codePointAt > 31 && codePointAt < 127) {
                    i2 += Character.charCount(codePointAt);
                } else {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, 0, i2);
                    buffer.writeUtf8CodePoint(63);
                    while (true) {
                        i2 += Character.charCount(codePointAt);
                        if (i2 < length) {
                            codePointAt = str.codePointAt(i2);
                            if (codePointAt > 31 && codePointAt < 127) {
                                i = codePointAt;
                            } else {
                                i = 63;
                            }
                            buffer.writeUtf8CodePoint(i);
                        } else {
                            return buffer.readUtf8();
                        }
                    }
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.URLConnection
    public void connect() throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.executed) {
            return;
        }
        Call buildCall = buildCall();
        this.executed = true;
        buildCall.enqueue(this);
        synchronized (this.lock) {
            while (this.connectPending && this.response == null && this.callFailure == null) {
                try {
                    this.lock.wait();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException();
                }
            }
            if (this.callFailure != null) {
                throw propagate(this.callFailure);
            }
        }
    }

    @Override // java.net.URLConnection
    public OutputStream getOutputStream() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            OutputStreamRequestBody outputStreamRequestBody = (OutputStreamRequestBody) buildCall().request().body();
            if (outputStreamRequestBody != null) {
                if (outputStreamRequestBody instanceof StreamedRequestBody) {
                    connect();
                    this.networkInterceptor.proceed();
                }
                if (!outputStreamRequestBody.isClosed()) {
                    return outputStreamRequestBody.outputStream();
                }
                throw new ProtocolException("cannot write request body after response has been read");
            }
            throw new ProtocolException("method does not support a request body: " + ((HttpURLConnection) this).method);
        }
        return (OutputStream) invokeV.objValue;
    }

    @Override // java.net.URLConnection
    public String getHeaderField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            try {
                if (str == null) {
                    return StatusLine.get(getResponse(true)).toString();
                }
                return getHeaders().get(str);
            } catch (IOException unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            if (!((HttpURLConnection) this).connected) {
                if (((HttpURLConnection) this).chunkLength <= 0) {
                    if (j >= 0) {
                        this.fixedLongContentLength = j;
                        ((HttpURLConnection) this).fixedContentLength = (int) Math.min(j, 2147483647L);
                        return;
                    }
                    throw new IllegalArgumentException("contentLength < 0");
                }
                throw new IllegalStateException("Already in chunked mode");
            }
            throw new IllegalStateException("Already connected");
        }
    }

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            super.setIfModifiedSince(j);
            if (((HttpURLConnection) this).ifModifiedSince != 0) {
                this.requestHeaders.set("If-Modified-Since", HttpDate.format(new Date(((HttpURLConnection) this).ifModifiedSince)));
            } else {
                this.requestHeaders.removeAll("If-Modified-Since");
            }
        }
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(String str) throws ProtocolException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (METHODS.contains(str)) {
                ((HttpURLConnection) this).method = str;
                return;
            }
            throw new ProtocolException("Expected one of " + METHODS + " but was " + str);
        }
    }
}
