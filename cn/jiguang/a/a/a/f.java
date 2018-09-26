package cn.jiguang.a.a.a;
/* loaded from: classes3.dex */
final class f implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ g jK;
    final /* synthetic */ d jL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, byte[] bArr, int i, int i2, g gVar) {
        this.jL = dVar;
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.jK = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.jL.b(this.a, this.b, this.c);
        if (this.jK != null) {
            this.jK.a();
        }
        this.jL.a.quit();
    }
}
