package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class e implements Runnable {
    final /* synthetic */ d are;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.are = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.are;
        i = this.are.arb;
        dVar.arb = (i + 1) % 10;
    }
}
