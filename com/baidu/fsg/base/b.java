package com.baidu.fsg.base;
/* loaded from: classes15.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InitDelayThread f1453a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InitDelayThread initDelayThread) {
        this.f1453a = initDelayThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1453a.mCallback != null) {
            this.f1453a.mCallback.callBack();
        }
    }
}
