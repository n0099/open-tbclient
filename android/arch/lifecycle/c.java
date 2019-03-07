package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends Lifecycle {
    private final b jy;
    private android.arch.a.a.a<Object, a> jw = new android.arch.a.a.a<>();
    private int jz = 0;
    private boolean jA = false;
    private boolean jB = false;
    private ArrayList<Lifecycle.State> jC = new ArrayList<>();
    private Lifecycle.State jx = Lifecycle.State.INITIALIZED;

    public c(@NonNull b bVar) {
        this.jy = bVar;
    }

    public void a(Lifecycle.State state) {
        this.jx = state;
    }

    public void a(Lifecycle.Event event) {
        this.jx = b(event);
        if (this.jA || this.jz != 0) {
            this.jB = true;
            return;
        }
        this.jA = true;
        sync();
        this.jA = false;
    }

    private boolean aQ() {
        if (this.jw.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.jw.aN().getValue().jx;
        Lifecycle.State state2 = this.jw.aO().getValue().jx;
        return state == state2 && this.jx == state2;
    }

    private void aR() {
        this.jC.remove(this.jC.size() - 1);
    }

    private void b(Lifecycle.State state) {
        this.jC.add(state);
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
        android.arch.a.a.b<Object, a>.d aM = this.jw.aM();
        while (aM.hasNext() && !this.jB) {
            Map.Entry next = aM.next();
            a aVar = (a) next.getValue();
            while (aVar.jx.compareTo(this.jx) < 0 && !this.jB && this.jw.contains(next.getKey())) {
                b(aVar.jx);
                aVar.b(this.jy, d(aVar.jx));
                aR();
            }
        }
    }

    private void aT() {
        Iterator<Map.Entry<Object, a>> descendingIterator = this.jw.descendingIterator();
        while (descendingIterator.hasNext() && !this.jB) {
            Map.Entry<Object, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.jx.compareTo(this.jx) > 0 && !this.jB && this.jw.contains(next.getKey())) {
                Lifecycle.Event c = c(value.jx);
                b(b(c));
                value.b(this.jy, c);
                aR();
            }
        }
    }

    private void sync() {
        while (!aQ()) {
            this.jB = false;
            if (this.jx.compareTo(this.jw.aN().getValue().jx) < 0) {
                aT();
            }
            Map.Entry<Object, a> aO = this.jw.aO();
            if (!this.jB && aO != null && this.jx.compareTo(aO.getValue().jx) > 0) {
                aS();
            }
        }
        this.jB = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        android.arch.lifecycle.a jF;
        Lifecycle.State jx;

        void b(b bVar, Lifecycle.Event event) {
            Lifecycle.State b = c.b(event);
            this.jx = c.a(this.jx, b);
            this.jF.a(bVar, event);
            this.jx = b;
        }
    }
}
