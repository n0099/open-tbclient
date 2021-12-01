package com.baidu.android.imsdk.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class MethodInvokeUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MethodInvokeUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Object invoke(Method method, Class<?> cls, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, method, cls, objArr)) == null) {
            try {
                method.invoke(cls, objArr);
                return null;
            } catch (IllegalAccessException e2) {
                LogUtils.e(LogUtils.TAG, "IllegalAccessException ", e2);
                return null;
            } catch (IllegalArgumentException e3) {
                LogUtils.e(LogUtils.TAG, "IllegalArgumentException ", e3);
                return null;
            } catch (InvocationTargetException e4) {
                LogUtils.e(LogUtils.TAG, "InvocationTargetException ", e4);
                return null;
            }
        }
        return invokeLLL.objValue;
    }
}
