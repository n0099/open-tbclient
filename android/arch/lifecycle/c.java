package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends Lifecycle {
    private final b jw;
    private android.arch.a.a.a<Object, a> ju = new android.arch.a.a.a<>();
    private int jx = 0;
    private boolean jy = false;
    private boolean jz = false;
    private ArrayList<Lifecycle.State> jA = new ArrayList<>();
    private Lifecycle.State jv = Lifecycle.State.INITIALIZED;

    public c(@NonNull b bVar) {
        this.jw = bVar;
    }

    public void a(Lifecycle.State state) {
        this.jv = state;
    }

    public void a(Lifecycle.Event event) {
        this.jv = b(event);
        if (this.jy || this.jx != 0) {
            this.jz = true;
            return;
        }
        this.jy = true;
        sync();
        this.jy = false;
    }

    private boolean aQ() {
        if (this.ju.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.ju.aN().getValue().jv;
        Lifecycle.State state2 = this.ju.aO().getValue().jv;
        return state == state2 && this.jv == state2;
    }

    private void aR() {
        this.jA.remove(this.jA.size() - 1);
    }

    private void b(Lifecycle.State state) {
        this.jA.add(state);
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

    private void aS() {
        android.arch.a.a.b<Object, a>.d aM = this.ju.aM();
        while (aM.hasNext() && !this.jz) {
            Map.Entry next = aM.next();
            a aVar = (a) next.getValue();
            while (aVar.jv.compareTo(this.jv) < 0 && !this.jz && this.ju.contains(next.getKey())) {
                b(aVar.jv);
                aVar.b(this.jw, d(aVar.jv));
                aR();
            }
        }
    }

    private void aT() {
        Iterator<Map.Entry<Object, a>> descendingIterator = this.ju.descendingIterator();
        while (descendingIterator.hasNext() && !this.jz) {
            Map.Entry<Object, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.jv.compareTo(this.jv) > 0 && !this.jz && this.ju.contains(next.getKey())) {
                Lifecycle.Event c = c(value.jv);
                b(b(c));
                value.b(this.jw, c);
                aR();
            }
        }
    }

    private void sync() {
        while (!aQ()) {
            this.jz = false;
            if (this.jv.compareTo(this.ju.aN().getValue().jv) < 0) {
                aT();
            }
            Map.Entry<Object, a> aO = this.ju.aO();
            if (!this.jz && aO != null && this.jv.compareTo(aO.getValue().jv) > 0) {
                aS();
            }
        }
        this.jz = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        android.arch.lifecycle.a jD;
        Lifecycle.State jv;

        void b(b bVar, Lifecycle.Event event) {
            Lifecycle.State b = c.b(event);
            this.jv = c.a(this.jv, b);
            this.jD.a(bVar, event);
            this.jv = b;
        }
    }
}
