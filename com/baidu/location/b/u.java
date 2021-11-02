package com.baidu.location.b;

import android.os.HandlerThread;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HandlerThread f39069a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723903, "Lcom/baidu/location/b/u;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723903, "Lcom/baidu/location/b/u;");
        }
    }

    public static synchronized HandlerThread a() {
        InterceptResult invokeV;
        HandlerThread handlerThread;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (u.class) {
                if (f39069a == null) {
                    HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                    f39069a = handlerThread2;
                    handlerThread2.start();
                }
                handlerThread = f39069a;
            }
            return handlerThread;
        }
        return (HandlerThread) invokeV.objValue;
    }
}
