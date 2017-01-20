package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends Thread {
    final /* synthetic */ g In;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(g gVar) {
        this.In = gVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean i;
        i = this.In.i();
        if (i) {
            this.In.j();
        }
    }
}
