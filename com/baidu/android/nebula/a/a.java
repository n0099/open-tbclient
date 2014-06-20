package com.baidu.android.nebula.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
/* loaded from: classes.dex */
public class a extends DefaultHttpClient {
    private static final String a = a.class.getSimpleName();
    private String b;
    private String c;
    private boolean d;
    private RuntimeException e;

    public a(Context context) {
        this(context, null, null);
    }

    public a(Context context, String str, h hVar) {
        this.e = new IllegalStateException("ProxyHttpClient created and never closed");
        hVar = hVar == null ? new h(context) : hVar;
        this.d = hVar.a();
        this.b = hVar.b();
        this.c = hVar.c();
        if (this.b != null && this.b.length() > 0) {
            getParams().setParameter("http.route.default-proxy", new HttpHost(this.b, Integer.valueOf(this.c).intValue()));
        }
        HttpConnectionParams.setConnectionTimeout(getParams(), 30000);
        HttpConnectionParams.setSoTimeout(getParams(), 30000);
        HttpConnectionParams.setSocketBufferSize(getParams(), 8192);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        HttpProtocolParams.setUserAgent(getParams(), str);
    }

    public void a() {
        if (this.e != null) {
            getConnectionManager().shutdown();
            this.e = null;
        }
    }

    protected HttpParams createHttpParams() {
        HttpParams createHttpParams = super.createHttpParams();
        HttpProtocolParams.setUseExpectContinue(createHttpParams, false);
        return createHttpParams;
    }

    protected void finalize() {
        super/*java.lang.Object*/.finalize();
        if (this.e != null) {
            Log.e(a, "Leak found", this.e);
        }
    }
}
