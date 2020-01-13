package com.baidu.platform.comapi.walknavi.d.a.d;
/* loaded from: classes6.dex */
class e implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, long j, long j2) {
        this.c = dVar;
        this.a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.this.a((int) ((100.0f * ((float) this.a)) / ((float) this.b)));
    }
}
