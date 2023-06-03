package com.baidu.searchbox.net;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.AbstractHttpManager;
import com.baidu.searchbox.http.DownloadHttpManager;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.webkit.internal.ETAG;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
@SuppressLint({"BDThrowableCheck"})
/* loaded from: classes4.dex */
public class DownloadProxyHttpClient implements IProxyHttpClient {
    public NewHttpRequest.NewHttpRequestBuilder httpRequestBuilder;
    public final HttpParams params;
    public String url;

    @Override // com.baidu.searchbox.net.IProxyHttpClient
    public void close() {
    }

    @Override // com.baidu.searchbox.net.IProxyHttpClient
    public void preExecute() {
    }

    /* loaded from: classes4.dex */
    public static final class NewHttpRequest extends HttpRequest<NewHttpRequestBuilder> {
        public org.apache.http.HttpRequest originalRequest;

        /* loaded from: classes4.dex */
        public final class HttpEntityBody extends RequestBody {
            public final HttpEntity entity;
            public final MediaType mediaType;

            public HttpEntityBody(HttpEntity httpEntity, String str) {
                this.entity = httpEntity;
                if (str != null) {
                    this.mediaType = MediaType.parse(str);
                } else if (httpEntity.getContentType() != null) {
                    this.mediaType = MediaType.parse(httpEntity.getContentType().getValue());
                } else {
                    this.mediaType = MediaType.parse("application/octet-stream");
                }
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return this.entity.getContentLength();
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return this.mediaType;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                this.entity.writeTo(bufferedSink.outputStream());
            }
        }

        /* loaded from: classes4.dex */
        public static final class NewHttpRequestBuilder extends HttpRequestBuilder<NewHttpRequestBuilder> {
            public org.apache.http.HttpRequest originalRequest;

            public NewHttpRequestBuilder(AbstractHttpManager abstractHttpManager) {
                super(abstractHttpManager);
            }

            public NewHttpRequestBuilder originalRequest(org.apache.http.HttpRequest httpRequest) {
                this.originalRequest = httpRequest;
                return this;
            }

            public NewHttpRequestBuilder(NewHttpRequest newHttpRequest) {
                this(newHttpRequest, null);
            }

            public NewHttpRequestBuilder(NewHttpRequest newHttpRequest, AbstractHttpManager abstractHttpManager) {
                super(newHttpRequest, abstractHttpManager);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.searchbox.http.request.HttpRequestBuilder
            public NewHttpRequest build() {
                return new NewHttpRequest(this);
            }
        }

        public NewHttpRequest(NewHttpRequestBuilder newHttpRequestBuilder) {
            super(newHttpRequestBuilder);
        }

        @Override // com.baidu.searchbox.http.request.HttpRequest
        public Request buildOkRequest(RequestBody requestBody) {
            return this.okRequestBuilder.method(this.originalRequest.getRequestLine().getMethod(), requestBody).build();
        }

        @Override // com.baidu.searchbox.http.request.HttpRequest
        public RequestBody buildOkRequestBody() {
            org.apache.http.HttpRequest httpRequest = this.originalRequest;
            if (!(httpRequest instanceof HttpEntityEnclosingRequest)) {
                return null;
            }
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity != null) {
                HttpEntityBody httpEntityBody = new HttpEntityBody(entity, null);
                Header contentEncoding = entity.getContentEncoding();
                if (contentEncoding != null) {
                    this.okRequestBuilder.addHeader(contentEncoding.getName(), contentEncoding.getValue());
                }
                return httpEntityBody;
            }
            return RequestBody.create((MediaType) null, new byte[0]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequest
        public void initExtraHttpRequest(NewHttpRequestBuilder newHttpRequestBuilder) {
            this.originalRequest = newHttpRequestBuilder.originalRequest;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequest
        public NewHttpRequestBuilder newBuilder(AbstractHttpManager abstractHttpManager) {
            return new NewHttpRequestBuilder(this, abstractHttpManager);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.request.HttpRequest
        public NewHttpRequestBuilder newBuilder() {
            return new NewHttpRequestBuilder(this);
        }
    }

    public DownloadProxyHttpClient() {
        this.params = new AbstractHttpParams() { // from class: com.baidu.searchbox.net.DownloadProxyHttpClient.1
            public Proxy proxy;
            public String userAgent;

            @Override // org.apache.http.params.HttpParams
            public boolean removeParameter(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // org.apache.http.params.HttpParams
            public HttpParams copy() {
                throw new UnsupportedOperationException();
            }

            @Override // org.apache.http.params.HttpParams
            public Object getParameter(String str) {
                if (str.equals(ConnRoutePNames.DEFAULT_PROXY)) {
                    Proxy proxy = this.proxy;
                    if (proxy == null) {
                        proxy = DownloadProxyHttpClient.this.httpManager().getOkHttpClient().proxy();
                    }
                    if (proxy == null) {
                        return null;
                    }
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    return new HttpHost(inetSocketAddress.getHostName(), inetSocketAddress.getPort());
                } else if (str.equals(CoreConnectionPNames.CONNECTION_TIMEOUT)) {
                    return Integer.valueOf(DownloadProxyHttpClient.this.httpManager().getOkHttpClient().connectTimeoutMillis());
                } else {
                    if (str.equals(CoreConnectionPNames.SO_TIMEOUT)) {
                        return Integer.valueOf(DownloadProxyHttpClient.this.httpManager().getOkHttpClient().readTimeoutMillis());
                    }
                    if (str.equals(ClientPNames.HANDLE_REDIRECTS)) {
                        return Boolean.valueOf(DownloadProxyHttpClient.this.httpManager().getOkHttpClient().followRedirects());
                    }
                    if (str.equals(CoreProtocolPNames.USER_AGENT)) {
                        return this.userAgent;
                    }
                    if (str.equals(ClientPNames.CONNECTION_MANAGER_FACTORY) || str.equals(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME)) {
                        return null;
                    }
                    throw new IllegalArgumentException(str);
                }
            }

            @Override // org.apache.http.params.HttpParams
            public HttpParams setParameter(String str, Object obj) {
                if (str.equals(ConnRoutePNames.DEFAULT_PROXY)) {
                    HttpHost httpHost = (HttpHost) obj;
                    if (httpHost != null) {
                        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(httpHost.getHostName(), httpHost.getPort()));
                        DownloadProxyHttpClient.this.httpRequestBuilder.proxy(proxy);
                        this.proxy = proxy;
                    }
                    return this;
                } else if (str.equals(CoreConnectionPNames.CONNECTION_TIMEOUT)) {
                    DownloadProxyHttpClient.this.httpRequestBuilder.connectionTimeout(((Integer) obj).intValue());
                    return this;
                } else if (str.equals(CoreConnectionPNames.SO_TIMEOUT)) {
                    int intValue = ((Integer) obj).intValue();
                    DownloadProxyHttpClient.this.httpRequestBuilder.readTimeout(intValue).writeTimeout(intValue);
                    return this;
                } else if (str.equals(ClientPNames.HANDLE_REDIRECTS)) {
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    DownloadProxyHttpClient.this.httpRequestBuilder.followRedirects(booleanValue).followSslRedirects(booleanValue);
                    return this;
                } else if (str.equals(CoreProtocolPNames.USER_AGENT)) {
                    String str2 = (String) obj;
                    DownloadProxyHttpClient.this.httpRequestBuilder.userAgent(str2);
                    this.userAgent = str2;
                    return this;
                } else {
                    throw new IllegalArgumentException(str);
                }
            }
        };
        this.httpRequestBuilder = new NewHttpRequest.NewHttpRequestBuilder(httpManager());
    }

    private void checkNetworkConnected() throws IOException {
        if (NetWorkUtils.isNetworkConnected(AppRuntime.getAppContext())) {
            return;
        }
        throw new IOException(" no network connected");
    }

    private void executePreCheck() throws IOException {
        checkNetworkConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpManager httpManager() {
        return DownloadHttpManager.getDefault(AppRuntime.getAppContext());
    }

    @Override // org.apache.http.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.http.client.HttpClient
    public HttpParams getParams() {
        return this.params;
    }

    public DownloadProxyHttpClient(String str) {
        this();
        if (!TextUtils.isEmpty(str)) {
            HttpProtocolParams.setUserAgent(getParams(), str);
        }
    }

    public static void consumeContentQuietly(HttpResponse httpResponse) {
        try {
            httpResponse.getEntity().consumeContent();
        } catch (Throwable unused) {
        }
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return execute((HttpHost) null, httpUriRequest, (HttpContext) null);
    }

    @Override // com.baidu.searchbox.net.IProxyHttpClient
    public HttpResponse executeSafely(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        return execute(httpUriRequest);
    }

    public void setUrl(String str) {
        this.url = str;
    }

    private HttpResponse transformResponse(Response response) throws IOException {
        int code = response.code();
        String message = response.message();
        ProtocolVersion protocolVersion = HttpVersion.HTTP_1_1;
        if (response.protocol().equals(Protocol.HTTP_2)) {
            protocolVersion = new ProtocolVersion(Config.EVENT_NATIVE_VIEW_HIERARCHY, 2, 0);
        } else if (response.protocol().equals(Protocol.SPDY_3)) {
            protocolVersion = new ProtocolVersion(ETAG.KEY_SPDY, 3, 1);
        }
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse(protocolVersion, code, message);
        ResponseBody body = response.body();
        InputStreamEntity inputStreamEntity = new InputStreamEntity(body.byteStream(), body.contentLength());
        basicHttpResponse.setEntity(inputStreamEntity);
        Headers headers = response.headers();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            basicHttpResponse.addHeader(name, value);
            if ("Content-Type".equalsIgnoreCase(name)) {
                inputStreamEntity.setContentType(value);
            } else if ("Content-Encoding".equalsIgnoreCase(name)) {
                inputStreamEntity.setContentEncoding(value);
            }
        }
        return basicHttpResponse;
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, org.apache.http.HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) execute(httpHost, httpRequest, responseHandler, null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpHost httpHost, org.apache.http.HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        HttpResponse execute = execute(httpHost, httpRequest, httpContext);
        try {
            return responseHandler.handleResponse(execute);
        } finally {
            consumeContentQuietly(execute);
        }
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return (T) execute(null, httpUriRequest, responseHandler, null);
    }

    @Override // org.apache.http.client.HttpClient
    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return (T) execute(null, httpUriRequest, responseHandler, httpContext);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, org.apache.http.HttpRequest httpRequest) throws IOException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpHost httpHost, org.apache.http.HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        Header[] allHeaders;
        preExecute();
        this.httpRequestBuilder.originalRequest(httpRequest);
        if (!TextUtils.isEmpty(this.url)) {
            this.httpRequestBuilder.url(this.url);
        } else {
            this.httpRequestBuilder.url(httpRequest.getRequestLine().getUri());
        }
        for (Header header : httpRequest.getAllHeaders()) {
            this.httpRequestBuilder.setHeader(header.getName(), header.getValue());
        }
        this.httpRequestBuilder.userAgent((String) httpRequest.getParams().getParameter(CoreProtocolPNames.USER_AGENT));
        this.httpRequestBuilder.cookieManager(httpManager().getCookieManager(true, false));
        try {
            NewHttpRequest build = this.httpRequestBuilder.enableStat(true).requestFrom(10).requestSubFrom(1022).build();
            executePreCheck();
            return transformResponse(build.executeSync());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override // org.apache.http.client.HttpClient
    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        return execute((HttpHost) null, httpUriRequest, httpContext);
    }
}
