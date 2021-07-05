package com.baidu.nps.utils;

import android.app.Application;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d0.c.a.b;
/* loaded from: classes3.dex */
public class ContextHolder {
    public static /* synthetic */ Interceptable $ic;
    public static Application sApplicationContext;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1432449526, "Lcom/baidu/nps/utils/ContextHolder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1432449526, "Lcom/baidu/nps/utils/ContextHolder;");
                return;
            }
        }
        sApplicationContext = b.b().a();
    }

    public ContextHolder() {
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

    public static Application getApplicationContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sApplicationContext : (Application) invokeV.objValue;
    }

    public static void setApplicationContext(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, application) == null) {
            sApplicationContext = application;
        }
    }
}
