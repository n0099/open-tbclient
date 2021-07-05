package com.baidu.android.pushservice.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f3152a;

    /* renamed from: b  reason: collision with root package name */
    public static d f3153b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f3154c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f3155d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f3156e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676929728, "Lcom/baidu/android/pushservice/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676929728, "Lcom/baidu/android/pushservice/h/d;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f3154c = availableProcessors;
        f3155d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f3156e = f3154c << 3;
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Runtime.getRuntime().addShutdownHook(new Thread(this) { // from class: com.baidu.android.pushservice.h.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f3157a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f3157a = this;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f3157a.b();
                }
            }
        });
        a aVar = new a(f3155d, f3156e, 2L, TimeUnit.MINUTES, new b());
        f3152a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static d a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f3153b == null || (aVar = f3152a) == null || aVar.isShutdown() || f3152a.isTerminated()) {
                f3153b = new d();
            }
            return f3153b;
        }
        return (d) invokeV.objValue;
    }

    public boolean a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            try {
                f3152a.submit(cVar);
                return true;
            } catch (Exception unused) {
                a aVar = f3152a;
                if (aVar == null || aVar.getCorePoolSize() == 0 || f3152a.getPoolSize() == 0) {
                    f3152a = new a(f3155d, f3156e, 2L, TimeUnit.MINUTES, new b());
                    return false;
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void b() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = f3152a) == null) {
            return;
        }
        try {
            aVar.getQueue().clear();
            f3152a.shutdown();
        } catch (Exception unused) {
        }
    }
}
