package com.baidu.android.pushservice.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public static a a;

    /* renamed from: b  reason: collision with root package name */
    public static e f31967b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f31968c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f31969d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f31970e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-676959488, "Lcom/baidu/android/pushservice/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-676959488, "Lcom/baidu/android/pushservice/g/e;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f31968c = availableProcessors;
        f31969d = Math.max(2, Math.min(availableProcessors - 1, 4));
        f31970e = f31968c << 3;
    }

    public e() {
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
        Runtime.getRuntime().addShutdownHook(new Thread(this) { // from class: com.baidu.android.pushservice.g.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

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
                this.a = this;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.b();
                }
            }
        });
        a aVar = new a(f31969d, f31970e, 2L, TimeUnit.MINUTES, new b());
        a = aVar;
        aVar.allowCoreThreadTimeOut(true);
    }

    public static e a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f31967b == null || (aVar = a) == null || aVar.isShutdown() || a.isTerminated()) {
                f31967b = new e();
            }
            return f31967b;
        }
        return (e) invokeV.objValue;
    }

    public boolean a(c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
            try {
                a.submit(cVar);
                return true;
            } catch (Exception unused) {
                a aVar = a;
                if (aVar == null || aVar.getCorePoolSize() == 0 || a.getPoolSize() == 0) {
                    a = new a(f31969d, f31970e, 2L, TimeUnit.MINUTES, new b());
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = a) == null) {
            return;
        }
        try {
            aVar.getQueue().clear();
            a.shutdown();
        } catch (Exception unused) {
        }
    }
}
