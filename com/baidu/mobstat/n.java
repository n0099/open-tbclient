package com.baidu.mobstat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (f.a().c()) {
            return;
        }
        synchronized (f.a()) {
            try {
                f.a().wait();
            } catch (InterruptedException e) {
                com.baidu.mobstat.a.b.a("stat", e);
            }
        }
    }
}
