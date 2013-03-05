package com.baidu.browser.webkit;

import android.webkit.ValueCallback;
/* loaded from: classes.dex */
public class BdValueCallback {
    private ValueCallback mSysValueCallback;
    private com.baidu.zeus.ValueCallback mZeusValueCallback;

    public BdValueCallback(ValueCallback valueCallback) {
        this.mSysValueCallback = valueCallback;
    }

    public BdValueCallback(com.baidu.zeus.ValueCallback valueCallback) {
        this.mZeusValueCallback = valueCallback;
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdValueCallback) && unwrap() == ((BdValueCallback) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusValueCallback != null ? this.mZeusValueCallback.hashCode() : this.mSysValueCallback.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusValueCallback != null ? this.mZeusValueCallback == obj : this.mSysValueCallback == obj;
    }

    public Object unwrap() {
        return this.mZeusValueCallback != null ? this.mZeusValueCallback : this.mSysValueCallback;
    }

    public void onReceiveValue(Object obj) {
        if (this.mZeusValueCallback != null) {
            this.mZeusValueCallback.onReceiveValue(obj);
        } else {
            this.mSysValueCallback.onReceiveValue(obj);
        }
    }
}
