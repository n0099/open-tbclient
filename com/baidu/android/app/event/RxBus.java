package com.baidu.android.app.event;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "RxBus";
    public static volatile RxBus mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public ConcurrentHashMap<Object, ConcurrentHashMap<Class, d>> mObservables;
    public final c<Object, Object> mRxBusSubject;
    public ConcurrentHashMap<Object, ConcurrentHashMap<Class, List<j>>> mSubscribers;

    /* loaded from: classes.dex */
    public class Remover implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isUnsubscribed;
        public k mSubscription;
        public Object mTag;
        public Class mType;
        public final /* synthetic */ RxBus this$0;

        public Remover(RxBus rxBus, Object obj, Class cls, k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rxBus, obj, cls, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = rxBus;
            this.mTag = obj;
            this.mType = cls;
            this.mSubscription = kVar;
        }

        @Override // h.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isUnsubscribed : invokeV.booleanValue;
        }

        @Override // h.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.mSubscription.isUnsubscribed()) {
                    this.mSubscription.unsubscribe();
                }
                this.this$0.unregister(this.mTag, this.mType);
                this.isUnsubscribed = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class TagKeeperOperator<T> implements d.b<T, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object tag;
        public final /* synthetic */ RxBus this$0;
        public final Class<T> type;

        public TagKeeperOperator(RxBus rxBus, Object obj, Class<T> cls) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rxBus, obj, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = rxBus;
            this.tag = obj;
            this.type = cls;
        }

        @Override // h.n.f
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((j) ((j) obj));
        }

        public j<? super T> call(j<? super T> jVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jVar)) == null) {
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.this$0.mSubscribers.get(this.tag);
                if (concurrentHashMap == null) {
                    concurrentHashMap = new ConcurrentHashMap();
                    ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) this.this$0.mSubscribers.putIfAbsent(this.tag, concurrentHashMap);
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
                j jVar2 = (j<T>) new j<T>(this, jVar) { // from class: com.baidu.android.app.event.RxBus.TagKeeperOperator.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ TagKeeperOperator this$1;
                    public final /* synthetic */ j val$subscriber;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, jVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$subscriber = jVar;
                    }

                    @Override // h.e
                    public void onCompleted() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.val$subscriber.isUnsubscribed()) {
                            return;
                        }
                        this.val$subscriber.onCompleted();
                    }

                    @Override // h.e
                    public void onError(Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) || this.val$subscriber.isUnsubscribed()) {
                            return;
                        }
                        this.val$subscriber.onError(th);
                    }

                    @Override // h.e
                    public void onNext(T t) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) || this.val$subscriber.isUnsubscribed()) {
                            return;
                        }
                        this.val$subscriber.onNext(t);
                    }
                };
                jVar2.add(new Remover(this.this$0, this.tag, this.type, jVar));
                list.add(jVar2);
                return jVar2;
            }
            return (j) invokeL.objValue;
        }
    }

    public RxBus() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mObservables = new ConcurrentHashMap<>();
        this.mSubscribers = new ConcurrentHashMap<>();
        this.mRxBusSubject = new c<>(PublishSubject.K());
    }

    private <T> void clearObservables(Object obj, Class<T> cls) {
        ConcurrentHashMap<Class, d> concurrentHashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, obj, cls) == null) || (concurrentHashMap = this.mObservables.get(obj)) == null) {
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
        ConcurrentHashMap<Class, List<j>> concurrentHashMap;
        Collection<List<j>> values;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65539, this, obj, cls) == null) || (concurrentHashMap = this.mSubscribers.get(obj)) == null) {
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

    private <T> d<T> createObservable(Object obj, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65540, this, obj, cls)) == null) ? this.mRxBusSubject.r(cls).j(new TagKeeperOperator(this, obj, cls)).s().d(new b<T>(this, obj) { // from class: com.baidu.android.app.event.RxBus.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RxBus this$0;
            public final /* synthetic */ Object val$tag;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, obj};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$tag = obj;
            }

            @Override // h.n.b
            public void call(T t) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, t) == null) {
                }
            }
        }).x() : (d) invokeLL.objValue;
    }

    public static RxBus get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (mInstance == null) {
                synchronized (RxBus.class) {
                    if (mInstance == null) {
                        mInstance = new RxBus();
                    }
                }
            }
            return mInstance;
        }
        return (RxBus) invokeV.objValue;
    }

    public <T> boolean isRegistered(Object obj, Class<T> cls) {
        InterceptResult invokeLL;
        ConcurrentHashMap<Class, d> concurrentHashMap;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, cls)) == null) ? (obj == null || cls == null || (concurrentHashMap = this.mObservables.get(obj)) == null || concurrentHashMap.get(cls) == null) ? false : true : invokeLL.booleanValue;
    }

    public void post(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) || obj == null) {
            return;
        }
        this.mRxBusSubject.onNext(obj);
    }

    public <T> d<T> register(Object obj, Class<T> cls) {
        InterceptResult invokeLL;
        ConcurrentHashMap<Class, d> putIfAbsent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, cls)) == null) {
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
        return (d) invokeLL.objValue;
    }

    public <T> void unregister(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            unregister(obj, null);
        }
    }

    public <T> void unregister(Object obj, Class<T> cls) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, obj, cls) == null) || obj == null) {
            return;
        }
        clearObservables(obj, cls);
        clearSubscriberAndUnsubscribe(obj, cls);
    }
}
