package com.baidu.android.app.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import rx.d;
import rx.j;
import rx.k;
import rx.subjects.PublishSubject;
import rx.subjects.b;
/* loaded from: classes2.dex */
public class RxBus {
    private static final boolean DEBUG = false;
    public static final String TAG = "RxBus";
    private static volatile RxBus mInstance;
    private ConcurrentHashMap<Object, ConcurrentHashMap<Class, d>> mObservables = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Object, ConcurrentHashMap<Class, List<j>>> mSubscribers = new ConcurrentHashMap<>();
    private final b<Object, Object> mRxBusSubject = new b<>(PublishSubject.cFk());

    private RxBus() {
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

    public void post(Object obj) {
        if (obj != null) {
            this.mRxBusSubject.onNext(obj);
        }
    }

    public <T> d<T> register(Object obj, Class<T> cls) {
        ConcurrentHashMap<Class, d> concurrentHashMap;
        if (obj == null || cls == null) {
            return null;
        }
        ConcurrentHashMap<Class, d> concurrentHashMap2 = this.mObservables.get(obj);
        if (concurrentHashMap2 == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            ConcurrentHashMap<Class, d> putIfAbsent = this.mObservables.putIfAbsent(obj, concurrentHashMap);
            if (putIfAbsent != null) {
                concurrentHashMap = putIfAbsent;
            }
        } else {
            concurrentHashMap = concurrentHashMap2;
        }
        d<T> dVar = concurrentHashMap.get(cls);
        if (dVar == null) {
            d<T> createObservable = createObservable(obj, cls);
            d<T> putIfAbsent2 = concurrentHashMap.putIfAbsent(cls, createObservable);
            return putIfAbsent2 == null ? createObservable : putIfAbsent2;
        }
        return dVar;
    }

    public <T> void unregister(Object obj) {
        unregister(obj, null);
    }

    public <T> void unregister(Object obj, Class<T> cls) {
        if (obj != null) {
            clearObservables(obj, cls);
            clearSubscriberAndUnsubscribe(obj, cls);
        }
    }

    private <T> d<T> createObservable(final Object obj, Class<T> cls) {
        return this.mRxBusSubject.I(cls).a((d.b<? extends R, ? super Object>) new TagKeeperOperator(obj, cls)).cDB().b(new rx.functions.b<T>() { // from class: com.baidu.android.app.event.RxBus.1
            @Override // rx.functions.b
            public void call(T t) {
            }
        }).cDD();
    }

    private <T> void clearObservables(Object obj, Class<T> cls) {
        ConcurrentHashMap<Class, d> concurrentHashMap = this.mObservables.get(obj);
        if (concurrentHashMap != null) {
            if (cls == null) {
                concurrentHashMap.clear();
            } else {
                concurrentHashMap.remove(cls);
            }
            if (concurrentHashMap.isEmpty()) {
                this.mObservables.remove(obj);
            }
        }
    }

    private <T> void clearSubscriberAndUnsubscribe(Object obj, Class<T> cls) {
        Collection<List<j>> values;
        ConcurrentHashMap<Class, List<j>> concurrentHashMap = this.mSubscribers.get(obj);
        if (concurrentHashMap != null) {
            if (cls == null) {
                ConcurrentHashMap<Class, List<j>> remove = this.mSubscribers.remove(obj);
                if (remove != null && (values = remove.values()) != null && !values.isEmpty()) {
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
                return;
            }
            List<j> remove2 = concurrentHashMap.remove(cls);
            if (remove2 != null) {
                for (j jVar2 : remove2) {
                    if (jVar2 != null && !jVar2.isUnsubscribed()) {
                        jVar2.unsubscribe();
                    }
                }
                remove2.clear();
            }
        }
    }

    public <T> boolean isRegistered(Object obj, Class<T> cls) {
        ConcurrentHashMap<Class, d> concurrentHashMap;
        return (obj == null || cls == null || (concurrentHashMap = this.mObservables.get(obj)) == null || concurrentHashMap.get(cls) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Remover implements k {
        private boolean isUnsubscribed;
        private k mSubscription;
        private Object mTag;
        private Class mType;

        public Remover(Object obj, Class cls, k kVar) {
            this.mTag = obj;
            this.mType = cls;
            this.mSubscription = kVar;
        }

        @Override // rx.k
        public void unsubscribe() {
            if (!this.mSubscription.isUnsubscribed()) {
                this.mSubscription.unsubscribe();
            }
            RxBus.this.unregister(this.mTag, this.mType);
            this.isUnsubscribed = true;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return this.isUnsubscribed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class TagKeeperOperator<T> implements d.b<T, T> {
        final Object tag;
        final Class<T> type;

        @Override // rx.functions.f
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((j) ((j) obj));
        }

        TagKeeperOperator(Object obj, Class<T> cls) {
            this.tag = obj;
            this.type = cls;
        }

        public j<? super T> call(final j<? super T> jVar) {
            ConcurrentHashMap concurrentHashMap;
            ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) RxBus.this.mSubscribers.get(this.tag);
            if (concurrentHashMap2 == null) {
                concurrentHashMap = new ConcurrentHashMap();
                ConcurrentHashMap concurrentHashMap3 = (ConcurrentHashMap) RxBus.this.mSubscribers.putIfAbsent(this.tag, concurrentHashMap);
                if (concurrentHashMap3 != null) {
                    concurrentHashMap = concurrentHashMap3;
                }
            } else {
                concurrentHashMap = concurrentHashMap2;
            }
            List list = (List) concurrentHashMap.get(this.type);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                list = (List) concurrentHashMap.putIfAbsent(this.type, arrayList);
                if (list == null) {
                    list = arrayList;
                }
            }
            j jVar2 = (j<T>) new j<T>() { // from class: com.baidu.android.app.event.RxBus.TagKeeperOperator.1
                @Override // rx.e
                public void onCompleted() {
                    if (!jVar.isUnsubscribed()) {
                        jVar.onCompleted();
                    }
                }

                @Override // rx.e
                public void onError(Throwable th) {
                    if (!jVar.isUnsubscribed()) {
                        jVar.onError(th);
                    }
                }

                @Override // rx.e
                public void onNext(T t) {
                    if (!jVar.isUnsubscribed()) {
                        jVar.onNext(t);
                    }
                }
            };
            jVar2.add(new Remover(this.tag, this.type, jVar));
            list.add(jVar2);
            return jVar2;
        }
    }
}
