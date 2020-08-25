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
/* loaded from: classes5.dex */
public class k extends Lifecycle {
    private final WeakReference<j> zd;
    private android.arch.a.b.a<i, a> zb = new android.arch.a.b.a<>();
    private int ze = 0;
    private boolean zf = false;
    private boolean zg = false;
    private ArrayList<Lifecycle.State> zh = new ArrayList<>();
    private Lifecycle.State zc = Lifecycle.State.INITIALIZED;

    public k(@NonNull j jVar) {
        this.zd = new WeakReference<>(jVar);
    }

    @MainThread
    public void a(@NonNull Lifecycle.State state) {
        b(state);
    }

    public void b(@NonNull Lifecycle.Event event) {
        b(c(event));
    }

    private void b(Lifecycle.State state) {
        if (this.zc != state) {
            this.zc = state;
            if (this.zf || this.ze != 0) {
                this.zg = true;
                return;
            }
            this.zf = true;
            sync();
            this.zf = false;
        }
    }

    private boolean hw() {
        if (this.zb.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.zb.hs().getValue().zc;
        Lifecycle.State state2 = this.zb.ht().getValue().zc;
        return state == state2 && this.zc == state2;
    }

    private Lifecycle.State c(i iVar) {
        Map.Entry<i, a> j = this.zb.j(iVar);
        return a(a(this.zc, j != null ? j.getValue().zc : null), !this.zh.isEmpty() ? this.zh.get(this.zh.size() - 1) : null);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void a(@NonNull i iVar) {
        j jVar;
        a aVar = new a(iVar, this.zc == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.zb.c(iVar, aVar) == null && (jVar = this.zd.get()) != null) {
            boolean z = this.ze != 0 || this.zf;
            Lifecycle.State c = c(iVar);
            this.ze++;
            while (aVar.zc.compareTo(c) < 0 && this.zb.contains(iVar)) {
                c(aVar.zc);
                aVar.b(jVar, e(aVar.zc));
                hx();
                c = c(iVar);
            }
            if (!z) {
                sync();
            }
            this.ze--;
        }
    }

    private void hx() {
        this.zh.remove(this.zh.size() - 1);
    }

    private void c(Lifecycle.State state) {
        this.zh.add(state);
    }

    @Override // android.arch.lifecycle.Lifecycle
    public void b(@NonNull i iVar) {
        this.zb.remove(iVar);
    }

    @Override // android.arch.lifecycle.Lifecycle
    @NonNull
    public Lifecycle.State hv() {
        return this.zc;
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
        android.arch.a.b.b<i, a>.d hr = this.zb.hr();
        while (hr.hasNext() && !this.zg) {
            Map.Entry next = hr.next();
            a aVar = (a) next.getValue();
            while (aVar.zc.compareTo(this.zc) < 0 && !this.zg && this.zb.contains(next.getKey())) {
                c(aVar.zc);
                aVar.b(jVar, e(aVar.zc));
                hx();
            }
        }
    }

    private void h(j jVar) {
        Iterator<Map.Entry<i, a>> descendingIterator = this.zb.descendingIterator();
        while (descendingIterator.hasNext() && !this.zg) {
            Map.Entry<i, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.zc.compareTo(this.zc) > 0 && !this.zg && this.zb.contains(next.getKey())) {
                Lifecycle.Event d = d(value.zc);
                c(c(d));
                value.b(jVar, d);
                hx();
            }
        }
    }

    private void sync() {
        j jVar = this.zd.get();
        if (jVar == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!hw()) {
            this.zg = false;
            if (this.zc.compareTo(this.zb.hs().getValue().zc) < 0) {
                h(jVar);
            }
            Map.Entry<i, a> ht = this.zb.ht();
            if (!this.zg && ht != null && this.zc.compareTo(ht.getValue().zc) > 0) {
                g(jVar);
            }
        }
        this.zg = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        Lifecycle.State zc;
        h zj;

        a(i iVar, Lifecycle.State state) {
            this.zj = m.k(iVar);
            this.zc = state;
        }

        void b(j jVar, Lifecycle.Event event) {
            Lifecycle.State c = k.c(event);
            this.zc = k.a(this.zc, c);
            this.zj.a(jVar, event);
            this.zc = c;
        }
    }
}
