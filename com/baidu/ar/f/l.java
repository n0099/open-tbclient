package com.baidu.ar.f;

import java.lang.reflect.Constructor;
/* loaded from: classes11.dex */
public class l {
    public static Object a(Object obj, String str, String str2, Object obj2, Class<?> cls) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, cls).invoke(obj, obj2);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(a(str, clsArr), objArr);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static Object a(Constructor<?> constructor, Object... objArr) {
        try {
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static Constructor<?> a(String str, Class<?>... clsArr) {
        try {
            return Class.forName(str).getDeclaredConstructor(clsArr);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static boolean a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader) != null;
        } catch (Exception e) {
            b.b("ReflectionUtils", "isClassExist class " + str + " is not exist!!!");
            e.printStackTrace(System.out);
            return false;
        }
    }

    public static Object aO(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public static Object k(String str, String str2) {
        try {
            return Class.forName(str).getDeclaredMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }
}
