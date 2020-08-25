package com.baidu.android.common.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
/* loaded from: classes7.dex */
public class ProxyHttpClient extends DefaultHttpClient {
    private static final boolean DEBUG = false;
    private static final int HTTP_TIMEOUT_MS = 30000;
    private static final String TAG = ProxyHttpClient.class.getSimpleName();
    private RuntimeException mLeakedException;
    private String mPort;
    private String mProxy;
    private boolean mUseWap;

    public ProxyHttpClient(Context context) {
        this(context, null, null);
    }

    public ProxyHttpClient(Context context, String str) {
        this(context, str, null);
    }

    public ProxyHttpClient(Context context, ConnectManager connectManager) {
        this(context, null, connectManager);
    }

    public ProxyHttpClient(Context context, String str, ConnectManager connectManager) {
        this.mLeakedException = new IllegalStateException("ProxyHttpClient created and never closed");
        connectManager = connectManager == null ? new ConnectManager(context) : connectManager;
        this.mUseWap = connectManager.isWapNetwork();
        this.mProxy = connectManager.getProxy();
        this.mPort = connectManager.getProxyPort();
        if (this.mProxy != null && this.mProxy.length() > 0) {
            getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(this.mProxy, Integer.valueOf(this.mPort).intValue()));
        }
        HttpConnectionParams.setConnectionTimeout(getParams(), 30000);
        HttpConnectionParams.setSoTimeout(getParams(), 30000);
        HttpConnectionParams.setSocketBufferSize(getParams(), 8192);
        if (!TextUtils.isEmpty(str)) {
            HttpProtocolParams.setUserAgent(getParams(), str);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mLeakedException != null) {
            Log.e(TAG, "Leak found", this.mLeakedException);
        }
    }

    public void close() {
        if (this.mLeakedException != null) {
            getConnectionManager().shutdown();
            this.mLeakedException = null;
        }
    }

    public boolean isWap() {
        return this.mUseWap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.http.impl.client.DefaultHttpClient, org.apache.http.impl.client.AbstractHttpClient
    public HttpParams createHttpParams() {
        HttpParams basicHttpParams;
        try {
            basicHttpParams = super.createHttpParams();
        } catch (ArrayIndexOutOfBoundsException e) {
            basicHttpParams = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams, "ISO-8859-1");
            HttpProtocolParams.setUserAgent(basicHttpParams, "Apache-HttpClient/UNAVAILABLE (java 1.4)");
        }
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        return basicHttpParams;
    }

    public HttpResponse executeSafely(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        try {
            return execute(httpUriRequest);
        } catch (NullPointerException e) {
            throw new ClientProtocolException(e);
        }
    }
}
