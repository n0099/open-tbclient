package com.baidu.searchbox.v8engine;
/* loaded from: classes2.dex */
public interface JSRuntime {
    void postOnJSThread(Runnable runnable);

    void runOnJSThread(Runnable runnable);
}
