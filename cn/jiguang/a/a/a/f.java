package cn.jiguang.a.a.a;
/* loaded from: classes3.dex */
final class f implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ g kt;
    final /* synthetic */ d ku;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, byte[] bArr, int i, int i2, g gVar) {
        this.ku = dVar;
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.kt = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.ku.b(this.a, this.b, this.c);
        if (this.kt != null) {
            this.kt.a();
        }
        this.ku.a.quit();
    }
}
