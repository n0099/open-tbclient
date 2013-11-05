package android.support.v4.app;
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f302a;
    final /* synthetic */ int b;
    final /* synthetic */ v c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, int i, int i2) {
        this.c = vVar;
        this.f302a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.c.o.mHandler, (String) null, this.f302a, this.b);
    }
}
