package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class e implements Runnable {
    final /* synthetic */ d aqb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.aqb = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        d dVar = this.aqb;
        i = this.aqb.apY;
        dVar.apY = (i + 1) % 10;
    }
}
