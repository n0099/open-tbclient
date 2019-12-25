package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class e implements Runnable {
    final /* synthetic */ d QR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.QR = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.QR;
        i = this.QR.QN;
        dVar.QN = (i + 1) % 10;
    }
}
