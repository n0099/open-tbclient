package com.baidu.sapi2.httpwrap;

import android.os.Looper;
import java.util.HashMap;
/* loaded from: classes5.dex */
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSuccess(int i, String str, HashMap<String, String> hashMap) {
        onSuccess(i, str);
    }

    public HttpHandlerWrap(Looper looper) {
    }

    public HttpHandlerWrap(String str) {
    }

    public HttpHandlerWrap(boolean z) {
        this.executCallbackInChildThread = z;
    }
}
