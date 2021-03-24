package com.baidu.sapi2.httpwrap;

import android.os.Looper;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class HttpHandlerWrap {
    public boolean executCallbackInChildThread;

    public HttpHandlerWrap() {
    }

    public boolean isExecutCallbackInChildThread() {
        return this.executCallbackInChildThread;
    }

    public void onFailure(Throwable th, int i, String str) {
    }

    public void onFinish() {
    }

    public void onStart() {
    }

    public void onSuccess(int i, String str) {
    }

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
