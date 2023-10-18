package com.baidu.searchbox.live.eventbus;
/* loaded from: classes4.dex */
public class EventPoster {
    public Class<?> eventType;
    public IActionHandler handler;
    public EventAction mAction;
    public volatile int threadMode;

    public EventPoster(int i, Class<?> cls, EventAction eventAction, IActionHandler iActionHandler) {
        this.threadMode = i;
        this.eventType = cls;
        this.mAction = eventAction;
        this.handler = iActionHandler;
    }

    public void call(Object obj) {
        if (this.mAction != null) {
            this.handler.execute(this.threadMode, obj, this.mAction);
        }
    }

    public boolean isSupport(Object obj) {
        if (obj.getClass() == this.eventType) {
            return true;
        }
        return false;
    }

    public void clear() {
        this.threadMode = 1;
        this.mAction = null;
    }
}
