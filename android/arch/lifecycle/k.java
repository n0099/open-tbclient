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
/* loaded from: classes19.dex */
public class k extends Lifecycle {
    private final WeakReference<j> zu;
    private android.arch.a.b.a<i, a> zs = new android.arch.a.b.a<>();
    private int zv = 0;
    private boolean zw = false;
    private boolean zx = false;
    private ArrayList<Lifecycle.State> zy = new ArrayList<>();
    private Lifecycle.State zt = Lifecycle.State.INITIALIZED;

    public k(@NonNull j jVar) {
        this.zu = new WeakReference<>(jVar);
    }

    @MainThread
    public void a(@NonNull Lifecycle.State state) {
        b(state);
    }

    public void b(@NonNull Lifecycle.Event event) {
        b(c(event));
    }

    private void b(Lifecycle.State state) {
        if (this.zt != state) {
            this.zt = state;
            if (this.zw || this.zv != 0) {
                this.zx = true;
                return;
            }
            this.zw = true;
            sync();
            this.zw = false;
        }
    }

    private boolean hx() {
        if (this.zs.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.zs.ht().getValue().zt;
        Lifecycle.State state2 = this.zs.hu().getValue().zt;
        return state == state2 && this.zt == state2;
    }

    private Lifecycle.State c(i iVar) {
        Map.Entry<i, a> j = this.zs.j(iVar);
        return a(a(this.zt, j != null ? j.getValue().zt : null), !this.zy.isEmpty() ? this.zy.get(this.zy.size() - 1) : null);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void a(@NonNull i iVar) {
        j jVar;
        a aVar = new a(iVar, this.zt == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.zs.c(iVar, aVar) == null && (jVar = this.zu.get()) != null) {
            boolean z = this.zv != 0 || this.zw;
            Lifecycle.State c = c(iVar);
            this.zv++;
            while (aVar.zt.compareTo(c) < 0 && this.zs.contains(iVar)) {
                c(aVar.zt);
                aVar.b(jVar, e(aVar.zt));
                hy();
                c = c(iVar);
            }
            if (!z) {
                sync();
            }
            this.zv--;
        }
    }

    private void hy() {
        this.zy.remove(this.zy.size() - 1);
    }

    private void c(Lifecycle.State state) {
        this.zy.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void b(@NonNull i iVar) {
        this.zs.remove(iVar);
    }

    @Override // android.arch.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State hw() {
        return this.zt;
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
        android.arch.a.b.b<i, a>.d hs = this.zs.hs();
        while (hs.hasNext() && !this.zx) {
            Map.Entry next = hs.next();
            a aVar = (a) next.getValue();
            while (aVar.zt.compareTo(this.zt) < 0 && !this.zx && this.zs.contains(next.getKey())) {
                c(aVar.zt);
                aVar.b(jVar, e(aVar.zt));
                hy();
            }
        }
    }

    private void h(j jVar) {
        Iterator<Map.Entry<i, a>> descendingIterator = this.zs.descendingIterator();
        while (descendingIterator.hasNext() && !this.zx) {
            Map.Entry<i, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.zt.compareTo(this.zt) > 0 && !this.zx && this.zs.contains(next.getKey())) {
                Lifecycle.Event d = d(value.zt);
                c(c(d));
                value.b(jVar, d);
                hy();
            }
        }
    }

    private void sync() {
        j jVar = this.zu.get();
        if (jVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!hx()) {
            this.zx = false;
            if (this.zt.compareTo(this.zs.ht().getValue().zt) < 0) {
                h(jVar);
            }
            Map.Entry<i, a> hu = this.zs.hu();
            if (!this.zx && hu != null && this.zt.compareTo(hu.getValue().zt) > 0) {
                g(jVar);
            }
        }
        this.zx = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class a {
        h zA;
        Lifecycle.State zt;

        a(i iVar, Lifecycle.State state) {
            this.zA = m.k(iVar);
            this.zt = state;
        }

        void b(j jVar, Lifecycle.Event event) {
            Lifecycle.State c = k.c(event);
            this.zt = k.a(this.zt, c);
            this.zA.a(jVar, event);
            this.zt = c;
        }
    }
}
