package bolts;
/* loaded from: classes2.dex */
public class h<TResult> {
    private final g<TResult> cz = new g<>();

    public g<TResult> aP() {
        return this.cz;
    }

    public boolean aO() {
        return this.cz.aO();
    }

    public boolean h(TResult tresult) {
        return this.cz.h(tresult);
    }

    public boolean f(Exception exc) {
        return this.cz.f(exc);
    }

    public void aQ() {
        if (!aO()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void i(TResult tresult) {
        if (!h(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void g(Exception exc) {
        if (!f(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
