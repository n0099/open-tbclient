package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, String str) {
        this.a = pVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c.g(this.b);
    }
}
