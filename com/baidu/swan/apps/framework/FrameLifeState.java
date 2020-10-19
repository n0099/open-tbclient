package com.baidu.swan.apps.framework;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public enum FrameLifeState {
    INACTIVATED,
    JUST_CREATED,
    JUST_STARTED,
    JUST_RESUMED;

    public final int activatedLevel() {
        return ordinal();
    }

    public final boolean moreActiveThan(@NonNull FrameLifeState frameLifeState) {
        return compareTo(frameLifeState) > 0;
    }

    public final boolean noMoreActiveThan(@NonNull FrameLifeState frameLifeState) {
        return !moreActiveThan(frameLifeState);
    }

    public final boolean moreInactiveThan(@NonNull FrameLifeState frameLifeState) {
        return compareTo(frameLifeState) < 0;
    }

    public final boolean noMoreInactiveThan(@NonNull FrameLifeState frameLifeState) {
        return !moreInactiveThan(frameLifeState);
    }

    public final boolean hasCreated() {
        return noMoreInactiveThan(JUST_CREATED);
    }

    public final boolean hasStarted() {
        return noMoreInactiveThan(JUST_STARTED);
    }

    public final boolean hasResumed() {
        return noMoreInactiveThan(JUST_RESUMED);
    }

    public final boolean inactivated() {
        return !activated();
    }

    public final boolean activated() {
        return moreActiveThan(INACTIVATED);
    }
}
