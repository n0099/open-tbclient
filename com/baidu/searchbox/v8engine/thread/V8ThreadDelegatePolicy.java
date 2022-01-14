package com.baidu.searchbox.v8engine.thread;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes11.dex */
public interface V8ThreadDelegatePolicy {
    void doDelegateRunnable(Runnable runnable);

    void doDelegateRunnable(Runnable runnable, long j2);

    void doDelegateRunnableDirectly(Runnable runnable);

    Thread getThread();

    void shutdown();

    void startV8Engine(V8Engine v8Engine);
}
