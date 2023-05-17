package com.baidu.searchbox.config.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.baidu.searchbox.config.impl.FontSizeRuntime;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
@SuppressLint({"ClassShipUseDetector", "SignatureUseDetector"})
/* loaded from: classes3.dex */
public class ReflectionUtil {
    public static final String LIBCORE = "libcore";
    public static final String METHOD_ACCEPT = "accept";
    public static final String METHOD_SENDTO = "sendto";
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final Class<?>[] ORDERED_PRIMITIVE_TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
    public static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPER_MAP = new HashMap();
    public static final Map<Class<?>, Class<?>> WRAPPER_PRIVATE_MAP = new HashMap();

    static {
        PRIMITIVE_WRAPPER_MAP.put(Boolean.TYPE, Boolean.class);
        PRIMITIVE_WRAPPER_MAP.put(Byte.TYPE, Byte.class);
        PRIMITIVE_WRAPPER_MAP.put(Character.TYPE, Character.class);
        PRIMITIVE_WRAPPER_MAP.put(Short.TYPE, Short.class);
        PRIMITIVE_WRAPPER_MAP.put(Integer.TYPE, Integer.class);
        PRIMITIVE_WRAPPER_MAP.put(Long.TYPE, Long.class);
        PRIMITIVE_WRAPPER_MAP.put(Double.TYPE, Double.class);
        PRIMITIVE_WRAPPER_MAP.put(Float.TYPE, Float.class);
        Map<Class<?>, Class<?>> map = PRIMITIVE_WRAPPER_MAP;
        Class<?> cls = Void.TYPE;
        map.put(cls, cls);
        for (Class<?> cls2 : PRIMITIVE_WRAPPER_MAP.keySet()) {
            Class<?> cls3 = PRIMITIVE_WRAPPER_MAP.get(cls2);
            if (!cls2.equals(cls3)) {
                WRAPPER_PRIVATE_MAP.put(cls3, cls2);
            }
        }
    }

    public static int compareParameterTypes(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float totalTransformationCost = getTotalTransformationCost(clsArr3, clsArr);
        float totalTransformationCost2 = getTotalTransformationCost(clsArr3, clsArr2);
        if (totalTransformationCost < totalTransformationCost2) {
            return -1;
        }
        if (totalTransformationCost2 < totalTransformationCost) {
            return 1;
        }
        return 0;
    }

    public static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (Modifier.isPublic(interfaces[i].getModifiers())) {
                    try {
                        return interfaces[i].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(interfaces[i], str, clsArr);
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

    public static Method getAccessibleMethodFromSuperclass(Class<?> cls, String str, Class<?>... clsArr) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (Modifier.isPublic(superclass.getModifiers())) {
                try {
                    return superclass.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                    return null;
                }
            }
        }
        return null;
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return invokeMethod(obj, str, toClass(objArr), objArr);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, toClass(objArr));
        if (matchingAccessibleMethod == null) {
            return null;
        }
        return matchingAccessibleMethod.invoke(null, objArr);
    }

    public static boolean isAssignable(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (!isSameLength(clsArr, clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = EMPTY_CLASS_ARRAY;
        }
        if (clsArr2 == null) {
            clsArr2 = EMPTY_CLASS_ARRAY;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!isAssignable(clsArr[i], clsArr2[i], z)) {
                return false;
            }
        }
        return true;
    }

    public static boolean setFieldValue(Object obj, String str, Object obj2) throws IllegalAccessException {
        Field field;
        if (obj == null || TextUtils.isEmpty(str) || obj2 == null || (field = getField(obj, str)) == null) {
            return false;
        }
        field.set(obj, obj2);
        return true;
    }

    public static boolean setStaticFieldValue(Class cls, String str, Object obj) throws IllegalAccessException {
        Field field;
        if (cls == null || TextUtils.isEmpty(str) || (field = getField((Class<?>) cls, str)) == null) {
            return false;
        }
        field.set(null, obj);
        return true;
    }

    public static Method getAccessibleMethod(Method method) {
        if (!isAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
        if (accessibleMethodFromInterfaceNest == null) {
            return getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes);
        }
        return accessibleMethodFromInterfaceNest;
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        getAllInterfaces(cls, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public static Class<?> getClass(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public static boolean isAccessible(Member member) {
        if (member != null && Modifier.isPublic(member.getModifiers()) && !member.isSynthetic()) {
            return true;
        }
        return false;
    }

    public static Class<?>[] toClass(Object... objArr) {
        Class<?> cls;
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return EMPTY_CLASS_ARRAY;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i] == null) {
                cls = null;
            } else {
                cls = objArr[i].getClass();
            }
            clsArr[i] = cls;
        }
        return clsArr;
    }

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        return WRAPPER_PRIVATE_MAP.get(cls);
    }

    public static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> hashSet) {
        Class<?>[] interfaces;
        while (cls != null) {
            for (Class<?> cls2 : cls.getInterfaces()) {
                if (hashSet.add(cls2)) {
                    getAllInterfaces(cls2, hashSet);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static Field getField(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            return getField(obj.getClass(), str);
        }
        return null;
    }

    public static Object getFieldValue(Object obj, String str) throws IllegalAccessException {
        Field field;
        if (TextUtils.isEmpty(str) || obj == null || (field = getField(obj, str)) == null) {
            return null;
        }
        return field.get(obj);
    }

    public static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        float f;
        if (!cls.isPrimitive()) {
            cls = wrapperToPrimitive(cls);
            f = 0.1f;
        } else {
            f = 0.0f;
        }
        int i = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = ORDERED_PRIMITIVE_TYPES;
            if (i >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i]) {
                f += 0.1f;
                if (i < clsArr.length - 1) {
                    cls = clsArr[i + 1];
                }
            }
            i++;
        }
        return f;
    }

    public static Object getStaticFieldValue(Class<?> cls, String str) throws IllegalAccessException {
        Field field = getField(cls, str);
        if (field == null || !Modifier.isStatic(field.getModifiers())) {
            return null;
        }
        field.setAccessible(true);
        return field.get(null);
    }

    public static float getTotalTransformationCost(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f = 0.0f;
        for (int i = 0; i < clsArr.length; i++) {
            f += getObjectTransformationCost(clsArr[i], clsArr2[i]);
        }
        return f;
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        if (objArr != null || objArr2 == null || objArr2.length <= 0) {
            if (objArr2 != null || objArr == null || objArr.length <= 0) {
                if (objArr != null && objArr2 != null && objArr.length != objArr2.length) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static void setAccessible(AccessibleObject accessibleObject, boolean z) {
        if (accessibleObject.isAccessible() != z) {
            accessibleObject.setAccessible(z);
        }
    }

    public static Field getField(Class<?> cls, String str) {
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                setAccessible(declaredField, true);
                return declaredField;
            } catch (NoSuchFieldException e) {
                if (FontSizeRuntime.getFontSizeBusiness().isDebug()) {
                    e.printStackTrace();
                }
            }
        }
        Field field = null;
        for (Class<?> cls3 : cls.getInterfaces()) {
            try {
                field = cls3.getField(str);
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
        }
        return field;
    }

    public static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitivePromotionCost(cls, cls2);
        }
        float f = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && isAssignable(cls, cls2, true)) {
                    f += 0.25f;
                    break;
                }
                f += 1.0f;
                cls = cls.getSuperclass();
            } else {
                break;
            }
        }
        if (cls == null) {
            return f + 1.5f;
        }
        return f;
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method[] declaredMethods;
        Method accessibleMethod;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            setAccessible(declaredMethod, true);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            Method method = null;
            for (Method method2 : cls.getDeclaredMethods()) {
                if (method2.getName().equals(str) && isAssignable(clsArr, method2.getParameterTypes(), true) && (accessibleMethod = getAccessibleMethod(method2)) != null && (method == null || compareParameterTypes(accessibleMethod.getParameterTypes(), method.getParameterTypes(), clsArr) < 0)) {
                    method = accessibleMethod;
                }
            }
            if (method != null) {
                setAccessible(method, true);
            }
            return method;
        }
    }

    public static Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object... objArr) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, clsArr);
        if (matchingAccessibleMethod == null) {
            return null;
        }
        return matchingAccessibleMethod.invoke(obj, objArr);
    }

    public static boolean isAssignable(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && cls == null) {
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
            if (!cls2.isPrimitive()) {
                return false;
            }
            if (Integer.TYPE.equals(cls)) {
                if (!Long.TYPE.equals(cls2) && !Float.TYPE.equals(cls2) && !Double.TYPE.equals(cls2)) {
                    return false;
                }
                return true;
            } else if (Long.TYPE.equals(cls)) {
                if (!Float.TYPE.equals(cls2) && !Double.TYPE.equals(cls2)) {
                    return false;
                }
                return true;
            } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                return false;
            } else {
                if (Float.TYPE.equals(cls)) {
                    return Double.TYPE.equals(cls2);
                }
                if (Character.TYPE.equals(cls)) {
                    if (!Integer.TYPE.equals(cls2) && !Long.TYPE.equals(cls2) && !Float.TYPE.equals(cls2) && !Double.TYPE.equals(cls2)) {
                        return false;
                    }
                    return true;
                } else if (Short.TYPE.equals(cls)) {
                    if (!Integer.TYPE.equals(cls2) && !Long.TYPE.equals(cls2) && !Float.TYPE.equals(cls2) && !Double.TYPE.equals(cls2)) {
                        return false;
                    }
                    return true;
                } else if (!Byte.TYPE.equals(cls)) {
                    return false;
                } else {
                    if (!Short.TYPE.equals(cls2) && !Integer.TYPE.equals(cls2) && !Long.TYPE.equals(cls2) && !Float.TYPE.equals(cls2) && !Double.TYPE.equals(cls2)) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return cls2.isAssignableFrom(cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isMethodDeclaredThrowable(Method method, Throwable th) {
        Class<?>[] exceptionTypes;
        String name;
        boolean z;
        if (th instanceof RuntimeException) {
            return true;
        }
        if (method != null && th != null && (exceptionTypes = method.getExceptionTypes()) != null && exceptionTypes.length != 0) {
            try {
                name = method.getName();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (!"accept".equals(name) && !METHOD_SENDTO.equals(name)) {
                z = false;
                if ((th instanceof SocketException) && z) {
                    if (method.getDeclaringClass().getName().indexOf(LIBCORE) >= 0) {
                        return true;
                    }
                }
                for (Class<?> cls : exceptionTypes) {
                    if (cls.isInstance(th) || cls.isAssignableFrom(th.getClass())) {
                        return true;
                    }
                }
            }
            z = true;
            if (th instanceof SocketException) {
                if (method.getDeclaringClass().getName().indexOf(LIBCORE) >= 0) {
                }
            }
            while (r3 < r6) {
            }
        }
        return false;
    }
}
