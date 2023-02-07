package com.baidu.searchbox.bdeventbus;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.core.BdEventBusCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.mipush.sdk.MiPushClient;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0001H\u0007J2\u0010\u0013\u001a\u00020\b\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u0010H\u0007J>\u0010\u0013\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u0010H\u0007J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0001H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "", "bdEventBusCore", "Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "(Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;)V", "TAG", "", "lazyRegister", "", ExifInterface.GPS_DIRECTION_TRUE, "subscriber", "eventType", "Ljava/lang/Class;", "threadMode", "", "action", "Lcom/baidu/searchbox/bdeventbus/Action;", "post", "event", MiPushClient.COMMAND_REGISTER, MiPushClient.COMMAND_UNREGISTER, "Companion", "SingletonHolder", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BdEventBus {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BDEVENTBUS_ENABLE = "bdeventbus_enable";
    public static final Companion Companion;
    public static final boolean DEFAULT_VALUE = false;
    public static final BdEventBus defaultInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public final BdEventBusCore bdEventBusCore;

    public /* synthetic */ BdEventBus(BdEventBusCore bdEventBusCore, DefaultConstructorMarker defaultConstructorMarker) {
        this(bdEventBusCore);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/BdEventBus$Companion;", "", "()V", "BDEVENTBUS_ENABLE", "", "DEFAULT_VALUE", "", "defaultInstance", "Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "getDefault", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final BdEventBus getDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return BdEventBus.defaultInstance;
            }
            return (BdEventBus) invokeV.objValue;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/BdEventBus$SingletonHolder;", "", "()V", "holder", "Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "getHolder", "()Lcom/baidu/searchbox/bdeventbus/BdEventBus;", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public final BdEventBus getHolder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return holder;
            }
            return (BdEventBus) invokeV.objValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.bdEventBusCore = bdEventBusCore;
        this.TAG = "BdEventBus";
    }

    @Deprecated(message = "请直接调用register方法")
    public final <T> void lazyRegister(Object subscriber, Class<T> eventType, int i, Action<T> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, subscriber, eventType, i, action) == null) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(action, "action");
            this.bdEventBusCore.subscribe$lib_bd_event_bus_release(subscriber, eventType, i, action);
        }
    }

    public final <T> void register(Object subscriber, Class<T> eventType, int i, Action<T> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, subscriber, eventType, i, action) == null) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(action, "action");
            this.bdEventBusCore.subscribe$lib_bd_event_bus_release(subscriber, eventType, i, action);
        }
    }

    public final void post(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.bdEventBusCore.post$lib_bd_event_bus_release(event);
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

    public final <T> void register(Object subscriber, Class<T> eventType, Action<T> action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, subscriber, eventType, action) == null) {
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            Intrinsics.checkNotNullParameter(eventType, "eventType");
            Intrinsics.checkNotNullParameter(action, "action");
            this.bdEventBusCore.subscribe$lib_bd_event_bus_release(subscriber, eventType, 0, action);
        }
    }
}
