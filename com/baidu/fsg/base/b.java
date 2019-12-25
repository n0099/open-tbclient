package com.baidu.fsg.base;
/* loaded from: classes3.dex */
class b implements Runnable {
    final /* synthetic */ InitDelayThread a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InitDelayThread initDelayThread) {
        this.a = initDelayThread;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a.mCallback != null) {
            this.a.mCallback.callBack();
        }
    }
}
