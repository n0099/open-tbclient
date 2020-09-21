package com.baidu.down.loopj.android.http;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.down.loopj.android.http.ConnectManager;
import com.baidu.down.loopj.android.request.handler.UrlConnectionRequestHandler;
import com.baidu.down.loopj.android.urlconnection.ProxyURLConnection;
import com.baidu.down.utils.NamingThreadFactory;
import com.baidu.webkit.internal.ETAG;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.protocol.HTTP;
/* loaded from: classes14.dex */
public class AsyncHttpClient {
    private static final boolean DEBUG = false;
    private static final int DEFAULT_MAX_CONNECTIONS = 20;
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final int DEFAULT_SOCKET_CONNECT_TIMEOUT = 10000;
    private static final int DEFAULT_SOCKET_TIMEOUT = 30000;
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    private static final String TAG = "AsyncHttpClient";
    private final Map<String, String> clientHeaderMap;
    private Context mCtx;
    private ProxyURLConnection mProxyURLConnection;
    private long[] mRetryIntervals;
    private final Map<Context, CopyOnWriteArrayList<WeakReference<Future<AsyncHttpRequest>>>> requestFutureMap;
    private final Map<Context, CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>>> requestMap;
    private ThreadPoolExecutor threadPool;
    private static int maxConnections = 20;
    private static int socketTimeout = 30000;
    private static String USER_AGENT_HTTPCLIENT = "APPSEARCH-DOWN-SDK-HC-V3.x";
    private static String USER_AGENT_HTTPURLCONNECTION = "APPSEARCH-DOWN-SDK-URL-V3.x";
    private static String HEADER_CONNECTION = HTTP.CONN_DIRECTIVE;
    private static String HEADER_CLOSE = "close";

    public boolean isWap() {
        return this.mProxyURLConnection.isWap();
    }

    public ConnectManager.NetWorkType getNetWorkType() {
        return this.mProxyURLConnection.getNetWorkType();
    }

    public void switchProxy() {
        this.mProxyURLConnection.initProxyHttpClient();
    }

    public AsyncHttpClient(Context context, long[] jArr) {
        this.mCtx = context.getApplicationContext();
        this.mRetryIntervals = jArr;
        this.mProxyURLConnection = new ProxyURLConnection(this.mCtx, jArr);
        this.mProxyURLConnection.setFollowRedirects(false);
        this.threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool(new NamingThreadFactory(TAG));
        this.requestFutureMap = new WeakHashMap();
        this.requestMap = new WeakHashMap();
        this.clientHeaderMap = new HashMap();
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPool = threadPoolExecutor;
    }

    public void setTimeout(int i) {
        this.mProxyURLConnection.setSocketTimeout(i);
    }

    public void setConnectTimeout(int i) {
        this.mProxyURLConnection.setConnectTimeout(i);
    }

    public void addHeader(String str, String str2) {
        this.clientHeaderMap.put(str, str2);
    }

    public void cancelRequests(Context context, boolean z, BinaryHttpResponseHandler binaryHttpResponseHandler) {
        if (binaryHttpResponseHandler != null) {
            binaryHttpResponseHandler.stopRunning();
        }
        CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> remove = this.requestMap.remove(context);
        if (remove != null) {
            for (WeakReference<AsyncHttpRequest> weakReference : remove) {
                AsyncHttpRequest asyncHttpRequest = weakReference.get();
                if (asyncHttpRequest != null) {
                    asyncHttpRequest.isInterrupt = true;
                    asyncHttpRequest.cancelRequest();
                }
            }
        }
        CopyOnWriteArrayList<WeakReference<Future<AsyncHttpRequest>>> remove2 = this.requestFutureMap.remove(context);
        if (remove2 != null) {
            for (WeakReference<Future<AsyncHttpRequest>> weakReference2 : remove2) {
                Future<AsyncHttpRequest> future = weakReference2.get();
                if (future != null) {
                    future.cancel(z);
                }
            }
        }
    }

    public void interruptRetryWaiting(Context context) {
        CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> copyOnWriteArrayList = this.requestMap.get(context);
        if (copyOnWriteArrayList != null) {
            for (WeakReference<AsyncHttpRequest> weakReference : copyOnWriteArrayList) {
                AsyncHttpRequest asyncHttpRequest = weakReference.get();
                if (asyncHttpRequest != null) {
                    asyncHttpRequest.interruptRetryWaiting();
                }
            }
        }
    }

    public void cancelTaskRequests(Context context, AsyncHttpRequest asyncHttpRequest) {
        CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> copyOnWriteArrayList = this.requestMap.get(context);
        if (copyOnWriteArrayList != null) {
            if (asyncHttpRequest != null) {
                asyncHttpRequest.isInterrupt = true;
                asyncHttpRequest.cancelRequest();
            }
            copyOnWriteArrayList.remove(asyncHttpRequest);
        }
    }

    public List<WeakReference<AsyncHttpRequest>> getTaskHttpRequestList(Context context) {
        if (this.requestMap != null) {
            return this.requestMap.get(context);
        }
        return null;
    }

    public void get(Context context, String str, Map<String, String> map, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler, MultiSrcRequestParams multiSrcRequestParams) {
        performGetURLConnection(context, str, map, requestParams, asyncHttpResponseHandler, multiSrcRequestParams);
    }

    public static String getUrlWithQueryString(String str, RequestParams requestParams) {
        if (requestParams != null) {
            String paramString = requestParams.getParamString();
            if (str.indexOf("?") == -1) {
                return str + "?" + paramString;
            }
            return str + ETAG.ITEM_SEPARATOR + paramString;
        }
        return str;
    }

    public void performGetURLConnection(Context context, String str, Map<String, String> map, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler, MultiSrcRequestParams multiSrcRequestParams) {
        Map<String, String> hashMap;
        String urlWithQueryString = getUrlWithQueryString(str, requestParams);
        if (map == null) {
            try {
                hashMap = new HashMap<>();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        } else {
            hashMap = map;
        }
        if (TextUtils.isEmpty(hashMap.get("User-Agent"))) {
            hashMap.put("User-Agent", USER_AGENT_HTTPURLCONNECTION);
        }
        if (asyncHttpResponseHandler instanceof MultiSrcBinaryTaskHandler) {
            sendMultiSrcURLConnectionRequest(urlWithQueryString, asyncHttpResponseHandler, context, str, multiSrcRequestParams, hashMap);
        } else {
            sendURLConnectionRequest(urlWithQueryString, asyncHttpResponseHandler, context, hashMap);
        }
    }

    protected void sendURLConnectionRequest(String str, AsyncHttpResponseHandler asyncHttpResponseHandler, Context context, Map<String, String> map) {
        AsyncHttpRequest asyncHttpRequest = new AsyncHttpRequest(new UrlConnectionRequestHandler(this.mProxyURLConnection, str, map), asyncHttpResponseHandler);
        Future<?> submit = this.threadPool.submit(asyncHttpRequest);
        if (context != null) {
            CopyOnWriteArrayList<WeakReference<Future<AsyncHttpRequest>>> copyOnWriteArrayList = this.requestFutureMap.get(context);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.requestFutureMap.put(context, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(new WeakReference<>(submit));
            CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> copyOnWriteArrayList2 = this.requestMap.get(context);
            if (copyOnWriteArrayList2 == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                this.requestMap.put(context, copyOnWriteArrayList2);
            }
            copyOnWriteArrayList2.add(new WeakReference<>(asyncHttpRequest));
        }
    }

    protected void sendMultiSrcURLConnectionRequest(String str, AsyncHttpResponseHandler asyncHttpResponseHandler, Context context, String str2, MultiSrcRequestParams multiSrcRequestParams, Map<String, String> map) {
        MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest = new MultiSrcAsyncHttpRequest(new UrlConnectionRequestHandler(this.mProxyURLConnection, str, map), asyncHttpResponseHandler, str2, multiSrcRequestParams);
        Future<?> submit = this.threadPool.submit(multiSrcAsyncHttpRequest);
        if (context != null) {
            CopyOnWriteArrayList<WeakReference<Future<AsyncHttpRequest>>> copyOnWriteArrayList = this.requestFutureMap.get(context);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.requestFutureMap.put(context, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(new WeakReference<>(submit));
            CopyOnWriteArrayList<WeakReference<AsyncHttpRequest>> copyOnWriteArrayList2 = this.requestMap.get(context);
            if (copyOnWriteArrayList2 == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                this.requestMap.put(context, copyOnWriteArrayList2);
            }
            copyOnWriteArrayList2.add(new WeakReference<>(multiSrcAsyncHttpRequest));
        }
    }
}
