package com.baidu.platform.comapi.walknavi.d.a.d;
/* loaded from: classes26.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f2981a;
    final /* synthetic */ long b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, long j, long j2) {
        this.c = dVar;
        this.f2981a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.this.a((int) ((100.0f * ((float) this.f2981a)) / ((float) this.b)));
    }
}
