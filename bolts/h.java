package bolts;
/* loaded from: classes6.dex */
public class h<TResult> {
    private final g<TResult> AW = new g<>();

    public g<TResult> iq() {
        return this.AW;
    }

    public boolean ip() {
        return this.AW.ip();
    }

    public boolean m(TResult tresult) {
        return this.AW.m(tresult);
    }

    public boolean g(Exception exc) {
        return this.AW.g(exc);
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
