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
/* loaded from: classes6.dex */
public class k extends Lifecycle {
    private final WeakReference<j> cc;
    private android.arch.a.b.a<i, a> bX = new android.arch.a.b.a<>();
    private int cd = 0;
    private boolean ce = false;
    private boolean cf = false;
    private ArrayList<Lifecycle.State> ci = new ArrayList<>();
    private Lifecycle.State bY = Lifecycle.State.INITIALIZED;

    public k(@NonNull j jVar) {
        this.cc = new WeakReference<>(jVar);
    }

    @MainThread
    public void a(@NonNull Lifecycle.State state) {
        b(state);
    }

    public void b(@NonNull Lifecycle.Event event) {
        b(c(event));
    }

    private void b(Lifecycle.State state) {
        if (this.bY != state) {
            this.bY = state;
            if (this.ce || this.cd != 0) {
                this.cf = true;
                return;
            }
            this.ce = true;
            sync();
            this.ce = false;
        }
    }

    private boolean av() {
        if (this.bX.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.bX.ar().getValue().bY;
        Lifecycle.State state2 = this.bX.as().getValue().bY;
        return state == state2 && this.bY == state2;
    }

    private Lifecycle.State c(i iVar) {
        Map.Entry<i, a> h = this.bX.h(iVar);
        return a(a(this.bY, h != null ? h.getValue().bY : null), !this.ci.isEmpty() ? this.ci.get(this.ci.size() - 1) : null);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void a(@NonNull i iVar) {
        j jVar;
        a aVar = new a(iVar, this.bY == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.bX.c(iVar, aVar) == null && (jVar = this.cc.get()) != null) {
            boolean z = this.cd != 0 || this.ce;
            Lifecycle.State c = c(iVar);
            this.cd++;
            while (aVar.bY.compareTo(c) < 0 && this.bX.contains(iVar)) {
                c(aVar.bY);
                aVar.b(jVar, e(aVar.bY));
                aw();
                c = c(iVar);
            }
            if (!z) {
                sync();
            }
            this.cd--;
        }
    }

    private void aw() {
        this.ci.remove(this.ci.size() - 1);
    }

    private void c(Lifecycle.State state) {
        this.ci.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void b(@NonNull i iVar) {
        this.bX.remove(iVar);
    }

    @Override // android.arch.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State au() {
        return this.bY;
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
        android.arch.a.b.b<i, a>.d aq = this.bX.aq();
        while (aq.hasNext() && !this.cf) {
            Map.Entry next = aq.next();
            a aVar = (a) next.getValue();
            while (aVar.bY.compareTo(this.bY) < 0 && !this.cf && this.bX.contains(next.getKey())) {
                c(aVar.bY);
                aVar.b(jVar, e(aVar.bY));
                aw();
            }
        }
    }

    private void h(j jVar) {
        Iterator<Map.Entry<i, a>> descendingIterator = this.bX.descendingIterator();
        while (descendingIterator.hasNext() && !this.cf) {
            Map.Entry<i, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.bY.compareTo(this.bY) > 0 && !this.cf && this.bX.contains(next.getKey())) {
                Lifecycle.Event d = d(value.bY);
                c(c(d));
                value.b(jVar, d);
                aw();
            }
        }
    }

    private void sync() {
        j jVar = this.cc.get();
        if (jVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!av()) {
            this.cf = false;
            if (this.bY.compareTo(this.bX.ar().getValue().bY) < 0) {
                h(jVar);
            }
            Map.Entry<i, a> as = this.bX.as();
            if (!this.cf && as != null && this.bY.compareTo(as.getValue().bY) > 0) {
                g(jVar);
            }
        }
        this.cf = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        Lifecycle.State bY;
        h ck;

        a(i iVar, Lifecycle.State state) {
            this.ck = m.i(iVar);
            this.bY = state;
        }

        void b(j jVar, Lifecycle.Event event) {
            Lifecycle.State c = k.c(event);
            this.bY = k.a(this.bY, c);
            this.ck.a(jVar, event);
            this.bY = c;
        }
    }
}
