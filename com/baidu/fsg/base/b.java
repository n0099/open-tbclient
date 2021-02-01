package com.baidu.fsg.base;
/* loaded from: classes5.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InitDelayThread f1875a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InitDelayThread initDelayThread) {
        this.f1875a = initDelayThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1875a.mCallback != null) {
            this.f1875a.mCallback.callBack();
        }
    }
}
