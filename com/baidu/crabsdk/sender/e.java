package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e implements Runnable {
    final /* synthetic */ d acv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.acv = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.acv;
        i = this.acv.acs;
        dVar.acs = (i + 1) % 10;
    }
}
