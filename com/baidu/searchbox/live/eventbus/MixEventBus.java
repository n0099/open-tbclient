package com.baidu.searchbox.live.eventbus;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class MixEventBus {
    public static MixEventBus sInstance;
    public static ConcurrentHashMap<Object, CopyOnWriteArrayList<EventPoster>> sSubscriberMap;
    public MixEventBusCore eventBusCore;

    /* loaded from: classes4.dex */
    public static class Holder {
        public static final MixEventBus INSTANCE = new MixEventBus();
    }

    public MixEventBus() {
        sSubscriberMap = new ConcurrentHashMap<>();
        this.eventBusCore = new MixEventBusCore();
    }

    public static MixEventBus getInstance() {
        if (sInstance == null) {
            sInstance = Holder.INSTANCE;
        }
        return sInstance;
    }

    public void post(Object obj) {
        if (obj == null || sSubscriberMap.isEmpty()) {
            return;
        }
        this.eventBusCore.post(sSubscriberMap, obj);
    }

    public void unRegister(Object obj) {
        if (obj != null && !sSubscriberMap.isEmpty() && sSubscriberMap.containsKey(obj)) {
            this.eventBusCore.unRegister(sSubscriberMap, obj);
        }
    }

    public void register(Object obj, Class<?> cls, int i, EventAction eventAction) {
        if (obj != null && cls != null && eventAction != null && ThreadMode.isValid(i)) {
            this.eventBusCore.register(sSubscriberMap, obj, cls, i, eventAction);
        }
    }

    public synchronized void register(Object obj, Class<?> cls, EventAction eventAction) {
        register(obj, cls, 1, eventAction);
    }
}
