package com.baidu.fsg.base;

import com.baidu.fsg.base.InitDelayThread;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InitDelayThread f5186a;

    public b(InitDelayThread initDelayThread) {
        this.f5186a = initDelayThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        InitDelayThread.InitDelayCallback initDelayCallback = this.f5186a.mCallback;
        if (initDelayCallback != null) {
            initDelayCallback.callBack();
        }
    }
}
