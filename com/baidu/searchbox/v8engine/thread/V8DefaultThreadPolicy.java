package com.baidu.searchbox.v8engine.thread;

import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes4.dex */
public class V8DefaultThreadPolicy implements V8ThreadDelegatePolicy {
    public Thread jsThread = null;
    public Handler mHandler;
    public V8Engine mV8Engine;

    /* loaded from: classes4.dex */
    public class V8EngineRunnable implements Runnable {
        public V8EngineRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            V8DefaultThreadPolicy.this.mHandler = new Handler();
            V8DefaultThreadPolicy.this.mV8Engine.startEngineInternal();
            Looper.loop();
        }
    }

    public V8DefaultThreadPolicy(V8Engine v8Engine) {
        this.mV8Engine = v8Engine;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.post(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void startV8Engine(V8Engine v8Engine) {
        if (this.jsThread == null) {
            Thread thread = new Thread(new V8EngineRunnable());
            this.jsThread = thread;
            thread.setName(v8Engine.threadName());
            this.jsThread.start();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j) {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.postDelayed(runnable, j);
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler.getLooper().getThread();
        }
        return null;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void shutdown() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.getLooper().quitSafely();
    }
}
