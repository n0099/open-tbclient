package com.baidu.ar.plugin.reflect;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes9.dex */
public class MemberUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ACCESS_TEST = 7;
    public static final Class<?>[] ORDERED_PRIMITIVE_TYPES;
    public static final Map<Class<?>, Class<?>> primitiveWrapperMap;
    public static final Map<Class<?>, Class<?>> wrapperPrimitiveMap;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-113773022, "Lcom/baidu/ar/plugin/reflect/MemberUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-113773022, "Lcom/baidu/ar/plugin/reflect/MemberUtils;");
                return;
            }
        }
        ORDERED_PRIMITIVE_TYPES = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
        HashMap hashMap = new HashMap();
        primitiveWrapperMap = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        primitiveWrapperMap.put(Byte.TYPE, Byte.class);
        primitiveWrapperMap.put(Character.TYPE, Character.class);
        primitiveWrapperMap.put(Short.TYPE, Short.class);
        primitiveWrapperMap.put(Integer.TYPE, Integer.class);
        primitiveWrapperMap.put(Long.TYPE, Long.class);
        primitiveWrapperMap.put(Double.TYPE, Double.class);
        primitiveWrapperMap.put(Float.TYPE, Float.class);
        Map<Class<?>, Class<?>> map = primitiveWrapperMap;
        Class<?> cls = Void.TYPE;
        map.put(cls, cls);
        wrapperPrimitiveMap = new HashMap();
        for (Class<?> cls2 : primitiveWrapperMap.keySet()) {
            Class<?> cls3 = primitiveWrapperMap.get(cls2);
            if (!cls2.equals(cls3)) {
                wrapperPrimitiveMap.put(cls3, cls2);
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

    public static int compareParameterTypes(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, clsArr, clsArr2, clsArr3)) == null) {
            float totalTransformationCost = getTotalTransformationCost(clsArr3, clsArr);
            float totalTransformationCost2 = getTotalTransformationCost(clsArr3, clsArr2);
            if (totalTransformationCost < totalTransformationCost2) {
                return -1;
            }
            return totalTransformationCost2 < totalTransformationCost ? 1 : 0;
        }
        return invokeLLL.intValue;
    }

    public static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, cls, cls2)) == null) {
            if (cls2.isPrimitive()) {
                return getPrimitivePromotionCost(cls, cls2);
            }
            float f2 = 0.0f;
            while (true) {
                if (cls != null && !cls2.equals(cls)) {
                    if (cls2.isInterface() && isAssignable(cls, cls2)) {
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

    public static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, cls, cls2)) == null) {
            if (cls.isPrimitive()) {
                f2 = 0.0f;
            } else {
                cls = wrapperToPrimitive(cls);
                f2 = 0.1f;
            }
            int i2 = 0;
            while (cls != cls2) {
                Class<?>[] clsArr = ORDERED_PRIMITIVE_TYPES;
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

    public static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, clsArr, clsArr2)) == null) {
            float f2 = 0.0f;
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                f2 += getObjectTransformationCost(clsArr[i2], clsArr2[i2]);
            }
            return f2;
        }
        return invokeLL.floatValue;
    }

    public static boolean isAccessible(Member member) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, member)) == null) ? (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true : invokeL.booleanValue;
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, cls, cls2)) == null) ? isAssignable(cls, cls2, true) : invokeLL.booleanValue;
    }

    public static boolean isPackageAccess(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) ? (i2 & 7) == 0 : invokeI.booleanValue;
    }

    public static Class<?> primitiveToWrapper(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, cls)) == null) ? (cls == null || !cls.isPrimitive()) ? cls : primitiveWrapperMap.get(cls) : (Class) invokeL.objValue;
    }

    public static boolean setAccessibleWorkaround(AccessibleObject accessibleObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, accessibleObject)) == null) {
            if (accessibleObject != null && !accessibleObject.isAccessible()) {
                Member member = (Member) accessibleObject;
                if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
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

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cls)) == null) ? wrapperPrimitiveMap.get(cls) : (Class) invokeL.objValue;
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65545, null, clsArr, clsArr2, z)) == null) {
            if (Utils.isSameLength(clsArr, clsArr2)) {
                if (clsArr == null) {
                    clsArr = Utils.EMPTY_CLASS_ARRAY;
                }
                if (clsArr2 == null) {
                    clsArr2 = Utils.EMPTY_CLASS_ARRAY;
                }
                for (int i2 = 0; i2 < clsArr.length; i2++) {
                    if (!isAssignable(clsArr[i2], clsArr2[i2], z)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeLLZ.booleanValue;
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65544, null, cls, cls2, z)) == null) {
            if (cls2 == null) {
                return false;
            }
            if (cls == null) {
                return !cls2.isPrimitive();
            }
            if (z) {
                if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                    return false;
                }
                if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
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
}
