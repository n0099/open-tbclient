package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ w a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Object c;
    private final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, String str, Object obj, long j) {
        this.a = wVar;
        this.b = str;
        this.c = obj;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.b, this.c, this.d);
    }
}
