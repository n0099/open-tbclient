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
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class MemberUtils {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f39682a = 7;

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f39683b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f39684c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f39685d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(107174159, "Lcom/baidu/fsg/base/utils/reflect/MemberUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(107174159, "Lcom/baidu/fsg/base/utils/reflect/MemberUtils;");
                return;
            }
        }
        f39683b = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        f39684c = new HashMap();
        f39685d = new HashMap();
        f39684c.put(Boolean.TYPE, Boolean.class);
        f39684c.put(Byte.TYPE, Byte.class);
        f39684c.put(Character.TYPE, Character.class);
        f39684c.put(Short.TYPE, Short.class);
        f39684c.put(Integer.TYPE, Integer.class);
        f39684c.put(Long.TYPE, Long.class);
        f39684c.put(Double.TYPE, Double.class);
        f39684c.put(Float.TYPE, Float.class);
        Map<Class<?>, Class<?>> map = f39684c;
        Class<?> cls = Void.TYPE;
        map.put(cls, cls);
        for (Class<?> cls2 : f39684c.keySet()) {
            Class<?> cls3 = f39684c.get(cls2);
            if (!cls2.equals(cls3)) {
                f39685d.put(cls3, cls2);
            }
        }
    }

    public MemberUtils() {
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

    public static float a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, clsArr, clsArr2)) == null) {
            float f2 = 0.0f;
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                f2 += b(clsArr[i2], clsArr2[i2]);
            }
            return f2;
        }
        return invokeLL.floatValue;
    }

    public static int a(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, clsArr, clsArr2, clsArr3)) == null) {
            float a2 = a(clsArr3, clsArr);
            float a3 = a(clsArr3, clsArr2);
            if (a2 < a3) {
                return -1;
            }
            return a3 < a2 ? 1 : 0;
        }
        return invokeLLL.intValue;
    }

    public static Class<?> a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls)) == null) ? (cls == null || !cls.isPrimitive()) ? cls : f39684c.get(cls) : (Class) invokeL.objValue;
    }

    public static boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? (i2 & 7) == 0 : invokeI.booleanValue;
    }

    public static boolean a(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, cls, cls2)) == null) ? a(cls, cls2, true) : invokeLL.booleanValue;
    }

    public static boolean a(Class<?> cls, Class<?> cls2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, cls, cls2, z)) == null) {
            if (cls2 == null) {
                return false;
            }
            if (cls == null) {
                return !cls2.isPrimitive();
            }
            if (z) {
                if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = a(cls)) == null) {
                    return false;
                }
                if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = b(cls)) == null) {
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

    public static boolean a(AccessibleObject accessibleObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, accessibleObject)) == null) {
            if (accessibleObject != null && !accessibleObject.isAccessible()) {
                Member member = (Member) accessibleObject;
                if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && a(member.getDeclaringClass().getModifiers())) {
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

    public static boolean a(Member member) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, member)) == null) ? (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true : invokeL.booleanValue;
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65546, null, clsArr, clsArr2, z)) == null) {
            if (Utils.a(clsArr, clsArr2)) {
                if (clsArr == null) {
                    clsArr = Utils.f39688b;
                }
                if (clsArr2 == null) {
                    clsArr2 = Utils.f39688b;
                }
                for (int i2 = 0; i2 < clsArr.length; i2++) {
                    if (!a(clsArr[i2], clsArr2[i2], z)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static float b(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, cls, cls2)) == null) {
            if (cls2.isPrimitive()) {
                return c(cls, cls2);
            }
            float f2 = 0.0f;
            while (true) {
                if (cls != null && !cls2.equals(cls)) {
                    if (cls2.isInterface() && a(cls, cls2)) {
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

    public static Class<?> b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, cls)) == null) ? f39685d.get(cls) : (Class) invokeL.objValue;
    }

    public static float c(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, cls, cls2)) == null) {
            if (cls.isPrimitive()) {
                f2 = 0.0f;
            } else {
                cls = b(cls);
                f2 = 0.1f;
            }
            int i2 = 0;
            while (cls != cls2) {
                Class<?>[] clsArr = f39683b;
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
