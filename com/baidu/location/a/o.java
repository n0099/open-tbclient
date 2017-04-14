package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ g NH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.NH = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.NH.i();
        if (i) {
            this.NH.j();
        }
    }
}
