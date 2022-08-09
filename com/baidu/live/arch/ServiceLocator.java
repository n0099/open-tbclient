package com.baidu.live.arch;

import androidx.collection.SimpleArrayMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.arch.api.IService;
import com.baidu.nps.main.manager.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0014:\u0001\u0014B\u0007¢\u0006\u0004\b\u0013\u0010\fJ'\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u000e\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u0012\u0004\u0012\u00020\u00010\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/baidu/live/arch/ServiceLocator;", "Lcom/baidu/live/arch/api/IService;", "T", "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "getService", "(Ljava/lang/Class;)Lcom/baidu/live/arch/api/IService;", "service", "", "registerServices", "(Ljava/lang/Class;Lcom/baidu/live/arch/api/IService;)V", "release", "()V", "releaseMemberServices", "unregisterServices", "(Ljava/lang/Class;)V", "Landroidx/collection/SimpleArrayMap;", "memberServices", "Landroidx/collection/SimpleArrayMap;", "<init>", "Companion", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ServiceLocator {
    public static /* synthetic */ Interceptable $ic;
    public static final Companion Companion;
    public static final SimpleArrayMap<Class<? extends IService>, IService> globalServices;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleArrayMap<Class<? extends IService>, IService> memberServices;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fR*\u0010\u000e\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\u0012\u0004\u0012\u00020\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/baidu/live/arch/ServiceLocator$Companion;", "Lcom/baidu/live/arch/api/IService;", "T", "Ljava/lang/Class;", Bundle.EXTRA_KEY_CLAZZ, "getGlobalService", "(Ljava/lang/Class;)Lcom/baidu/live/arch/api/IService;", "service", "", "registerGlobalServices", "(Ljava/lang/Class;Lcom/baidu/live/arch/api/IService;)V", "unregisterGlobalService", "(Ljava/lang/Class;)V", "Landroidx/collection/SimpleArrayMap;", "globalServices", "Landroidx/collection/SimpleArrayMap;", "<init>", "()V", "lib-live-mini-arch_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public final <T extends IService> T getGlobalService(Class<T> cls) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
                Object obj = ServiceLocator.globalServices.get(cls);
                if (!(obj instanceof IService)) {
                    obj = null;
                }
                return (T) obj;
            }
            return (T) invokeL.objValue;
        }

        public final void registerGlobalServices(Class<? extends IService> cls, IService iService) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, iService) == null) {
                ServiceLocator.globalServices.put(cls, iService);
            }
        }

        public final void unregisterGlobalService(Class<? extends IService> cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cls) == null) {
                ServiceLocator.globalServices.remove(cls);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-245921194, "Lcom/baidu/live/arch/ServiceLocator;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-245921194, "Lcom/baidu/live/arch/ServiceLocator;");
                return;
            }
        }
        Companion = new Companion(null);
        globalServices = new SimpleArrayMap<>();
    }

    public ServiceLocator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.memberServices = new SimpleArrayMap<>();
    }

    public final <T extends IService> T getService(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            IService iService = this.memberServices.get(cls);
            if (!(iService instanceof IService)) {
                iService = null;
            }
            T t = (T) iService;
            return t == null ? (T) Companion.getGlobalService(cls) : t;
        }
        return (T) invokeL.objValue;
    }

    public final void registerServices(Class<? extends IService> cls, IService iService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, iService) == null) {
            this.memberServices.put(cls, iService);
        }
    }

    public final void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.memberServices.clear();
            globalServices.clear();
        }
    }

    public final void releaseMemberServices() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.memberServices.clear();
        }
    }

    public final void unregisterServices(Class<? extends IService> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
            this.memberServices.remove(cls);
        }
    }
}
