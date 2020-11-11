package com.baidu.platform.comapi.walknavi.d.a.d;
/* loaded from: classes7.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ long f2979a;
    final /* synthetic */ long b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, long j, long j2) {
        this.c = dVar;
        this.f2979a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.this.a((int) ((100.0f * ((float) this.f2979a)) / ((float) this.b)));
    }
}
