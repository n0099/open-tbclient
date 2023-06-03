package com.baidu.searchbox.net;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.net.ConnectManager;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;
/* loaded from: classes4.dex */
public class ProxyHttpClient extends com.baidu.android.common.net.ProxyHttpClient {
    public static final String TAG = "ProxyHttpClient";
    public IProxyHttpClient mIProxyHttpClient;

    public ProxyHttpClient(Context context) {
        this(context, null, null);
    }

    public HttpResponse executeSafely(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        return this.mIProxyHttpClient.executeSafely(httpUriRequest);
    }

    public ProxyHttpClient(Context context, ConnectManager connectManager) {
        this(context, null, connectManager);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T) this.mIProxyHttpClient.execute(httpUriRequest, responseHandler);
    }

    public ProxyHttpClient(Context context, String str) {
        this(context, str, null);
    }

    public ProxyHttpClient(Context context, String str, ConnectManager connectManager) {
        super(context, str, connectManager);
        this.mIProxyHttpClient = null;
        DownloadProxyHttpClient downloadProxyHttpClient = new DownloadProxyHttpClient(str);
        this.mIProxyHttpClient = downloadProxyHttpClient;
        setParams(downloadProxyHttpClient.getParams());
        if (!TextUtils.isEmpty(str)) {
            HttpProtocolParams.setUserAgent(getParams(), str);
        }
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        return (T) this.mIProxyHttpClient.execute(httpHost, httpRequest, responseHandler);
    }

    public void close() {
        super.close();
        this.mIProxyHttpClient.close();
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T) this.mIProxyHttpClient.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException, ClientProtocolException {
        return (T) this.mIProxyHttpClient.execute(httpUriRequest, responseHandler, httpContext);
    }
}
