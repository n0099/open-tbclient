package com.baidu.ar.plugin.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class MethodUtils {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, Method> sMethodCache;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1258892073, "Lcom/baidu/ar/plugin/reflect/MethodUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1258892073, "Lcom/baidu/ar/plugin/reflect/MethodUtils;");
                return;
            }
        }
        sMethodCache = new HashMap();
    }

    public MethodUtils() {
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

    public static <T> Constructor<T> getAccessibleConstructor(Constructor<T> constructor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, constructor)) == null) {
            Validate.isTrue(constructor != null, "constructor cannot be null", new Object[0]);
            if (MemberUtils.isAccessible(constructor) && isAccessible(constructor.getDeclaringClass())) {
                return constructor;
            }
            return null;
        }
        return (Constructor) invokeL.objValue;
    }

    public static Method getAccessibleMethod(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, method)) == null) {
            if (MemberUtils.isAccessible(method)) {
                Class<?> declaringClass = method.getDeclaringClass();
                if (Modifier.isPublic(declaringClass.getModifiers())) {
                    return method;
                }
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
                return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes) : accessibleMethodFromInterfaceNest;
            }
            return null;
        }
        return (Method) invokeL.objValue;
    }

    public static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, cls, str, clsArr)) == null) {
            while (cls != null) {
                Class<?>[] interfaces = cls.getInterfaces();
                for (int i2 = 0; i2 < interfaces.length; i2++) {
                    if (Modifier.isPublic(interfaces[i2].getModifiers())) {
                        try {
                            return interfaces[i2].getDeclaredMethod(str, clsArr);
                        } catch (NoSuchMethodException unused) {
                            Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(interfaces[i2], str, clsArr);
                            if (accessibleMethodFromInterfaceNest != null) {
                                return accessibleMethodFromInterfaceNest;
                            }
                        }
                    }
                }
                cls = cls.getSuperclass();
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, cls, str, clsArr)) == null) {
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                if (Modifier.isPublic(superclass.getModifiers())) {
                    try {
                        return superclass.getMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        return null;
                    }
                }
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static String getKey(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, str, clsArr)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.toString());
            sb.append("#");
            sb.append(str);
            if (clsArr != null && clsArr.length > 0) {
                for (Class<?> cls2 : clsArr) {
                    sb.append(cls2.toString());
                    sb.append("#");
                }
            } else {
                sb.append(Void.class.toString());
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Constructor<?>[] constructors;
        Constructor<T> accessibleConstructor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, cls, clsArr)) == null) {
            Validate.isTrue(cls != null, "class cannot be null", new Object[0]);
            try {
                Constructor<T> constructor = cls.getConstructor(clsArr);
                MemberUtils.setAccessibleWorkaround(constructor);
                return constructor;
            } catch (NoSuchMethodException unused) {
                Constructor<T> constructor2 = null;
                for (Constructor<?> constructor3 : cls.getConstructors()) {
                    if (MemberUtils.isAssignable(clsArr, constructor3.getParameterTypes(), true) && (accessibleConstructor = getAccessibleConstructor(constructor3)) != null) {
                        MemberUtils.setAccessibleWorkaround(accessibleConstructor);
                        if (constructor2 == null || MemberUtils.compareParameterTypes(accessibleConstructor.getParameterTypes(), constructor2.getParameterTypes(), clsArr) < 0) {
                            constructor2 = accessibleConstructor;
                        }
                    }
                }
                return constructor2;
            }
        }
        return (Constructor) invokeLL.objValue;
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Method method;
        Method[] methods;
        Method accessibleMethod;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, cls, str, clsArr)) == null) {
            String key = getKey(cls, str, clsArr);
            synchronized (sMethodCache) {
                method = sMethodCache.get(key);
            }
            if (method != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            }
            try {
                Method method2 = cls.getMethod(str, clsArr);
                MemberUtils.setAccessibleWorkaround(method2);
                synchronized (sMethodCache) {
                    sMethodCache.put(key, method2);
                }
                return method2;
            } catch (NoSuchMethodException unused) {
                Method method3 = null;
                for (Method method4 : cls.getMethods()) {
                    if (method4.getName().equals(str) && MemberUtils.isAssignable(clsArr, method4.getParameterTypes(), true) && (accessibleMethod = getAccessibleMethod(method4)) != null && (method3 == null || MemberUtils.compareParameterTypes(accessibleMethod.getParameterTypes(), method3.getParameterTypes(), clsArr) < 0)) {
                        method3 = accessibleMethod;
                    }
                }
                if (method3 != null) {
                    MemberUtils.setAccessibleWorkaround(method3);
                }
                synchronized (sMethodCache) {
                    sMethodCache.put(key, method3);
                    return method3;
                }
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cls, objArr)) == null) {
            Object[] nullToEmpty = Utils.nullToEmpty(objArr);
            return (T) invokeConstructor(cls, nullToEmpty, Utils.toClass(nullToEmpty));
        }
        return (T) invokeLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, obj, str, objArr, clsArr)) == null) {
            Class<?>[] nullToEmpty = Utils.nullToEmpty(clsArr);
            Object[] nullToEmpty2 = Utils.nullToEmpty(objArr);
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, nullToEmpty);
            if (matchingAccessibleMethod != null) {
                return matchingAccessibleMethod.invoke(obj, nullToEmpty2);
            }
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return invokeLLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65551, null, cls, str, objArr, clsArr)) == null) {
            Class<?>[] nullToEmpty = Utils.nullToEmpty(clsArr);
            Object[] nullToEmpty2 = Utils.nullToEmpty(objArr);
            Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, nullToEmpty);
            if (matchingAccessibleMethod != null) {
                return matchingAccessibleMethod.invoke(null, nullToEmpty2);
            }
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
        }
        return invokeLLLL.objValue;
    }

    public static boolean isAccessible(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, cls)) == null) {
            while (cls != null) {
                if (!Modifier.isPublic(cls.getModifiers())) {
                    return false;
                }
                cls = cls.getEnclosingClass();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, cls, objArr, clsArr)) == null) {
            Object[] nullToEmpty = Utils.nullToEmpty(objArr);
            Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, Utils.nullToEmpty(clsArr));
            if (matchingAccessibleConstructor != null) {
                return (T) matchingAccessibleConstructor.newInstance(nullToEmpty);
            }
            throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
        }
        return (T) invokeLLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, obj, str, objArr)) == null) {
            Object[] nullToEmpty = Utils.nullToEmpty(objArr);
            return invokeMethod(obj, str, nullToEmpty, Utils.toClass(nullToEmpty));
        }
        return invokeLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, cls, str, objArr)) == null) {
            Object[] nullToEmpty = Utils.nullToEmpty(objArr);
            return invokeStaticMethod(cls, str, nullToEmpty, Utils.toClass(nullToEmpty));
        }
        return invokeLLL.objValue;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
            String key = getKey(cls, str, clsArr);
            synchronized (sMethodCache) {
                method = sMethodCache.get(key);
            }
            if (method != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            }
            Method accessibleMethod = getAccessibleMethod(cls.getMethod(str, clsArr));
            synchronized (sMethodCache) {
                sMethodCache.put(key, accessibleMethod);
            }
            return accessibleMethod;
        }
        return (Method) invokeLLL.objValue;
    }
}
