package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ w a;
    private final /* synthetic */ String b;
    private final /* synthetic */ t c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, String str, t tVar) {
        this.a = wVar;
        this.b = str;
        this.c = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.b, this.a.a(this.b));
    }
}
