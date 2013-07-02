package com.baidu.browser.webkit;

import android.webkit.HttpAuthHandler;
/* loaded from: classes.dex */
public class BdHttpAuthHandler {
    private HttpAuthHandler mSysHttpAuthHandler;
    private com.baidu.zeus.HttpAuthHandler mZeusHttpAuthHandler;

    public BdHttpAuthHandler(HttpAuthHandler httpAuthHandler) {
        this.mSysHttpAuthHandler = httpAuthHandler;
    }

    public BdHttpAuthHandler(com.baidu.zeus.HttpAuthHandler httpAuthHandler) {
        this.mZeusHttpAuthHandler = httpAuthHandler;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdHttpAuthHandler) && unwrap() == ((BdHttpAuthHandler) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusHttpAuthHandler != null ? this.mZeusHttpAuthHandler.hashCode() : this.mSysHttpAuthHandler.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusHttpAuthHandler != null ? this.mZeusHttpAuthHandler == obj : this.mSysHttpAuthHandler == obj;
    }

    public Object unwrap() {
        return this.mZeusHttpAuthHandler != null ? this.mZeusHttpAuthHandler : this.mSysHttpAuthHandler;
    }

    public void proceed(String str, String str2) {
        if (this.mZeusHttpAuthHandler != null) {
            this.mZeusHttpAuthHandler.proceed(str, str2);
        } else {
            this.mSysHttpAuthHandler.proceed(str, str2);
        }
    }

    public void cancel() {
        if (this.mZeusHttpAuthHandler != null) {
            this.mZeusHttpAuthHandler.cancel();
        } else {
            this.mSysHttpAuthHandler.cancel();
        }
    }

    public boolean useHttpAuthUsernamePassword() {
        return this.mZeusHttpAuthHandler != null ? this.mZeusHttpAuthHandler.useHttpAuthUsernamePassword() : this.mSysHttpAuthHandler.useHttpAuthUsernamePassword();
    }
}
