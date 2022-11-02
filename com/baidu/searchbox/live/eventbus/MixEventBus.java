package com.baidu.searchbox.live.eventbus;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class MixEventBus {
    public static /* synthetic */ Interceptable $ic;
    public static MixEventBus sInstance;
    public static ConcurrentHashMap<Object, CopyOnWriteArrayList<EventPoster>> sSubscriberMap;
    public transient /* synthetic */ FieldHolder $fh;
    public MixEventBusCore eventBusCore;

    /* renamed from: com.baidu.searchbox.live.eventbus.MixEventBus$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final MixEventBus INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-305283635, "Lcom/baidu/searchbox/live/eventbus/MixEventBus$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-305283635, "Lcom/baidu/searchbox/live/eventbus/MixEventBus$Holder;");
                    return;
                }
            }
            INSTANCE = new MixEventBus(null);
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public MixEventBus() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        sSubscriberMap = new ConcurrentHashMap<>();
        this.eventBusCore = new MixEventBusCore();
    }

    public static MixEventBus getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (sInstance == null) {
                sInstance = Holder.INSTANCE;
            }
            return sInstance;
        }
        return (MixEventBus) invokeV.objValue;
    }

    public /* synthetic */ MixEventBus(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void post(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || obj == null || sSubscriberMap.isEmpty()) {
            return;
        }
        this.eventBusCore.post(sSubscriberMap, obj);
    }

    public void unRegister(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && obj != null && !sSubscriberMap.isEmpty() && sSubscriberMap.containsKey(obj)) {
            this.eventBusCore.unRegister(sSubscriberMap, obj);
        }
    }

    public void register(Object obj, Class<?> cls, int i, EventAction eventAction) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, cls, i, eventAction) == null) && obj != null && cls != null && eventAction != null && ThreadMode.isValid(i)) {
            this.eventBusCore.register(sSubscriberMap, obj, cls, i, eventAction);
        }
    }

    public synchronized void register(Object obj, Class<?> cls, EventAction eventAction) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, cls, eventAction) == null) {
            synchronized (this) {
                register(obj, cls, 1, eventAction);
            }
        }
    }
}
