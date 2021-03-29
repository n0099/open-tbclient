package com.baidu.apollon.eventbus;
/* loaded from: classes.dex */
public final class EventBus {
    public static final String DEFAULT_METHOD_NAME = "onModuleEvent";
    public static EventBus mEventBusInstance;
    public static b mEventController;

    /* loaded from: classes.dex */
    public class Event {
        public String mEventKey;
        public Object mEventObj;

        public Event(String str, Object obj) {
            this.mEventKey = str;
            this.mEventObj = obj;
        }
    }

    /* loaded from: classes.dex */
    public enum ThreadMode {
        PostThread,
        MainThread,
        Async
    }

    public EventBus() {
        mEventController = new b();
    }

    public static EventBus getInstance() {
        if (mEventBusInstance == null) {
            synchronized (EventBus.class) {
                if (mEventBusInstance == null) {
                    mEventBusInstance = new EventBus();
                }
            }
        }
        return mEventBusInstance;
    }

    public void cancelEventDelivery(Event event) {
        mEventController.c(event);
    }

    public void post(Event event) {
        mEventController.a(event);
    }

    public void postStickyEvent(Event event) {
        mEventController.b(event);
    }

    public void register(Object obj, String str, int i, ThreadMode threadMode) {
        mEventController.a(obj, str, i, false, threadMode);
    }

    public void registerSticky(Object obj, String str, int i, ThreadMode threadMode) {
        mEventController.a(obj, str, i, true, threadMode);
    }

    public void removeAllStickyEvents() {
        mEventController.a();
    }

    public void removeStickyEvent(String str) {
        mEventController.a(str);
    }

    public synchronized void unregister(Object obj) {
        mEventController.a(obj);
    }

    public void register(Object obj, String[] strArr, int i, ThreadMode threadMode) {
        mEventController.a(obj, strArr, i, false, threadMode);
    }

    public synchronized void unregister(Object obj, String str) {
        mEventController.a(obj, str);
    }

    public synchronized void unregister(Object obj, String[] strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            mEventController.a(obj, str);
        }
    }
}
