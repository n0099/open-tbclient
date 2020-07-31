package com.baidu.location.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class q implements Runnable {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean a;
        if (!com.baidu.location.b.i.i()) {
            a = this.a.a(com.baidu.location.f.getServiceContext());
            if (!a) {
                return;
            }
        }
        this.a.d();
    }
}
