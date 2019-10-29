package bolts;
/* loaded from: classes2.dex */
public class h<TResult> {
    private final g<TResult> cY = new g<>();

    public g<TResult> aP() {
        return this.cY;
    }

    public boolean aO() {
        return this.cY.aO();
    }

    public boolean h(TResult tresult) {
        return this.cY.h(tresult);
    }

    public boolean g(Exception exc) {
        return this.cY.g(exc);
    }

    public void aQ() {
        if (!aO()) {
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
