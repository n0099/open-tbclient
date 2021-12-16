package com.baidu.searchbox.v8engine;
/* loaded from: classes10.dex */
public interface JSRuntime {
    void postOnJSThread(Runnable runnable);

    void postOnJSThread(Runnable runnable, long j2);

    void runOnJSThread(Runnable runnable);

    void runOnJSThreadDirectly(Runnable runnable);
}
