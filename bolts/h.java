package bolts;
/* loaded from: classes14.dex */
public class h<TResult> {
    private final g<TResult> CW = new g<>();

    public g<TResult> hN() {
        return this.CW;
    }

    public boolean hM() {
        return this.CW.hM();
    }

    public boolean l(TResult tresult) {
        return this.CW.l(tresult);
    }

    public boolean g(Exception exc) {
        return this.CW.g(exc);
    }

    public void hO() {
        if (!hM()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void m(TResult tresult) {
        if (!l(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public void h(Exception exc) {
        if (!g(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }
}
