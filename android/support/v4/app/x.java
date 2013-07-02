package android.support.v4.app;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ v c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, int i, int i2) {
        this.c = vVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.c.o.mHandler, (String) null, this.a, this.b);
    }
}
