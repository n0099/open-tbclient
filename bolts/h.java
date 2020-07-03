package bolts;
/* loaded from: classes7.dex */
public class h<TResult> {
    private final g<TResult> zQ = new g<>();

    public g<TResult> gO() {
        return this.zQ;
    }

    public boolean gN() {
        return this.zQ.gN();
    }

    public boolean l(TResult tresult) {
        return this.zQ.l(tresult);
    }

    public boolean g(Exception exc) {
        return this.zQ.g(exc);
    }

    public void gP() {
        if (!gN()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void m(TResult tresult) {
        if (!l(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void h(Exception exc) {
        if (!g(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
