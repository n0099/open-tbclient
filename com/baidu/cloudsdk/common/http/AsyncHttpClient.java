package com.baidu.cloudsdk.common.http;

import android.content.Context;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;
/* loaded from: classes.dex */
public class AsyncHttpClient extends DefaultHttpClient {
    protected static final ThreadPoolExecutor sThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    protected long mLastCheckTime = 0;
    protected int mNetworkCheckInterval = VersionUtils.CUR_DEVELOPMENT;
    protected final WeakHashMap mRequestMap;

    /* loaded from: classes.dex */
    public class a extends HttpEntityWrapper {
        public a(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public InputStream getContent() {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }

        public long getContentLength() {
            return -1L;
        }
    }

    public AsyncHttpClient() {
        HttpParams params = getParams();
        ConnManagerParams.setTimeout(params, 15000L);
        ConnManagerParams.setMaxConnectionsPerRoute(params, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(params, 10);
        HttpConnectionParams.setSoTimeout(params, 15000);
        HttpConnectionParams.setConnectionTimeout(params, 15000);
        HttpConnectionParams.setTcpNoDelay(params, true);
        HttpConnectionParams.setSocketBufferSize(params, 8192);
        HttpProtocolParams.setUserAgent(params, "Baidu-Android-Lib-V1.0");
        HttpClientParams.setCookiePolicy(params, "compatibility");
        params.setParameter("http.connection-manager.factory-object", new defpackage.a(this));
        addRequestInterceptor(new x(this));
        addResponseInterceptor(new bh(this));
        this.mRequestMap = new WeakHashMap();
    }

    private void a(Context context) {
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
                    ConnRouteParams.setDefaultProxy(getParams(), (HttpHost) null);
                }
                this.mLastCheckTime = currentTimeMillis;
            }
        }
    }

    public static String getUrlWithQueryString(String str, RequestParams requestParams) {
        if (str == null || requestParams == null) {
            return str;
        }
        String queryString = requestParams.getQueryString();
        return str.indexOf("?") == -1 ? str + "?" + queryString : str + "&" + queryString;
    }

    public void cancelRequests(Context context, boolean z) {
        List<WeakReference> list = (List) this.mRequestMap.get(context);
        if (list != null) {
            for (WeakReference weakReference : list) {
                Future future = (Future) weakReference.get();
                if (future != null) {
                    future.cancel(z);
                }
            }
        }
        this.mRequestMap.remove(context);
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

    protected void finalize() {
        for (Map.Entry entry : this.mRequestMap.entrySet()) {
            cancelRequests((Context) entry.getKey(), true);
        }
        super/*java.lang.Object*/.finalize();
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

    protected void sendRequest(HttpUriRequest httpUriRequest, HttpResponseHandler httpResponseHandler, Context context) {
        a(context);
        Future<?> submit = sThreadPool.submit(new bi(this, new SyncBasicHttpContext(new BasicHttpContext()), httpUriRequest, httpResponseHandler));
        if (context != null) {
            List list = (List) this.mRequestMap.get(context);
            if (list == null) {
                list = new LinkedList();
                this.mRequestMap.put(context, list);
            }
            list.add(new WeakReference(submit));
        }
    }

    public void setMaxRetries(int i) {
        if (i <= 0) {
            i = 3;
        }
        setHttpRequestRetryHandler(new DefaultHttpRequestRetryHandler(i, false));
    }

    public void setNetworkCheckInterval(int i) {
        if (i <= 10000) {
            i = 10000;
        }
        this.mNetworkCheckInterval = i;
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
}
