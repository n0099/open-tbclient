package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public static Object a;
    public static r b;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences c;
    public SharedPreferences d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1037723810, "Lcom/baidu/location/b/r;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1037723810, "Lcom/baidu/location/b/r;");
                return;
            }
        }
        a = new Object();
    }

    public r() {
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
        this.c = null;
        this.d = null;
        if (0 == 0) {
            try {
                if (com.baidu.location.f.getServiceContext() != null) {
                    this.c = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePreIA", 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.c = null;
            }
        }
    }

    public static r a() {
        InterceptResult invokeV;
        r rVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a) {
                if (b == null) {
                    b = new r();
                }
                rVar = b;
            }
            return rVar;
        }
        return (r) invokeV.objValue;
    }

    public SharedPreferences a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.d == null && context != null) {
                try {
                    this.d = context.getSharedPreferences("MapCoreServicePregck", 0);
                } catch (Exception e) {
                    e.printStackTrace();
                    this.d = null;
                }
            }
            return this.d;
        }
        return (SharedPreferences) invokeL.objValue;
    }
}
