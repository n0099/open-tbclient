package com.baidu.cloudsdk.common.http;

import android.content.Context;
import com.baidu.android.common.net.ConnectManager;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
/* loaded from: classes2.dex */
public class AsyncHttpClient extends DefaultHttpClient {
    private static final int DEFAULT_CHECK_INTERVAL = 10000;
    private static final int DEFAULT_CONNECT_TIMEOUT = 15000;
    private static final int DEFAULT_MAX_CONNECTIONS = 10;
    private static final int DEFAULT_MAX_RETRIES = 3;
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final String DEFAULT_USER_AGENT = "Baidu-Android-Lib-V1.0";
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    protected static final ThreadPoolExecutor sThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    protected long mLastCheckTime = 0;
    protected int mNetworkCheckInterval = 10000;
    protected final WeakHashMap<Context, List<WeakReference<Future<?>>>> mRequestMap;

    public AsyncHttpClient() {
        HttpParams params = getParams();
        ConnManagerParams.setTimeout(params, 15000L);
        ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(params, 10);
        HttpConnectionParams.setSoTimeout(params, 15000);
        HttpConnectionParams.setConnectionTimeout(params, 15000);
        HttpConnectionParams.setTcpNoDelay(params, true);
        HttpConnectionParams.setSocketBufferSize(params, 8192);
        HttpProtocolParams.setUserAgent(params, DEFAULT_USER_AGENT);
        HttpClientParams.setCookiePolicy(params, CookiePolicy.BROWSER_COMPATIBILITY);
        params.setParameter(ClientPNames.CONNECTION_MANAGER_FACTORY, new ClientConnectionManagerFactory() { // from class: com.baidu.cloudsdk.common.http.AsyncHttpClient.1
            @Override // org.apache.http.conn.ClientConnectionManagerFactory
            public ClientConnectionManager newInstance(HttpParams httpParams, SchemeRegistry schemeRegistry) {
                SSLSocketFactory socketFactory = SSLSocketFactory.getSocketFactory();
                schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, PlainSocketFactory.getSocketFactory(), 80));
                schemeRegistry.register(new Scheme("https", socketFactory, 443));
                return new ThreadSafeClientConnManager(httpParams, schemeRegistry);
            }
        });
        addRequestInterceptor(new HttpRequestInterceptor() { // from class: com.baidu.cloudsdk.common.http.AsyncHttpClient.2
            @Override // org.apache.http.HttpRequestInterceptor
            public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
                if (!httpRequest.containsHeader(AsyncHttpClient.HEADER_ACCEPT_ENCODING)) {
                    httpRequest.addHeader(AsyncHttpClient.HEADER_ACCEPT_ENCODING, AsyncHttpClient.ENCODING_GZIP);
                }
            }
        });
        addResponseInterceptor(new HttpResponseInterceptor() { // from class: com.baidu.cloudsdk.common.http.AsyncHttpClient.3
            @Override // org.apache.http.HttpResponseInterceptor
            public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
                Header contentEncoding;
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null && (contentEncoding = entity.getContentEncoding()) != null) {
                    HeaderElement[] elements = contentEncoding.getElements();
                    for (HeaderElement headerElement : elements) {
                        if (headerElement.getName().equalsIgnoreCase(AsyncHttpClient.ENCODING_GZIP)) {
                            httpResponse.setEntity(new InflatingEntity(httpResponse.getEntity()));
                            return;
                        }
                    }
                }
            }
        });
        this.mRequestMap = new WeakHashMap<>();
    }

    protected void finalize() throws Throwable {
        for (Map.Entry<Context, List<WeakReference<Future<?>>>> entry : this.mRequestMap.entrySet()) {
            cancelRequests(entry.getKey(), true);
        }
        super.finalize();
    }

    public void setTimeout(int i) {
        if (i <= 0) {
            i = 15000;
        }
        HttpParams params = getParams();
        ConnManagerParams.setTimeout(params, i);
        HttpConnectionParams.setSoTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
    }

    public void setUserAgent(String str) {
        HttpProtocolParams.setUserAgent(getParams(), str);
    }

    public void setNetworkCheckInterval(int i) {
        if (i <= 10000) {
            i = 10000;
        }
        this.mNetworkCheckInterval = i;
    }

    public void setMaxRetries(int i) {
        if (i <= 0) {
            i = 3;
        }
        setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(i, false));
    }

    public void get(Context context, String str, HttpResponseHandler httpResponseHandler) {
        get(context, str, null, null, httpResponseHandler);
    }

    public void get(Context context, String str, RequestParams requestParams, HttpResponseHandler httpResponseHandler) {
        get(context, str, requestParams, null, httpResponseHandler);
    }

    public void get(Context context, String str, RequestParams requestParams, Header[] headerArr, HttpResponseHandler httpResponseHandler) {
        HttpGet httpGet = new HttpGet(getUrlWithQueryString(str, requestParams));
        if (headerArr != null) {
            httpGet.setHeaders(headerArr);
        }
        sendRequest(httpGet, httpResponseHandler, context);
    }

    public void post(Context context, String str, HttpResponseHandler httpResponseHandler) {
        post(context, str, null, null, httpResponseHandler);
    }

    public void post(Context context, String str, RequestParams requestParams, HttpResponseHandler httpResponseHandler) {
        post(context, str, requestParams, null, httpResponseHandler);
    }

    public void post(Context context, String str, RequestParams requestParams, Header[] headerArr, HttpResponseHandler httpResponseHandler) {
        HttpPost httpPost = new HttpPost(str);
        if (requestParams != null) {
            httpPost.setEntity(requestParams.getHttpEntity());
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        sendRequest(httpPost, httpResponseHandler, context);
    }

    public void delete(Context context, String str, HttpResponseHandler httpResponseHandler) {
        delete(context, str, null, null, httpResponseHandler);
    }

    public void delete(Context context, String str, RequestParams requestParams, HttpResponseHandler httpResponseHandler) {
        delete(context, str, requestParams, null, httpResponseHandler);
    }

    public void delete(Context context, String str, RequestParams requestParams, Header[] headerArr, HttpResponseHandler httpResponseHandler) {
        HttpDelete httpDelete = new HttpDelete(getUrlWithQueryString(str, requestParams));
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        sendRequest(httpDelete, httpResponseHandler, context);
    }

    public void put(Context context, String str, HttpResponseHandler httpResponseHandler) {
        put(context, str, null, null, httpResponseHandler);
    }

    public void put(Context context, String str, RequestParams requestParams, HttpResponseHandler httpResponseHandler) {
        put(context, str, requestParams, null, httpResponseHandler);
    }

    public void put(Context context, String str, RequestParams requestParams, Header[] headerArr, HttpResponseHandler httpResponseHandler) {
        HttpPut httpPut = new HttpPut(str);
        if (requestParams != null) {
            httpPut.setEntity(requestParams.getHttpEntity());
        }
        if (headerArr != null) {
            httpPut.setHeaders(headerArr);
        }
        sendRequest(httpPut, httpResponseHandler, context);
    }

    public void cancelRequests(Context context, boolean z) {
        List<WeakReference<Future<?>>> list = this.mRequestMap.get(context);
        if (list != null) {
            for (WeakReference<Future<?>> weakReference : list) {
                Future<?> future = weakReference.get();
                if (future != null) {
                    future.cancel(z);
                }
            }
        }
        this.mRequestMap.remove(context);
    }

    public static String getUrlWithQueryString(String str, RequestParams requestParams) {
        if (str != null && requestParams != null) {
            String queryString = requestParams.getQueryString();
            if (!str.contains("?")) {
                return str + "?" + queryString;
            }
            return str + "&" + queryString;
        }
        return str;
    }

    public static void silentCloseInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    protected void sendRequest(HttpUriRequest httpUriRequest, HttpResponseHandler httpResponseHandler, Context context) {
        try {
            checkNetworkStateAndAdjust(context);
            Future<?> submit = sThreadPool.submit(new AsyncHttpRequest(this, new SyncBasicHttpContext(new BasicHttpContext()), httpUriRequest, httpResponseHandler));
            if (context != null) {
                List<WeakReference<Future<?>>> list = this.mRequestMap.get(context);
                if (list == null) {
                    list = new LinkedList<>();
                    this.mRequestMap.put(context, list);
                }
                list.add(new WeakReference<>(submit));
            }
        } catch (NullPointerException e) {
        } catch (RejectedExecutionException e2) {
        }
    }

    private void checkNetworkStateAndAdjust(Context context) {
        if (context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastCheckTime > this.mNetworkCheckInterval) {
                ConnectManager connectManager = new ConnectManager(context);
                if (connectManager.isWapNetwork()) {
                    String proxy = connectManager.getProxy();
                    int parseInt = Integer.parseInt(connectManager.getProxyPort());
                    if (proxy != null && proxy.length() > 0) {
                        ConnRouteParams.setDefaultProxy(getParams(), new HttpHost(proxy, parseInt));
                    }
                } else {
                    ConnRouteParams.setDefaultProxy(getParams(), null);
                }
                this.mLastCheckTime = currentTimeMillis;
            }
        }
    }

    public static void endEntityViaReflection(HttpEntity httpEntity) {
        Field field;
        if (httpEntity instanceof HttpEntityWrapper) {
            try {
                Field[] declaredFields = HttpEntityWrapper.class.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        field = null;
                        break;
                    }
                    field = declaredFields[i];
                    if (field.getName().equals("wrappedEntity")) {
                        break;
                    }
                    i++;
                }
                if (field != null) {
                    field.setAccessible(true);
                    HttpEntity httpEntity2 = (HttpEntity) field.get(httpEntity);
                    if (httpEntity2 != null) {
                        httpEntity2.consumeContent();
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class InflatingEntity extends HttpEntityWrapper {
        GZIPInputStream gzipStream;
        InputStream wrappedStream;

        public InflatingEntity(HttpEntity httpEntity) {
            super(httpEntity);
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public InputStream getContent() throws IOException {
            this.wrappedStream = this.wrappedEntity.getContent();
            this.gzipStream = new GZIPInputStream(this.wrappedStream);
            return this.gzipStream;
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public long getContentLength() {
            return -1L;
        }

        @Override // org.apache.http.entity.HttpEntityWrapper, org.apache.http.HttpEntity
        public void consumeContent() throws IOException {
            AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
            AsyncHttpClient.silentCloseInputStream(this.gzipStream);
            super.consumeContent();
        }
    }
}
