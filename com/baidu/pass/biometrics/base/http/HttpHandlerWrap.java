package com.baidu.pass.biometrics.base.http;

import android.os.Looper;
/* loaded from: classes2.dex */
public class HttpHandlerWrap {
    public boolean executCallbackInChildThread;

    public HttpHandlerWrap() {
    }

    public boolean isExecutCallbackInChildThread() {
        return this.executCallbackInChildThread;
    }

    public void onFailure(Throwable th, int i2, String str) {
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onSuccess(int i2, String str) {
    }

    public HttpHandlerWrap(Looper looper) {
    }

    public HttpHandlerWrap(String str) {
    }

    public HttpHandlerWrap(boolean z) {
        this.executCallbackInChildThread = z;
    }
}
