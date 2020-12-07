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
/* loaded from: classes12.dex */
public class k extends Lifecycle {
    private final WeakReference<j> Al;
    private android.arch.a.b.a<i, a> Aj = new android.arch.a.b.a<>();
    private int Am = 0;
    private boolean An = false;
    private boolean Ao = false;
    private ArrayList<Lifecycle.State> Ap = new ArrayList<>();
    private Lifecycle.State Ak = Lifecycle.State.INITIALIZED;

    public k(@NonNull j jVar) {
        this.Al = new WeakReference<>(jVar);
    }

    @MainThread
    public void a(@NonNull Lifecycle.State state) {
        b(state);
    }

    public void b(@NonNull Lifecycle.Event event) {
        b(c(event));
    }

    private void b(Lifecycle.State state) {
        if (this.Ak != state) {
            this.Ak = state;
            if (this.An || this.Am != 0) {
                this.Ao = true;
                return;
            }
            this.An = true;
            sync();
            this.An = false;
        }
    }

    private boolean hx() {
        if (this.Aj.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.Aj.ht().getValue().Ak;
        Lifecycle.State state2 = this.Aj.hu().getValue().Ak;
        return state == state2 && this.Ak == state2;
    }

    private Lifecycle.State c(i iVar) {
        Map.Entry<i, a> j = this.Aj.j(iVar);
        return a(a(this.Ak, j != null ? j.getValue().Ak : null), !this.Ap.isEmpty() ? this.Ap.get(this.Ap.size() - 1) : null);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void a(@NonNull i iVar) {
        j jVar;
        a aVar = new a(iVar, this.Ak == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.Aj.c(iVar, aVar) == null && (jVar = this.Al.get()) != null) {
            boolean z = this.Am != 0 || this.An;
            Lifecycle.State c = c(iVar);
            this.Am++;
            while (aVar.Ak.compareTo(c) < 0 && this.Aj.contains(iVar)) {
                c(aVar.Ak);
                aVar.b(jVar, e(aVar.Ak));
                hy();
                c = c(iVar);
            }
            if (!z) {
                sync();
            }
            this.Am--;
        }
    }

    private void hy() {
        this.Ap.remove(this.Ap.size() - 1);
    }

    private void c(Lifecycle.State state) {
        this.Ap.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void b(@NonNull i iVar) {
        this.Aj.remove(iVar);
    }

    @Override // android.arch.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State hw() {
        return this.Ak;
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
        android.arch.a.b.b<i, a>.d hs = this.Aj.hs();
        while (hs.hasNext() && !this.Ao) {
            Map.Entry next = hs.next();
            a aVar = (a) next.getValue();
            while (aVar.Ak.compareTo(this.Ak) < 0 && !this.Ao && this.Aj.contains(next.getKey())) {
                c(aVar.Ak);
                aVar.b(jVar, e(aVar.Ak));
                hy();
            }
        }
    }

    private void h(j jVar) {
        Iterator<Map.Entry<i, a>> descendingIterator = this.Aj.descendingIterator();
        while (descendingIterator.hasNext() && !this.Ao) {
            Map.Entry<i, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.Ak.compareTo(this.Ak) > 0 && !this.Ao && this.Aj.contains(next.getKey())) {
                Lifecycle.Event d = d(value.Ak);
                c(c(d));
                value.b(jVar, d);
                hy();
            }
        }
    }

    private void sync() {
        j jVar = this.Al.get();
        if (jVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!hx()) {
            this.Ao = false;
            if (this.Ak.compareTo(this.Aj.ht().getValue().Ak) < 0) {
                h(jVar);
            }
            Map.Entry<i, a> hu = this.Aj.hu();
            if (!this.Ao && hu != null && this.Ak.compareTo(hu.getValue().Ak) > 0) {
                g(jVar);
            }
        }
        this.Ao = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        Lifecycle.State Ak;
        h Ar;

        a(i iVar, Lifecycle.State state) {
            this.Ar = m.k(iVar);
            this.Ak = state;
        }

        void b(j jVar, Lifecycle.Event event) {
            Lifecycle.State c = k.c(event);
            this.Ak = k.a(this.Ak, c);
            this.Ar.a(jVar, event);
            this.Ak = c;
        }
    }
}
