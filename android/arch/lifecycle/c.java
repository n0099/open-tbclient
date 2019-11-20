package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class c extends Lifecycle {
    private final b bF;
    private android.arch.a.a.a<Object, a> bD = new android.arch.a.a.a<>();
    private int bG = 0;
    private boolean bH = false;
    private boolean bI = false;
    private ArrayList<Lifecycle.State> bJ = new ArrayList<>();
    private Lifecycle.State bE = Lifecycle.State.INITIALIZED;

    public c(@NonNull b bVar) {
        this.bF = bVar;
    }

    public void a(Lifecycle.State state) {
        this.bE = state;
    }

    public void a(Lifecycle.Event event) {
        this.bE = b(event);
        if (this.bH || this.bG != 0) {
            this.bI = true;
            return;
        }
        this.bH = true;
        ax();
        this.bH = false;
    }

    private boolean at() {
        if (this.bD.size() == 0) {
            return true;
        }
        Lifecycle.State state = this.bD.aq().getValue().bE;
        Lifecycle.State state2 = this.bD.ar().getValue().bE;
        return state == state2 && this.bE == state2;
    }

    private void au() {
        this.bJ.remove(this.bJ.size() - 1);
    }

    private void b(Lifecycle.State state) {
        this.bJ.add(state);
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
        android.arch.a.a.b<Object, a>.d ap = this.bD.ap();
        while (ap.hasNext() && !this.bI) {
            Map.Entry next = ap.next();
            a aVar = (a) next.getValue();
            while (aVar.bE.compareTo(this.bE) < 0 && !this.bI && this.bD.contains(next.getKey())) {
                b(aVar.bE);
                aVar.b(this.bF, d(aVar.bE));
                au();
            }
        }
    }

    private void aw() {
        Iterator<Map.Entry<Object, a>> descendingIterator = this.bD.descendingIterator();
        while (descendingIterator.hasNext() && !this.bI) {
            Map.Entry<Object, a> next = descendingIterator.next();
            a value = next.getValue();
            while (value.bE.compareTo(this.bE) > 0 && !this.bI && this.bD.contains(next.getKey())) {
                Lifecycle.Event c = c(value.bE);
                b(b(c));
                value.b(this.bF, c);
                au();
            }
        }
    }

    private void ax() {
        while (!at()) {
            this.bI = false;
            if (this.bE.compareTo(this.bD.aq().getValue().bE) < 0) {
                aw();
            }
            Map.Entry<Object, a> ar = this.bD.ar();
            if (!this.bI && ar != null && this.bE.compareTo(ar.getValue().bE) > 0) {
                av();
            }
        }
        this.bI = false;
    }

    static Lifecycle.State a(@NonNull Lifecycle.State state, @Nullable Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        Lifecycle.State bE;
        android.arch.lifecycle.a bM;

        void b(b bVar, Lifecycle.Event event) {
            Lifecycle.State b = c.b(event);
            this.bE = c.a(this.bE, b);
            this.bM.a(bVar, event);
            this.bE = b;
        }
    }
}
