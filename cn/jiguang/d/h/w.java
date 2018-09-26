package cn.jiguang.d.h;
/* loaded from: classes3.dex */
public final class w implements Comparable<w>, Runnable {
    private int a;
    private final Runnable b;

    public w(Runnable runnable, int i) {
        if (i <= 0) {
            i = 4;
        } else if (i > 10) {
            i = 10;
        }
        this.a = i;
        this.b = runnable;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(w wVar) {
        return wVar.a - this.a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.currentThread().setPriority(this.a);
        } catch (Throwable th) {
        }
        try {
            if (this.b != null) {
                this.b.run();
            }
        } catch (Throwable th2) {
        }
    }
}
