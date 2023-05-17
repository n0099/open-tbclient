package com.baidu.location.b;

import android.os.HandlerThread;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class v {
    public static /* synthetic */ Interceptable $ic;
    public static HandlerThread a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037723934, "Lcom/baidu/location/b/v;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037723934, "Lcom/baidu/location/b/v;");
        }
    }

    public static synchronized HandlerThread a() {
        InterceptResult invokeV;
        HandlerThread handlerThread;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (v.class) {
                if (a == null) {
                    HandlerThread handlerThread2 = new HandlerThread("ServiceStartArguments", 10);
                    a = handlerThread2;
                    handlerThread2.start();
                }
                handlerThread = a;
            }
            return handlerThread;
        }
        return (HandlerThread) invokeV.objValue;
    }
}
