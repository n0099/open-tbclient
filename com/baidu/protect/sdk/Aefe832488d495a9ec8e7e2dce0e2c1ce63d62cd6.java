package com.baidu.protect.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String libName = "baiduprotect_sdk-efe832488d495a9ec8e7e2dce0e2c1ce63d62cd6";
    public transient /* synthetic */ FieldHolder $fh;

    public static native byte b(int i, Object obj, Object... objArr);

    public static native char c(int i, Object obj, Object... objArr);

    public static native double d(int i, Object obj, Object... objArr);

    public static native float f(int i, Object obj, Object... objArr);

    public static native int i(int i, Object obj, Object... objArr);

    public static native long j(int i, Object obj, Object... objArr);

    public static native Object l(int i, Object obj, Object... objArr);

    public static native short s(int i, Object obj, Object... objArr);

    public static native void v(int i, Object obj, Object... objArr);

    public static native boolean z(int i, Object obj, Object... objArr);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2005741488, "Lcom/baidu/protect/sdk/Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2005741488, "Lcom/baidu/protect/sdk/Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;");
                return;
            }
        }
        int i = 0;
        while (i < 3) {
            try {
                System.loadLibrary(libName);
                break;
            } catch (Throwable unused) {
                i++;
            }
        }
        if (3 == i) {
            SdkManager.notifyInitError();
        }
    }

    public Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
