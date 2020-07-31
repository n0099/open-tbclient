package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes12.dex */
public final class e implements Runnable {
    final /* synthetic */ d anQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.anQ = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.anQ;
        i = this.anQ.anN;
        dVar.anN = (i + 1) % 10;
    }
}
