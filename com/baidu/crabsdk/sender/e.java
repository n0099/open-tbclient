package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class e implements Runnable {
    final /* synthetic */ d amB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.amB = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.amB;
        i = this.amB.amy;
        dVar.amy = (i + 1) % 10;
    }
}
