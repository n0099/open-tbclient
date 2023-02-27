package com.baidu.android.pushservice.jni;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class NativeReflect {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1536518785, "Lcom/baidu/android/pushservice/jni/NativeReflect;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1536518785, "Lcom/baidu/android/pushservice/jni/NativeReflect;");
                return;
            }
        }
        try {
            System.loadLibrary("bdpush_V3_6");
        } catch (Throwable unused) {
        }
    }

    public static native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);
}
