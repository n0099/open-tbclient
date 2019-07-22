package bolts;
/* loaded from: classes2.dex */
public class h<TResult> {
    private final g<TResult> ko = new g<>();

    public g<TResult> bm() {
        return this.ko;
    }

    public boolean bl() {
        return this.ko.bl();
    }

    public boolean h(TResult tresult) {
        return this.ko.h(tresult);
    }

    public boolean g(Exception exc) {
        return this.ko.g(exc);
    }

    public void bn() {
        if (!bl()) {
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
