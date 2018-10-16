package cn.jiguang.a.a.a;
/* loaded from: classes3.dex */
final class f implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ g kp;
    final /* synthetic */ d kq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, byte[] bArr, int i, int i2, g gVar) {
        this.kq = dVar;
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.kp = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.kq.b(this.a, this.b, this.c);
        if (this.kp != null) {
            this.kp.a();
        }
        this.kq.a.quit();
    }
}
