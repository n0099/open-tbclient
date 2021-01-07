package com.baidu.fsg.base;
/* loaded from: classes6.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ InitDelayThread f1927a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InitDelayThread initDelayThread) {
        this.f1927a = initDelayThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1927a.mCallback != null) {
            this.f1927a.mCallback.callBack();
        }
    }
}
