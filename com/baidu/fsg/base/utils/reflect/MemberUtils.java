package com.baidu.fsg.base.utils.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
class MemberUtils {
    private static final int a = 7;
    private static final Class<?>[] b = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};
    private static final Map<Class<?>, Class<?>> c = new HashMap();
    private static final Map<Class<?>, Class<?>> d = new HashMap();

    MemberUtils() {
    }

    static {
        c.put(Boolean.TYPE, Boolean.class);
        c.put(Byte.TYPE, Byte.class);
        c.put(Character.TYPE, Character.class);
        c.put(Short.TYPE, Short.class);
        c.put(Integer.TYPE, Integer.class);
        c.put(Long.TYPE, Long.class);
        c.put(Double.TYPE, Double.class);
        c.put(Float.TYPE, Float.class);
        c.put(Void.TYPE, Void.TYPE);
        for (Class<?> cls : c.keySet()) {
            Class<?> cls2 = c.get(cls);
            if (!cls.equals(cls2)) {
                d.put(cls2, cls);
            }
        }
    }

    private static boolean a(int i) {
        return (i & 7) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(AccessibleObject accessibleObject) {
        if (accessibleObject == null || accessibleObject.isAccessible()) {
            return false;
        }
        Member member = (Member) accessibleObject;
        if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && a(member.getDeclaringClass().getModifiers())) {
            try {
                accessibleObject.setAccessible(true);
                return true;
            } catch (SecurityException e) {
            }
        }
        return false;
    }

    static boolean a(Class<?> cls, Class<?> cls2) {
        return a(cls, cls2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2, boolean z) {
        if (Utils.a(clsArr, clsArr2)) {
            if (clsArr == null) {
                clsArr = Utils.b;
            }
            if (clsArr2 == null) {
                clsArr2 = Utils.b;
            }
            for (int i = 0; i < clsArr.length; i++) {
                if (!a(clsArr[i], clsArr2[i], z)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    static boolean a(Class<?> cls, Class<?> cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return cls2.isPrimitive() ? false : true;
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

    static Class<?> a(Class<?> cls) {
        if (cls != null && cls.isPrimitive()) {
            return c.get(cls);
        }
        return cls;
    }

    static Class<?> b(Class<?> cls) {
        return d.get(cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Class<?>[] clsArr, Class<?>[] clsArr2, Class<?>[] clsArr3) {
        float a2 = a(clsArr3, clsArr);
        float a3 = a(clsArr3, clsArr2);
        if (a2 < a3) {
            return -1;
        }
        return a3 < a2 ? 1 : 0;
    }

    private static float a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        float f = 0.0f;
        for (int i = 0; i < clsArr.length; i++) {
            f += b(clsArr[i], clsArr2[i]);
        }
        return f;
    }

    private static float b(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return c(cls, cls2);
        }
        float f = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && a(cls, cls2)) {
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

    private static float c(Class<?> cls, Class<?> cls2) {
        float f = 0.0f;
        if (!cls.isPrimitive()) {
            f = 0.0f + 0.1f;
            cls = b(cls);
        }
        float f2 = f;
        Class<?> cls3 = cls;
        for (int i = 0; cls3 != cls2 && i < b.length; i++) {
            if (cls3 == b[i]) {
                f2 += 0.1f;
                if (i < b.length - 1) {
                    cls3 = b[i + 1];
                }
            }
        }
        return f2;
    }
}
