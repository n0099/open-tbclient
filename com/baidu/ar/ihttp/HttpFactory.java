package com.baidu.ar.ihttp;

import com.baidu.ar.h.n;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class HttpFactory {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b ry;
    public static volatile int rz;
    public static Object sLock;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1938173543, "Lcom/baidu/ar/ihttp/HttpFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1938173543, "Lcom/baidu/ar/ihttp/HttpFactory;");
                return;
            }
        }
        sLock = new Object();
    }

    public HttpFactory() {
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

    public static b eP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (ry != null) {
                return ry;
            }
            if (isAvailable()) {
                synchronized (sLock) {
                    if (ry == null) {
                        ry = (b) n.aV("com.baidu.ar.http.HttpRequestFactory");
                    }
                }
            }
            return ry;
        }
        return (b) invokeV.objValue;
    }

    public static boolean isAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (rz == 1) {
                return true;
            }
            boolean z = false;
            if (rz == -1) {
                return false;
            }
            try {
                Class.forName("com.baidu.ar.http.HttpRequestFactory");
                z = true;
            } catch (ClassNotFoundException unused) {
            }
            synchronized (sLock) {
                rz = z ? 1 : -1;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static IHttpRequest newRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            b eP = eP();
            if (eP != null) {
                return eP.newRequest();
            }
            return null;
        }
        return (IHttpRequest) invokeV.objValue;
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) || ry == null) {
            return;
        }
        ry.release();
        ry = null;
    }
}
