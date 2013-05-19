package com.baidu.mobstat;
/* loaded from: classes.dex */
class n implements Runnable {
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
