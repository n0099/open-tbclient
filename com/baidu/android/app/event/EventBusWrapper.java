package com.baidu.android.app.event;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int LAZY_POST_MSG = 2;
    public static final Handler LAZY_SUBSCRIBE_HANDLER;
    public static final int LAZY_SUBSCRIBE_MSG = 1;
    public static final String TAG = "EventBusWrapper";
    public static final int THREAD_MODE_BACKGROUND = 1;
    public static final int THREAD_MODE_CURRENT = 2;
    public static final int THREAD_MODE_MAIN = 0;
    public static ConcurrentHashMap<Object, ConcurrentLinkedQueue<LazySubscriber>> sLazySubscribers;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class LazySubscriber {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b action;
        public final int mode;
        public final Class type;

        public LazySubscriber(Class cls, b bVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.type = cls;
            this.action = bVar;
            this.mode = i2;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == null) {
                    return false;
                }
                return this.type.equals(((LazySubscriber) obj).type);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1120166017, "Lcom/baidu/android/app/event/EventBusWrapper;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1120166017, "Lcom/baidu/android/app/event/EventBusWrapper;");
                return;
            }
        }
        sLazySubscribers = new ConcurrentHashMap<>();
        HandlerThread handlerThread = new HandlerThread(RxBus.TAG);
        handlerThread.start();
        LAZY_SUBSCRIBE_HANDLER = new Handler(handlerThread.getLooper()) { // from class: com.baidu.android.app.event.EventBusWrapper.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r7);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r7};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Looper) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i2 = message.what;
                    if (i2 == 1) {
                        EventBusWrapper.registerLazySubscribers();
                    } else if (i2 == 2) {
                        EventBusWrapper.post(message.obj);
                    }
                }
            }
        };
    }

    public EventBusWrapper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void lazyPost(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, obj) == null) {
            Handler handler = LAZY_SUBSCRIBE_HANDLER;
            handler.sendMessage(handler.obtainMessage(2, obj));
        }
    }

    public static <T> void lazyRegister(Object obj, Class<T> cls, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, obj, cls, bVar) == null) {
            lazyRegister(obj, cls, bVar, 2);
        }
    }

    public static <T> void lazyRegisterOnBackgroundThread(Object obj, Class<T> cls, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, obj, cls, bVar) == null) {
            lazyRegister(obj, cls, bVar, 1);
        }
    }

    public static <T> void lazyRegisterOnMainThread(Object obj, Class<T> cls, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, obj, cls, bVar) == null) {
            lazyRegister(obj, cls, bVar, 0);
        }
    }

    public static void post(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, obj) == null) {
            if (sLazySubscribers.size() > 0) {
                LAZY_SUBSCRIBE_HANDLER.removeMessages(1);
                registerLazySubscribers();
            }
            RxBus.get().post(obj);
        }
    }

    public static <T> d<T> register(Object obj, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, obj, cls)) == null) {
            if (RxBus.get().isRegistered(obj, cls)) {
                return d.n();
            }
            return RxBus.get().register(obj, cls);
        }
        return (d) invokeLL.objValue;
    }

    public static void registerLazySubscribers() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, null) == null) || sLazySubscribers.size() <= 0) {
            return;
        }
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

    public static <T> d<T> registerOnBackgroundThread(Object obj, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, obj, cls)) == null) {
            if (RxBus.get().isRegistered(obj, cls)) {
                return d.n();
            }
            d register = register(obj, cls);
            if (register != null) {
                return register.o(Schedulers.computation());
            }
            return null;
        }
        return (d) invokeLL.objValue;
    }

    public static <T> d<T> registerOnMainThread(Object obj, Class<T> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, obj, cls)) == null) {
            if (RxBus.get().isRegistered(obj, cls)) {
                return d.n();
            }
            d register = register(obj, cls);
            if (register != null) {
                return register.o(a.b());
            }
            return null;
        }
        return (d) invokeLL.objValue;
    }

    public static synchronized void unregister(Object obj) {
        ConcurrentLinkedQueue<LazySubscriber> remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, obj) == null) {
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
    }

    public static <T> void lazyRegister(Object obj, Class<T> cls, b<T> bVar, int i2) {
        ConcurrentLinkedQueue<LazySubscriber> putIfAbsent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(AdIconUtil.AD_TEXT_ID, null, obj, cls, bVar, i2) == null) || obj == null || cls == null || bVar == null) {
            return;
        }
        ConcurrentLinkedQueue<LazySubscriber> concurrentLinkedQueue = sLazySubscribers.get(obj);
        if (concurrentLinkedQueue == null && (putIfAbsent = sLazySubscribers.putIfAbsent(obj, (concurrentLinkedQueue = new ConcurrentLinkedQueue<>()))) != null) {
            concurrentLinkedQueue = putIfAbsent;
        }
        LazySubscriber lazySubscriber = new LazySubscriber(cls, bVar, i2);
        if (!concurrentLinkedQueue.contains(lazySubscriber)) {
            concurrentLinkedQueue.add(lazySubscriber);
        }
        LAZY_SUBSCRIBE_HANDLER.sendEmptyMessage(1);
    }

    public static <T> void register(Object obj, Class<T> cls, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, obj, cls, bVar) == null) {
            register(obj, cls, bVar, 2);
        }
    }

    public static <T> void register(Object obj, Class<T> cls, b<T> bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65548, null, obj, cls, bVar, i2) == null) || obj == null || cls == null || bVar == null || RxBus.get().isRegistered(obj, cls)) {
            return;
        }
        b<Throwable> bVar2 = new b<Throwable>() { // from class: com.baidu.android.app.event.EventBusWrapper.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.b
            public void call(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                }
            }
        };
        d<T> register = RxBus.get().register(obj, cls);
        if (i2 == 0) {
            register.o(a.b()).d(bVar).c(bVar2).x().y();
        } else if (i2 == 1) {
            register.o(Schedulers.computation()).d(bVar).c(bVar2).x().y();
        } else if (i2 == 2) {
            register.d(bVar).c(bVar2).x().y();
        } else {
            register.d(bVar).c(bVar2).x().y();
        }
    }

    public static <T> void registerOnBackgroundThread(Object obj, Class<T> cls, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, obj, cls, bVar) == null) {
            register(obj, cls, bVar, 1);
        }
    }

    public static <T> void registerOnMainThread(Object obj, Class<T> cls, b<T> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, obj, cls, bVar) == null) {
            register(obj, cls, bVar, 0);
        }
    }

    public static <T> void register(Object obj, Class<T> cls, g gVar, b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65546, null, obj, cls, gVar, bVar) == null) || obj == null || cls == null || bVar == null || gVar == null || RxBus.get().isRegistered(obj, cls)) {
            return;
        }
        RxBus.get().register(obj, cls).o(gVar).d(bVar).c(new b<Throwable>() { // from class: com.baidu.android.app.event.EventBusWrapper.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // h.n.b
            public void call(Throwable th) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                }
            }
        }).x().y();
    }
}
