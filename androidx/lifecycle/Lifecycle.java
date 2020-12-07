package androidx.lifecycle;

import android.support.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes19.dex */
public interface Lifecycle {
    @NonNull
    public static final AtomicReference<Object> AX = new AtomicReference<>();

    /* loaded from: classes19.dex */
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
