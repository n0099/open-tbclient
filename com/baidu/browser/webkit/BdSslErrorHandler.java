package com.baidu.browser.webkit;

import android.webkit.SslErrorHandler;
/* loaded from: classes.dex */
public class BdSslErrorHandler {
    private SslErrorHandler mSysSslErrorHandler;
    private com.baidu.zeus.SslErrorHandler mZeusSslErrorHandler;

    public BdSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.mSysSslErrorHandler = sslErrorHandler;
    }

    public BdSslErrorHandler(com.baidu.zeus.SslErrorHandler sslErrorHandler) {
        this.mZeusSslErrorHandler = sslErrorHandler;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdSslErrorHandler) && unwrap() == ((BdSslErrorHandler) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusSslErrorHandler != null ? this.mZeusSslErrorHandler.hashCode() : this.mSysSslErrorHandler.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusSslErrorHandler != null ? this.mZeusSslErrorHandler == obj : this.mSysSslErrorHandler == obj;
    }

    public Object unwrap() {
        return this.mZeusSslErrorHandler != null ? this.mZeusSslErrorHandler : this.mSysSslErrorHandler;
    }

    public void proceed() {
        if (this.mZeusSslErrorHandler != null) {
            this.mZeusSslErrorHandler.proceed();
        } else {
            this.mSysSslErrorHandler.proceed();
        }
    }

    public void cancel() {
        if (this.mZeusSslErrorHandler != null) {
            this.mZeusSslErrorHandler.cancel();
        } else {
            this.mSysSslErrorHandler.cancel();
        }
    }
}
