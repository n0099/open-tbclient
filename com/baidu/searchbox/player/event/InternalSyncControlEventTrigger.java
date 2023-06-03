package com.baidu.searchbox.player.event;
/* loaded from: classes4.dex */
public class InternalSyncControlEventTrigger extends SingleTargetTrigger {
    public void pause() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_PAUSE);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }

    public void prepare() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_PREPARE);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }

    public void resume() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_RESUME);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }

    public void start() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_START);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }

    public void stop() {
        VideoEvent obtainEvent = ControlEvent.obtainEvent(InternalSyncControlEvent.INTERNAL_ACTION_STOP);
        obtainEvent.setPriority(1);
        triggerEvent(obtainEvent);
    }
}
