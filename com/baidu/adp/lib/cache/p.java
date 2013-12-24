package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, String str) {
        this.b = oVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c.g(this.a);
    }
}
