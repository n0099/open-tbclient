package com.baidu.searchbox.v8engine;
/* loaded from: classes5.dex */
public interface JSRuntime {
    void postOnJSThread(Runnable runnable);

    void postOnJSThread(Runnable runnable, long j);

    void runOnJSThread(Runnable runnable);

    void runOnJSThreadDirectly(Runnable runnable);
}
