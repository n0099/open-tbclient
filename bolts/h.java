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

    public boolean k(TResult tresult) {
        return this.zq.k(tresult);
    }

    public boolean f(Exception exc) {
        return this.zq.f(exc);
    }

    public void gz() {
        if (!gx()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void l(TResult tresult) {
        if (!k(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void g(Exception exc) {
        if (!f(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
