package com.baidu.mobads.container.dex;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes5.dex */
public class SkyReflectionUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SkyReflectionUtil() {
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

    public static Object callStaticMethod(Class<?> cls, String str, Class[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, cls, str, clsArr, objArr)) == null) {
            if (cls != null) {
                try {
                    return cls.getMethod(str, clsArr).invoke(null, objArr);
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return invokeLLLL.objValue;
    }

    public static Class<?> getClassForName(String str, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, classLoader)) == null) {
            if (classLoader != null) {
                try {
                    return classLoader.loadClass(str);
                } catch (Throwable unused) {
                }
            }
            return null;
        }
        return (Class) invokeLL.objValue;
    }

    public static Object getFieldValue(ClassLoader classLoader, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, classLoader, str, str2)) == null) {
            try {
                return getFieldValue(Class.forName(str, true, classLoader), str2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, cls, str, clsArr)) == null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object getNewInstance(String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, str, clsArr, objArr)) == null) {
            try {
                Class classForName = getClassForName(str);
                if (classForName != null) {
                    return classForName.getDeclaredConstructor(clsArr).newInstance(objArr);
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return invokeLLL.objValue;
    }

    public static Class<?>[] getParameterTypes(Object... objArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, objArr)) == null) {
            try {
                int length = objArr.length;
                Class<?>[] clsArr = new Class[length];
                for (int i2 = 0; i2 < length; i2++) {
                    clsArr[i2] = objArr[i2].getClass();
                }
                return clsArr;
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Class[]) invokeL.objValue;
    }

    public static Object getProxyInstance(String str, InvocationHandler invocationHandler) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, invocationHandler)) == null) {
            Class classForName = getClassForName(str);
            if (classForName != null) {
                return Proxy.newProxyInstance(classForName.getClassLoader(), new Class[]{classForName}, invocationHandler);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Object invoke(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, obj, str, objArr)) == null) {
            try {
                return invoke(obj.getClass(), obj, str, getParameterTypes(objArr), objArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Object invokeMethod(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeCommon;
        Method declaredMethod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{str, obj, classLoader, str2, clsArr, objArr})) == null) {
            try {
                Class<?> classForName = getClassForName(str, classLoader);
                if (classForName != null && (declaredMethod = classForName.getDeclaredMethod(str2, clsArr)) != null) {
                    declaredMethod.setAccessible(true);
                    return declaredMethod.invoke(obj, objArr);
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return invokeCommon.objValue;
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, cls, str, objArr)) == null) {
            try {
                return invoke(cls, null, str, getParameterTypes(objArr), objArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static boolean isMethodExist(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, cls, str, clsArr)) == null) {
            try {
                return cls.getDeclaredMethod(str, clsArr) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static Class getClassForName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return Class.forName(str);
            } catch (Throwable unused) {
                return null;
            }
        }
        return (Class) invokeL.objValue;
    }

    public static Object getFieldValue(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str)) == null) {
            Field declaredField = XAdRemoteCommonUtils.getDeclaredField(cls, str);
            declaredField.setAccessible(true);
            try {
                return declaredField.get(cls);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, obj, str, clsArr, objArr)) == null) {
            try {
                return invoke(obj.getClass(), obj, str, clsArr, objArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLLLL.objValue;
    }

    public static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65546, null, cls, obj, str, clsArr, objArr)) == null) {
            try {
                if (isMethodExist(cls, str, clsArr)) {
                    return getMethod(cls, str, clsArr).invoke(obj, objArr);
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return invokeLLLLL.objValue;
    }

    public static Object invokeMethod(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLLLL;
        Method declaredMethod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65550, null, str, obj, str2, clsArr, objArr)) == null) {
            try {
                Class classForName = getClassForName(str);
                if (classForName != null && (declaredMethod = classForName.getDeclaredMethod(str2, clsArr)) != null) {
                    declaredMethod.setAccessible(true);
                    return declaredMethod.invoke(obj, objArr);
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return invokeLLLLL.objValue;
    }
}
