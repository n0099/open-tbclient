package com.baidu.mobstat;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (j.a().c()) {
            return;
        }
        synchronized (j.a()) {
            try {
                j.a().wait();
            } catch (InterruptedException e) {
                com.baidu.mobstat.a.e.a("statsdk", e);
            }
        }
    }
}
