package a.a.a.c.a;

import android.os.Build;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
/* loaded from: classes9.dex */
public class c {
    public static Object a(Class<?> cls, Class<?>[] clsArr, Object[] objArr) {
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object a(Class cls, Object[] objArr, Object obj) {
        Object newInstance = Array.newInstance(cls, objArr.length + 1);
        Array.set(newInstance, 0, obj);
        for (int i = 1; i < objArr.length + 1; i++) {
            Array.set(newInstance, i, objArr[i - 1]);
        }
        return newInstance;
    }

    public static Field a(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredField(str);
            } catch (Exception e) {
            }
        }
        return null;
    }

    public static void a(Object obj, String str, Object obj2) {
        Field a2 = a(obj, str);
        if (a2 != null) {
            a2.setAccessible(true);
            try {
                a2.set(obj, obj2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> boolean a(T[] tArr, T t) {
        int i;
        if (tArr != null) {
            i = 0;
            while (i < tArr.length) {
                T t2 = tArr[i];
                if (t2 == t || (t2 != null && t2.equals(t))) {
                    break;
                }
                i++;
            }
        }
        i = -1;
        return i != -1;
    }

    public static Object c(Object obj, String str) {
        Field a2 = a(obj, str);
        if (a2 != null) {
            a2.setAccessible(true);
            try {
                return a2.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static b hq() {
        int i = Build.VERSION.SDK_INT;
        return i >= 26 ? new d() : i >= 23 ? new f() : i >= 14 ? new a() : new e();
    }
}
