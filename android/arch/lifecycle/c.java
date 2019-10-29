package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends Lifecycle {
    private final b ch;
    private android.arch.a.a.a<Object, a> cf = new android.arch.a.a.a<>();
    private int ci = 0;
    private boolean cj = false;
    private boolean ck = false;
    private ArrayList<Lifecycle.State> cl = new ArrayList<>();
    private Lifecycle.State cg = Lifecycle.State.INITIALIZED;

    public c(@NonNull b bVar) {
        this.ch = bVar;
    }

    public void a(Lifecycle.State state) {
        this.cg = state;
    }

    public void a(Lifecycle.Event event) {
        this.cg = b(event);
        if (this.cj || this.ci != 0) {
            this.ck = true;
            return;
        }
        this.cj = true;
        ax();
        this.cj = false;
    }

    private boolean at() {
        if (this.cf.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.cf.aq().getValue().cg;
        Lifecycle.State state2 = this.cf.ar().getValue().cg;
        return state == state2 && this.cg == state2;
    }

    private void au() {
        this.cl.remove(this.cl.size() - 1);
    }

    private void b(Lifecycle.State state) {
        this.cl.add(state);
    }

    static Lifecycle.State b(Lifecycle.Event event) {
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

    private static Lifecycle.Event c(Lifecycle.State state) {
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

    private static Lifecycle.Event d(Lifecycle.State state) {
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

    private void av() {
        android.arch.a.a.b<Object, a>.d ap = this.cf.ap();
        while (ap.hasNext() && !this.ck) {
            Map.Entry next = ap.next();
            a aVar = (a) next.getValue();
            while (aVar.cg.compareTo(this.cg) < 0 && !this.ck && this.cf.contains(next.getKey())) {
                b(aVar.cg);
                aVar.b(this.ch, d(aVar.cg));
                au();
            }
        }
    }

    private void aw() {
        Iterator<Map.Entry<Object, a>> descendingIterator = this.cf.descendingIterator();
        while (descendingIterator.hasNext() && !this.ck) {
            Map.Entry<Object, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.cg.compareTo(this.cg) > 0 && !this.ck && this.cf.contains(next.getKey())) {
                Lifecycle.Event c = c(value.cg);
                b(b(c));
                value.b(this.ch, c);
                au();
            }
        }
    }

    private void ax() {
        while (!at()) {
            this.ck = false;
            if (this.cg.compareTo(this.cf.aq().getValue().cg) < 0) {
                aw();
            }
            Map.Entry<Object, a> ar = this.cf.ar();
            if (!this.ck && ar != null && this.cg.compareTo(ar.getValue().cg) > 0) {
                av();
            }
        }
        this.ck = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        Lifecycle.State cg;
        android.arch.lifecycle.a co;

        void b(b bVar, Lifecycle.Event event) {
            Lifecycle.State b = c.b(event);
            this.cg = c.a(this.cg, b);
            this.co.a(bVar, event);
            this.cg = b;
        }
    }
}
