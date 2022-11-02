package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.vi.VIContext;
/* loaded from: classes2.dex */
public class JNIInitializer {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public transient /* synthetic */ FieldHolder $fh;

    public JNIInitializer() {
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

    public static Context getCachedContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (Context) invokeV.objValue;
    }

    public static void setContext(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, application) == null) {
            if (application != null) {
                if (a == null) {
                    a = application;
                }
                VIContext.init(application);
                return;
            }
            throw new RuntimeException();
        }
    }
}
