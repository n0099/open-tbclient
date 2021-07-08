package com.baidu.mobads.container.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/* loaded from: classes2.dex */
public class ReflectionUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ReflectionUtils() {
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

    public static Class<?> getClass(String str, ClassLoader classLoader) {
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

    public static Field getDeclaredField(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, obj, str)) == null) {
            for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                try {
                    return cls.getDeclaredField(str);
                } catch (Exception unused) {
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static Object getFieldValue(ClassLoader classLoader, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, classLoader, str, str2)) == null) {
            try {
                return getFieldValue((Class) Class.forName(str, true, classLoader), str2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    public static Method getMethod(Object obj, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, obj, str, clsArr)) == null) {
            try {
                Method declaredMethod = getClass(obj).getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Exception unused) {
                return null;
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object getNewInstance(String str, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, clsArr, objArr)) == null) {
            try {
                Class cls = getClass(str);
                if (cls != null) {
                    return cls.getDeclaredConstructor(clsArr).newInstance(objArr);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, objArr)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, str, invocationHandler)) == null) {
            Class cls = getClass(str);
            if (cls != null) {
                return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler);
            }
            return null;
        }
        return invokeLL.objValue;
    }

    public static Object invoke(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65552, null, obj, str, objArr)) == null) {
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
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{str, obj, classLoader, str2, clsArr, objArr})) == null) {
            try {
                Class<?> cls = getClass(str, classLoader);
                if (cls != null && (declaredMethod = cls.getDeclaredMethod(str2, clsArr)) != null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, cls, str, objArr)) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, cls, str, clsArr)) == null) {
            try {
                return cls.getDeclaredMethod(str, clsArr) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static Class getClass(String str) {
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

    public static Class<?> getClass(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            try {
                return Class.forName(obj.getClass().getName());
            } catch (Exception e2) {
                RemoteXAdLogger.getInstance().d(e2);
                return null;
            }
        }
        return (Class) invokeL.objValue;
    }

    public static Object getFieldValue(Class cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, cls, str)) == null) {
            Field declaredField = getDeclaredField((Class<?>) cls, str);
            declaredField.setAccessible(true);
            try {
                return declaredField.get(cls);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, cls, str, clsArr)) == null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                }
            } catch (Exception unused) {
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Object invoke(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65551, null, obj, str, clsArr, objArr)) == null) {
            try {
                return invoke(obj.getClass(), obj, str, clsArr, objArr);
            } catch (Throwable unused) {
                return null;
            }
        }
        return invokeLLLL.objValue;
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Class[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65555, null, cls, str, clsArr, objArr)) == null) {
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

    public static Object invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65550, null, cls, obj, str, clsArr, objArr)) == null) {
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

    public static Field getDeclaredField(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, str)) == null) {
            while (cls != Object.class) {
                try {
                    return cls.getDeclaredField(str);
                } catch (Exception unused) {
                    cls = cls.getSuperclass();
                }
            }
            return null;
        }
        return (Field) invokeLL.objValue;
    }

    public static Object invokeMethod(String str, Object obj, String str2, Class<?>[] clsArr, Object... objArr) {
        InterceptResult invokeLLLLL;
        Method declaredMethod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65554, null, str, obj, str2, clsArr, objArr)) == null) {
            try {
                Class cls = getClass(str);
                if (cls != null && (declaredMethod = cls.getDeclaredMethod(str2, clsArr)) != null) {
                    declaredMethod.setAccessible(true);
                    return declaredMethod.invoke(obj, objArr);
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        return invokeLLLLL.objValue;
    }

    public static Object getFieldValue(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, str)) == null) {
            Field declaredField = getDeclaredField(obj, str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
                try {
                    return declaredField.get(obj);
                } catch (Exception unused) {
                    return null;
                }
            }
            return null;
        }
        return invokeLL.objValue;
    }
}
