package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class w implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Object b;
    final /* synthetic */ long c;
    final /* synthetic */ v d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar, String str, Object obj, long j) {
        this.d = vVar;
        this.a = str;
        this.b = obj;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d.a(this.a, this.b, this.c);
    }
}
