package com.baidu.searchbox.v8engine.net;

import com.baidu.searchbox.v8engine.NotProguard;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.smallgame.sdk.Log;
import java.lang.ref.WeakReference;
import java.util.Observable;
@NotProguard
/* loaded from: classes2.dex */
public class NetRequest extends Observable {
    public static final String TAG = "NetRequest";
    public WeakReference<V8Engine> mEngineWeakReference;
    public NetRequestSettings mNetRequestSettings;
    public RedirectInterceptor mRedirectInterceptor;
    public RequestInterceptor mRequestInterceptor;

    /* loaded from: classes2.dex */
    public interface RedirectInterceptor {
        boolean shouldInterceptRedirect(NetRequestParam netRequestParam, NetRedirectInfo netRedirectInfo);
    }

    /* loaded from: classes2.dex */
    public interface RequestInterceptor {
        boolean shouldInterceptRequest(NetRequestResult netRequestResult, NetRequestParam netRequestParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeExecute(long j, NetRequestParam netRequestParam);

    private synchronized void receiveRequestCallback(NetRequestParam netRequestParam, int i2, String str, int i3, String[] strArr, int i4, String str2) {
        if (netRequestParam != null && i2 != -1) {
            NetRequestCallback netRequestCallback = netRequestParam.getNetRequestCallback();
            if (netRequestCallback != null) {
                if (i2 == 0) {
                    netRequestCallback.onSucceeded(str, i3, NetRequestParam.stringPairToMap(strArr));
                } else if (i2 == 1) {
                    netRequestCallback.onFailed(i4, str2);
                }
            }
        }
    }

    private synchronized void receiveRequestResult(NetRequestResult netRequestResult) {
        setChanged();
        notifyObservers(netRequestResult);
    }

    private boolean shouldInterceptRedirect(NetRequestParam netRequestParam, NetRedirectInfo netRedirectInfo) {
        RedirectInterceptor redirectInterceptor = this.mRedirectInterceptor;
        if (redirectInterceptor != null) {
            return redirectInterceptor.shouldInterceptRedirect(netRequestParam, netRedirectInfo);
        }
        return false;
    }

    private boolean shouldInterceptRequest(NetRequestResult netRequestResult, NetRequestParam netRequestParam) {
        RequestInterceptor requestInterceptor = this.mRequestInterceptor;
        if (requestInterceptor != null) {
            return requestInterceptor.shouldInterceptRequest(netRequestResult, netRequestParam);
        }
        return false;
    }

    public void bindV8Engine(V8Engine v8Engine) {
        this.mEngineWeakReference = new WeakReference<>(v8Engine);
    }

    public boolean execute(final NetRequestParam netRequestParam) {
        WeakReference<V8Engine> weakReference = this.mEngineWeakReference;
        if (weakReference == null) {
            Log.w(TAG, "Execute net request failed. Must call setNetRequest method of V8Engine object firstly");
            return false;
        }
        V8Engine v8Engine = weakReference.get();
        if (v8Engine == null) {
            Log.w(TAG, "Execute net request failed. The bound V8Engine object has been destroyed");
            return false;
        }
        final long nativePtr = v8Engine.nativePtr();
        v8Engine.postOnJSThread(new Runnable() { // from class: com.baidu.searchbox.v8engine.net.NetRequest.1
            @Override // java.lang.Runnable
            public void run() {
                NetRequest.this.nativeExecute(nativePtr, netRequestParam);
            }
        });
        return true;
    }

    public NetRequestSettings getNetRequestSettings() {
        return this.mNetRequestSettings;
    }

    public RequestInterceptor getRequestInterceptor() {
        return this.mRequestInterceptor;
    }

    public void setNetRequestSettings(NetRequestSettings netRequestSettings) {
        this.mNetRequestSettings = netRequestSettings;
        WeakReference<V8Engine> weakReference = this.mEngineWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mEngineWeakReference.get().setNetRequest(this);
    }

    public void setRedirectInterceptor(RedirectInterceptor redirectInterceptor) {
        this.mRedirectInterceptor = redirectInterceptor;
    }

    public void setRequestInterceptor(RequestInterceptor requestInterceptor) {
        this.mRequestInterceptor = requestInterceptor;
    }
}
