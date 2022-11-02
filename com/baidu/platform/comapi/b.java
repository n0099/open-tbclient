package com.baidu.platform.comapi;

import android.app.Application;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.platform.comapi.b.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.vi.VIContext;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;
    public static final AtomicBoolean b;
    public static final AtomicBoolean c;
    public static Context d;
    public static a e;
    public static final CountDownLatch f;
    public static boolean g;
    public static boolean h;
    public static boolean i;
    public static boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2041284065, "Lcom/baidu/platform/comapi/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2041284065, "Lcom/baidu/platform/comapi/b;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
        f = new CountDownLatch(1);
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65541, null) != null) {
            return;
        }
        while (true) {
            boolean z = a.get();
            if (z) {
                return;
            }
            if (a.compareAndSet(z, true)) {
                a aVar = new a();
                e = aVar;
                if (!aVar.a(d)) {
                    throw new RuntimeException("BDMapSDKException: engine init failed");
                }
            }
        }
    }

    public b() {
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

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return c.get();
        }
        return invokeV.booleanValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            e.b();
            a.set(false);
        }
    }

    public static Context d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return d;
        }
        return (Context) invokeV.objValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return h;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return i;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return j;
        }
        return invokeV.booleanValue;
    }

    public static void a(Application application, boolean z, boolean z2, boolean z3, boolean z4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{application, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            if (application != null) {
                g = z;
                h = z2;
                i = z3;
                j = z4;
                if (d == null) {
                    d = application;
                }
                VIContext.init(application);
                return;
            }
            throw new RuntimeException("BDMapSDKException: Application Context is null");
        }
    }

    public static void a(com.baidu.platform.comapi.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(65539, null, bVar) != null) {
            return;
        }
        while (true) {
            boolean z = c.get();
            if (z) {
                return;
            }
            if (c.compareAndSet(z, true)) {
                if (bVar != null) {
                    try {
                        c.a.a(bVar);
                    } finally {
                        f.countDown();
                    }
                }
            }
        }
    }
}
