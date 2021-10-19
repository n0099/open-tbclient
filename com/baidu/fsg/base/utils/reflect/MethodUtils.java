package com.baidu.fsg.base.utils.reflect;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class MethodUtils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, Method> f39686a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1479839254, "Lcom/baidu/fsg/base/utils/reflect/MethodUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1479839254, "Lcom/baidu/fsg/base/utils/reflect/MethodUtils;");
                return;
            }
        }
        f39686a = new HashMap();
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

    public static <T> Constructor<T> a(Constructor<T> constructor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, constructor)) == null) {
            Validate.a(constructor != null, "constructor cannot be null", new Object[0]);
            if (MemberUtils.a((Member) constructor) && a((Class<?>) constructor.getDeclaringClass())) {
                return constructor;
            }
            return null;
        }
        return (Constructor) invokeL.objValue;
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, cls, str, clsArr)) == null) {
            while (cls != null) {
                Class<?>[] interfaces = cls.getInterfaces();
                for (int i2 = 0; i2 < interfaces.length; i2++) {
                    if (Modifier.isPublic(interfaces[i2].getModifiers())) {
                        try {
                            return interfaces[i2].getDeclaredMethod(str, clsArr);
                        } catch (NoSuchMethodException unused) {
                            Method a2 = a(interfaces[i2], str, clsArr);
                            if (a2 != null) {
                                return a2;
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

    public static Method a(Method method) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, method)) == null) {
            if (MemberUtils.a((Member) method)) {
                Class<?> declaringClass = method.getDeclaringClass();
                if (Modifier.isPublic(declaringClass.getModifiers())) {
                    return method;
                }
                String name = method.getName();
                Class<?>[] parameterTypes = method.getParameterTypes();
                Method a2 = a(declaringClass, name, parameterTypes);
                return a2 == null ? b(declaringClass, name, parameterTypes) : a2;
            }
            return null;
        }
        return (Method) invokeL.objValue;
    }

    public static boolean a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, cls)) == null) {
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

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, cls, str, clsArr)) == null) {
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null) {
                    break;
                } else if (Modifier.isPublic(cls.getModifiers())) {
                    try {
                        return cls.getMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                    }
                }
            }
            return null;
        }
        return (Method) invokeLLL.objValue;
    }

    public static String c(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, cls, str, clsArr)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.toString());
            sb.append("#");
            sb.append(str);
            if (clsArr == null || clsArr.length <= 0) {
                sb.append(Void.class.toString());
            } else {
                for (Class<?> cls2 : clsArr) {
                    sb.append(cls2.toString());
                    sb.append("#");
                }
            }
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }

    public static Method d(Class<?> cls, String str, Class<?>... clsArr) {
        InterceptResult invokeLLL;
        Method method;
        Method[] methods;
        Method a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, cls, str, clsArr)) == null) {
            String c2 = c(cls, str, clsArr);
            synchronized (f39686a) {
                method = f39686a.get(c2);
            }
            if (method != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            }
            try {
                Method method2 = cls.getMethod(str, clsArr);
                MemberUtils.a((AccessibleObject) method2);
                synchronized (f39686a) {
                    f39686a.put(c2, method2);
                }
                return method2;
            } catch (NoSuchMethodException unused) {
                Method method3 = null;
                for (Method method4 : cls.getMethods()) {
                    if (method4.getName().equals(str) && MemberUtils.a(clsArr, method4.getParameterTypes(), true) && (a2 = a(method4)) != null && (method3 == null || MemberUtils.a(a2.getParameterTypes(), method3.getParameterTypes(), clsArr) < 0)) {
                        method3 = a2;
                    }
                }
                if (method3 != null) {
                    MemberUtils.a((AccessibleObject) method3);
                }
                synchronized (f39686a) {
                    f39686a.put(c2, method3);
                    return method3;
                }
            }
        }
        return (Method) invokeLLL.objValue;
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        InterceptResult invokeLLL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, null, cls, str, clsArr)) == null) {
            String c2 = c(cls, str, clsArr);
            synchronized (f39686a) {
                method = f39686a.get(c2);
            }
            if (method != null) {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            }
            Method a2 = a(cls.getMethod(str, clsArr));
            synchronized (f39686a) {
                f39686a.put(c2, a2);
            }
            return a2;
        }
        return (Method) invokeLLL.objValue;
    }

    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        InterceptResult invokeLL;
        Constructor<?>[] constructors;
        Constructor<T> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cls, clsArr)) == null) {
            Validate.a(cls != null, "class cannot be null", new Object[0]);
            try {
                Constructor<T> constructor = cls.getConstructor(clsArr);
                MemberUtils.a((AccessibleObject) constructor);
                return constructor;
            } catch (NoSuchMethodException unused) {
                Constructor<T> constructor2 = null;
                for (Constructor<?> constructor3 : cls.getConstructors()) {
                    if (MemberUtils.a(clsArr, constructor3.getParameterTypes(), true) && (a2 = a(constructor3)) != null) {
                        MemberUtils.a((AccessibleObject) a2);
                        if (constructor2 == null || MemberUtils.a(a2.getParameterTypes(), constructor2.getParameterTypes(), clsArr) < 0) {
                            constructor2 = a2;
                        }
                    }
                }
                return constructor2;
            }
        }
        return (Constructor) invokeLL.objValue;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, cls, objArr)) == null) {
            Object[] a2 = Utils.a(objArr);
            return (T) invokeConstructor(cls, a2, Utils.b(a2));
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65548, null, cls, objArr, clsArr)) == null) {
            Object[] a2 = Utils.a(objArr);
            Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, Utils.a(clsArr));
            if (matchingAccessibleConstructor != null) {
                return (T) matchingAccessibleConstructor.newInstance(a2);
            }
            throw new NoSuchMethodException("No such accessible constructor on object: " + cls.getName());
        }
        return (T) invokeLLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65549, null, obj, str, objArr)) == null) {
            Object[] a2 = Utils.a(objArr);
            return invokeMethod(obj, str, a2, Utils.b(a2));
        }
        return invokeLLL.objValue;
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, obj, str, objArr, clsArr)) == null) {
            Class<?>[] a2 = Utils.a(clsArr);
            Object[] a3 = Utils.a(objArr);
            Method d2 = d(obj.getClass(), str, a2);
            if (d2 != null) {
                return d2.invoke(obj, a3);
            }
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
        }
        return invokeLLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65551, null, cls, str, objArr)) == null) {
            Object[] a2 = Utils.a(objArr);
            return invokeStaticMethod(cls, str, a2, Utils.b(a2));
        }
        return invokeLLL.objValue;
    }

    public static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65552, null, cls, str, objArr, clsArr)) == null) {
            Class<?>[] a2 = Utils.a(clsArr);
            Object[] a3 = Utils.a(objArr);
            Method d2 = d(cls, str, a2);
            if (d2 != null) {
                return d2.invoke(null, a3);
            }
            throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + cls.getName());
        }
        return invokeLLLL.objValue;
    }
}
