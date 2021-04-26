package c;
/* loaded from: classes.dex */
public class f<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final e<TResult> f1497a = new e<>();

    public e<TResult> a() {
        return this.f1497a;
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void c(Exception exc) {
        if (!f(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void d(TResult tresult) {
        if (!g(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean e() {
        return this.f1497a.t();
    }

    public boolean f(Exception exc) {
        return this.f1497a.u(exc);
    }

    public boolean g(TResult tresult) {
        return this.f1497a.v(tresult);
    }
}
