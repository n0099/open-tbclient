package b.a.a.a.a;
/* loaded from: classes3.dex */
public abstract class ag extends ah {
    protected w Bm;
    private y Bn;

    public ag(w wVar, y yVar) {
        this.Bn = null;
        this.Bm = null;
        this.Bm = wVar;
        this.Bn = yVar;
    }

    public final void a(int i, int i2) {
        if (this.Bn != null) {
            this.Bn.a(i, i2);
        }
    }

    public final void a(ac acVar) {
        if (this.Bn == null || acVar == null) {
            return;
        }
        this.Bn.a(acVar);
    }

    public final w hN() {
        return this.Bm;
    }
}
