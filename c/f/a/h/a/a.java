package c.f.a.h.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.dxmpay.apollon.utils.reflect.Utils;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Class<?>[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f28150b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f28151c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1933258270, "Lc/f/a/h/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1933258270, "Lc/f/a/h/a/a;");
                return;
            }
        }
        a = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        f28150b = new HashMap();
        f28151c = new HashMap();
        f28150b.put(Boolean.TYPE, Boolean.class);
        f28150b.put(Byte.TYPE, Byte.class);
        f28150b.put(Character.TYPE, Character.class);
        f28150b.put(Short.TYPE, Short.class);
        f28150b.put(Integer.TYPE, Integer.class);
        f28150b.put(Long.TYPE, Long.class);
        f28150b.put(Double.TYPE, Double.class);
        f28150b.put(Float.TYPE, Float.class);
        Map<Class<?>, Class<?>> map = f28150b;
        Class<?> cls = Void.TYPE;
        map.put(cls, cls);
        for (Class<?> cls2 : f28150b.keySet()) {
            Class<?> cls3 = f28150b.get(cls2);
            if (!cls2.equals(cls3)) {
                f28151c.put(cls3, cls2);
            }
        }
    }

    public static float a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, clsArr, clsArr2)) == null) {
            float f2 = 0.0f;
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                f2 += j(clsArr[i2], clsArr2[i2]);
            }
            return f2;
        }
        return invokeLL.floatValue;
    }

    public static int b(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, clsArr, clsArr2, clsArr3)) == null) {
            float a2 = a(clsArr3, clsArr);
            float a3 = a(clsArr3, clsArr2);
            if (a2 < a3) {
                return -1;
            }
            return a3 < a2 ? 1 : 0;
        }
        return invokeLLL.intValue;
    }

    public static Class<?> c(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) ? (cls == null || !cls.isPrimitive()) ? cls : f28150b.get(cls) : (Class) invokeL.objValue;
    }

    public static boolean d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? (i2 & 7) == 0 : invokeI.booleanValue;
    }

    public static boolean e(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, cls, cls2)) == null) ? f(cls, cls2, true) : invokeLL.booleanValue;
    }

    public static boolean f(Class<?> cls, Class<?> cls2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, cls, cls2, z)) == null) {
            if (cls2 == null) {
                return false;
            }
            if (cls == null) {
                return !cls2.isPrimitive();
            }
            if (z) {
                if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = c(cls)) == null) {
                    return false;
                }
                if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = k(cls)) == null) {
                    return false;
                }
            }
            if (cls.equals(cls2)) {
                return true;
            }
            if (cls.isPrimitive()) {
                if (cls2.isPrimitive()) {
                    if (Integer.TYPE.equals(cls)) {
                        return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                    } else if (Long.TYPE.equals(cls)) {
                        return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                    } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                        return false;
                    } else {
                        if (Float.TYPE.equals(cls)) {
                            return Double.TYPE.equals(cls2);
                        }
                        if (Character.TYPE.equals(cls)) {
                            return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                        } else if (Short.TYPE.equals(cls)) {
                            return Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                        } else if (Byte.TYPE.equals(cls)) {
                            return Short.TYPE.equals(cls2) || Integer.TYPE.equals(cls2) || Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
                        } else {
                            return false;
                        }
                    }
                }
                return false;
            }
            return cls2.isAssignableFrom(cls);
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean g(AccessibleObject accessibleObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, accessibleObject)) == null) {
            if (accessibleObject != null && !accessibleObject.isAccessible()) {
                Member member = (Member) accessibleObject;
                if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && d(member.getDeclaringClass().getModifiers())) {
                    try {
                        accessibleObject.setAccessible(true);
                        return true;
                    } catch (SecurityException unused) {
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(Member member) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, member)) == null) ? (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true : invokeL.booleanValue;
    }

    public static boolean i(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, clsArr, clsArr2, z)) == null) {
            if (Utils.b(clsArr, clsArr2)) {
                if (clsArr == null) {
                    clsArr = Utils.f53704b;
                }
                if (clsArr2 == null) {
                    clsArr2 = Utils.f53704b;
                }
                for (int i2 = 0; i2 < clsArr.length; i2++) {
                    if (!f(clsArr[i2], clsArr2[i2], z)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static float j(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, cls, cls2)) == null) {
            if (cls2.isPrimitive()) {
                return l(cls, cls2);
            }
            float f2 = 0.0f;
            while (true) {
                if (cls != null && !cls2.equals(cls)) {
                    if (cls2.isInterface() && e(cls, cls2)) {
                        f2 += 0.25f;
                        break;
                    }
                    f2 += 1.0f;
                    cls = cls.getSuperclass();
                } else {
                    break;
                }
            }
            return cls == null ? f2 + 1.5f : f2;
        }
        return invokeLL.floatValue;
    }

    public static Class<?> k(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cls)) == null) ? f28151c.get(cls) : (Class) invokeL.objValue;
    }

    public static float l(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, cls, cls2)) == null) {
            if (cls.isPrimitive()) {
                f2 = 0.0f;
            } else {
                cls = k(cls);
                f2 = 0.1f;
            }
            int i2 = 0;
            while (cls != cls2) {
                Class<?>[] clsArr = a;
                if (i2 >= clsArr.length) {
                    break;
                }
                if (cls == clsArr[i2]) {
                    f2 += 0.1f;
                    if (i2 < clsArr.length - 1) {
                        cls = clsArr[i2 + 1];
                    }
                }
                i2++;
            }
            return f2;
        }
        return invokeLL.floatValue;
    }
}
