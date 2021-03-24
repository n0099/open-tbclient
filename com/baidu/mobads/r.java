package com.baidu.mobads;

import android.content.Context;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static com.baidu.mobads.utils.q f8506a = com.baidu.mobads.utils.q.a();

    /* renamed from: b  reason: collision with root package name */
    public static final String f8507b = "com.baidu.mobads.r";

    public static Class<?> a(String str, ClassLoader classLoader) {
        if (classLoader != null) {
            try {
                return classLoader.loadClass(str);
            } catch (Exception e2) {
                f8506a.d(f8507b, Log.getStackTraceString(e2));
            }
        }
        return null;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return declaredMethod;
            }
            return null;
        } catch (Exception e2) {
            f8506a.i(f8507b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static boolean a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr) != null;
        } catch (Exception e2) {
            f8506a.i(f8507b, Log.getStackTraceString(e2));
            return false;
        }
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            return a(obj.getClass(), obj, str, clsArr, objArr);
        } catch (Exception e2) {
            f8506a.i(f8507b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            if (a(cls, str, clsArr)) {
                return b(cls, str, clsArr).invoke(obj, objArr);
            }
            return null;
        } catch (Exception e2) {
            f8506a.i(f8507b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(String str, ClassLoader classLoader, Class<?>[] clsArr, Object... objArr) {
        try {
            Class<?> a2 = a(str, classLoader);
            if (a2 != null) {
                return a2.getDeclaredConstructor(clsArr).newInstance(objArr);
            }
            return null;
        } catch (Exception e2) {
            f8506a.i(f8507b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static Object a(String str, Object obj, ClassLoader classLoader, String str2, Class<?>[] clsArr, Object... objArr) {
        Method declaredMethod;
        try {
            Class<?> a2 = a(str, classLoader);
            if (a2 == null || (declaredMethod = a2.getDeclaredMethod(str2, clsArr)) == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception e2) {
            f8506a.i(f8507b, Log.getStackTraceString(e2));
            return null;
        }
    }

    public static DexClassLoader a(Context context) {
        try {
            return new DexClassLoader(com.baidu.mobads.g.g.a(context), context.getFilesDir().getAbsolutePath(), null, r.class.getClass().getClassLoader());
        } catch (Exception unused) {
            return null;
        }
    }
}
