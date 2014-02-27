package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
final class w implements Runnable {
    final /* synthetic */ v a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Object c;
    private final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, String str, Object obj, long j) {
        this.a = vVar;
        this.b = str;
        this.c = obj;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b, this.c, this.d);
    }
}
