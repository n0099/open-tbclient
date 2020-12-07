package com.baidu.fsg.base;
/* loaded from: classes16.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InitDelayThread f1455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InitDelayThread initDelayThread) {
        this.f1455a = initDelayThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1455a.mCallback != null) {
            this.f1455a.mCallback.callBack();
        }
    }
}
