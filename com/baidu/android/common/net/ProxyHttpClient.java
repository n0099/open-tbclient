package com.baidu.android.common.net;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
/* loaded from: classes.dex */
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

    public ProxyHttpClient(Context context, ConnectManager connectManager) {
        this(context, null, connectManager);
    }

    public ProxyHttpClient(Context context, String str) {
        this(context, str, null);
    }

    public ProxyHttpClient(Context context, String str, ConnectManager connectManager) {
        this.mLeakedException = new IllegalStateException("ProxyHttpClient created and never closed");
        connectManager = connectManager == null ? new ConnectManager(context) : connectManager;
        this.mUseWap = connectManager.isWapNetwork();
        this.mProxy = connectManager.getProxy();
        this.mPort = connectManager.getProxyPort();
        if (this.mUseWap) {
            getParams().setParameter("http.route.default-proxy", new HttpHost(this.mProxy, Integer.valueOf(this.mPort).intValue()));
        }
        HttpConnectionParams.setConnectionTimeout(getParams(), HTTP_TIMEOUT_MS);
        HttpConnectionParams.setSoTimeout(getParams(), HTTP_TIMEOUT_MS);
        HttpConnectionParams.setSocketBufferSize(getParams(), 8192);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HttpProtocolParams.setUserAgent(getParams(), str);
    }

    public void close() {
        if (this.mLeakedException != null) {
            getConnectionManager().shutdown();
            this.mLeakedException = null;
        }
    }

    protected HttpParams createHttpParams() {
        HttpParams createHttpParams = super.createHttpParams();
        HttpProtocolParams.setUseExpectContinue(createHttpParams, false);
        return createHttpParams;
    }

    protected void finalize() throws Throwable {
        super/*java.lang.Object*/.finalize();
        if (this.mLeakedException != null) {
            Log.e(TAG, "Leak found", this.mLeakedException);
        }
    }

    public boolean isWap() {
        return this.mUseWap;
    }
}
