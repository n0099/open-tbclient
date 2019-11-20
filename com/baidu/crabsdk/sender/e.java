package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {
    final /* synthetic */ d Km;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.Km = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.Km;
        i = this.Km.Kj;
        dVar.Kj = (i + 1) % 10;
    }
}
