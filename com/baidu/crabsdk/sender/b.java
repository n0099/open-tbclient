package com.baidu.crabsdk.sender;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class b implements Runnable {
    final /* synthetic */ a aco;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aco = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        a aVar = this.aco;
        i = this.aco.by;
        aVar.by = (i + 1) % 10;
    }
}
