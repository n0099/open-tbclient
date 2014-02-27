package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
final class x implements Runnable {
    final /* synthetic */ v a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, String str) {
        this.a = vVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c(this.b);
    }
}
