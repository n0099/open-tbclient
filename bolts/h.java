package bolts;
/* loaded from: classes5.dex */
public class h<TResult> {
    private final g<TResult> Af = new g<>();

    public g<TResult> hG() {
        return this.Af;
    }

    public boolean hF() {
        return this.Af.hF();
    }

    public boolean j(TResult tresult) {
        return this.Af.j(tresult);
    }

    public boolean g(Exception exc) {
        return this.Af.g(exc);
    }

    public void hH() {
        if (!hF()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void k(TResult tresult) {
        if (!j(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void h(Exception exc) {
        if (!g(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
