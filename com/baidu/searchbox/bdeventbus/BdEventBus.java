package com.baidu.searchbox.bdeventbus;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.core.BdEventBusCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b:\u0002\u001b\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJE\u0010\u000b\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0010\u001a\u00020\n\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\u0010\u0010\u0011JE\u0010\u0010\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0007¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "", "T", "subscriber", "Ljava/lang/Class;", "eventType", "", "threadMode", "Lcom/baidu/searchbox/bdeventbus/Action;", "action", "", "lazyRegister", "(Ljava/lang/Object;Ljava/lang/Class;ILcom/baidu/searchbox/bdeventbus/Action;)V", "event", "post", "(Ljava/lang/Object;)V", "register", "(Ljava/lang/Object;Ljava/lang/Class;Lcom/baidu/searchbox/bdeventbus/Action;)V", "unregister", "", "TAG", "Ljava/lang/String;", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "bdEventBusCore", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "<init>", "(Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;)V", "Companion", "SingletonHolder", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class BdEventBus {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BDEVENTBUS_ENABLE = "bdeventbus_enable";
    public static final Companion Companion;
    public static final boolean DEFAULT_VALUE = false;
    public static final BdEventBus defaultInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public final BdEventBusCore bdEventBusCore;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/BdEventBus$Companion;", "Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "getDefault", "()Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "", "BDEVENTBUS_ENABLE", "Ljava/lang/String;", "", "DEFAULT_VALUE", "Z", "defaultInstance", "Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "<init>", "()V", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final BdEventBus getDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? BdEventBus.defaultInstance : (BdEventBus) invokeV.objValue;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0002\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/BdEventBus$SingletonHolder;", "Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "holder", "Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "getHolder", "()Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "<init>", "()V", "lib-bd-event-bus_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class SingletonHolder {
        public static /* synthetic */ Interceptable $ic;
        public static final SingletonHolder INSTANCE;
        public static final BdEventBus holder;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1216361619, "Lcom/baidu/searchbox/bdeventbus/BdEventBus$SingletonHolder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1216361619, "Lcom/baidu/searchbox/bdeventbus/BdEventBus$SingletonHolder;");
                    return;
                }
            }
            INSTANCE = new SingletonHolder();
            holder = new BdEventBus(new BdEventBusCore(), null);
        }

        public SingletonHolder() {
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

        public final BdEventBus getHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? holder : (BdEventBus) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1071626502, "Lcom/baidu/searchbox/bdeventbus/BdEventBus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1071626502, "Lcom/baidu/searchbox/bdeventbus/BdEventBus;");
                return;
            }
        }
        Companion = new Companion(null);
        defaultInstance = SingletonHolder.INSTANCE.getHolder();
    }

    public BdEventBus(BdEventBusCore bdEventBusCore) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdEventBusCore};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bdEventBusCore = bdEventBusCore;
        this.TAG = "BdEventBus";
    }

    @Deprecated(message = "请直接调用register方法")
    public final <T> void lazyRegister(Object subscriber, Class<T> eventType, int i2, Action<T> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, subscriber, eventType, i2, action) == null) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(action, "action");
            this.bdEventBusCore.subscribe$lib_bd_event_bus_release(subscriber, eventType, i2, action);
        }
    }

    public final void post(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.bdEventBusCore.post$lib_bd_event_bus_release(event);
        }
    }

    public final <T> void register(Object subscriber, Class<T> eventType, Action<T> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, subscriber, eventType, action) == null) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(action, "action");
            this.bdEventBusCore.subscribe$lib_bd_event_bus_release(subscriber, eventType, 0, action);
        }
    }

    public final synchronized void unregister(Object subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, subscriber) == null) {
            synchronized (this) {
                Intrinsics.checkNotNullParameter(subscriber, "subscriber");
                this.bdEventBusCore.unregister(subscriber);
            }
        }
    }

    public final <T> void register(Object subscriber, Class<T> eventType, int i2, Action<T> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, subscriber, eventType, i2, action) == null) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(action, "action");
            this.bdEventBusCore.subscribe$lib_bd_event_bus_release(subscriber, eventType, i2, action);
        }
    }

    public /* synthetic */ BdEventBus(BdEventBusCore bdEventBusCore, DefaultConstructorMarker defaultConstructorMarker) {
        this(bdEventBusCore);
    }
}
