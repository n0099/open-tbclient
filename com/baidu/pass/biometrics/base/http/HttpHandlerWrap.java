package com.baidu.pass.biometrics.base.http;

import android.os.Looper;
/* loaded from: classes20.dex */
public class HttpHandlerWrap {
    protected boolean executCallbackInChildThread;

    public HttpHandlerWrap() {
    }

    public boolean isExecutCallbackInChildThread() {
        return this.executCallbackInChildThread;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFailure(Throwable th, int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFinish() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(int i, String str) {
    }

    public HttpHandlerWrap(Looper looper) {
    }

    public HttpHandlerWrap(String str) {
    }

    public HttpHandlerWrap(boolean z) {
        this.executCallbackInChildThread = z;
    }
}
