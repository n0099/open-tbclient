package com.baidu.fsg.base;

import com.baidu.fsg.base.InitDelayThread;
/* loaded from: classes2.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InitDelayThread f5170a;

    public b(InitDelayThread initDelayThread) {
        this.f5170a = initDelayThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        InitDelayThread.InitDelayCallback initDelayCallback = this.f5170a.mCallback;
        if (initDelayCallback != null) {
            initDelayCallback.callBack();
        }
    }
}
