package com.baidu.fsg.base.utils.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class MemberUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5384a = 7;

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?>[] f5385b = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f5386c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f5387d = new HashMap();

    static {
        f5386c.put(Boolean.TYPE, Boolean.class);
        f5386c.put(Byte.TYPE, Byte.class);
        f5386c.put(Character.TYPE, Character.class);
        f5386c.put(Short.TYPE, Short.class);
        f5386c.put(Integer.TYPE, Integer.class);
        f5386c.put(Long.TYPE, Long.class);
        f5386c.put(Double.TYPE, Double.class);
        f5386c.put(Float.TYPE, Float.class);
        Map<Class<?>, Class<?>> map = f5386c;
        Class<?> cls = Void.TYPE;
        map.put(cls, cls);
        for (Class<?> cls2 : f5386c.keySet()) {
            Class<?> cls3 = f5386c.get(cls2);
            if (!cls2.equals(cls3)) {
                f5387d.put(cls3, cls2);
            }
        }
    }

    public static boolean a(int i2) {
        return (i2 & 7) == 0;
    }

    public static boolean a(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    public static Class<?> b(Class<?> cls) {
        return f5387d.get(cls);
    }

    public static float c(Class<?> cls, Class<?> cls2) {
        float f2;
        if (cls.isPrimitive()) {
            f2 = 0.0f;
        } else {
            cls = b(cls);
            f2 = 0.1f;
        }
        int i2 = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = f5385b;
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

    public static boolean a(AccessibleObject accessibleObject) {
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

    public static float b(Class<?> cls, Class<?> cls2) {
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

    public static boolean a(Class<?> cls, Class<?> cls2) {
        return a(cls, cls2, true);
    }

    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (Utils.a(clsArr, clsArr2)) {
            if (clsArr == null) {
                clsArr = Utils.f5390b;
            }
            if (clsArr2 == null) {
                clsArr2 = Utils.f5390b;
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

    public static boolean a(Class<?> cls, Class<?> cls2, boolean z) {
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

    public static Class<?> a(Class<?> cls) {
        return (cls == null || !cls.isPrimitive()) ? cls : f5386c.get(cls);
    }

    public static int a(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float a2 = a(clsArr3, clsArr);
        float a3 = a(clsArr3, clsArr2);
        if (a2 < a3) {
            return -1;
        }
        return a3 < a2 ? 1 : 0;
    }

    public static float a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            f2 += b(clsArr[i2], clsArr2[i2]);
        }
        return f2;
    }
}
