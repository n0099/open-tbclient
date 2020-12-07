package bolts;
/* loaded from: classes10.dex */
public class h<TResult> {
    private final g<TResult> BM = new g<>();

    public g<TResult> iq() {
        return this.BM;
    }

    public boolean ip() {
        return this.BM.ip();
    }

    public boolean m(TResult tresult) {
        return this.BM.m(tresult);
    }

    public boolean g(Exception exc) {
        return this.BM.g(exc);
    }

    public void ir() {
        if (!ip()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void n(TResult tresult) {
        if (!m(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void h(Exception exc) {
        if (!g(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
