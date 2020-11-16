package android.arch.lifecycle;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
/* loaded from: classes14.dex */
public abstract class Lifecycle {

    /* loaded from: classes14.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    @MainThread
    public abstract void a(@NonNull i iVar);

    @MainThread
    public abstract void b(@NonNull i iVar);

    @NonNull
    @MainThread
    public abstract State hw();

    /* loaded from: classes14.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            return compareTo(state) >= 0;
        }
    }
}
