package bolts;
/* loaded from: classes4.dex */
public class h<TResult> {
    private final g<TResult> dF = new g<>();

    public g<TResult> bb() {
        return this.dF;
    }

    public boolean ba() {
        return this.dF.ba();
    }

    public boolean k(TResult tresult) {
        return this.dF.k(tresult);
    }

    public boolean f(Exception exc) {
        return this.dF.f(exc);
    }

    public void bc() {
        if (!ba()) {
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
