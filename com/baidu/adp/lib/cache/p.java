package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class p implements Runnable {
    final /* synthetic */ o a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, String str) {
        this.a = oVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.c.g(this.b);
    }
}
