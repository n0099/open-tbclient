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
    private final WeakReference<j> ye;
    private android.arch.a.b.a<i, a> yc = new android.arch.a.b.a<>();
    private int yf = 0;
    private boolean yg = false;
    private boolean yh = false;
    private ArrayList<Lifecycle.State> yi = new ArrayList<>();
    private Lifecycle.State yd = Lifecycle.State.INITIALIZED;

    public k(@NonNull j jVar) {
        this.ye = new WeakReference<>(jVar);
    }

    @MainThread
    public void a(@NonNull Lifecycle.State state) {
        b(state);
    }

    public void b(@NonNull Lifecycle.Event event) {
        b(c(event));
    }

    private void b(Lifecycle.State state) {
        if (this.yd != state) {
            this.yd = state;
            if (this.yg || this.yf != 0) {
                this.yh = true;
                return;
            }
            this.yg = true;
            sync();
            this.yg = false;
        }
    }

    private boolean fR() {
        if (this.yc.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.yc.fN().getValue().yd;
        Lifecycle.State state2 = this.yc.fO().getValue().yd;
        return state == state2 && this.yd == state2;
    }

    private Lifecycle.State c(i iVar) {
        Map.Entry<i, a> h = this.yc.h(iVar);
        return a(a(this.yd, h != null ? h.getValue().yd : null), !this.yi.isEmpty() ? this.yi.get(this.yi.size() - 1) : null);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void a(@NonNull i iVar) {
        j jVar;
        a aVar = new a(iVar, this.yd == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.yc.c(iVar, aVar) == null && (jVar = this.ye.get()) != null) {
            boolean z = this.yf != 0 || this.yg;
            Lifecycle.State c = c(iVar);
            this.yf++;
            while (aVar.yd.compareTo(c) < 0 && this.yc.contains(iVar)) {
                c(aVar.yd);
                aVar.b(jVar, e(aVar.yd));
                fS();
                c = c(iVar);
            }
            if (!z) {
                sync();
            }
            this.yf--;
        }
    }

    private void fS() {
        this.yi.remove(this.yi.size() - 1);
    }

    private void c(Lifecycle.State state) {
        this.yi.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void b(@NonNull i iVar) {
        this.yc.remove(iVar);
    }

    @Override // android.arch.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State fQ() {
        return this.yd;
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
        android.arch.a.b.b<i, a>.d fM = this.yc.fM();
        while (fM.hasNext() && !this.yh) {
            Map.Entry next = fM.next();
            a aVar = (a) next.getValue();
            while (aVar.yd.compareTo(this.yd) < 0 && !this.yh && this.yc.contains(next.getKey())) {
                c(aVar.yd);
                aVar.b(jVar, e(aVar.yd));
                fS();
            }
        }
    }

    private void h(j jVar) {
        Iterator<Map.Entry<i, a>> descendingIterator = this.yc.descendingIterator();
        while (descendingIterator.hasNext() && !this.yh) {
            Map.Entry<i, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.yd.compareTo(this.yd) > 0 && !this.yh && this.yc.contains(next.getKey())) {
                Lifecycle.Event d = d(value.yd);
                c(c(d));
                value.b(jVar, d);
                fS();
            }
        }
    }

    private void sync() {
        j jVar = this.ye.get();
        if (jVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!fR()) {
            this.yh = false;
            if (this.yd.compareTo(this.yc.fN().getValue().yd) < 0) {
                h(jVar);
            }
            Map.Entry<i, a> fO = this.yc.fO();
            if (!this.yh && fO != null && this.yd.compareTo(fO.getValue().yd) > 0) {
                g(jVar);
            }
        }
        this.yh = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        Lifecycle.State yd;
        h yk;

        a(i iVar, Lifecycle.State state) {
            this.yk = m.i(iVar);
            this.yd = state;
        }

        void b(j jVar, Lifecycle.Event event) {
            Lifecycle.State c = k.c(event);
            this.yd = k.a(this.yd, c);
            this.yk.a(jVar, event);
            this.yd = c;
        }
    }
}
