package com.baidu.adp.lib.cache;
/* loaded from: classes.dex */
class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f390a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Object c;
    private final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, String str, Object obj, long j) {
        this.f390a = tVar;
        this.b = str;
        this.c = obj;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f390a.a(this.b, this.c, this.d);
    }
}
