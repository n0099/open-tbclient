package bolts;
/* loaded from: classes2.dex */
public class h<TResult> {
    private final g<TResult> kp = new g<>();

    public g<TResult> bj() {
        return this.kp;
    }

    public boolean bi() {
        return this.kp.bi();
    }

    public boolean h(TResult tresult) {
        return this.kp.h(tresult);
    }

    public boolean g(Exception exc) {
        return this.kp.g(exc);
    }

    public void bk() {
        if (!bi()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void i(TResult tresult) {
        if (!h((h<TResult>) tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void h(Exception exc) {
        if (!g(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
