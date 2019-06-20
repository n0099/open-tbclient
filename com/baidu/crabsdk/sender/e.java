package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {
    final /* synthetic */ d aaj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aaj = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aaj;
        i = this.aaj.aag;
        dVar.aag = (i + 1) % 10;
    }
}
