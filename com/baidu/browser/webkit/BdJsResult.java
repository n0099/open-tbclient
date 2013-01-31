package com.baidu.browser.webkit;

import android.webkit.JsResult;
/* loaded from: classes.dex */
public class BdJsResult {
    private JsResult mSysJsResult;
    private com.baidu.zeus.JsResult mZeusJsResult;

    public BdJsResult(JsResult jsResult) {
        this.mSysJsResult = jsResult;
    }

    public BdJsResult(com.baidu.zeus.JsResult jsResult) {
        this.mZeusJsResult = jsResult;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdJsResult) && unwrap() == ((BdJsResult) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusJsResult != null ? this.mZeusJsResult.hashCode() : this.mSysJsResult.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusJsResult != null ? this.mZeusJsResult == obj : this.mSysJsResult == obj;
    }

    public Object unwrap() {
        return this.mZeusJsResult != null ? this.mZeusJsResult : this.mSysJsResult;
    }

    public final void cancel() {
        if (this.mZeusJsResult != null) {
            this.mZeusJsResult.cancel();
        } else {
            this.mSysJsResult.cancel();
        }
    }

    public final void confirm() {
        if (this.mZeusJsResult != null) {
            this.mZeusJsResult.confirm();
        } else {
            this.mSysJsResult.confirm();
        }
    }
}
