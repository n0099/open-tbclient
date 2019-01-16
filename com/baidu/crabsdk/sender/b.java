package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b implements Runnable {
    final /* synthetic */ a YL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.YL = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        a aVar = this.YL;
        i = this.YL.by;
        aVar.by = (i + 1) % 10;
    }
}
