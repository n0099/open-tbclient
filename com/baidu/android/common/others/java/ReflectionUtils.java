package com.baidu.android.common.others.java;

import java.lang.reflect.Method;
/* loaded from: classes10.dex */
public final class ReflectionUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "ReflectionUtils";

    public static boolean invokeHideMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        try {
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            cls.getMethod(str, clsArr).invoke(obj, objArr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Object invokeHideMethodForObject(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        try {
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            return cls.getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean invokeDeclaredMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        try {
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, objArr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Object invokeDeclaredMethodForObject(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        try {
            if (obj instanceof Class) {
                cls = (Class) obj;
            } else {
                cls = obj.getClass();
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }
}
