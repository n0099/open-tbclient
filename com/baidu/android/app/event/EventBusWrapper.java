package com.baidu.android.app.event;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import h.d;
import h.g;
import h.l.b.a;
import h.n.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import rx.schedulers.Schedulers;
/* loaded from: classes.dex */
public final class EventBusWrapper {
    public static final boolean DEBUG = false;
    public static final int LAZY_POST_MSG = 2;
    public static final Handler LAZY_SUBSCRIBE_HANDLER;
    public static final int LAZY_SUBSCRIBE_MSG = 1;
    public static final String TAG = "EventBusWrapper";
    public static final int THREAD_MODE_BACKGROUND = 1;
    public static final int THREAD_MODE_CURRENT = 2;
    public static final int THREAD_MODE_MAIN = 0;
    public static ConcurrentHashMap<Object, ConcurrentLinkedQueue<LazySubscriber>> sLazySubscribers = new ConcurrentHashMap<>();

    /* loaded from: classes.dex */
    public static class LazySubscriber {
        public final b action;
        public final int mode;
        public final Class type;

        public LazySubscriber(Class cls, b bVar, int i) {
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

    static {
        HandlerThread handlerThread = new HandlerThread(RxBus.TAG);
        handlerThread.start();
        LAZY_SUBSCRIBE_HANDLER = new Handler(handlerThread.getLooper()) { // from class: com.baidu.android.app.event.EventBusWrapper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    EventBusWrapper.registerLazySubscribers();
                } else if (i == 2) {
                    EventBusWrapper.post(message.obj);
                }
            }
        };
    }

    public static void lazyPost(Object obj) {
        Handler handler = LAZY_SUBSCRIBE_HANDLER;
        handler.sendMessage(handler.obtainMessage(2, obj));
    }

    public static <T> void lazyRegister(Object obj, Class<T> cls, b<T> bVar) {
        lazyRegister(obj, cls, bVar, 2);
    }

    public static <T> void lazyRegisterOnBackgroundThread(Object obj, Class<T> cls, b<T> bVar) {
        lazyRegister(obj, cls, bVar, 1);
    }

    public static <T> void lazyRegisterOnMainThread(Object obj, Class<T> cls, b<T> bVar) {
        lazyRegister(obj, cls, bVar, 0);
    }

    public static void post(Object obj) {
        if (sLazySubscribers.size() > 0) {
            LAZY_SUBSCRIBE_HANDLER.removeMessages(1);
            registerLazySubscribers();
        }
        RxBus.get().post(obj);
    }

    public static <T> d<T> register(Object obj, Class<T> cls) {
        if (RxBus.get().isRegistered(obj, cls)) {
            return d.o();
        }
        return RxBus.get().register(obj, cls);
    }

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
                } catch (Exception unused) {
                }
            }
        }
    }

    public static <T> d<T> registerOnBackgroundThread(Object obj, Class<T> cls) {
        if (RxBus.get().isRegistered(obj, cls)) {
            return d.o();
        }
        d register = register(obj, cls);
        if (register != null) {
            return register.p(Schedulers.computation());
        }
        return null;
    }

    public static <T> d<T> registerOnMainThread(Object obj, Class<T> cls) {
        if (RxBus.get().isRegistered(obj, cls)) {
            return d.o();
        }
        d register = register(obj, cls);
        if (register != null) {
            return register.p(a.b());
        }
        return null;
    }

    public static synchronized void unregister(Object obj) {
        ConcurrentLinkedQueue<LazySubscriber> remove;
        synchronized (EventBusWrapper.class) {
            if (obj == null) {
                return;
            }
            if (sLazySubscribers.size() > 0 && (remove = sLazySubscribers.remove(obj)) != null) {
                remove.clear();
            }
            RxBus.get().unregister(obj);
        }
    }

    public static <T> void lazyRegister(Object obj, Class<T> cls, b<T> bVar, int i) {
        ConcurrentLinkedQueue<LazySubscriber> putIfAbsent;
        if (obj == null || cls == null || bVar == null) {
            return;
        }
        ConcurrentLinkedQueue<LazySubscriber> concurrentLinkedQueue = sLazySubscribers.get(obj);
        if (concurrentLinkedQueue == null && (putIfAbsent = sLazySubscribers.putIfAbsent(obj, (concurrentLinkedQueue = new ConcurrentLinkedQueue<>()))) != null) {
            concurrentLinkedQueue = putIfAbsent;
        }
        LazySubscriber lazySubscriber = new LazySubscriber(cls, bVar, i);
        if (!concurrentLinkedQueue.contains(lazySubscriber)) {
            concurrentLinkedQueue.add(lazySubscriber);
        }
        LAZY_SUBSCRIBE_HANDLER.sendEmptyMessage(1);
    }

    public static <T> void register(Object obj, Class<T> cls, b<T> bVar) {
        register(obj, cls, bVar, 2);
    }

    public static <T> void register(Object obj, Class<T> cls, b<T> bVar, int i) {
        if (obj == null || cls == null || bVar == null || RxBus.get().isRegistered(obj, cls)) {
            return;
        }
        b<Throwable> bVar2 = new b<Throwable>() { // from class: com.baidu.android.app.event.EventBusWrapper.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.b
            public void call(Throwable th) {
            }
        };
        d<T> register = RxBus.get().register(obj, cls);
        if (i == 0) {
            register.p(a.b()).e(bVar).d(bVar2).y().z();
        } else if (i == 1) {
            register.p(Schedulers.computation()).e(bVar).d(bVar2).y().z();
        } else if (i == 2) {
            register.e(bVar).d(bVar2).y().z();
        } else {
            register.e(bVar).d(bVar2).y().z();
        }
    }

    public static <T> void registerOnBackgroundThread(Object obj, Class<T> cls, b<T> bVar) {
        register(obj, cls, bVar, 1);
    }

    public static <T> void registerOnMainThread(Object obj, Class<T> cls, b<T> bVar) {
        register(obj, cls, bVar, 0);
    }

    public static <T> void register(Object obj, Class<T> cls, g gVar, b bVar) {
        if (obj == null || cls == null || bVar == null || gVar == null || RxBus.get().isRegistered(obj, cls)) {
            return;
        }
        RxBus.get().register(obj, cls).p(gVar).e(bVar).d(new b<Throwable>() { // from class: com.baidu.android.app.event.EventBusWrapper.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.b
            public void call(Throwable th) {
            }
        }).y().z();
    }
}
