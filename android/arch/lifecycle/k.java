package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes4.dex */
public class k extends Lifecycle {
    private final WeakReference<j> cf;
    private android.arch.a.b.a<i, a> cd = new android.arch.a.b.a<>();
    private int cg = 0;
    private boolean ch = false;
    private boolean ci = false;
    private ArrayList<Lifecycle.State> cj = new ArrayList<>();
    private Lifecycle.State ce = Lifecycle.State.INITIALIZED;

    public k(@NonNull j jVar) {
        this.cf = new WeakReference<>(jVar);
    }

    @MainThread
    public void a(@NonNull Lifecycle.State state) {
        b(state);
    }

    public void b(@NonNull Lifecycle.Event event) {
        b(c(event));
    }

    private void b(Lifecycle.State state) {
        if (this.ce != state) {
            this.ce = state;
            if (this.ch || this.cg != 0) {
                this.ci = true;
                return;
            }
            this.ch = true;
            sync();
            this.ch = false;
        }
    }

    private boolean av() {
        if (this.cd.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.cd.ar().getValue().ce;
        Lifecycle.State state2 = this.cd.as().getValue().ce;
        return state == state2 && this.ce == state2;
    }

    private Lifecycle.State c(i iVar) {
        Map.Entry<i, a> h = this.cd.h(iVar);
        return a(a(this.ce, h != null ? h.getValue().ce : null), !this.cj.isEmpty() ? this.cj.get(this.cj.size() - 1) : null);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void a(@NonNull i iVar) {
        j jVar;
        a aVar = new a(iVar, this.ce == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.cd.c(iVar, aVar) == null && (jVar = this.cf.get()) != null) {
            boolean z = this.cg != 0 || this.ch;
            Lifecycle.State c = c(iVar);
            this.cg++;
            while (aVar.ce.compareTo(c) < 0 && this.cd.contains(iVar)) {
                c(aVar.ce);
                aVar.b(jVar, e(aVar.ce));
                aw();
                c = c(iVar);
            }
            if (!z) {
                sync();
            }
            this.cg--;
        }
    }

    private void aw() {
        this.cj.remove(this.cj.size() - 1);
    }

    private void c(Lifecycle.State state) {
        this.cj.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void b(@NonNull i iVar) {
        this.cd.remove(iVar);
    }

    @Override // android.arch.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State au() {
        return this.ce;
    }

    static Lifecycle.State c(Lifecycle.Event event) {
        switch (event) {
            case ON_CREATE:
            case ON_STOP:
                return Lifecycle.State.CREATED;
            case ON_START:
            case ON_PAUSE:
                return Lifecycle.State.STARTED;
            case ON_RESUME:
                return Lifecycle.State.RESUMED;
            case ON_DESTROY:
                return Lifecycle.State.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + event);
        }
    }

    private static Lifecycle.Event d(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return Lifecycle.Event.ON_DESTROY;
            case STARTED:
                return Lifecycle.Event.ON_STOP;
            case RESUMED:
                return Lifecycle.Event.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    private static Lifecycle.Event e(Lifecycle.State state) {
        switch (state) {
            case INITIALIZED:
            case DESTROYED:
                return Lifecycle.Event.ON_CREATE;
            case CREATED:
                return Lifecycle.Event.ON_START;
            case STARTED:
                return Lifecycle.Event.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + state);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: android.arch.a.b.a<android.arch.lifecycle.i, android.arch.lifecycle.k$a> */
    /* JADX WARN: Multi-variable type inference failed */
    private void g(j jVar) {
        android.arch.a.b.b<i, a>.d aq = this.cd.aq();
        while (aq.hasNext() && !this.ci) {
            Map.Entry next = aq.next();
            a aVar = (a) next.getValue();
            while (aVar.ce.compareTo(this.ce) < 0 && !this.ci && this.cd.contains(next.getKey())) {
                c(aVar.ce);
                aVar.b(jVar, e(aVar.ce));
                aw();
            }
        }
    }

    private void h(j jVar) {
        Iterator<Map.Entry<i, a>> descendingIterator = this.cd.descendingIterator();
        while (descendingIterator.hasNext() && !this.ci) {
            Map.Entry<i, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.ce.compareTo(this.ce) > 0 && !this.ci && this.cd.contains(next.getKey())) {
                Lifecycle.Event d = d(value.ce);
                c(c(d));
                value.b(jVar, d);
                aw();
            }
        }
    }

    private void sync() {
        j jVar = this.cf.get();
        if (jVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!av()) {
            this.ci = false;
            if (this.ce.compareTo(this.cd.ar().getValue().ce) < 0) {
                h(jVar);
            }
            Map.Entry<i, a> as = this.cd.as();
            if (!this.ci && as != null && this.ce.compareTo(as.getValue().ce) > 0) {
                g(jVar);
            }
        }
        this.ci = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        Lifecycle.State ce;
        h cl;

        a(i iVar, Lifecycle.State state) {
            this.cl = m.i(iVar);
            this.ce = state;
        }

        void b(j jVar, Lifecycle.Event event) {
            Lifecycle.State c = k.c(event);
            this.ce = k.a(this.ce, c);
            this.cl.a(jVar, event);
            this.ce = c;
        }
    }
}
