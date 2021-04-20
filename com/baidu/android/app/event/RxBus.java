package com.baidu.android.app.event;

import h.d;
import h.j;
import h.k;
import h.n.b;
import h.t.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import rx.subjects.PublishSubject;
/* loaded from: classes.dex */
public class RxBus {
    public static final boolean DEBUG = false;
    public static final String TAG = "RxBus";
    public static volatile RxBus mInstance;
    public ConcurrentHashMap<Object, ConcurrentHashMap<Class, d>> mObservables = new ConcurrentHashMap<>();
    public ConcurrentHashMap<Object, ConcurrentHashMap<Class, List<j>>> mSubscribers = new ConcurrentHashMap<>();
    public final c<Object, Object> mRxBusSubject = new c<>(PublishSubject.N());

    /* loaded from: classes.dex */
    public class Remover implements k {
        public boolean isUnsubscribed;
        public k mSubscription;
        public Object mTag;
        public Class mType;

        public Remover(Object obj, Class cls, k kVar) {
            this.mTag = obj;
            this.mType = cls;
            this.mSubscription = kVar;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            return this.isUnsubscribed;
        }

        @Override // h.k
        public void unsubscribe() {
            if (!this.mSubscription.isUnsubscribed()) {
                this.mSubscription.unsubscribe();
            }
            RxBus.this.unregister(this.mTag, this.mType);
            this.isUnsubscribed = true;
        }
    }

    /* loaded from: classes.dex */
    public class TagKeeperOperator<T> implements d.b<T, T> {
        public final Object tag;
        public final Class<T> type;

        public TagKeeperOperator(Object obj, Class<T> cls) {
            this.tag = obj;
            this.type = cls;
        }

        @Override // h.n.f
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((j) ((j) obj));
        }

        public j<? super T> call(final j<? super T> jVar) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) RxBus.this.mSubscribers.get(this.tag);
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap();
                ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) RxBus.this.mSubscribers.putIfAbsent(this.tag, concurrentHashMap);
                if (concurrentHashMap2 != null) {
                    concurrentHashMap = concurrentHashMap2;
                }
            }
            List list = (List) concurrentHashMap.get(this.type);
            if (list == null) {
                list = new ArrayList();
                List list2 = (List) concurrentHashMap.putIfAbsent(this.type, list);
                if (list2 != null) {
                    list = list2;
                }
            }
            j jVar2 = (j<T>) new j<T>() { // from class: com.baidu.android.app.event.RxBus.TagKeeperOperator.1
                @Override // h.e
                public void onCompleted() {
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    jVar.onCompleted();
                }

                @Override // h.e
                public void onError(Throwable th) {
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    jVar.onError(th);
                }

                @Override // h.e
                public void onNext(T t) {
                    if (jVar.isUnsubscribed()) {
                        return;
                    }
                    jVar.onNext(t);
                }
            };
            jVar2.add(new Remover(this.tag, this.type, jVar));
            list.add(jVar2);
            return jVar2;
        }
    }

    private <T> void clearObservables(Object obj, Class<T> cls) {
        ConcurrentHashMap<Class, d> concurrentHashMap = this.mObservables.get(obj);
        if (concurrentHashMap == null) {
            return;
        }
        if (cls == null) {
            concurrentHashMap.clear();
        } else {
            concurrentHashMap.remove(cls);
        }
        if (concurrentHashMap.isEmpty()) {
            this.mObservables.remove(obj);
        }
    }

    private <T> void clearSubscriberAndUnsubscribe(Object obj, Class<T> cls) {
        Collection<List<j>> values;
        ConcurrentHashMap<Class, List<j>> concurrentHashMap = this.mSubscribers.get(obj);
        if (concurrentHashMap == null) {
            return;
        }
        if (cls == null) {
            ConcurrentHashMap<Class, List<j>> remove = this.mSubscribers.remove(obj);
            if (remove == null || (values = remove.values()) == null || values.isEmpty()) {
                return;
            }
            for (List<j> list : values) {
                if (list != null && !list.isEmpty()) {
                    for (j jVar : list) {
                        if (jVar != null && !jVar.isUnsubscribed()) {
                            jVar.unsubscribe();
                        }
                    }
                    list.clear();
                }
            }
            values.clear();
            return;
        }
        List<j> remove2 = concurrentHashMap.remove(cls);
        if (remove2 == null) {
            return;
        }
        for (j jVar2 : remove2) {
            if (jVar2 != null && !jVar2.isUnsubscribed()) {
                jVar2.unsubscribe();
            }
        }
        remove2.clear();
    }

    private <T> d<T> createObservable(final Object obj, Class<T> cls) {
        return this.mRxBusSubject.s(cls).k(new TagKeeperOperator(obj, cls)).t().e(new b<T>() { // from class: com.baidu.android.app.event.RxBus.1
            @Override // h.n.b
            public void call(T t) {
            }
        }).y();
    }

    public static RxBus get() {
        if (mInstance == null) {
            synchronized (RxBus.class) {
                if (mInstance == null) {
                    mInstance = new RxBus();
                }
            }
        }
        return mInstance;
    }

    public <T> boolean isRegistered(Object obj, Class<T> cls) {
        ConcurrentHashMap<Class, d> concurrentHashMap;
        return (obj == null || cls == null || (concurrentHashMap = this.mObservables.get(obj)) == null || concurrentHashMap.get(cls) == null) ? false : true;
    }

    public void post(Object obj) {
        if (obj == null) {
            return;
        }
        this.mRxBusSubject.onNext(obj);
    }

    public <T> d<T> register(Object obj, Class<T> cls) {
        ConcurrentHashMap<Class, d> putIfAbsent;
        if (obj == null || cls == null) {
            return null;
        }
        ConcurrentHashMap<Class, d> concurrentHashMap = this.mObservables.get(obj);
        if (concurrentHashMap == null && (putIfAbsent = this.mObservables.putIfAbsent(obj, (concurrentHashMap = new ConcurrentHashMap<>()))) != null) {
            concurrentHashMap = putIfAbsent;
        }
        d<T> dVar = concurrentHashMap.get(cls);
        if (dVar == null) {
            d<T> createObservable = createObservable(obj, cls);
            d<T> putIfAbsent2 = concurrentHashMap.putIfAbsent(cls, createObservable);
            return putIfAbsent2 != null ? putIfAbsent2 : createObservable;
        }
        return dVar;
    }

    public <T> void unregister(Object obj) {
        unregister(obj, null);
    }

    public <T> void unregister(Object obj, Class<T> cls) {
        if (obj == null) {
            return;
        }
        clearObservables(obj, cls);
        clearSubscriberAndUnsubscribe(obj, cls);
    }
}
