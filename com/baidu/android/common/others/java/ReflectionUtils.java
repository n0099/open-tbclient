package com.baidu.android.common.others.java;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public final class ReflectionUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ReflectionUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public ReflectionUtils() {
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

    public static boolean invokeDeclaredMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, obj, str, clsArr, objArr)) == null) {
            try {
                if (obj instanceof Class) {
                    cls = (Class) obj;
                } else {
                    cls = obj.getClass();
                }
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(obj, objArr);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static Object invokeDeclaredMethodForObject(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, obj, str, clsArr, objArr)) == null) {
            try {
                if (obj instanceof Class) {
                    cls = (Class) obj;
                } else {
                    cls = obj.getClass();
                }
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, objArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeLLLL.objValue;
    }

    public static boolean invokeHideMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, obj, str, clsArr, objArr)) == null) {
            try {
                if (obj instanceof Class) {
                    cls = (Class) obj;
                } else {
                    cls = obj.getClass();
                }
                cls.getMethod(str, clsArr).invoke(obj, objArr);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public static Object invokeHideMethodForObject(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, clsArr, objArr)) == null) {
            try {
                if (obj instanceof Class) {
                    cls = (Class) obj;
                } else {
                    cls = obj.getClass();
                }
                return cls.getMethod(str, clsArr).invoke(obj, objArr);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeLLLL.objValue;
    }
}
