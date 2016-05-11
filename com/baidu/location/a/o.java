package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ g GC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.GC = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.GC.i();
        if (i) {
            this.GC.j();
        }
    }
}
