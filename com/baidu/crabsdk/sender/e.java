package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {
    final /* synthetic */ d aaG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aaG = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aaG;
        i = this.aaG.aaD;
        dVar.aaD = (i + 1) % 10;
    }
}
