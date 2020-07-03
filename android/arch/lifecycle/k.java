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
    private final WeakReference<j> yE;
    private android.arch.a.b.a<i, a> yC = new android.arch.a.b.a<>();
    private int yF = 0;
    private boolean yG = false;
    private boolean yH = false;
    private ArrayList<Lifecycle.State> yI = new ArrayList<>();
    private Lifecycle.State yD = Lifecycle.State.INITIALIZED;

    public k(@NonNull j jVar) {
        this.yE = new WeakReference<>(jVar);
    }

    @MainThread
    public void a(@NonNull Lifecycle.State state) {
        b(state);
    }

    public void b(@NonNull Lifecycle.Event event) {
        b(c(event));
    }

    private void b(Lifecycle.State state) {
        if (this.yD != state) {
            this.yD = state;
            if (this.yG || this.yF != 0) {
                this.yH = true;
                return;
            }
            this.yG = true;
            sync();
            this.yG = false;
        }
    }

    private boolean gi() {
        if (this.yC.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.yC.ge().getValue().yD;
        Lifecycle.State state2 = this.yC.gf().getValue().yD;
        return state == state2 && this.yD == state2;
    }

    private Lifecycle.State c(i iVar) {
        Map.Entry<i, a> i = this.yC.i(iVar);
        return a(a(this.yD, i != null ? i.getValue().yD : null), !this.yI.isEmpty() ? this.yI.get(this.yI.size() - 1) : null);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void a(@NonNull i iVar) {
        j jVar;
        a aVar = new a(iVar, this.yD == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.yC.c(iVar, aVar) == null && (jVar = this.yE.get()) != null) {
            boolean z = this.yF != 0 || this.yG;
            Lifecycle.State c = c(iVar);
            this.yF++;
            while (aVar.yD.compareTo(c) < 0 && this.yC.contains(iVar)) {
                c(aVar.yD);
                aVar.b(jVar, e(aVar.yD));
                gj();
                c = c(iVar);
            }
            if (!z) {
                sync();
            }
            this.yF--;
        }
    }

    private void gj() {
        this.yI.remove(this.yI.size() - 1);
    }

    private void c(Lifecycle.State state) {
        this.yI.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void b(@NonNull i iVar) {
        this.yC.remove(iVar);
    }

    @Override // android.arch.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State gh() {
        return this.yD;
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
        android.arch.a.b.b<i, a>.d gd = this.yC.gd();
        while (gd.hasNext() && !this.yH) {
            Map.Entry next = gd.next();
            a aVar = (a) next.getValue();
            while (aVar.yD.compareTo(this.yD) < 0 && !this.yH && this.yC.contains(next.getKey())) {
                c(aVar.yD);
                aVar.b(jVar, e(aVar.yD));
                gj();
            }
        }
    }

    private void h(j jVar) {
        Iterator<Map.Entry<i, a>> descendingIterator = this.yC.descendingIterator();
        while (descendingIterator.hasNext() && !this.yH) {
            Map.Entry<i, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.yD.compareTo(this.yD) > 0 && !this.yH && this.yC.contains(next.getKey())) {
                Lifecycle.Event d = d(value.yD);
                c(c(d));
                value.b(jVar, d);
                gj();
            }
        }
    }

    private void sync() {
        j jVar = this.yE.get();
        if (jVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!gi()) {
            this.yH = false;
            if (this.yD.compareTo(this.yC.ge().getValue().yD) < 0) {
                h(jVar);
            }
            Map.Entry<i, a> gf = this.yC.gf();
            if (!this.yH && gf != null && this.yD.compareTo(gf.getValue().yD) > 0) {
                g(jVar);
            }
        }
        this.yH = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        Lifecycle.State yD;
        h yK;

        a(i iVar, Lifecycle.State state) {
            this.yK = m.j(iVar);
            this.yD = state;
        }

        void b(j jVar, Lifecycle.Event event) {
            Lifecycle.State c = k.c(event);
            this.yD = k.a(this.yD, c);
            this.yK.a(jVar, event);
            this.yD = c;
        }
    }
}
