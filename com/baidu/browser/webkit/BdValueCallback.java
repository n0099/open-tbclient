package com.baidu.browser.webkit;

import android.webkit.ValueCallback;
/* loaded from: classes.dex */
public class BdValueCallback<T> {
    private ValueCallback<T> mSysValueCallback;
    private com.baidu.zeus.ValueCallback<T> mZeusValueCallback;

    public BdValueCallback(ValueCallback<T> valueCallback) {
        this.mSysValueCallback = valueCallback;
    }

    public BdValueCallback(com.baidu.zeus.ValueCallback<T> valueCallback) {
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

    public void onReceiveValue(T t) {
        if (this.mZeusValueCallback != null) {
            this.mZeusValueCallback.onReceiveValue(t);
        } else {
            this.mSysValueCallback.onReceiveValue(t);
        }
    }
}
