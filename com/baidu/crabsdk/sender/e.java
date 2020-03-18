package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class e implements Runnable {
    final /* synthetic */ d SC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.SC = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.SC;
        i = this.SC.Sz;
        dVar.Sz = (i + 1) % 10;
    }
}
