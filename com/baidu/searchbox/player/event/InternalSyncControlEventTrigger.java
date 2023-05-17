package com.baidu.searchbox.player.event;

import com.baidu.searchbox.player.annotation.PublicMethod;
/* loaded from: classes3.dex */
public class InternalSyncControlEventTrigger extends SingleTargetTrigger {
    @PublicMethod
    public void pause() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_PAUSE);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void prepare() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_PREPARE);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void resume() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_RESUME);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void start() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_START);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }

    @PublicMethod
    public void stop() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_STOP);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }
}
