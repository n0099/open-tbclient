package com.baidu.fsg.base;

import com.baidu.fsg.base.InitDelayThread;
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InitDelayThread f5151a;

    public b(InitDelayThread initDelayThread) {
        this.f5151a = initDelayThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        InitDelayThread.InitDelayCallback initDelayCallback = this.f5151a.mCallback;
        if (initDelayCallback != null) {
            initDelayCallback.callBack();
        }
    }
}
