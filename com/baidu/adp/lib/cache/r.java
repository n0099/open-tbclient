package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ p a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, String str) {
        this.a = pVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c.f(this.b);
    }
}
