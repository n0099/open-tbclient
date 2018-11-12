package com.baidu.sofire;

import android.app.Activity;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class f {
    public static boolean a(Activity activity, Activity activity2) {
        Field[] declaredFields;
        if (activity == null || activity2 == null) {
            return false;
        }
        for (Class cls = Activity.class; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    if (field.getName().equals("mWindow")) {
                        field.set(activity2, activity.getWindow());
                    } else {
                        field.set(activity2, field.get(activity));
                    }
                } catch (Throwable th) {
                    com.baidu.sofire.b.e.a(th);
                }
            }
        }
        return true;
    }

    public static boolean a(Class<?> cls, Object obj, Object obj2) {
        Field[] declaredFields;
        if (obj == null || obj2 == null) {
            return false;
        }
        while (cls != null && cls != Object.class) {
            for (Field field : cls.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    field.set(obj2, field.get(obj));
                } catch (Throwable th) {
                    com.baidu.sofire.b.e.a(th);
                }
            }
            cls = cls.getSuperclass();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
        if (r0 != null) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x000d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method declaredMethod;
        try {
            declaredMethod = cls.getMethod(str, clsArr);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
        while (cls != null) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                com.baidu.sofire.b.e.a(e);
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
        while (cls != null) {
        }
        throw new NoSuchMethodException();
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        Throwable th;
        try {
            method = a(cls, str, clsArr);
        } catch (Throwable th2) {
            method = null;
            th = th2;
        }
        try {
            method.setAccessible(true);
        } catch (Throwable th3) {
            th = th3;
            com.baidu.sofire.b.e.a(th);
            return method;
        }
        return method;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
        if (r0 != null) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x000d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Field a(Class<?> cls, String str) {
        Field declaredField;
        try {
            declaredField = cls.getField(str);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
        while (cls != null) {
            try {
                declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException e) {
                com.baidu.sofire.b.e.a(e);
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException();
        while (cls != null) {
        }
        throw new NoSuchFieldException();
    }

    public static Field b(Class<?> cls, String str) {
        try {
            return a(cls, str);
        } catch (NoSuchFieldException e) {
            com.baidu.sofire.b.e.a(e);
            return null;
        }
    }
}
