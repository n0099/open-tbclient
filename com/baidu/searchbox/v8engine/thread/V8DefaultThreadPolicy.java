package com.baidu.searchbox.v8engine.thread;

import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes14.dex */
public class V8DefaultThreadPolicy implements V8ThreadDelegatePolicy {
    private Thread jsThread = null;
    private Handler mHandler;
    private V8Engine mV8Engine;

    public V8DefaultThreadPolicy(V8Engine v8Engine) {
        this.mV8Engine = v8Engine;
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void startV8Engine(V8Engine v8Engine) {
        if (this.jsThread == null) {
            this.jsThread = new Thread(new V8EngineRunnable());
            this.jsThread.setName(v8Engine.threadName());
            this.jsThread.start();
        }
    }

    /* loaded from: classes14.dex */
    class V8EngineRunnable implements Runnable {
        V8EngineRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            V8DefaultThreadPolicy.this.mHandler = new Handler();
            V8DefaultThreadPolicy.this.mV8Engine.startEngineInternal();
            Looper.loop();
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable) {
        if (this.mHandler != null) {
            this.mHandler.post(runnable);
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnable(Runnable runnable, long j) {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(runnable, j);
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void doDelegateRunnableDirectly(Runnable runnable) {
        if (this.mHandler != null) {
            this.mHandler.post(runnable);
        }
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public void shutdown() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.getLooper().quitSafely();
    }

    @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
    public Thread getThread() {
        if (this.mHandler != null) {
            return this.mHandler.getLooper().getThread();
        }
        return null;
    }
}
