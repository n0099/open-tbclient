package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class e implements Runnable {
    final /* synthetic */ d anU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.anU = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.anU;
        i = this.anU.anR;
        dVar.anR = (i + 1) % 10;
    }
}
