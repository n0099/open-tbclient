package com.baidu.ar.g;

import java.lang.reflect.Constructor;
/* loaded from: classes14.dex */
public class n {
    public static Object a(Object obj, String str, String str2, Object obj2, Class<?> cls) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, cls).invoke(obj, obj2);
        } catch (Exception e) {
            b.k("ReflectionUtils", "invokeMethod() className = " + str + " && methodName = " + str2 + " error!!!");
            return null;
        }
    }

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(a(str, clsArr), objArr);
        } catch (Exception e) {
            b.k("ReflectionUtils", "getNewInstance(params) className = " + str + " error!!!");
            return null;
        }
    }

    public static Object a(Constructor<?> constructor, Object... objArr) {
        try {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            b.k("ReflectionUtils", "getNewInstance() error!!!");
            return null;
        }
    }

    public static Constructor<?> a(String str, Class<?>... clsArr) {
        try {
            return Class.forName(str).getDeclaredConstructor(clsArr);
        } catch (Exception e) {
            b.k("ReflectionUtils", "getSingleInstance() className = " + str + " error!!!");
            return null;
        }
    }

    public static boolean a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader) != null;
        } catch (Exception e) {
            b.k("ReflectionUtils", "isClassExist() class " + str + " is not exist!!!");
            return false;
        }
    }

    public static Object aS(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Exception e) {
            b.k("ReflectionUtils", "getNewInstance() className = " + str + " error!!!");
            return null;
        }
    }

    public static Object m(String str, String str2) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            b.k("ReflectionUtils", "getSingleInstance() className = " + str + " error!!!");
            return null;
        }
    }
}
