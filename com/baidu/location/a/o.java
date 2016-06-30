package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ g Gy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.Gy = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.Gy.i();
        if (i) {
            this.Gy.j();
        }
    }
}
