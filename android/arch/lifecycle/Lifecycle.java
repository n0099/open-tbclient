package android.arch.lifecycle;
/* loaded from: classes2.dex */
public abstract class Lifecycle {

    /* loaded from: classes2.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* loaded from: classes2.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(State state) {
            return compareTo(state) >= 0;
        }
    }
}
