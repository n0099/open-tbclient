package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ x a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Object c;
    private final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, String str, Object obj, long j) {
        this.a = xVar;
        this.b = str;
        this.c = obj;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a(this.b, this.c, this.d);
    }
}
