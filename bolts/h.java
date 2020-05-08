package bolts;
/* loaded from: classes7.dex */
public class h<TResult> {
    private final g<TResult> zq = new g<>();

    public g<TResult> gy() {
        return this.zq;
    }

    public boolean gx() {
        return this.zq.gx();
    }

    public boolean l(TResult tresult) {
        return this.zq.l(tresult);
    }

    public boolean g(Exception exc) {
        return this.zq.g(exc);
    }

    public void gz() {
        if (!gx()) {
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
