package bolts;
/* loaded from: classes2.dex */
public class h<TResult> {
    private final g<TResult> kl = new g<>();

    public g<TResult> bj() {
        return this.kl;
    }

    public boolean bi() {
        return this.kl.bi();
    }

    public boolean g(TResult tresult) {
        return this.kl.g((g<TResult>) tresult);
    }

    public boolean g(Exception exc) {
        return this.kl.g(exc);
    }

    public void bk() {
        if (!bi()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void h(TResult tresult) {
        if (!g((h<TResult>) tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void h(Exception exc) {
        if (!g(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
