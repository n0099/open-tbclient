package android.support.v4.app;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, int i, int i2) {
        this.c = lVar;
        this.a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.c.o.a, (String) null, this.a, this.b);
    }
}
