package b.a.a.a.a;
/* loaded from: classes15.dex */
public abstract class ag extends ah {
    protected w Bk;
    private y Bl;

    public ag(w wVar, y yVar) {
        this.Bl = null;
        this.Bk = null;
        this.Bk = wVar;
        this.Bl = yVar;
    }

    public final void a(int i, int i2) {
        if (this.Bl != null) {
            this.Bl.a(i, i2);
        }
    }

    public final void a(ac acVar) {
        if (this.Bl == null || acVar == null) {
            return;
        }
        this.Bl.a(acVar);
    }

    public final w hN() {
        return this.Bk;
    }
}
