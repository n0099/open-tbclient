package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {
    final /* synthetic */ d KM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.KM = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.KM;
        i = this.KM.KJ;
        dVar.KJ = (i + 1) % 10;
    }
}
