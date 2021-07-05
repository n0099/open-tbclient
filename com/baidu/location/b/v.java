package com.baidu.location.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f6647a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f6648b;

    /* renamed from: com.baidu.location.b.v$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static v f6649a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820268865, "Lcom/baidu/location/b/v$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(820268865, "Lcom/baidu/location/b/v$a;");
                    return;
                }
            }
            f6649a = new v(null);
        }
    }

    public v() {
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

    public /* synthetic */ v(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static v a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f6649a : (v) invokeV.objValue;
    }

    public synchronized ExecutorService b() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f6647a == null || this.f6647a.isShutdown()) {
                    this.f6647a = null;
                    this.f6647a = Executors.newSingleThreadExecutor();
                }
                executorService = this.f6647a;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public synchronized ExecutorService c() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                if (this.f6648b == null || this.f6648b.isShutdown()) {
                    this.f6648b = null;
                    this.f6648b = Executors.newFixedThreadPool(2);
                }
                executorService = this.f6648b;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ExecutorService executorService = this.f6647a;
            if (executorService != null) {
                executorService.shutdown();
            }
            ExecutorService executorService2 = this.f6648b;
            if (executorService2 != null) {
                executorService2.shutdown();
            }
        }
    }
}
