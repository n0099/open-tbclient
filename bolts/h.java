package bolts;
/* loaded from: classes16.dex */
public class h<TResult> {
    private final g<TResult> AB = new g<>();

    public g<TResult> ip() {
        return this.AB;
    }

    public boolean in() {
        return this.AB.in();
    }

    public boolean m(TResult tresult) {
        return this.AB.m(tresult);
    }

    public boolean g(Exception exc) {
        return this.AB.g(exc);
    }

    public void iq() {
        if (!in()) {
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
