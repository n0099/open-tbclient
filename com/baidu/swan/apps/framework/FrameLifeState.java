package com.baidu.swan.apps.framework;

import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public enum FrameLifeState {
    INACTIVATED,
    JUST_CREATED,
    JUST_STARTED,
    JUST_RESUMED;

    public final boolean activated() {
        return moreActiveThan(INACTIVATED);
    }

    public final int activatedLevel() {
        return ordinal();
    }

    public final boolean hasCreated() {
        return noMoreInactiveThan(JUST_CREATED);
    }

    public final boolean hasResumed() {
        return noMoreInactiveThan(JUST_RESUMED);
    }

    public final boolean hasStarted() {
        return noMoreInactiveThan(JUST_STARTED);
    }

    public final boolean inactivated() {
        return !activated();
    }

    public final boolean moreActiveThan(@NonNull FrameLifeState frameLifeState) {
        return compareTo(frameLifeState) > 0;
    }

    public final boolean moreInactiveThan(@NonNull FrameLifeState frameLifeState) {
        return compareTo(frameLifeState) < 0;
    }

    public final boolean noMoreActiveThan(@NonNull FrameLifeState frameLifeState) {
        return !moreActiveThan(frameLifeState);
    }

    public final boolean noMoreInactiveThan(@NonNull FrameLifeState frameLifeState) {
        return !moreInactiveThan(frameLifeState);
    }
}
