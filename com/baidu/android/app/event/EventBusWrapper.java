package com.baidu.android.app.event;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import rx.a.b.a;
import rx.d;
import rx.functions.b;
import rx.g;
import rx.schedulers.Schedulers;
/* loaded from: classes2.dex */
public final class EventBusWrapper {
    public static final boolean DEBUG = false;
    private static final int LAZY_POST_MSG = 2;
    private static final Handler LAZY_SUBSCRIBE_HANDLER;
    private static final int LAZY_SUBSCRIBE_MSG = 1;
    private static final String TAG = "EventBusWrapper";
    private static final int THREAD_MODE_BACKGROUND = 1;
    private static final int THREAD_MODE_CURRENT = 2;
    private static final int THREAD_MODE_MAIN = 0;
    private static ConcurrentHashMap<Object, ConcurrentLinkedQueue<LazySubscriber>> sLazySubscribers = new ConcurrentHashMap<>();

    static {
        HandlerThread handlerThread = new HandlerThread(RxBus.TAG);
        handlerThread.start();
        LAZY_SUBSCRIBE_HANDLER = new Handler(handlerThread.getLooper()) { // from class: com.baidu.android.app.event.EventBusWrapper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    EventBusWrapper.registerLazySubscribers();
                } else if (message.what == 2) {
                    EventBusWrapper.post(message.obj);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LazySubscriber {
        final b action;
        final int mode;
        final Class type;

        LazySubscriber(Class cls, b bVar, int i) {
            this.type = cls;
            this.action = bVar;
            this.mode = i;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            return this.type.equals(((LazySubscriber) obj).type);
        }
    }

    private EventBusWrapper() {
    }

    public static <T> d<T> register(Object obj, Class<T> cls) {
        return RxBus.get().isRegistered(obj, cls) ? d.cOj() : RxBus.get().register(obj, cls);
    }

    public static <T> void register(Object obj, Class<T> cls, b<T> bVar) {
        register(obj, cls, bVar, 2);
    }

    private static <T> void register(Object obj, Class<T> cls, b<T> bVar, int i) {
        if (obj != null && cls != null && bVar != null && !RxBus.get().isRegistered(obj, cls)) {
            b<Throwable> bVar2 = new b<Throwable>() { // from class: com.baidu.android.app.event.EventBusWrapper.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(Throwable th) {
                }
            };
            d<T> register = RxBus.get().register(obj, cls);
            if (i == 0) {
                register.a(a.cOs()).b(bVar).a(bVar2).cOm().cOa();
            } else if (i == 1) {
                register.a(Schedulers.computation()).b(bVar).a(bVar2).cOm().cOa();
            } else if (i == 2) {
                register.b(bVar).a(bVar2).cOm().cOa();
            } else {
                register.b(bVar).a(bVar2).cOm().cOa();
            }
        }
    }

    public static <T> void register(Object obj, Class<T> cls, g gVar, b bVar) {
        if (obj != null && cls != null && bVar != null && gVar != null && !RxBus.get().isRegistered(obj, cls)) {
            RxBus.get().register(obj, cls).a(gVar).b(bVar).a(new b<Throwable>() { // from class: com.baidu.android.app.event.EventBusWrapper.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // rx.functions.b
                public void call(Throwable th) {
                }
            }).cOm().cOa();
        }
    }

    public static synchronized void unregister(Object obj) {
        ConcurrentLinkedQueue<LazySubscriber> remove;
        synchronized (EventBusWrapper.class) {
            if (obj != null) {
                if (sLazySubscribers.size() > 0 && (remove = sLazySubscribers.remove(obj)) != null) {
                    remove.clear();
                }
                RxBus.get().unregister(obj);
            }
        }
    }

    public static void post(Object obj) {
        if (sLazySubscribers.size() > 0) {
            LAZY_SUBSCRIBE_HANDLER.removeMessages(1);
            registerLazySubscribers();
        }
        RxBus.get().post(obj);
    }

    public static <T> d<T> registerOnMainThread(Object obj, Class<T> cls) {
        if (RxBus.get().isRegistered(obj, cls)) {
            return d.cOj();
        }
        d register = register(obj, cls);
        if (register != null) {
            return register.a(a.cOs());
        }
        return null;
    }

    public static <T> void registerOnMainThread(Object obj, Class<T> cls, b<T> bVar) {
        register(obj, cls, bVar, 0);
    }

    public static <T> void lazyRegisterOnMainThread(Object obj, Class<T> cls, b<T> bVar) {
        lazyRegister(obj, cls, bVar, 0);
    }

    public static <T> void lazyRegisterOnBackgroundThread(Object obj, Class<T> cls, b<T> bVar) {
        lazyRegister(obj, cls, bVar, 1);
    }

    public static <T> void lazyRegister(Object obj, Class<T> cls, b<T> bVar) {
        lazyRegister(obj, cls, bVar, 2);
    }

    private static <T> void lazyRegister(Object obj, Class<T> cls, b<T> bVar, int i) {
        ConcurrentLinkedQueue<LazySubscriber> concurrentLinkedQueue;
        if (obj != null && cls != null && bVar != null) {
            ConcurrentLinkedQueue<LazySubscriber> concurrentLinkedQueue2 = sLazySubscribers.get(obj);
            if (concurrentLinkedQueue2 == null && (concurrentLinkedQueue2 = sLazySubscribers.putIfAbsent(obj, (concurrentLinkedQueue = new ConcurrentLinkedQueue<>()))) == null) {
                concurrentLinkedQueue2 = concurrentLinkedQueue;
            }
            LazySubscriber lazySubscriber = new LazySubscriber(cls, bVar, i);
            if (!concurrentLinkedQueue2.contains(lazySubscriber)) {
                concurrentLinkedQueue2.add(lazySubscriber);
            }
            LAZY_SUBSCRIBE_HANDLER.sendEmptyMessage(1);
        }
    }

    public static <T> d<T> registerOnBackgroundThread(Object obj, Class<T> cls) {
        if (RxBus.get().isRegistered(obj, cls)) {
            return d.cOj();
        }
        d register = register(obj, cls);
        if (register != null) {
            return register.a(Schedulers.computation());
        }
        return null;
    }

    public static <T> void registerOnBackgroundThread(Object obj, Class<T> cls, b<T> bVar) {
        register(obj, cls, bVar, 1);
    }

    public static void lazyPost(Object obj) {
        LAZY_SUBSCRIBE_HANDLER.sendMessage(LAZY_SUBSCRIBE_HANDLER.obtainMessage(2, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void registerLazySubscribers() {
        if (sLazySubscribers.size() > 0) {
            for (Map.Entry<Object, ConcurrentLinkedQueue<LazySubscriber>> entry : sLazySubscribers.entrySet()) {
                try {
                    ConcurrentLinkedQueue<LazySubscriber> value = entry.getValue();
                    while (value != null && !value.isEmpty()) {
                        LazySubscriber peek = value.peek();
                        if (peek != null) {
                            register(entry.getKey(), peek.type, peek.action, peek.mode);
                            value.remove(peek);
                        }
                    }
                    sLazySubscribers.remove(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                }
            }
        }
    }
}
